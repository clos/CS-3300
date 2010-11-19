//dataholder.java
//Author: Stevie Frederick
//serves as the database holding device for GPS coordinate verification

import gps.GPSLocation;

public class dataholder{
	public int size;
	public ArrayList<GPSLocation> locations;
	
	public dataholder(int size){
		this.size = size;
		this.locations = new ArrayList<GPSLocation>;
	}

	public void addElement(int element, GPSLoaction value){
		this.locations.add(value);
		size += 1;
	}

	public float getElement(int element){
		return locations.get(element);
	}

}
