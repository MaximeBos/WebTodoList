package com.Bos.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class InstructorLogServlet
 */
@WebServlet("/InstructorLogServlet")
public class InstructorLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LogInDBUtil loginDBUtil;
	
	@Resource(name="jdbc/tododb")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		loginDBUtil = new LogInDBUtil(dataSource);
	}
	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					request.setAttribute("login", cookie.getValue());
				}
				if(cookie.getName().equals("mdp")) {
					request.setAttribute("mdp", cookie.getValue());
				}
			}
		request.getRequestDispatcher("/login-instructor.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			User user = new User();
		     user.setLogin(request.getParameter("login"));
		     user.setMdp(request.getParameter("mdp"));
		     user=  loginDBUtil.LoginInstructor(user);

	     
	     if (user.isValid())
	     { 
	    	 Cookie cookielogin = new Cookie("login", user.getLogin());
	    	 Cookie cookiemdp = new Cookie ("mdp", user.getMdp());
	    	 
	    	 cookielogin.setMaxAge(60*60*24*31);
	    	 cookiemdp.setMaxAge(60*60*24*31);
	    	 
	    	 response.addCookie(cookiemdp);
	    	 response.addCookie(cookielogin);
	    	 
	    	 response.sendRedirect("ToDoControllerServlet");  
	     }
	     
	     else
	     {
	    	 response.sendRedirect("error.jsp");
	     }
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}
	
	
	

}
