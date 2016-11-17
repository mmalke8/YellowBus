<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="parentsCSS.css" rel="stylesheet" type="text/css"/>

<title>School Bus Tracker</title>
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #FFBF00;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #FFBF00;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
      	background-color: #FFBF00;
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<%@ page language="java" import="endUsers.*" %>
<%@page import="databasePackage.*" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="parents.jsp">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="TrackBus.jsp">Track Bus</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Change Student Status <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="attending.jsp">Attending</a></li>
                            <li><a href="notAttending.jsp">Not Attending</a></li>
                            <li><a href="parentPicked.jsp">Picked up by parent</a></li>
                        </ul>
                    </li>
                </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle glyphicon glyphicon-user"><%Parent parent = (Parent)request.getSession().getAttribute("currentSessionParent"); out.print(parent.getName());%><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="Welcome.jsp">Log out</a></li>
                        </ul>
                    </li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Welcome, <%out.print(parent.getName()); %></h1>
      <p>Using the above Navigation Bar you can choose to:</p>
      <ul>
      	<li>Change your child's attendance status.</li>
      	<li>Track your child's Bus.</li>
      </ul>
      <hr>
      <div class="col-sm-12 text-left">
      
      	<%
      	Student myStudent = ParentDB.getStudent(parent.getUaeId());%>
      	
      	<h2><%out.print(myStudent.getName()+"'s current status");%></h2>
      	
      	<h3><%out.print(myStudent.statusToString(myStudent.getStatus()));%></h3>
      	
      </div>
      
    </div>
    <div class="col-sm-2 sidenav">
      
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>