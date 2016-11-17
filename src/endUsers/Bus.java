package endUsers;

import java.util.ArrayList;

public class Bus {

	public Bus(){
		driver = new BusDriver();
		attendant = new BusAttendant();
		route = null;
		busNumber = 0;
		plateNumber = "NoPlate";
		isAvailable = true;
	}
	public Bus(BusDriver driver, BusAttendant attend, StudentList students, Location route, int number, String plate){
		this.driver = driver;
		this.attendant = attend;
		this.groupStudents = students;
		this.route = route;
		this.busNumber = number;
		this.plateNumber = plate;
		this.isAvailable = true;
	}
	public Bus(int busNumber, double lon, double lat){
		this.busNumber = busNumber;
		Location tempLoc = new Location(lon, lat);
		route = tempLoc;
	}
	
	public void changeAvailability(boolean avail){
		isAvailable = avail;
	}
	public int getNumber(){
		return busNumber;
	}
	public boolean getAvailability(){
		return isAvailable;
	}
	public void setDriver(BusDriver driver){
		this.driver = driver;
	}
	
	public void setAttendant(BusAttendant attend){
		this.attendant = attend;
	}
	
	public void setGroup(StudentList group){
		this.groupStudents = group;
	}
	public Location getLocation(){
		return route;
	}
	
	private BusDriver driver;	//BusDriver Class will be added later.
	private BusAttendant attendant;	//BusAttendant Class will be added later.
	private StudentList groupStudents;
	private Location route;
	private int busNumber;
	private String plateNumber;
	private boolean isAvailable;	//True if the bus is available for use.
	
}
