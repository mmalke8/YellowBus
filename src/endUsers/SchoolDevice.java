package endUsers;

import java.util.ArrayList;

public class SchoolDevice {		//This class is used as an interface to access the School
								//class
	public SchoolDevice(){
		mySchool = new School();
	}
	public SchoolDevice(long id, String name,String userName, String password, ArrayList<StudentList> listStudents){
		mySchool = new School(name, userName, password, listStudents);
	}
	public void addGroup(StudentList group){
		mySchool.addGroup(group);
	}
	

	private School mySchool;
}
