package databasePackage;

import java.sql.ResultSet;
import java.util.ArrayList;

import endUsers.Bus;
import endUsers.Location;

public abstract class SchoolDB {
	
	
	
	
	/*
	  Tracking the bus for school
	  parameters: bus CNo
	  returns: Location type
	 */
	public static Location trackBus(long id){
		Location tmp = null;
		ResultSet rs = Database.getQuery("SELECT lon, lat FROM bus WHERE cno="+id+";");
		try{
			tmp = new Location(rs.getDouble(1), rs.getDouble(2));      
		}
		catch(Exception e){
			System.out.println("Exception in SchoolDB.trackBus " + e);
		}
		return tmp;
	}
	public static String getSchoolName(long id){
		String schoolName = null;
		ResultSet rs = Database.getQuery("select * from school where SID=" + id + ";");
		try{
			schoolName = rs.getString(4);
		}
		catch(Exception e){
			System.out.println("Exception in ParentDB.getStudent " + e);
		}
		return schoolName;
	}
	public static ArrayList<Bus> getAllBuses(long id){
		ResultSet rs = Database.getQuery("SELECT CNo, lon, lat FROM bus WHERE SID="+id+";");
		ArrayList<Bus> busList = new ArrayList<Bus>();
		Bus tempBus = null;
		try{
			
			do{
				tempBus = new Bus(rs.getInt(1), rs.getDouble(2), rs.getDouble(3));
				busList.add(tempBus);
				
			}while (rs.next());
		}
		catch(Exception e){
			System.out.println("Exception in SchoolDB.getAllBuses()" + e);
			return null;
		}
		
		return busList;
	}
	
}

