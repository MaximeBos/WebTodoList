package com.Bos.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ToDoControllerServlet
 */
@WebServlet("/ToDoControllerServlet")
public class ToDoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ToDoDBUtil todoDBUtil;
	
	@Resource(name="jdbc/tododb")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			listToDo(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listToDo(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		List<ToDo> todo = todoDBUtil.getToDo();
		request.setAttribute("TODO_LIST", todo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todo.jsp");
		dispatcher.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String des= req.getParameter("description");
		ToDo todo = new ToDo(des);
		todoDBUtil.addToDo(todo);
		try {
			listToDo(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		todoDBUtil = new ToDoDBUtil(dataSource);
	}
}

