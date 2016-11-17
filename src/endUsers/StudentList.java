package endUsers;

import java.util.ArrayList;

public class StudentList {

	public StudentList(ArrayList<Student> listStudents){
		students = listStudents;
	}
	
	
	public boolean addStudent(Student student){		//Will return True if
													//Student added successfully.
		return students.add(student);
	}
	
	
	public ArrayList<Student> getListStudents(){
		return students;
	}
	
	
	
	
	
	private ArrayList<Student> students;
}
