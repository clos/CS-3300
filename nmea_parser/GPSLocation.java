

import java.sql.Time;
//TODO Javadoc/commenting
public class GPSLocation {
	/*
	 * Attributes
	 */
	private GPSCoordinate longitude, latitude;
	private Time time;
	private String nmeaSentence;
	private String checksum;
	
	
	
	
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
		this.checksum = null;
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
	public String checksum(){
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
		this.checksum = checksum;
	}
	
}
