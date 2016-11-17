package endUsers;


import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databasePackage.Database;
import databasePackage.ParentDB;

public class EndUserChecker extends HttpServlet{	//Checks which Type of user is trying to login to the System
	
	
	public EndUserChecker(HttpServletRequest request, HttpServletResponse response){
		
		doPost(request, response);
	}
	public EndUserChecker(){
		
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
		String userid = request.getParameter("myUsername");    
	    String pwd = request.getParameter("myPassword");
	    
	    
	    Person person = Database.login(userid, pwd);
	    if(person == null){
	    	try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else if(person instanceof Parent){
	    ((Parent) person).setStudent(ParentDB.getStudent(person.getUaeId()));
	    HttpSession session = request.getSession(true);
	    
	    
	    session.setAttribute("currentSessionParent", person);
	    try {
			response.sendRedirect("parents.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    else if(person instanceof BusAttendant){
	    	HttpSession session = request.getSession(true);
		    
		    
		    session.setAttribute("currentSessionBusAttendant", person);
		    try {
				response.sendRedirect("attendant.jsp");	//Change Later
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else if(person instanceof School){
	    	HttpSession session = request.getSession(true);
		    
		    
		    session.setAttribute("currentSessionSchool", person);
		    try {
				response.sendRedirect("school.jsp");		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    
	    
	    
	}
		
		
			
			
			
			
		
	
	
	boolean tryAgain = false;

	
}
