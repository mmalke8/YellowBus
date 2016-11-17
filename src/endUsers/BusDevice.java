package endUsers;

public class BusDevice {

	public BusDevice(){
		myBus = new Bus();
		myAlert = new Alert();
	}
	public BusDevice(Bus bus){
		this.myBus = bus;
	}
	
	
	public void setAlert(int severity, String message){
		myAlert.setAlert(severity, message);
	}
	
	
	private Alert myAlert;
	private Bus myBus;
}
