<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page language="java" import="java.util.ArrayList" %>
<%@page import="endUsers.*" %>
<%@page import="databasePackage.*" %>


<%

	String[] attendance = request.getParameterValues("student");
	boolean busFull = true;
	ArrayList<Student> studentList = (ArrayList<Student>)request.getSession().getAttribute("studentList");
			for(Student student: studentList){
				for(String studentName: attendance){
					if(studentName.equals(student.getName())){
						BusDB.changeStudentStatus(student.getId(), StudentStatus.OnBus);
					}
				}
			}
			response.sendRedirect("TrackBusAttendant.jsp");
		
	
	

%>


</body>
</html>