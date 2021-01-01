package com.Guillaume.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDbUtil {
    private DataSource dataSource;

    public UserDbUtil (DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<User> getUser() throws Exception {
        List<User> user= new ArrayList<User>();
        Connection myConn=null;
        Statement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql= "select * from user order by username;";
            myRs = myStmt.executeQuery(sql);
            while(myRs.next()){
                String username = myRs.getString("username");
                String password=myRs.getString("password");
                boolean teacher=myRs.getBoolean("teacher");
                User tempUser= new User(username, password, teacher);
                user.add(tempUser);
            }
            return user;
        } finally{
            close(myConn,myStmt,myRs);
        }
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
