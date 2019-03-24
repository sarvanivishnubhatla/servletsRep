package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/New")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String user=request.getParameter("txtlogin");
		String pass=request.getParameter("textpass");
		if(user.equals("sa")&&pass.equals("sa"))
		{
			out.println("<font color='yellow'> welcome to servlet</font>");
			//RequestDispatcher rd=request.getRequestDispatcher("Welcome");
			//rd.include(request, response);
			response.sendRedirect("Welcome");
		}
		else
		{
			out.println("<font color='red'>check your user name and password</font>");
		}
	}

	
}
