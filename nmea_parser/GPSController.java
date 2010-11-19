package nmea_parser;

import java.util.regex.Pattern;


public class GPSController{
	private NMEAParser parser;
	private SerialIO io;
	private Pattern nmeaSentencePattern;
	private long pollCount;
	private String buffer;
	private int index1, index2;


	public GPSController(){
		this.parser = new NMEAParser();
		this.io = new SerialIO("test_nmea_sentences2.txt");
//		this.nmeaSentencePattern = Pattern.compile(this.parser.getNMEASentencePattern());
		this.pollCount = 1000;
		this.buffer = "";
	}

	public gps.GPSLocation grabGPS(){
		String sentence = "";
		String tempStr;
		gps.GPSLocation gps = null;
		int count = 0;
		while((gps == null) && count < this.pollCount){
			buffer = buffer.concat(this.io.pull());
			count++;
			index1 = buffer.indexOf('$');
			if(index1 >= 0){
				index2 = buffer.substring(index1).indexOf('\n') + index1;
				while(index2 < index1 && count < this.pollCount){
					tempStr = this.io.pull();
					if(tempStr.length() > 0)buffer = buffer.concat(this.io.pull());
					else return null;
					count++;
					index2 = buffer.substring(index1).indexOf('\n') + index1;
				}
				sentence = buffer.substring(index1, index2 + 1);
	//			gps = this.parser.parseSentence(sentence);
				if(index2+1 < buffer.length()) buffer = buffer.substring(index2+1);
			}
		}
		return gps;
	}

	
}
