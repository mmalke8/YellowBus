package endUsers;

public class ParentDevice {
	public ParentDevice(Parent parent){
		isSignedIn = false;
		this.parent = parent;
	}
	
	public void signIn(){
		isSignedIn = true;
	}
	public void signOut(){
		isSignedIn = false;
	}
	
	private boolean isSignedIn;
	private Parent parent;
}
