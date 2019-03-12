package com.Bos.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DeleteToDoServlet
 */
@WebServlet("/DeleteToDoServlet")
public class DeleteToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDBUtil todoDBUtil;
	
	@Resource(name="jdbc/tododb")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		todoDBUtil = new ToDoDBUtil(dataSource);
	}
	
    public DeleteToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("todoId"));
		todoDBUtil.deleteToDo(id);
		response.sendRedirect("ToDoControllerServlet");
	}

}
