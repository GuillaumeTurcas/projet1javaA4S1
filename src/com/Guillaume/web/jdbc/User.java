package com.Guillaume.web.jdbc;

public class User {
	private String username;
	private String password;
	private boolean teacher;
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean getTeacher() {
		return teacher;
	}
	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User(String username, String password, boolean teacher) {
		super();
		this.username = username;
		this.password = password;
		this.teacher = teacher;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@Override
    public String toString() { 
        return "[" + this.username + "] [ is teacher = " + this.teacher + " ]"; 
    }
}
