<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css" href="alertCSS.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 

<title>Bus Attendant - Alerts</title>

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

 <script src="js/vendor/jquery.js"></script>
  <script src="js/foundation/foundation.js"></script>
  <script src="js/foundation/foundation.slider.js"></script>	
 <script>
    $(document).foundation();
  </script>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Send Alert</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="attendant.jsp">Home</a></li>
        <li><a href="TrackBusAttendant.jsp">View Route</a></li>     
       </ul>   
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%BusAttendant attendant = (BusAttendant)request.getSession().getAttribute("currentSessionBusAttendant"); out.print(attendant.getName()); %></a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    
    </div>
    <div class="col-sm-8 text-left"> 
      <h1><%out.print(attendant.getName()); %>,</h1>
      <p>Using the above Navigation Bar you can choose to:</p>
      <ul>
      	<li>Go Back to the Bus Attendant HomePage.</li>
      	<li>Go to the Tracking Attendance Interface.</li>
      </ul>
      <hr>
      
      <h3>In case of an unsuspected event, report the severity, along with a description.</h3>

      <form>
    <div class="form-group">
      <label for="sel1">Select Severity:</label>
      <select class="form-control" id="sel1">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
      </div>
      </form>

      <div class="form-group">
  <label for="comment">Write Alert</label> <label for="comment"> <u> (maximum 200 characters)</u></label> <label for="comment">: </label>
  
  <textarea class="form-control" rows="5" cols="5" maxlength="200" id="comment"></textarea>
  <button class="btn btn-primary center-block" type="submit" >Send</button>
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
