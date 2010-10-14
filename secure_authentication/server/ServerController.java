package server;
import client.ClientCred;
import communication.SecureCommunicator;
import communication.ServerEncryption;

import message.*;
import gps.*;

public class ServerController {
	private ClientList authClients;
	private ServerConfiguration config;
	private SecureCommunicator encryptServer;
	private long messageIdCnt;
	private int clientIdIssueCnt;

	
	
	public ServerController(){
		this.authClients = new ClientList();
		this.config = new ServerConfiguration();
		this.encryptServer = new ServerEncryption();
		this.messageIdCnt = 1;
		this.clientIdIssueCnt = 1;
	}
	
	public ServerController(ServerConfiguration config){
		this();
		this.config = config;
	}
	
	public void processMessage(Message message){
		
		if(message.getClass().equals(AuthRequest.class)){
			AuthRequest authReqMessage = (AuthRequest) message;
			AuthRec receipt;
			// If the username and password are correct
			if(this.authenticateClient(authReqMessage.getUsername(), 
					authReqMessage.getPassword())){
				// Generate a new clientId
				int clientId = this.genClientId();
				// Add the new client to the client list
				this.authClients.addClientListEntry(new ClientListEntry(
						new ClientCred(clientId, 
								authReqMessage.getUsername(), 
								authReqMessage.getPassword())));
				// Create the accepted receipt message
				receipt = new AuthRec(this.genMessageId(), clientId, true);
			}
			else
				// Create the denied receipt message
				receipt = new AuthRec(this.genMessageId(), -1 , false);
			// Send the receipt message
			this.encryptServer.sendMessage(receipt);
		}
		else if(message.getClass().equals(GPSInfo.class)){
			GPSInfo gpsInfoMessage = (GPSInfo) message;
			Message receipt;
			// Check if the given client ID is an authorized client
			ClientCred cred = this.authClients.findClientCred(gpsInfoMessage.getClientID());
			// If the client ID is not authorized
			if(cred == null)
				receipt = new CredentialsReq(this.genMessageId());
			// If the client ID is authorized and GPS is valid
			else if(this.authenticateGPS(gpsInfoMessage.getGPSInfo(), cred))
				receipt = new GPSRec(this.genMessageId(), true);
			// If the client ID is authorized and GPS is invalid
			else
				receipt = new GPSRec(this.genMessageId(), false);
			// Send the receipt back to the client
			this.encryptServer.sendMessage(receipt);
		}
		else{
			Message receipt = new CredentialsReq(this.genMessageId());
			this.encryptServer.sendMessage(receipt);
			
		}
	}
	private boolean authenticateClient(String username, String password){
		return true;
	}
	private boolean authenticateGPS(GPSLocation gpsInfo, ClientCred cred){
		return true;
	}
	private long genMessageId(){
		this.messageIdCnt = (this.messageIdCnt++) % Long.MAX_VALUE;
		return this.messageIdCnt;
	}
	private int genClientId(){
		this.clientIdIssueCnt = (this.clientIdIssueCnt++) % Integer.MAX_VALUE;
		return this.clientIdIssueCnt;
	}
	
	
	public void run(){
		while(true){
			this.processMessage(this.encryptServer.receiveMessage());
		}
	}
}
