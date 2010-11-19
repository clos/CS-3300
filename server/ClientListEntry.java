package server;
import client.ClientCred;


public class ClientListEntry {
	private ClientCred cred;
	
	public ClientListEntry(){
		this.cred = new ClientCred();
	}
	public ClientListEntry(ClientCred cred){
		this.cred = cred;
	}
	public void setCred(ClientCred cred){
		this.cred = cred;
	}
	public ClientCred getCred(){
		return this.cred;
	}
}
