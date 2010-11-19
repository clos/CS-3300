package server;

import java.util.ArrayList;

import client.ClientCred;

public class ClientList {
	private ArrayList<ClientListEntry> list;
	
	public ClientList(){
		this.list = new ArrayList<ClientListEntry>();
	}
	
	public void addClientListEntry(ClientListEntry client){
		this.list.add(client);
	}
	
	public ClientListEntry getClientListEntry(ClientListEntry client){
		int index;
		index = this.list.indexOf(client);
		if(index >= 0)
			return this.list.get(index);
		else
			return null;
	}
	public ClientCred findClientCred(int clientId){
		for(int index=0; index < list.size(); index++){
			if(list.get(index).getCred().getClientId() == clientId)
				return list.get(index).getCred();
		}
		return null;
		
	}
}
