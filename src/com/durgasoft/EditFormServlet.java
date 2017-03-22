package com.durgasoft;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("eid");
		String egender=request.getParameter("egender");
		EmployeeDao dao=EmployeeDaoFactory.getEmployeeDao();
		EmployeeTo eto=dao.getEmployee(eid);
		if(eto!=null){
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body bgcolor='lightblue'>");
			out.println("<form method='post' action='./update'>");
			out.println("<center><br><br>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>Employee Id  :</td><td>"+eto.getEid()+"</td>");
			out.println("<input type='hidden' name='eid' value='"+eto.getEid()+"'/>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Employee Name</td><td><input type='text' name='ename' value='"+eto.getEname()+"'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Employee Address</td><td><input type='text' name='eaddr' value='"+eto.getEaddr()+"'/></td>");
			out.println("</tr>");
			out.println("<tr><td>Gender</td><td><input type='radio' name='egender' value='+Male+'>Male</input</td><td><input type='radio' name='egender' value='FeMale'>Female</input></td></tr>");
			out.println("<tr>");
			out.println("<td>Date Of Join</td><td><input type='date' name='edoj' value='"+eto.getEdoj()+"'/></td>");
			out.println("</tr>");
			out.println("<td><input type='submit' value='Update'/></td>");
			out.println("</tr>");
			out.println("</table></center></form></body></html>");
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("notexisted.html");
			rd.forward(request, response);
		}
	}

}
