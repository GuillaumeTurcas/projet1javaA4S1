<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.Guillaume.web.jdbc.*" %>
<html>
    <head>
    <style type="text/css">
    	body {
 		 margin: 0;
	  padding: 0;
 		 font-family: sans-serif;
 	 background: #34495e;
    	}
    	td {
			border:0;
  			background: none;
  			display: block;
		    margin: 20px auto;
		    text-align: center;
		    border: 2px solid #2ecc71;
		    padding: 14px 10px;
		    width: 200px;
		    outline: none;
		    color: white;
		    border-radius: 24px;
		    width: 80%;
			
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
		  width: 80%;
		}
		th {
		  color: white;
		  text-transform: uppercase;
		  font-weight: 500;
		  
		}
		input[type="submit"]{
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
		input[type="submit"]:hover {
		  background: #2ecc71;
		}
		h1 {
			color: white;
		  	text-transform: uppercase;
		  	font-weight: 800;
		}
    </style>
        <title>To do List</title>

    </head>
    <body>
    <div id="container">
	<div id="content">
	<form action="LoginController" method = "post" style="text-align: center">
	<br />
	<h1> Welcome ${sessionScope.user.username }</h1>
	<h1> ToDo List</h1>
	<table style="text-align: center" >
	<tr>
	<th>Description </th>
	</tr> 
	<c:forEach var="tempTodo" items="${TODO_LIST}" >
	<tr>
	<td> ${tempTodo.description}</td>
	</c:forEach>
	</table>
	</form>
	<form action="LogoutServlet" method = "get" >
		<input type="submit" value = "Log out" style="align: bottom" />
	</form>
	</div>
	</div>
    </body>
</html>
