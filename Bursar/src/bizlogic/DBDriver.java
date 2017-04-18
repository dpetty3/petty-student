package bizlogic;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.bursar.business.Employee;
import com.bursar.business.Receipt;

public class DBDriver {

	
	public static Connection conn;
	
	/////////////////////////////////////////////////////////////////////
	/////////Start with connecting to the database///////////////////////
	public DBDriver(String driver, String URL, String user, String pass){
		
		// Make database connection
		try{
			
			// Load the driver
			Class.forName(driver);
			
			// Create your URL
			String url = URL;
			String username = user;
			String password = pass;
	
			
			conn = DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//*************************Authenticate Customer*******************************************//
	// Login method for getting parameters [ user name , password] and authenticating employee //
	////////				If an employee RETURN TRUE else RETURN FALSE                  ///////
	public Employee authenticateEmployee(String username, String password)
	{
		try{
			
			//            Verify the employee is in the database    //
			// Thinking Ahead : Pull the first name + eid + manager //
			//                  for setting employee to a manager or// 
			//                  employee status. 					//
			
			String emp = "{call CHECKEMP(?,?,?,?,?,?)}";
			CallableStatement sp = conn.prepareCall(emp);
			
			// Set the in parameters to sp for the stored procedure
			sp.setString("UN", username);
			sp.setString("PW", password);
			
			// Get the database info of emp[first name, id, job status]////
			sp.registerOutParameter("EID", java.sql.Types.NUMERIC);
			sp.registerOutParameter("FN", java.sql.Types.VARCHAR);
			sp.registerOutParameter("LN", java.sql.Types.VARCHAR);
			sp.registerOutParameter("STAT", java.sql.Types.VARCHAR);
			
			sp.executeUpdate();
			
			long empid = sp.getLong("EID");
			String fName = sp.getNString("FN");
			String lName = sp.getNString("LN");
			String title = sp.getString("STAT");
			
			///////////////////////////////////////////////////////////
			//														///
			////////// Persist info to the employee POJO///////////////
			Employee employee = new Employee();
			employee.setEid(empid);
			employee.setUname(username);
			employee.setFname(fName);			
			employee.setLname(lName);			
			employee.setStat(title);
			
			
			//*******************************************
			// Checks to see if someone actually logged in 
			// with information in the database that checks valid
			if(employee != null)
			{
				return employee;
			}
			//*******************************************
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		// This person was not found
		return null;
	}
//*******************************************************************	


	public Receipt insertForm(Employee employee, String expType, Double amt, String status, InputStream is) {
	
		// Store these into the database.
		
		try{
			// Call stored procedure from database to input users 
			//                expense reimbursement receipt
		
			CallableStatement sp = conn.prepareCall("{call RECEIPTIN(?,?,?,?,?)}");
			
			System.out.println(employee);
			System.out.println(expType);
			System.out.println(amt);
			System.out.println(status);
			
			// Set the in parameters to sp for the stored procedure
			sp.setLong(1, employee.getEid());
			sp.setString(2, expType );
			sp.setDouble(3, amt );
			sp.setString(4, status);
			sp.setBlob(5, is);
			
			sp.executeUpdate();
			
			long eid = sp.getLong("EID");
			String eType = sp.getNString("ETYPE");
			double eAmt = sp.getDouble("EAMT");
			String stat = sp.getNString("STAT");
			Blob eRcpt = sp.getBlob("RCTIMG");
			
			///////////////////////////////////////////////////////////
			//														///
			////////// Persist info to the employee POJO///////////////
			Receipt receipt= new Receipt();
			receipt.setEmpID(eid);
			receipt.setExpType(eType);
			receipt.setExpAmt(eAmt);
			receipt.setEmpStat(stat);
			receipt.setExpR(eRcpt);

			
			//*******************************************
			// Checks to see if someone actually logged in 
			// with information in the database that checks valid
			if(receipt != null)
			{
			return receipt;
			}
			//*******************************************
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	
}
