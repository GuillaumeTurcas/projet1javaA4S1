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
        h1 {
			color: white;
		  	text-transform: uppercase;
		  	font-weight: 800;
		  	transform: translate(42%,0);
		}
		table {
		  width: 300px;
		  padding: 40px;
		  transform: translate(+13%,0);
		  background: #191919;
		  text-align: center;
		  width: 80%;
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
		    width: 70%;
		    border-radius: 24px;
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
		  top: 80%;
		  left: 50%;
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
		a {
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
	a:hover {
		background: #2ecc71;
	}
		
    </style>
        <title>To do List</title>
    </head>
    <body>
        <div id="container">
	<div id="content">
	<form action="LoginController" method = "post">
	<h1> Welcome ${sessionScope.user.username }</h1>
	<h1> Todo List </h1>
	<table>
		<tr>
			<th>Description </th>
		</tr> 
		<c:forEach var="tempTodo" items="${TODO_LIST}" >
			<tr>
			<c:url var="EditLink" value="EditTodoServlet">
			<c:param name="todoId" value="${tempTodo.idtodo}"/>
			</c:url>
			<c:url var="SuppLink" value="SuppTodoServlet">
			<c:param name="todoId" value="${tempTodo.idtodo }"/>
			</c:url>
				<td> ${tempTodo.description}</td>
				<td> <a href="${EditLink }"> Edit</a></td>
				<td> <a href="${SuppLink }"> Supp</a></td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<form action="LogoutServlet" method = "get">
		<input type="submit" value = "Log out"/>
	</form>
	<form action="AddTodoServlet" method = "get">
		<input type="submit" value = "Add Todo"/>
	</form>
	</div>
	</div>
    </body>
</html>
