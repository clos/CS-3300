import junit.framework.TestCase;





public class MessageTests extends TestCase{

	public class Sender implements Runnable{

		@Override
		public void run() {
			try{
				SecureCommunicator Receiver = new SecureCommunicator();
				SecureCommunicator Sender = new SecureCommunicator();
				AuthRequest TestAuthRequest = new AuthRequest("TestUserName","TestPassword");
				AuthRec TestAuthReceived = new AuthRec();
				
				
				Sender.sendMessage(TestAuthRequest,"127.0.0.1");
				Receiver.receiveMessage();
				Receiver.sendMessage(TestAuthReceived,"127.0.0.1");
				Sender.receiveMessage();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
	}
	
	public class Receiver implements Runnable{

		@Override
		public void run() {
			
		}
		
	}

	public void TestSendMessage(){
		Sender send = new Sender();
		Receiver rec = new Receiver();
		
		
	}
	
	
    public static void main(String[] args) {
        junit.textui.TestRunner.run(
        		TestCase.class);
    }
    
    
}