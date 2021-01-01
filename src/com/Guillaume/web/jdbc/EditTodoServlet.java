package com.Guillaume.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class EditTodoServlet
 */
@WebServlet("/EditTodoServlet")
public class EditTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUser checkuser;
    private HttpSession session;
	
	private TodoDbUtil todoDbUtil;
	
	@Resource(name="jdbc/tdlistdb")
	private DataSource dataSource;
	
	int id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		todoDbUtil = new TodoDbUtil(dataSource);
		checkuser = new CheckUser(dataSource);
	}
	
	public EditTodoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	String username = user.getUsername();
    	try {
			if(checkuser.getTeacher(username) == true) {
				id = Integer.parseInt(request.getParameter("todoId"));
				Todo todo = todoDbUtil.fetchTodo(id);
				request.setAttribute("Todo", todo);
				request.getRequestDispatcher("edit-todo.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("ErrorStudentOverstep.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		Todo todo = new Todo(id, description);
		todoDbUtil.updateTodo(todo);
		response.sendRedirect("TodoListServletTeacher");
	}

}
