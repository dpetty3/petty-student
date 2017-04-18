package Servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bursar.business.Employee;

import bizlogic.DBDriver;


@MultipartConfig
public class ReimbServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//////////////////////////////////////////////////////////////////////
		// Start with making a connection to get the form submission fields//// 
		//            and saving it to the database////////////////////////////
		String driver = getServletContext().getInitParameter("driver");
		String url = getServletContext().getInitParameter("URL");
		String user = getServletContext().getInitParameter("username");
		String pass = getServletContext().getInitParameter("password");
		
		DBDriver dao = new DBDriver(driver,url,user,pass);
		////////////////////////////////////////////////////////////////////////
	
		// Get the form submissions from web page [expense type : specified reimbursement]
		String expType = req.getParameter("expType");
		double amt = Double.parseDouble(req.getParameter("expAmt"));
		
		//Instantiate input stream of the multi-part file
		InputStream is = null;
		
		// Gets file in the multi-part request 
		Part receipt= req.getPart("receipt");
		
		if (receipt != null)
		{
			// prints out file info for debugging
			System.out.println(receipt.getName());
			System.out.println(receipt.getSize());
			System.out.println(receipt.getContentType());
			
			// obtains input stream of the upload file 
			is = receipt.getInputStream();
		}
		
		
		//   Call insertForm method to insert the form to a file and database
		//                        File for printing 
		//                      Database for storing
		//
		
		
		Employee employee = (Employee)req.getSession().getAttribute("emp");

		
		// Instantiate the receipt to pending
		String status = "Pending";
		dao.insertForm( employee, expType, amt, status, is);
		
		resp.sendRedirect("reimburse.jsp");
		
	}
	
}
