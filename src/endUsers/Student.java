package endUsers;




public class Student{
	private long id;
	private String name;
	private StudentStatus status;
	private long busNo;
	private Location location;
	
	public Student(long id, String name, StudentStatus status, long busNo, Location location){
		this.id = id;
		this.name = name;
		this.status = status;
		this.busNo = busNo;
		this.location = location;
	}
	public Student(){
		name = "NoName";
		status = StudentStatus.NotAttending;
		busNo = 00000;
		location = new Location();
		
	}
	
	public long getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public long getBusNo(){
		return busNo;	
	}
	public Location getLocation(){
		return location;
	}
	public String toString(){
		String tmp = "";
		tmp += "name: " + name;
		tmp += " status: " + status;
		tmp += " busNo: " + busNo;
		tmp += " lon: " + location.getLon();
		tmp += " lat: " + location.getLat();		
		return tmp;
	}
	/*
	takes a string and returns a StudentStatus
	usually used to get information from DB to
	create a student object
	*/
	public static StudentStatus stringToStatus(String status){
	   StudentStatus statusEntered = null;
	   switch(status){
		case "NotAttending":
			statusEntered = StudentStatus.NotAttending;
			break;
		case "OnBus":
			statusEntered = StudentStatus.OnBus;
			break;
		case "InSchool":
			statusEntered = StudentStatus.InSchool;
			break;
		case "ParentPick":
			statusEntered = StudentStatus.ParentPick;
			break;
		case "Delivered":
			statusEntered = StudentStatus.Delivered;
			break;
		case "Attending":
			statusEntered = StudentStatus.Attending;
			break;
	   }
	   return statusEntered;
	}
	/*
	 same as the above but the reverse
	 used to update student status in the DB	 
	 */
	public static String statusToString(StudentStatus status){
		   String statusEntered = null;
		   switch(status){
			case NotAttending:
				statusEntered = "NotAttending";
				break;
			case OnBus:
				statusEntered = "OnBus";
				break;
			case InSchool:
				statusEntered = "InSchool";
				break;
			case ParentPick:
				statusEntered = "ParentPick";
				break;
			case Delivered:
				statusEntered = "Delivered";
				break;
			case Attending:
				statusEntered = "Attending";
				break;
		   }
		   return statusEntered;
		}
	public StudentStatus getStatus(){
		return status;
	}
	public void setStatus(StudentStatus stat){
		status = stat;
	}
}
