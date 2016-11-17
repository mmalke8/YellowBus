package databasePackage;

import events.*;
import java.sql.ResultSet;
import java.util.ArrayList;

import endUsers.Location;
import endUsers.Student;
import endUsers.StudentStatus;

public abstract class ParentDB{	
	public static void main (String[] args){
		//System.out.println(ParentDB.trackBus(124165498454554L));
		//System.out.println(ParentDB.changeStudentStatus(454511321321115L, StudentStatus.NotAttending));
		//System.out.println(ParentDB.getStudentStatus(454511321321115L));
	}
	
	
	/*
	  Tracking the bus for parent
	  parameters: parent id
	  returns: location type
	 */
	public static Location trackBus(long id){
		Location tmp = null;
		ResultSet rs = Database.getQuery("SELECT lon, lat FROM bus WHERE cno"
    			+ "= any(SELECT bcno from student where PID="+id+");");
		try{
			tmp = new Location(rs.getDouble(1), rs.getDouble(2));      
		}
		catch(Exception e){
			System.out.println("Exception in ParentDB.trackBus " + e);
		}
		return tmp;
	}
	
	/*
	 update student status function, used by the parent
	 parameters: parent id, StudentStatus (the update one)
	 returns: boolean 
	 */
	public static boolean changeStudentStatus(long id, StudentStatus s){				
		return Database.updateQuery("update student set status= '" + Student.statusToString(s)
    			+ "' where PID=" + id + ";");
	}
	
	public static Student getStudent(long id){
		Student tmp = null;
		ResultSet rs = Database.getQuery("select * from student where PID=" + id + ";");
		try{
			tmp = new Student(rs.getLong(1),rs.getString(6), Student.stringToStatus(rs.getString(5)), rs.getLong(2),
					new Location(rs.getDouble(8), rs.getDouble(7)));  
		}
		catch(Exception e){
			System.out.println("Exception in ParentDB.getStudent " + e);
		}
		return tmp;	
	}
	
	/*
	 get the status of the student, used by the parent
	 parameter: parent id
	 returns: StudentStatus type
	 */
	public static StudentStatus getStudentStatus(long id){
		StudentStatus tmp = null;
		ResultSet rs = Database.getQuery("select status from student where PID=" + id + ";");
		try{
			tmp = Student.stringToStatus(rs.getString(1));      
		}
		catch(Exception e){
			System.out.println("Exception in ParentDB.trackBus " + e);
		}
		return tmp;		
	}
	/*
	 used by the parent to get the notifications and alerts
	 parameter: parentId
	 returns: ArrayList<Notice>
	 Notice class is abstract, the returned objects are children of notice
	 which are notification and alert, you need to check which are returned
	 if you want to display the notification and alerts separately
	 */
	public static ArrayList<Notice> getMyNotificationsAndAlerts(long id){
		ResultSet notifications = Database.getQuery("select * from notification where PID=" + id + ";");
		ResultSet alerts = Database.getQuery("select * from alert where PID=" + id + ";");

		
		ArrayList<Notice> notList = new ArrayList<>();
		Notice tmp = null;
		
		try{
       	do{   
       		tmp = new Notification(notifications.getLong(1), notifications.getTimestamp(2), 
       				notifications.getLong(3), notifications.getLong(4), 
       				Notification.stringToMessage(notifications.getString(5)));
       		notList.add(tmp);
       	}while(notifications.next());
       }
       catch (Exception e){
       	System.out.println("Exception in BusDB.getMyNotification " + e);
       }
		
		try{
			do{   
	    		tmp = new Alert(alerts.getLong(1), alerts.getTimestamp(2), alerts.getLong(3), 
	    				alerts.getLong(4), alerts.getString(5));
	    		notList.add(tmp);
	    	}while(alerts.next());
       }
       catch (Exception e){
       	System.out.println("Exception in BusDB.getMyAlerts " + e);
       }
		return notList;
	}
}

