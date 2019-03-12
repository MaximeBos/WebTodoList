package com.Bos.web.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.annotation.Resource;


/**
 * Servlet implementation class EditToDoServlet
 */
@WebServlet("/EditToDoServlet")
public class EditToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ToDoDBUtil todoDBUtil;
	
	@Resource(name="jdbc/tododb")
	private DataSource dataSource;
	
	int id;
	@Override
	public void init() throws ServletException {
	super.init();
	todoDBUtil = new ToDoDBUtil(dataSource);
	}
	
    public EditToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id=Integer.parseInt(request.getParameter("todoId"));
		ToDo todo= todoDBUtil.fetchToDo(id);
		request.setAttribute("todo", todo);
		request.getRequestDispatcher("edit-todo.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String des= request.getParameter("description");
		ToDo todo = new ToDo(id,des);
		todoDBUtil.updateToDo(todo);
		response.sendRedirect("ToDoControllerServlet");
	}
	
	

}
