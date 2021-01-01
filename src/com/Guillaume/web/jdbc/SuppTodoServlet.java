package com.Guillaume.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SuppTodoServlet
 */
@WebServlet("/SuppTodoServlet")
public class SuppTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TodoDbUtil todoDbUtil;
	
	@Resource(name="jdbc/tdlistdb")
	private DataSource dataSource;
	
	int id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		todoDbUtil = new TodoDbUtil(dataSource);
	}
	
	public SuppTodoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("todoId"));
		Todo todo = todoDbUtil.fetchTodo(id);
		request.setAttribute("Todo", todo);
		todoDbUtil.suppTodo(todo);
		response.sendRedirect("TodoListServletTeacher");
	}

}
