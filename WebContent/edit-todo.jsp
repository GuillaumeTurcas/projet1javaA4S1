<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Edit a Todo</title>
<style type="text/css">
            	body {
 		 margin: 0;
	  padding: 0;
 		 font-family: sans-serif;
 	 background: #34495e;
    	}
  input[type = "text"] {
  border:0;
  background: none;
  display: block;
  transform: center;
  margin: 20px auto;
  border: 2px solid #2ecc71;
  padding: 14px 10px;
  width: 500px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
}

input[type = "text"]:focus {
  width: 580px;
  border-color: #2ecc71;
}
	input[type="submit"]{
		  border:0;
		  background: none;
		  display: block;
		  margin: 20px auto;
		  top: 60%;
		  left: 50%;
		  position:absolute;
		  text-align: center;
		  border: 2px solid #2ecc71;
		  padding: 14px 40px;
		  outline: none;
		  color: white;
		  border-radius: 24px;
		  transition: 0.25s;
		  cursor: pointer;
	}
	input[type="submit"]:hover {
		  background: #2ecc71;
	}
	h1 {
		color: white;
		text-transform: uppercase;
		font-weight: 800;
		transform: translate(42%,0);
	}
	h2 {
		color: white;
		text-transform: uppercase;
		font-weight: 500;
		transform: translate(42%,0);
	}
	a {
	border:0;
		  background: none;
		  display: block;
		  margin: 20px auto;
		  top: 60%;
		  left: 10%;
		  position:absolute;
		  text-align: center;
		  border: 2px solid #2ecc71;
		  padding: 14px 40px;
		  outline: none;
		  color: white;
		  border-radius: 24px;
		  transition: 0.25s;
		  cursor: pointer;
	}
	a:hover {
		background: #2ecc71;
	}
</style>
</head>
<body>
<div id="container">
	<h1> Edit a Todo</h1>
	<h2> Description</h2>
<form action="EditTodoServlet" method = "post">
<table>
	<tbody>
	<tr>
	<td><input type="text" name = "description" value="${Todo.description}"/></td>
	</tr>
	<tr>
	<td><label></label> </td>
	<td><input type="submit" value = "Save"/></td>
	</tr>
	</tbody>
</table>
</form>
<div style="clear:both;"></div>
	<a href="TodoListServletTeacher">Back to List</a>
</div>


</body>
</html>