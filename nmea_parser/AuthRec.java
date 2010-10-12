
public class AuthRec extends Message{
	Message messageReceived;
	boolean wasMessageReceived;
	boolean accepted;
	int clientID;
	
	public AuthRec(){
		clientID=0;
		accepted=true;
	}
	
	public boolean RecLogin() {
		wasMessageReceived = true;
		return wasMessageReceived;
	}
	

	public Message getMessageReceived() {
		return messageReceived;
	}

	public void setMessageReceived(Message messageReceived) {
		this.messageReceived = messageReceived;
	}

	public boolean isWasMessageReceived() {
		return wasMessageReceived;
	}

	public void setWasMessageReceived(boolean wasMessageReceived) {
		this.wasMessageReceived = wasMessageReceived;
	}

}
