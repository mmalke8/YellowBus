package endUsers;

public class Alert {

	public Alert(){
		severity = 0;
		message = "NoMessage";
	}
	
	public boolean setAlert(int sev, String message){	//Returns true if alert was set.
		if(sev > 5 || sev < 0)
			return false;
		else{
			this.severity = sev;
			this.message = message;
			return true;
		}
	}
	
	
	private int severity; 	//We will use a scale of 1-5
	private String message;
}
