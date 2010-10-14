package message;

public class AuthRec extends Message {
	private boolean accepted;
	private int clientId;
	
	public AuthRec(long messageId){
		this.setMessageID(messageId);
		this.accepted = false;
		this.clientId = -1;
	}
	
	public AuthRec(long messageId, int clientId, boolean accepted){
		this(messageId);
		this.clientId = clientId;
		this.accepted = accepted;
	}
	
	public boolean getAccepted(){
		return this.accepted;
	}
	
	public int getClientId(){
		return this.clientId;
	}
}
