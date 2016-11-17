package endUsers;

public class Location{
	private double lon;
	private double lat;
	public Location(double lon, double lat){
		this.lon = lon;
		this.lat = lat;
	}
	public Location(){
		lat = 0;
		lon = 0;
	}
	public double getLon(){
		return lon;
	}
	public double getLat(){
		return lat;
	}
	public String toString(){
		return "lon: " + lon + " lat: " + lat;
	}
}
