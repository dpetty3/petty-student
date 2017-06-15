package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buslogic.DBDriver;

public class regServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override // Contain business methods
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Get context parameters for database
		String driver = getServletContext().getInitParameter("Driver");
		String url = getServletContext().getInitParameter("URL");
		String user = getServletContext().getInitParameter("username");
		String pass = getServletContext().getInitParameter("password");

		// Call insert customer from DBDriver class
		DBDriver dao = new DBDriver(driver, url, user, pass);
		
		
		// fetch variables/values from the REQUEST object!
				String username = req.getParameter("user");
				String password = req.getParameter("pass");
				String fname = req.getParameter("fname");
				String lname = req.getParameter("lname");
				String email = req.getParameter("email");
				
		// Register the customer to the database 
		boolean flag = dao.insertCustomer(fname, lname, email, username, password);
		System.out.println(flag);


		// forward to login page after registration
		RequestDispatcher rd = req.getRequestDispatcher("/login.html");
		
		// close db connection
			//	dao.closeConnection();
	}

}
