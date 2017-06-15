package buslogic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.FauxBank.business.Customer;
import com.FauxBank.business.Transaction;

public class DBDriver {

	public static Connection conn;

	// Start with connecting to the database
	public DBDriver(String driver, String URL, String user, String pass) {
		// make database connection
		try {
			// load the driver
			Class.forName(driver);

			// Create your URL
			String url = URL;
			String username = user;
			String password = pass;

			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// Get text box parameters from HTML and persist to customer object
	public boolean insertCustomer(String fname, String lname, String email, String uname, String pwd) {
		// insert customer in the Bank Customers table
		try {
			
			//1 account num 
			//2 first name
			//3 last name
			//4 email
			//5 username
			//6 password
			//7 balance
			
			// insert customer into the Customers table
			String custIn = "{call CUSTIN(?,?,?,?,?,?,?)}";
			CallableStatement ps = conn.prepareCall(custIn);
			
			// Generate random number for account number
			ps.setInt(1, 0);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, email);
			ps.setString(5, uname);
			ps.setString(6, pwd);
			ps.setLong(7, 0);

			
			
			ps.executeUpdate();
	
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Customer authenticateCustomer(String username, String password) {

		try {

			Customer customer;
			
			// verify or authenticate user credentials
			String getFname = "{call CHECKLOGIN(?,?,?,?,?)}";
			CallableStatement ps = conn.prepareCall(getFname);

			ps.setString("UN", username);
			ps.setString("PW", password);
			
			ps.registerOutParameter("FN", java.sql.Types.VARCHAR);
			ps.registerOutParameter("ANUM", java.sql.Types.NUMERIC);
			ps.registerOutParameter("BAL", java.sql.Types.NUMERIC);
			
			ps.executeUpdate();
			
			long anum = ps.getLong("ANUM");
			String fname = ps.getNString("FN");
			double bal = ps.getDouble("BAL");
			
			customer = new Customer();
			customer.setAcctNum(anum);
			customer.setFname(fname);
			customer.setBalance(bal);			
			
			if(fname != null)
			{
			  return customer; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public void transSub(Customer upCust, Transaction stoTrans)
	{
		try {

			String inax = "{ call SUBMITTRANS(?,?,?,?) }";
			CallableStatement cs = conn.prepareCall(inax);

			cs.setLong("ANUM", upCust.getAcctNum());
			cs.setDouble("NEWBAL", 	upCust.getBalance());
			cs.setString("TXT", stoTrans.getTxType());
			cs.setDouble("AMT", stoTrans.getAmount());
						
			cs.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	
	// close connection
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
