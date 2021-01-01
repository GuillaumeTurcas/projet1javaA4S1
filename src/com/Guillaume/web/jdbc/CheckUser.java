package com.Guillaume.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;


public class CheckUser {
	private DataSource dataSource;
	
	 public CheckUser (DataSource theDataSource) {
	        dataSource = theDataSource;
	    }
	private String dbURL = "jdbc:mysql://localhost:3306/tdlistdb";
	private String dbUname = "root";
	private String dbPassword = "S1997o91l17";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	private String result = " ";
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean getTeacher(String username) throws Exception {
		loadDriver(dbDriver);
		Connection myConn=null;
        Statement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql= ("SELECT teacher FROM user WHERE username ='" + username + "';");
            myRs = myStmt.executeQuery(sql);
            boolean teacher = false;
            while(myRs.next()){
                teacher =myRs.getBoolean("teacher");
            }
            return teacher;
        } finally{
            close(myConn,myStmt,myRs);
        }
    }
	
	public boolean validate(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "SELECT * FROM user WHERE username = ? and password = ?;";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if(!status) {
				result = "User not found, try again";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	 private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
	        try{
	            if(myStmt!=null)
	                myStmt.close();
	            if(myRs!=null)
	                myRs.close();
	            if(myConn!=null)
	                myConn.close();
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	 }
	
}
