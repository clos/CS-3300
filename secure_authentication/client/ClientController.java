package client;
import gps.GPSDaemon;
import gps.GPSLocation;

import java.net.InetAddress;

import communication.ClientEncryption;
import communication.SecureCommunicator;

import message.*;


public class ClientController {
	private InetAddress serverAddress;
	private int serverPort, messageTimeout;
	private boolean authState, gpsValid;
	private SecureCommunicator encryptClient;
	private ClientCred client;
	private long messageIdCnt;
	private GPSDaemon gpsd;
	
	
	
	// Constructors
	
	public ClientController(){
		this.serverAddress = null;
		this.serverPort = 0;
		this.messageTimeout = 0;
		this.authState = false;
		this.encryptClient = new ClientEncryption();
		this.client = new ClientCred();
		this.messageIdCnt = 1;
		this.gpsd = new GPSDaemon();
		
	}
	public ClientController(InetAddress serverAddress, int serverPort, 
			int messageTimeout, String username, String password){
		this();
		this.serverAddress = serverAddress;
		if(serverPort > 0)
			this.serverPort = serverPort;
		if(messageTimeout > 0)
			this.messageTimeout = messageTimeout;
		this.client.setUsername(username);
		this.client.setPassword(password);
		
	}
	
	/* Process a received message */
	private void processMessage(Message message){
		if(message.getClass().equals(AuthRec.class)){
			AuthRec authRecMessage = (AuthRec) message;
			//Set ClientID from Server
			this.client.setClientId(authRecMessage.getClientId());
			//Set Authenticated State
			this.authState = authRecMessage.getAccepted();
		}
		else if(message.getClass().equals(CredentialsReq.class)){
			//Make sure Client is set to try and Authenticate
			this.authState = false;
		}
		else if(message.getClass().equals(GPSRec.class)){
			GPSRec gpsRecMessage = (GPSRec) message;
			//Set GPS Validity state
			this.gpsValid = gpsRecMessage.getValid();
		}
		else{
			//Send Response to Server of unknown message type
			this.encryptClient.sendMessage(new UnknownRec(this.genMessageId()));
		}
	}
	//Generate a fairly unique message ID
	private long genMessageId(){
		this.messageIdCnt = (this.messageIdCnt++) % Long.MAX_VALUE;
		return this.messageIdCnt;
	}
	
	
	public void run(){
		Message receipt;
		GPSLocation gpsLoc;
		while(true){
			//Send Authentication Request to Server
			this.encryptClient.sendMessage(new AuthRequest(this.genMessageId(), -1, 
					this.client.getUsername(), this.client.getPassword()));
			//Receive response from server
			receipt = this.encryptClient.receiveMessage();
			//Update client state based on server response
			this.processMessage(receipt);
			//While client is authenticated to server
			while(this.authState){
				//Query GPS Daemon for gps info
				gpsLoc = this.gpsd.getGPS();
				//Send GPS Info
				this.encryptClient.sendMessage(new GPSInfo(this.genMessageId(), 
						this.client.getClientId(), gpsLoc));
				//Receive response from server
				receipt = this.encryptClient.receiveMessage();
				//Update client state based on server response
				this.processMessage(receipt);
			}
		}
	}
}
	

