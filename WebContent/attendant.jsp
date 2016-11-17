<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="attendantCSS.css" rel="stylesheet" type="text/css"/>
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>YellowBus - Bus Attendant</title>

</head>
<style>
   
    
    /* Set orange background color, white text and some padding */
    footer {
      background-color: #FFBF00;
      color: white;
      padding: 15px;
      
    }
    header{
    	background-color: #FFBF00;
    	padding:15px
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
<body>


<%@ page language="java" import="endUsers.*" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="attendant.jsp">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="TrackBusAttendant.jsp">View Route</a></li>
        <li><a href="alert.jsp">Send Alert</a></li>     
       </ul>   
                   
      <ul class="nav navbar-nav navbar-right">
       <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle glyphicon glyphicon-user"><%BusAttendant attendant = (BusAttendant)request.getSession().getAttribute("currentSessionBusAttendant"); out.print(attendant.getName());%><b class="caret"></b></a>
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
      <h1>Welcome, <%out.print(attendant.getName()); %></h1>
      <p>Using the above Navigation Bar you can choose to:</p>
      <ul>
      	<li>View the Bus Route.</li>
      	<li>View the attendance list.</li>
      	<li>Send an alert.</li>
      </ul>
      <hr>
      <h3></h3>
      <p></p>
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


