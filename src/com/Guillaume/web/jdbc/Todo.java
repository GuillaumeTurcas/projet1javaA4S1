package com.Guillaume.web.jdbc;

public class Todo {
	public int idtodo;
	public String description;
	
	public int getIdtodo() {
		return this.idtodo;
	}
	
	public void setIdtodo(int idtodo) {
		this.idtodo = idtodo;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Todo(int idtodo, String description) {
		super();
		this.idtodo = idtodo;
		this.description = description;
	}
	
	
	@Override
    public String toString() { 
        return "[" + this.idtodo + "] [ " + this.description + " ]"; 
    }}
