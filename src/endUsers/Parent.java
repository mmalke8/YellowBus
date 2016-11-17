package endUsers;



public class Parent extends Person{	
	public Parent(long uaeId, String name, String password){
		super(uaeId, name, password);
		myStudent = new Student();
	}
	public Parent(){
		super();
		myStudent = new Student();
	}
	public Student getStudent(){
		return myStudent;
	}
	public void setStudent(Student student){
		myStudent = student;
	}
	private Student myStudent;
	
}
