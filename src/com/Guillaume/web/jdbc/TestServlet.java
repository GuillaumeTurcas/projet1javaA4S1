package com.Guillaume.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name="jdbc/tdlistdb")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
    		//Step1:
            PrintWriter out = response.getWriter();
            response.setContentType("text/plain");
            //Step2: Get a connection to the database
            Connection myConn=null;
            Statement myStmt= null;
            ResultSet myRs=null;
            try{
                myConn= dataSource.getConnection();
                //Step3: create SQL statements
                String sql = "SELECT username FROM user;";
                myStmt= myConn.createStatement();
                //Step4: Execute SQL query
                myRs=myStmt.executeQuery(sql);
                //Step5: Process the ResultSet
                while(myRs.next()){
                	String password = myRs.getString("username");
                    out.println(password);
                }
            }catch(Exception exc){
                System.out.println(exc.getMessage());
            }
        }
}
