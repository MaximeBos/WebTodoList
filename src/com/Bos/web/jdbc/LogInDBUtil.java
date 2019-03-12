package com.Bos.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;


public class LogInDBUtil {
	private DataSource dataSource;
	public LogInDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public User LoginInstructor(User user) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;		
		
		 String login = user.getLogin();  
         String mdp = user.getMdp();  
	    		
		try {
			myConn = dataSource.getConnection();
			String sql =  "select * from tododb.instructor where login='" + login + "' AND mdp='" + mdp + "'";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			boolean more = myRs.next();
						
			if (!more) 
	         {
				user.setValid(false);  
	         }
			
			 else if (more) 
	         {
	            user.setValid(true);
	         }
			
		}
		
		catch (Exception ex) 
	      {
	         System.out.println("Log In failed: An Exception has occurred! " + ex);
	      } 
		finally 
	      {
	         close(myConn, myStmt, myRs);
	         }
	      
		return user;
	}
	
	public User LoginStudent(User user) throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;		
		
		 String login = user.getLogin();  
         String mdp = user.getMdp();  
	    		
		try {
			myConn = dataSource.getConnection();
			String sql =  "select * from tododb.student where login='" + login + "' AND mdp='" + mdp + "'";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			boolean more = myRs.next();
						
			if (!more) 
	         {
				user.setValid(false);  
	         }
			
			 else if (more) 
	         {
	            user.setValid(true);
	         }
			
		}
		
		catch (Exception ex) 
	      {
	         System.out.println("Log In failed: An Exception has occurred! " + ex);
	      } 
		finally 
	      {
	         close(myConn, myStmt, myRs);
	         }
	      
		return user;
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


