package com.durgasoft;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String eaddr=request.getParameter("eaddr");
		String egender=request.getParameter("egender");
		EmployeeDao dao=EmployeeDaoFactory.getEmployeeDao();
		String status=dao.update(eid,ename,eaddr,egender);
		RequestDispatcher rd=request.getRequestDispatcher(status+".html");
		rd.forward(request, response);
	}

}
