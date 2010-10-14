package server;

import message.Message;
import communication.ServerEncryption;

public class DummyServerEncryption extends ServerEncryption {
	public Message sentMessage;
	@Override
	public boolean sendMessage(Message message) {
		this.sentMessage = message;
		return true;
	}
	
}
