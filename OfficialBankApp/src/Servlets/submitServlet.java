package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FauxBank.business.Customer;
import com.FauxBank.business.Transaction;

import buslogic.DBDriver;

public class submitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get context parameters for database connection
		String driver = getServletContext().getInitParameter("Driver");
		String url = getServletContext().getInitParameter("URL");
		String user = getServletContext().getInitParameter("username");
		String pass = getServletContext().getInitParameter("password");

		// Call insert from DBDriver class
		DBDriver dao = new DBDriver(driver, url, user, pass);

		// update customer object in session
		HttpSession session = req.getSession();
		Customer person = (Customer) session.getAttribute("client");
		double amt = Double.parseDouble(req.getParameter("amt"));
		double newBal = person.getBalance() + amt;
		System.out.println(amt);
		System.out.println(newBal);
		person.setBalance(newBal);

		session.setAttribute("client", person);

		
			
		// create transaction object
		Transaction newTrans = new Transaction();
		String tType = amt > 0? "deposit" : "withdraw";
		System.out.println(tType);
		newTrans.setTxType(tType);
		newTrans.setAmount(amt);
		
		
		dao.transSub(person, newTrans);
		

	}

}
