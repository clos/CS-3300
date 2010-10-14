package server;
import gps.CoordinateType;
import gps.GPSCoordinate;
import gps.GPSLocation;
import gps.Hemisphere;

import java.net.InetAddress;

import message.Message;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServerControllerTest {
	ServerController server;
	Message authreq, gpsinfo;
	GPSLocation gps1;
	@Before
	public setUp(){
		this.server = ServerController(InetAddress.getLocalHost(), 545454, 100);
		this.authreq = AuthRequest("myID", "myPW");
		gps1 = new GPSLocation(new GPSCoordinate(CoordinateType.Latitude, Hemisphere.North, 60), 
								new GPSCoordinate(CoordinateType.Longitude, Hemisphere.West, 60));
		this.gpsinfo = GPSInfo(gps1, 10);
		
		//write config file out
		
	}
	@Test
	public void constructorTest(){
		
	}
	@Test
	public void loadConfigTest(){
		
	}
	@Test
	public void authenticateClientTest(){
		
	}
	@Test
	public void processMessageTest(){
		
	}
	public void checkClientTimesTest(){
		
	}
}
