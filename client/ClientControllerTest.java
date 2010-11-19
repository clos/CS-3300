package client;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import gps.GPSDaemon;
import gps.GPSLocation;

import java.net.InetAddress;

import communication.ClientEncryption;
import communication.SecureCommunicator;


public class ClientControllerTest {
	ClientController client;
        private InetAddress serverAddress;
        private int serverPort, messageTimeout;
        private boolean authState, gpsValid;
        private SecureCommunicator encryptClient;
        private ClientCred client;
        private long messageIdCnt;
        private GPSDaemon gpsd;


}
