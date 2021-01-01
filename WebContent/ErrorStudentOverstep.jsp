<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Access Denied</title>
<style type="text/css">
body {
 		 margin: 0;
	  padding: 0;
 		 font-family: sans-serif;
 	 background: #34495e;
    	}
h1 {
	color: red;
	text-transform: uppercase;
	font-weight: 500;
}

input[type="submit"]{
		  border:0;
		  background: none;
		  display: block;
		  margin: 20px auto;
		  top: 80%;
		  left: 50%
		  text-align: center;
		  border: 2px solid Tomato;
		  padding: 14px 40px;
		  outline: none;
		  color: white;
		  border-radius: 24px;
		  transition: 0.25s;
		  cursor: pointer;
		}
		input[type="submit"]:hover {
		  background: Tomato
;
		}

</style>
</head>
<body>
<h1>Access Denied, Teacher account require</h1>
<form action="LogoutServlet" method = "get">
		<input type="submit" value = "Log out"/>
	</form>
</body>
</html>