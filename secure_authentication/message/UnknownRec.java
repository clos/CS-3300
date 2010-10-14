package message;

public class UnknownRec extends Message {
	private int unknownMessageId;
	
	public UnknownRec(long messageId){
		this.setMessageID(messageId);
		this.unknownMessageId = -1;
	}
	public UnknownRec(long messageId, int unknownId){
		this(messageId);
		this.unknownMessageId = unknownId;
	}
	
	public int getUnknownId(){
		return this.unknownMessageId;
	}
}
