package endUsers;

import java.util.ArrayList;

public class BusManagementSystem {

	public BusManagementSystem(){
		buses = null;
	}
	public BusManagementSystem(ArrayList<Bus> buses){
		this.buses = buses;
	}
	public Bus getAvailableBus(){
		for(Bus bus:buses){
			if(bus.getAvailability())		//Checks for the first available bus.
				bus.changeAvailability(false);
				return bus;
		}
		return null;
	}
	public void addBus(Bus bus){
		buses.add(bus);
	}
	
	
	private ArrayList<Bus> buses;
}
