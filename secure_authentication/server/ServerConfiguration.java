package server;
import java.net.InetAddress;
public class ServerConfiguration {
	int listenPort;
	InetAddress ldapAddress;
	
	public ServerConfiguration(){
		this.listenPort = -1;
		this.ldapAddress = null;
	}
	public ServerConfiguration(int listenPort, InetAddress ldap){
		if(listenPort > 0)
			this.listenPort = listenPort;
		this.ldapAddress = ldap;
	}
	public int getListenPort(){
		return this.listenPort;
	}
	public InetAddress getLdapAddress(){
		return this.ldapAddress;
	}
	
}
