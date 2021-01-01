package com.Guillaume.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/TodoListServletTeacher")
public class TodoListServletTeacher extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoDbUtil todoDbUtil;
    @Resource(name="jdbc/tdlistdb")
    private DataSource dataSource;
    private CheckUser checkuser;
    private HttpSession session;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	String username = user.getUsername();
    	try {
			if(checkuser.getTeacher(username) == true) {
			    try {
			    	List<Todo> todo = todoDbUtil.getTodo();
			        request.setAttribute("TODO_LIST", todo);
			        System.out.print("test");
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/TestServlet.jsp");
			        dispatcher.forward(request, response);
			    } catch (Exception e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    }
			}
			else {
				request.getRequestDispatcher("ErrorStudentOverstep.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        todoDbUtil = new TodoDbUtil(dataSource);
        checkuser = new CheckUser(dataSource);
    }
}
