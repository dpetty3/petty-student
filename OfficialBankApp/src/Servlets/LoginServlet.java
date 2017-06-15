package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FauxBank.business.Customer;

import buslogic.DBDriver;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doPost(req, resp);
	}

	@Override // Contain business methods
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get context parameters for database
		String driver = getServletContext().getInitParameter("Driver");
		String url = getServletContext().getInitParameter("URL");
		String user = getServletContext().getInitParameter("username");
		String pass = getServletContext().getInitParameter("password");

		DBDriver dao = new DBDriver(driver, url, user, pass);

		// fetch variables/values from the REQUEST object!
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		// Call authenticate customer from DBDriver class
		Customer customer = dao.authenticateCustomer(username, password);
		
		if (customer == null) {
			resp.sendRedirect("login.html");
			
		} else {
			//get a session for keeping the customers info
			HttpSession session = req.getSession();
			session.setAttribute("client", customer);
			resp.sendRedirect("trans.html");
		}
	}

	// System.out.println( username + "," + password);

	// This out object will allow you to print to browser
	// PrintWriter out = resp.getWriter();
	/*
	 * 
	 * if(username.equals()&& (password.equals("1234"))) { //Send to transaction
	 * page for successful login resp.sendRedirect("trans.html");
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * else { //option 1 //show failure page //Show success page
	 * out.println("<html>"); out.println("<body bgcolor = 'orange'>");
	 * out.println("FAILURE!!!"); out.println("</body>");
	 * out.println("</html>");
	 * 
	 * //option 2 //server-side //prepares the forward to remember it for that
	 * instant RequestDispatcher rd = req.getRequestDispatcher("/failure.html");
	 * // forwards it rd.forward(req, resp);
	 * 
	 * 
	 * //option 3 //client-side resp.sendRedirect("login.html");
	 * 
	 * }
	 */

}
