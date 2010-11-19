package nmea_parser;
//dataholder.java
//Author: Stevie Frederick
//serves as the database holding device for GPS coordinate verification

import java.util.ArrayList;

import gps.GPSLocation;

public class dataholder{
public int size;
public ArrayList<GPSLocation> locations;

public dataholder(int size){
this.size = size;
this.locations = new ArrayList<GPSLocation>();
}

public void addElement(gps.GPSLocation value){
this.locations.add(value);
size += 1;
}

public GPSLocation getElement(int element){
return locations.get(element);
}

}