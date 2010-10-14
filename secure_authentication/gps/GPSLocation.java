package gps;



import java.sql.Time;
//TODO Javadoc/commenting

public class GPSLocation {
	/*
	 * Attributes
	 */
	private GPSCoordinate longitude, latitude;
	private Time time;
	private String nmeaSentence;
	private char checksum;
	private boolean valid;
	
	
	
	
	/*
	 * Constructors
	 */
	public GPSLocation(){
		this.latitude = new GPSCoordinate();
		this.latitude.setType(CoordinateType.Latitude);
		this.longitude = new GPSCoordinate();
		this.longitude.setType(CoordinateType.Longitude);
		this.time = new Time(0);
		this.nmeaSentence = null;
		this.checksum = 0;
		this.valid = false;
	}
	//TODO Check input for reasonable time, valid coordinates
	public GPSLocation(GPSCoordinate latitude, GPSCoordinate longitude){
		this();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	/*
	 * Accessors
	 */
	public GPSCoordinate latitude(){
		return this.latitude;
	}
	public GPSCoordinate longitude(){
		return this.longitude;
	}
	public Time time(){
		return this.time;
	}
	public char checksum(){
		return this.checksum;
	}
	public String nmeaSentence(){
		return this.nmeaSentence;
	}
	
	
	/*
	 * Mutators
	 */
	//TODO Check input
	public void setLatitude(GPSCoordinate latitude){
		this.latitude = latitude;
	}
	//TODO Check input
	public void setLongitude(GPSCoordinate longitude){
		this.longitude = longitude;
	}
	//TODO Check input
	public void setTime(Time time){
		this.time = time;
	}
	public void setSentence(String sentence){
		this.nmeaSentence = sentence;
	}
	public void setCheckSum(String checksum){
		char a = 0;
		char b = 0;
		if(checksum.length() == 2){
			if(checksum.charAt(0) > 65 && checksum.charAt(0) <= 70)
				a = (char)((int)checksum.charAt(0) - 55);
			else if(checksum.charAt(0) > 48 && checksum.charAt(0) <= 57)
				a = (char)((int)checksum.charAt(0) - 48);
			if(checksum.charAt(1) > 65 && checksum.charAt(1) <= 70)
				b = (char)((int)checksum.charAt(1) - 55);
			else if(checksum.charAt(1) > 48 && checksum.charAt(1) <= 57)
				b = (char)((int)checksum.charAt(1) - 48);
			a = (char)((int) a << 4);
			this.checksum = (char)(a + b);
			this.validate();
		}
	}
	
	public char calcChecksum(){
		int index;
		char tempChecksum = 0;
		if(this.checksum != 0 && this.nmeaSentence != null){
			for(index=1;index<this.nmeaSentence.length()-5;index++){
				tempChecksum = (char)(tempChecksum ^ this.nmeaSentence.charAt(index));	
			}
		}
		return tempChecksum;
	}
	public boolean isValid(){
		return this.valid;
	}
	private boolean validate(){
		char tempChecksum = this.calcChecksum();
		if(this.checksum == tempChecksum){
			this.valid = true;
			return true;
		}
		else{
			this.valid = false;
			return false;
		}
			
	}
}
	
	