package endUsers;

public class Person {
	private String name;
	private long uaeId;	
	private String password;
	
	public Person(long uaeId, String name, String password){
		this.name = name;
		this.uaeId = uaeId;
		this.password = password;
		System.out.println("This is constructor, values: " + name +uaeId+password);
	}	
	public Person(){
		name = "NoName";
		uaeId = 000;
		password = "NoPassword";
	}
	//used to return an instance of a child of person
			//depending on the type
			//mostly used in the login function of the database
			public static Person factory(long uaeId, String name, String type, String password){
				if (type.equals("parent"))
					return new Parent(uaeId, name, password);
				else if (type.equals("bus"))
					return new BusAttendant(uaeId, name, password);	
				else if(type.equals("school"))
					return new School(uaeId, name, password);
				return null;
			}
	public long getUaeId(){
		return uaeId;
	}
	
	public String getPassword(){
		return password;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return "name is: " + name +", and ID is: " + Long.toString(uaeId);
	}	
}