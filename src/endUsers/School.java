package endUsers;

import java.util.ArrayList;

import databasePackage.SchoolDB;

public class School extends Person{
	
	public School(){
		super();
		groupStudents = null;
	}
	public School(long id, String userName, String password){
		super(id, userName, password);
		this.groupStudents = null;
		this.schoolName = SchoolDB.getSchoolName(id);
	}
	public void addGroup(StudentList group){
		groupStudents.add(group);
	}
	public String getName(){
		return schoolName;
	}
	public void setName(String name){
		schoolName = name;
	}
	
	private ArrayList<StudentList> groupStudents;
	private String schoolName;
}
