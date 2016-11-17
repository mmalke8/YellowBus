package databasePackage;


import events.*;
import java.sql.ResultSet;
import java.util.ArrayList;

import endUsers.Location;
import endUsers.Student;
import endUsers.StudentStatus;

public abstract class BusDB {
	public static void main (String[] args){
		//System.out.println(BusDB.updateMyLocation(10001, new Location(22.123456, 23.123456)));
//		ArrayList<Student> g = BusDB.getList(10003);
//		for (Student i : g)
//			System.out.println(i);		
		//System.out.println(BusDB.changeStudentStatus(132154987846546L, StudentStatus.OnBus));

	}	
	
	/*
	 update student status function, used by the bus	 
	 parameters: student id StudentStatus (the update one)
	 returns: boolean
	 
	 It will be used by the bus to mark student as OnBus, Delivered, and InSchool
	 note that this will be maintained by the bus interface (e.g. if the student attends
	 the bus then the bus will mark that student OnBus, when it drops it to school
	 it will mark it as InSchool and so on and so forth). Note that the bus acquires
	 the student ID from the getList function in which it has to be used before
	 the bus starts moving	
	 */
	public static boolean changeStudentStatus(long id, StudentStatus s){				
		return Database.updateQuery("update student set status= '" + Student.statusToString(s) 
            	+ "' where suaeid=" + id + ";");
	}
	
	/*
	 used by the bus to update its location
	 parameters: bus CNo and Location type
	 returns: boolean
	 */
	public static boolean updateMyLocation(long id, Location location){				
		return Database.updateQuery("update bus set lat=" + location.getLat() + ", lon=" + location.getLon()
				+ " where Cno=" + id +";");
	}
	
	public static ArrayList<Student> getList(long id){
		ResultSet rs = Database.getQuery("select SUAEID, name, status, bcno, lon, lat from student where "
				+ "bcno=" + id + ";");
		Student tmp;
		ArrayList<Student> tmpList = new ArrayList<>();

		try{
        	do{   
        		if (Student.stringToStatus(rs.getString(3)) != StudentStatus.NotAttending &&
        				Student.stringToStatus(rs.getString(3)) != StudentStatus.ParentPick &&
        					Student.stringToStatus(rs.getString(3)) != StudentStatus.OnBus){
        			tmp = new Student(rs.getLong(1), rs.getString(2), Student.stringToStatus(rs.getString(3)), 
        				rs.getLong(4), new Location(rs.getDouble(5), rs.getDouble(6)));
        			tmpList.add(tmp);
        		}
        	}while(rs.next());
        }
        catch (Exception e){
        	System.out.println("Exception in BusDB.getList " + e);
        }
		return tmpList;
	}
	public static Location trackBus(long id){
		Location tmp = null;
		ResultSet rs = Database.getQuery("SELECT lon, lat FROM bus WHERE CNo="+id+";");
		try{
			tmp = new Location(rs.getDouble(1), rs.getDouble(2));      
		}
		catch(Exception e){
			System.out.println("Exception in ParentDB.trackBus " + e);
		}
		return tmp;
	}
	public static void studentsInSchool(long id){	
		for (Student i: BusDB.getList(id)){
			changeStudentStatus(i.getId(), StudentStatus.InSchool);	
		}
	}
	/*
	 a function that is used to give all parents of all
	 students on board of the bus a notification
	 parameters: bus cno, 
	 */
	public static void broadcastNotification(long id, NotificationMessage message){
		ResultSet parentIdList = Database.getQuery("select pid from student where bcno=" + id +";");		
		try{
			do{
       		Database.updateQuery("insert into notification (busCNo, PID, message) " +
       				"values(" + id + "," + 
       				parentIdList.getLong(1) + ",'" + Notification.messageToString(message) + "');");        		
       	}while(parentIdList.next());
       }
       catch (Exception e){
       	System.out.println("Exception in BusDB.broadcastNotification " + e);
       }
	}
	/*
	 used by the bus to create a notification regarding 
	 one student on board (i.e. ETA5Min)
	 parameters: bus CNo, studentId (obtained from the getList saved on the bus)
	 */
	public static void oneNotification(long busId, long studentId, NotificationMessage message){
		ResultSet parentId = Database.getQuery("select pid from student where suaeid=" +
				+ studentId +";");		
		try{			
       	Database.updateQuery("insert into notification (busCNo, PID, message) " +
       				"values(" + busId + "," + parentId.getLong(1) + 
       				",'" + Notification.messageToString(message) + "');");        		
       }
       catch (Exception e){
       	System.out.println("Exception in BusDB.oneNotification " + e);
       }
	}
	/*
	 a function that is used to give all parents of all
	 students on board of the bus a notification
	 parameters: bus cno, 
	 */
	public static void broadcastAlert(long id, String message){
		ResultSet parentIdList = Database.getQuery("select pid from student where bcno=" + id +";");		
		try{
			do{
      		Database.updateQuery("insert into alert (busCNo, PID, message) " +
      				"values(" + id + "," + 
      				parentIdList.getLong(1) + ",'" + message + "');");        		
      	}while(parentIdList.next());
      }
      catch (Exception e){
      	System.out.println("Exception in BusDB.broadcastAlert " + e);
      }
	}
}

