package message;

public abstract class Message {
	private long id;
	
	public void setMessageID(long id){
		this.id = id;
	}
	public long getMessageID(){
		return this.id;
	}
}
