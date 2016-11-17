<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page language="java" import="endUsers.*" %>
<%@page import="databasePackage.*" %>

<%
		
		Location location = BusDB.trackBus(10001);
		session = request.getSession();
		session.setAttribute("getBusLocation", location);
		response.sendRedirect("TrackBusSchool.jsp");
	
%>

</body>
</html>