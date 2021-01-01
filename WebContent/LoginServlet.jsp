<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: #34495e;
}

h1{
  color: white;
  text-transform: uppercase;
  font-weight: 500;
}

h4{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
}

input[type=checkbox] {
    -webkit-appearance: none;
    -border-radius: 8px;
    height: 15px;
    width: 15px;
    background: none;
    border: 1px solid #2ecc71;
}

a {  
  text-decoration: none;
}


a:link {
  color: white;
}

a:visited {
  color: white;
}

input[type = "text"],.box input[type = "password"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
}

input[type = "text"]:focus,.box input[type = "password"]:focus{
  width: 280px;
  border-color: #2ecc71;
}
input[type = "submit"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #2ecc71;
  padding: 14px 40px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}
input[type = "submit"]:hover{
  background: #2ecc71;
}

table {
	width: 300px;
  padding: 40px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: #191919;
  text-align: center;
}
.custom {
		font-family: Courier;
		color: red;
		font-size:20px
}
form {
 width: 300px;
  padding: 40px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: #191919;
  text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div style="text-align: center">
		<form class="box" action="LoginServlet" method="post">
				<h1>Login</h1>

				<input type="text" id ="username" name="username" placeholder="username" maxlength="60" required = "true" value="${requestScope.username}" />

				<input type="password" id="password" name="password" placeholder="password" required="true" />

				<input type="submit" value="Submit" />
				
				<br /> 
				
				<p class="custom" > ${checkuser.getResult() }</p>>
		</form>
	</div>
</body>
</html>

