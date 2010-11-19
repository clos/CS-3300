import gpscomm.*;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class GPSClientel {
	public static String runGPS(){
	try {
		TTransport transport;
		transport = new TSocket("localhost", 9090);
		transport.open();	
		TProtocol protocol = new TBinaryProtocol(transport);
		GPSComm.Client client = new GPSComm.Client(protocol);
		String retstr = client.getCommString();
		transport.close();
		return retstr;
		} catch (TException x){
		 x.printStackTrace();
		}
	}
}

