<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" type="text/css" href="loginCSS.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<title>User Login</title>


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
  
</head>
<body>
<%@ page language="java" import="endUsers.*" %>



<header class="container-fluid text-center">
<div class="container col sm-4 left" id="page_header">
		<h2 class="col-sm-4"><span class="glyphicon glyphicon-log-in"></span> User Login</h2>
		<h2 class="col-sm-8 text-right"><a href="Welcome.jsp"><span class="glyphicon glyphicon-home"></span></a> Home</h2>
</div>

  </header>
<div class="jumbotron" id=jumbotron>    
  <div class="container" id="infoContainer">
    <div class="col-sm-12 text-center"> 
      <form action="newJSP.jsp" method="POST">
			<p>
				<label>Username</label>
				<input type = "text"
					   name = "myUsername"/>
			
			</p>
			<p>
				<label>Password</label>
				<input type="password"
					   name="myPassword"/>
			
			</p>
			<button class="btn btn-success" name="loginButton" id="loginButton" type="submit">Login</button>
			</form>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
 
</footer>
<script src="bootstrap/js/notify.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>