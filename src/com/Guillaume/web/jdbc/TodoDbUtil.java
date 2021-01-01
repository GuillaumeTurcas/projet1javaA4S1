package com.Guillaume.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TodoDbUtil {
    private DataSource dataSource;

    public TodoDbUtil (DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Todo> getTodo() throws Exception {
        List<Todo> todo= new ArrayList<Todo>();
        Connection myConn=null;
        Statement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql= "select * from todo order by idtodo;";
            myRs = myStmt.executeQuery(sql);
            while(myRs.next()){
                int id = myRs.getInt("idtodo");
                String description=myRs.getString("description");
                Todo tempTodo= new Todo(id,description);
                todo.add(tempTodo);
            }
            return todo;
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
    
    public Todo fetchTodo(int id) {
    	Connection myConn=null;
        Statement myStmt = null;
        ResultSet myRs= null;
        Todo todo = null;
        
        try {
        	myConn = dataSource.getConnection();
            myStmt= myConn.createStatement();
            String sql= "select * from todo where idtodo="+id+";";
            myRs = myStmt.executeQuery(sql);
            
            while(myRs.next()) {
            	String description=myRs.getString("description");
                todo = new Todo(id,description);
            }
            return todo;
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        	return null;
        }finally {
        	close(myConn,myStmt,myRs);
        }
    }
    
    public void updateTodo(Todo todo) {
    	Connection myConn=null;
    	PreparedStatement myStmt = null;
    	try {
	    	myConn = dataSource.getConnection();
	    	String sql = "update todo set description=? where idtodo=?";
	    	myStmt = myConn.prepareStatement(sql);
	    	myStmt.setString(1, todo.getDescription());
	    	myStmt.setInt(2, todo.getIdtodo());
	    	myStmt.execute();
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	finally{
    		close(myConn,myStmt,null);
    	}

    }
    
    public void suppTodo(Todo todo) {
    	Connection myConn=null;
    	PreparedStatement myStmt = null;
    	try {
	    	myConn = dataSource.getConnection();
	    	String sql = "DELETE FROM todo WHERE idtodo = ?";
	    	myStmt = myConn.prepareStatement(sql);
	    	myStmt.setInt(1, todo.getIdtodo());
	    	myStmt.execute();
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	finally{
    		close(myConn,myStmt,null);
    	}
    }
    
    public void addTodo(Todo todo) {
    	Connection myConn=null;
    	Statement statement = null;
    	try {
	    	myConn = dataSource.getConnection();
	    	statement = myConn.createStatement();
	    	int statut = statement.executeUpdate( "INSERT INTO todo(description) VALUES ('"+todo.description+"');" );
	    	System.out.println(statut);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	finally{
    		close(myConn,statement,null);
    	}
    }
}
