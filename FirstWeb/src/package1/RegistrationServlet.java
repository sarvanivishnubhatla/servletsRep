package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String FirstName=request.getParameter("First-name");
        String LastName=request.getParameter("Last-name");
        String Email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        String Password=request.getParameter("Password");
        String ConfirmPassword=request.getParameter("Confirm Password");
        out.println("<font color='green'>welcome to Registration</font>");
        out.println("FirstName:"+request.getParameter("First-name")+"<br />");
        out.println("LastName:"+request.getParameter("Last-name")+"<br />");
        out.println("Email:"+request.getParameter("Email")+"<br />");
        out.println("Gender:"+request.getParameter("Gender")+"<br />");
        out.println("Password:"+request.getParameter("Password")+"<br />");
        out.println("Confirm Password:"+request.getParameter("Confirm Password")+"<br />");
        
    	RequestDispatcher rd=request.getRequestDispatcher("login.html");
    	rd.include(request,response);
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
