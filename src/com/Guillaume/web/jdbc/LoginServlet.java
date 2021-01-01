package com.Guillaume.web.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.Guillaume.web.jdbc.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/tdlistdb")
	private DataSource dataSource;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lastUser = getCookieValue(request, "username");
		if(lastUser != null) {
			request.setAttribute("lastUser", lastUser);
		}
		this.getServletContext().getRequestDispatcher("/LoginServlet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//UserDbUtil userDbUtil = new UserDbUtil(dataSource);
		CheckUser checkuser = new CheckUser(dataSource);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String destPage = "LoginServlet.jsp";

		User user = new User(username, password);
		
		try {
			HttpSession session = request.getSession();
            if (checkuser.validate(user)) {
            	session.setAttribute("error", "");
                session.setAttribute("user",user);
                Cookie cookie = new Cookie("user", username);
                cookie.setMaxAge(60*60*24*365);
                response.addCookie(cookie);
                if (checkuser.getTeacher(username) == true){
                	destPage = "TodoListServletTeacher";
                	response.sendRedirect(destPage);
                }
                else {
                	destPage = "TodoListServlet";
                	response.sendRedirect(destPage);
                	} 
                }
            else {
            	session.setAttribute("error", "Wrong password or username");
            	request.setAttribute("checkuser", checkuser);
        		request.getServletContext().getRequestDispatcher("/LoginServlet.jsp").forward(request, response);
            }
        } catch(Exception exc) {
          System.out.println(exc.getMessage());
        }
	}
	
	private static String getCookieValue(HttpServletRequest request, String username) {
		Cookie[] cookies = request.getCookies();;
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if( cookie != null && username.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

}