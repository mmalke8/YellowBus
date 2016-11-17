<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Track Bus</title>
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
	<%@ page language="java" import="java.util.ArrayList" %>
	<%@page import="databasePackage.*" %>
	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="TrackBusAttendant.jsp">Track Bus</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="attendant.jsp">Home</a></li>
        <li><a href="alert.jsp">Send Alert</a>
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
    
   <div class="col-sm-4 text-center">
   
   	<h2>Attendance List</h2>
   	<div class="col-sm-12 text-center">
   		<form action="attendanceList.jsp">
			<%
			
				ArrayList<Student> studentList = BusDB.getList(attendant.getUaeId());
				session = request.getSession();
				session.setAttribute("studentList", studentList);
				for(Student student:studentList){
					out.print("<input type=\"checkbox\" name=\"student\" value=\""+student.getName()+"\"> "+student.getName()+"<br>");
				}
			
			%>
			<button class="btn btn-success" type="submit" name="submit" value="attendanceList">Submit List!</button>
		</form>
   	</div>
   
   </div>
   <div class="col-sm-4 text-center">
   	
   		
   			
   			
   	
   </div>
    
    <div class="col-sm-2 sidenav">
      
    </div>
  </div>
  </div>

<footer class="container-fluid text-center">
  
</footer>











<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDSusI39kTTNKMQIYNbgRSOnlvq6Qp54QU"></script> 
<script>
function myMap() {
  var mapCanvas = document.getElementById("map");
  var myCenter = new google.maps.LatLng(51.508742,-0.120850); 
  var mapOptions = {center: myCenter, zoom: 15};
  var map = new google.maps.Map(mapCanvas,mapOptions);
  var marker = new google.maps.Marker({
    position: myCenter
  });
  marker.setMap(map);
}
</script>

<!--  <script>
function geoFindMe() {
	  var output = document.getElementById("out");

	  if (!navigator.geolocation){
	    output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
	    return;
	  }

	  function success(position) {
	    var latitude  = position.coords.latitude;
	    var longitude = position.coords.longitude;

	    output.innerHTML = '<p>Latitude is ' + latitude + ' <br>Longitude is ' + longitude + '</p>';

	    var img = new Image();
	    var src = "https://maps.googleapis.com/maps/api/staticmap?center=" +latitude+ "," +longitude+ "&zoom=13&size=300x300&sensor=false";

	    output.appendChild(img);
	  }

	  function error() {
	    output.innerHTML = "Unable to retrieve your location";
	  }

	  output.innerHTML = "<p>Locating...</p>";

	  navigator.geolocation.getCurrentPosition(success, error);
	}
</script>-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>