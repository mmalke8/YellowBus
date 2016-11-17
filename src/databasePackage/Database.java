package databasePackage;

import java.sql.*;

import endUsers.Person;

public class Database{	
	private static String dbName = "ourdb";
	private static String dbUsername = "root";
	private static String dbPassword = "";
	private static Connection conn = null;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/" + dbName;
	
	public static void main (String[] args){
		System.out.println(Database.login("parent24", "parent24"));
   }			
				
	/*
	 executes an sql statement and updates the database
	 parameter: a string that is correct sql query
	 returns: boolean
	 */
	public static boolean updateQuery(String statement){	
		try{
			if (conn == null)
				Database.connected();
			
            PreparedStatement pst = null;            
            pst = conn.prepareStatement(statement);                      
            pst.executeUpdate();
        } 
		catch (Exception e){
			System.out.println("SQL failed in the changeStudentStatus function" + e);
			return false;
        }				
		return true;			
	}
		
	/*
	 executes an sql statement and returns a result set
	 parameter: a string that is correct sql query
	 returns: ResultSet
	 */
	public static ResultSet getQuery(String statement){	
        PreparedStatement pst = null;
        ResultSet rs = null;    
		try{
			if (conn == null)
				Database.connected();        
			
			pst = conn.prepareStatement(statement);            
            rs = pst.executeQuery();
            try{
            	rs.next();
            }
            catch (NullPointerException e){
            	System.out.println("Null pointer exception in the trackBus function: " + e);
            }
        } 
		catch (Exception e){
			System.out.println("SQL failed in the trackBus function" + e);
        }		
		return rs;
	}

	
	/*
	login function called on from the login interface
	parameters: username and password, both strings
	username is expected to be in lowercase
	returns: an instance of Person's child object if success
	returns: a null if login failed
	IMPORTANT: programmer needs to check for the fail or success of the login
	IMPORTANT: programmer checks the type returned, 
	if it is a parent object, then go to the parent interface
	also check for null
	*/
	public static Person login(String username, String password){
        Person tmp = null; 
        String table = null;
        if (username.charAt(0) == 'p'){
        	table = "parent";
        }
        else if (username.charAt(0) == 'b'){
        	table = "bus";
        }
        else if (username.charAt(0) == 's'){
        	table = "school";
        }
        try{
        	System.out.println(username + password);
			//if (conn == null)
			Database.connected();
            PreparedStatement pst = null;
            ResultSet rs = null;       

            pst = conn.prepareStatement("select * from " + table + " where username=? and password=?");            
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            
           
            if(rs.next()){
            	if(table.equals("parent") | table.equals("school")){
            	tmp = Person.factory(rs.getLong(1),rs.getString(4), table, rs.getString(3));
            	}
            	else{
            		tmp = Person.factory(rs.getLong(1), rs.getString(12), table, rs.getString(6));
            	}
            	System.out.println(tmp);
            }
            else{
            	return null;
            }
        }
        catch (Exception e){
        	System.out.println("Exception at Database.login " + e);
        }
		return tmp;
	}
	
	/*
	check if the conn variable is not null, else connects
	returns: true if connected/connection established
	false otherwise
	*/
   private static boolean connected(){
	   if (conn != null)
		   return true;
	   try{           
           Class.forName (driver);
           conn = DriverManager.getConnection (url, dbUsername, dbPassword);
           System.out.println ("Database connection established");
       }
       catch (ClassNotFoundException e){
    	   System.out.println("Exception in the connected function " + e);
    	   return false;
       }
       catch(Exception e){
    	   System.out.println("Exception in the connected function " + e);
           return false;
       }
	   return true;
   }
}