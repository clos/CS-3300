package client;

public class ClientCred {
	private int clientId;
	private String username, password;
	
	
	
	public ClientCred(){
		this.clientId = -1;
		this.username = "";
		this.password = "";
	}
	public ClientCred(int clientId, String username, String password){
		this();
		this.clientId = clientId;
		this.username = username;
		this.password = password;
	}
	
	
	public void setClientId(int clientId){
		this.clientId = clientId;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
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
