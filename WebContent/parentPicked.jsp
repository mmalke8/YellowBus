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
Parent parent = (Parent)request.getSession().getAttribute("currentSessionParent");
Student myStudent = parent.getStudent();
myStudent.setStatus(StudentStatus.ParentPick);
parent.setStudent(myStudent);
ParentDB.changeStudentStatus(parent.getUaeId(), myStudent.getStatus());
session.setAttribute("currentSessionParent", parent);
response.sendRedirect("parents.jsp");
%>

</body>
</html>