
public abstract class Message {
	private String username;
	private String password;
	private String GPSInfo;
	private int clientID;
	private boolean accepted;	
	private boolean valid;
	
	public Message(){
		
	}
	
public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGPSInfo() {
		return GPSInfo;
	}

	public void setGPSInfo(String gPSInfo) {
		GPSInfo = gPSInfo;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}



}
