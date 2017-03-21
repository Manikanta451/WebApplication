package com.durgasoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		EmployeeDao dao=EmployeeDaoFactory.getEmployeeDao();
		EmployeeTo eto=dao.search(eid);
		if(eto!=null){
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body bgcolor='lightblue'>");
			out.println("<br><br><br><center>");
			out.println("<table border='1'>");
			out.println("<tr><td>Employee Id</td><td>"+eto.getEid()+"</td></tr>");
			out.println("<tr><td>Employee Name</td><td>"+eto.getEname()+"</td></tr>");
			out.println("<tr><td>Employee Address</td><td>"+eto.getEaddr()+"</td></tr>");
			out.println("</table></center></body></html>");
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("notexisted.html");
			rd.forward(request, response);
		}
	}

}
