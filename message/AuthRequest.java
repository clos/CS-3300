package message;

public class AuthRequest extends Message {
	private String username, password;
	private int clientId;
	
	public AuthRequest(long messageId){
		this.setMessageID(messageId);
		this.username = "";
		this.password = "";
		this.clientId = -1;
	}
	public AuthRequest(long messageId, int clientId, String username, String password){
		this(messageId);
		this.clientId = clientId;
		this.username = username;
		this.password = password;
	}
	
	public int getClientId(){
		return this.clientId;
	}
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
}
