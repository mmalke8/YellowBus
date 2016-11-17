<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="Welcome.css" rel="stylesheet" type="text/css">
<title>Welcome to YellowBus</title>
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
    
    /* Set orange background color, white text and some padding */
    footer {
      background-color: #FFBF00;
      color: white;
      padding: 15px;
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
  
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="Welcome.jsp">Welcome</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-1 sidenav">
    
    </div>
    <div class="col-sm-10 text-left"> 
      <img src="images/yellowBusLogo.png" width="15%" height="15%">
      <p>Welcome to YellowBus, the first School Bus Tracker web site in the UAE!<br>
      To login, <a href="login.jsp">click here</a>, or click the login button above<br>
      Different users have different accessibility on this web site 
      </p>
     
     <div class="col-sm-4 text-left">
     	<h3>Parent</h3>
     	<ul>
      	<li>Track Child's Bus</li>
      	<li>Receive notifications when the Bus is nearby (10-15mins)</li>
      	<li>Inform the Bus whether or not your child will be attending school on a given day.</li>
      	<li>Inform the Bus if your child will be picked up after school hours.</li>
      	<li>Receive alerts regarding any events that occur with your child's School Bus.</li>
      	
      </ul>
     </div>
     <div class="col-sm-4 text-left">
     	<h3>School Manager</h3>
     	<ul>
     		<li>Can track specific buses belonging to the school.</li>
     		<li>Assign buses to different groups of students</li>
     	</ul>
     </div>
     
     <div class="col-sm-4 text-left">
     	<h3>Bus Attendant</h3>
     	<ul>
     		<li>View Bus Route</li>
     		<li>Send Alerts to School and Parents</li>
     		<li>Check student's attendance</li>
     	</ul>
     </div>
     </div>
      
    <div class="col-sm-1 sidenav">
      
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
 
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>