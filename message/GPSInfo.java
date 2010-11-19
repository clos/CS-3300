package message;
import gps.GPSLocation;
public class GPSInfo extends Message {
	private GPSLocation gpsInfo;
	private int clientID;
	
	public GPSInfo(long messageId){
		this.setMessageID(messageId);
		this.gpsInfo = null;
		this.clientID = -1;
	}
	public GPSInfo(long messageId, int clientId, GPSLocation gpsInfo){
		this(messageId);
		this.clientID = clientId;
		this.gpsInfo = gpsInfo;
	}
	
	public int getClientID(){
		return this.clientID;
	}
	public GPSLocation getGPSInfo(){
		return this.gpsInfo;
	}
}
