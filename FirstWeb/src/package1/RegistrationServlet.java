package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ConnectionCls;
import com.model.User;


@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String FirstName=request.getParameter("fname");
        String LastName=request.getParameter("lname");
        String Email=request.getParameter("email");
       // String Gender=request.getParameter("Gender");
        String Password=request.getParameter("Password");
        String ConfirmPassword=request.getParameter("ConfirmPassword");
        String Dob=request.getParameter("dob");
        String Phno=request.getParameter("phno");
        
        User us=new User(FirstName,LastName,Password,Email,Phno,Dob);
        try {
			us.method();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        out.println("<table>");
        if(Password.equals(ConfirmPassword))
        {
        	out.println("Sucessfully Registered ");
        	
        	out.println("<font color='black'>welcome </font>");
        	out.println(request.getParameter("fname")+"<br/>");
            out.println("<table align=center cellspacing=3 cellpadding 2 border=3><tr><td>LastName:</td><td>"+request.getParameter("lname")+"</td></tr><br/>");
            out.println("<tr><td>Email:</td><td>"+request.getParameter("email")+"</td></tr><br/>");
            out.println("<tr><td>Gender:</td><td>"+request.getParameter("Gender")+"</td></tr><br/>");
            out.println("<tr><td>Password:</td><td>"+request.getParameter("Password")+"</td></tr><br/>");
            out.println("<tr><td>ConfirmPassword:</td><td>"+request.getParameter("ConfirmPassword")+"</td></tr><br/>");
            out.println("<tr><td>Dob:</td><td>"+request.getParameter("dob")+"</td></tr><br/>");
            out.println("<tr><td>Phno:</td><td>"+request.getParameter("phno")+"</td></tr></table>");
            
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
        	rd.include(request,response);
        }
        else
        {
        	out.println("Invalid Login");
        	out.println("<br><button><a href='registration.html'style='text-decoration:none;'>Plese Register again</a></button>");
        }
	}
}

