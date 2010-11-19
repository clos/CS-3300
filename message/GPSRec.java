package message;

public class GPSRec extends Message {
	private boolean valid;
	
	public GPSRec(long messageId){
		this.setMessageID(messageId);
		this.valid = false;
	}
	public GPSRec(long messageId, boolean valid){
		this(messageId);
		this.valid = valid;
	}
	public boolean getValid(){
		return this.valid;
	}
}
