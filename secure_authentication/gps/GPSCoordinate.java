package gps;



//TODO Javadoc/commenting, add degrees/minutes/seconds
public class GPSCoordinate {
	/*
	 * Attributes
	 */
	public CoordinateType type;
	public Hemisphere hemisphere;
	//private int degrees, minutes, seconds;
	private double value;
	
	
	/*
	 * Constructors
	 */
	
	public GPSCoordinate(){
		this.value = -1;
		this.type = CoordinateType.INVALID;
		this.hemisphere = Hemisphere.INVALID;
	}
	//TODO Check input
	public GPSCoordinate(CoordinateType type, Hemisphere hemisphere, 
			double degrees){
		this();
		this.type = type;
		this.hemisphere = hemisphere;
		this.value = degrees;
	}
	
	/*
	 * Accessors
	 */
	public CoordinateType type(){
		return this.type;
	}
	public Hemisphere hemisphere(){
		return this.hemisphere;
	}
	public double degrees(){
		return this.value;
	}
	
	
	
	/*
	 * Mutators
	 */
	public void setType(CoordinateType type){
		this.type = type;
	}
	public void setHemisphere(Hemisphere hemisphere){
		this.hemisphere = hemisphere;
	}
	//TODO Check input
	public void setDegrees(int degrees){
		this.value = degrees;
	}
		
	@Override
	public String toString(){
		if(this.value > 0)
			if(this.hemisphere != Hemisphere.INVALID)
				return Double.toString(this.value);
		return null;
			
	}


	
}