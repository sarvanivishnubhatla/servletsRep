package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ConnectionCls;


@WebServlet("/New")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String user=request.getParameter("txtlogin");
		String pass=request.getParameter("textpass");
		ConnectionCls c1 = new ConnectionCls();
		ResultSet rs=null;
		try {
			rs=c1.storeData(user,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next())
			{
			out.println("loginSucessful");
			response.sendRedirect("ConfigParameterPage.html");
			}
			else
			{
				out.println("login Failed , please enter correct cridenctials");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
