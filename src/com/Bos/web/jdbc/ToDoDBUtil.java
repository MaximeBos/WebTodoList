package com.Bos.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ToDoDBUtil {
	private DataSource dataSource;
	public ToDoDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;

	}
	
	public List<ToDo> getToDo() throws Exception {
		List<ToDo> todo= new ArrayList<ToDo>();
		
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todo order by id";
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()){
				int id = myRs.getInt("id");
				String description=myRs.getString("description");
			ToDo tempToDo= new ToDo(id,description);
				todo.add(tempToDo);
			}
			
		    return todo;
		    
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	
	public void addToDo(ToDo todo){
		Connection myConn=null;
		PreparedStatement myStmt = null;
		ResultSet myRs= null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "INSERT INTO todo (description) VALUES (?)";
			myStmt = myConn.prepareStatement(sql);
			 String description = todo.getDescription();
			myStmt.setString(1, description);
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,myRs);
		}
	}
	
	public ToDo fetchToDo(int id) {
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		ToDo todo=null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todo where id="+id;
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
			String description=myRs.getString("description");
			todo = new ToDo(id,description);
			}
			return todo;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	
	public void updateToDo(ToDo todo) {
		Connection myConn=null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update todo set description=? where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, todo.getDescription());
			myStmt.setInt(2,todo.getId());
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}
	
	public void deleteToDo(int id) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		Statement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "delete from todo where id="+id;
			myStmt.execute(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		} 
		finally{ 
			close(myConn,myStmt,null); 
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