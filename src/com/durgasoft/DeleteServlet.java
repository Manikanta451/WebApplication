package com.durgasoft;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		EmployeeDao dao=EmployeeDaoFactory.getEmployeeDao();
		String status=dao.delete(eid);
		RequestDispatcher rd=request.getRequestDispatcher("delete.html");
		rd.forward(request, response);
	}
}
