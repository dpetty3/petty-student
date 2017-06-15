package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buslogic.DBDriver;

public class transServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		// Fetching the variables/values from the request object for transaction type
		String dTrans = req.getParameter("transType");
				
		if(dTrans.equals("Deposit") || dTrans.equals("Withdraw"))
		{
			resp.sendRedirect("dw.html");
			
		}
		else if(dTrans.equals("Check Balance") || dTrans.equals("View Transactions"))
		{
			
			resp.sendRedirect("transList.jsp");
		}

		
	}
	
	

}
