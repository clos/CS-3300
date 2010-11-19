package nmea_parser;


public class TestGPSController {
	public static void main(String[] args){
		GPSController controller = new GPSController();
		System.out.println("GPS Info");
		System.out.println("---------");
		for(int cnt=0;cnt<20;cnt++){
			gps.GPSLocation gps = controller.grabGPS();
		
			if(gps == null)
				break;;
			System.out.println("Latitude: " 
					+ String.format("%10f", gps.latitude().degrees()) 
					+ " Longitude: " 
					+ String.format("%10f", gps.longitude().degrees())
					+ " Valid: "
					+ gps.isValid());
		}
		
	}
}
