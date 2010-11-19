package nmea_parser;



public class NMEAParserTester {
	public static void main(String[] args){
		NMEAParser parser = new NMEAParser();
	/**	GPSLocation gpsloc = parser.parseSentence("$GPGLL,3821.03,S,09004.22,E,022849,A,*18\r\n");

		System.out.println("Checksum Check");
		System.out.println("---------------");
		System.out.println("calculated: " + (int)gpsloc.calcChecksum());
		System.out.println("actual: " + (int)gpsloc.checksum());
		System.out.println("\nGPS Location");
		System.out.println("-------------");
		System.out.println("Latitude: " + gpsloc.latitude().toString());
		System.out.println("Longitude: " + gpsloc.longitude().toString());**/
	}
}
