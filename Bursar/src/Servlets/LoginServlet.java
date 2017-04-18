package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bursar.business.Employee;

import bizlogic.DBDriver;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		//////////// Set up database connection/////////////////////////
		String driver = getServletContext().getInitParameter("driver");
		String url = getServletContext().getInitParameter("URL");
		String user = getServletContext().getInitParameter("username");
		String pass = getServletContext().getInitParameter("password");
		
		DBDriver dao = new DBDriver(driver, url, user, pass);
		////////////////////////////////////////////////////////////////
		
		// Get the users input from web page
		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		
		// Call authenticate employee method
		// from DBDriver for receiving which employee
		// An employee or null will be returned
		Employee emp = dao.authenticateEmployee(username, password);
		

		// If null -> return them to the login page and have them try again
		if(emp == null)
		{
			
			resp.sendRedirect("login.html");
			
		}
		else
		{
			//-----------------------------------------------------//
			//   Start a session for holding employee while being logged in
			// The session employee = emp
			HttpSession session = req.getSession();

			session.setAttribute("emp", emp);
			if(emp.getStat().equals("M"))
			{
				// direct them to the manager view
				resp.sendRedirect("reimburse.jsp");
			}
			if(emp.getStat().equals("E"))
			{
				// direct them to the employee view
				resp.sendRedirect("reimburse.jsp");
			}
			//-----------------------------------------------------------//
		}
	}
}
