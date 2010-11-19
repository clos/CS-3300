package communication;
import message.Message;


public interface SecureCommunicator {
	public boolean sendMessage(Message message);
	public Message receiveMessage();
}
