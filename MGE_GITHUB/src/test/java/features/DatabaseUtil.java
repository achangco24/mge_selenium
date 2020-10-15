package features;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	
	public Connection connectToDB() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		//CCB27TST2
//		String host="10.140.236.24";
//		String port= "1522";
//		String serviceName = "CB27TST2";
//		String username = "cisuser";
//		String password = "cisuser_tst2";
		
		//CCBGOLD
//		String host="192.168.8.101";
//		String port= "1522";
//		String serviceName = "CCBGOLD";
//		String username = "cisuser";
//		String password = "cisuser_gld1";
		
		//SEI-CCBDEV
		String host="192.168.8.101";
		String port= "1522";
		String serviceName = "CCBDEV";
		String username = "cisuser";
		String password = "cisuser_dev1";

		
		//SEI-CCBPROD
		/*
		String host="192.168.6.171";
		String port= "1522";
		String serviceName = "CCBPROD";
		String username = "cisadm";
		String password = "cisadm_prd";
		*/
		
		//CCBTRN
//		String host="192.168.8.101";
//		String port= "1522";
//		String serviceName = "CCBTRN";
//		String username = "cisuser";
//		String password = "cisuser_trn1";
		
		
		//SEI_CCBTST2
//		String host="cwdwdndevscan";
//		String port= "1522";
//		String serviceName = "CCBTST2";
//		String username = "cisuser";
//		String password = "cisuser_tst2";
		
		Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@//" + host + ":" + port + "/" + serviceName, username, password);
		return connect;
	}
	
	
	public void main(String[] args) throws SQLException, ClassNotFoundException{
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String host="10.140.236.24";
			String port= "1522";
			String serviceName = "CB27TST2";
			String username = "cisuser";
			String password = "cisuser_test2";
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@//" + host + ":" + port + "/" + serviceName, username, password);
			
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = con.createStatement();
			String sql;
			sql = "SELECT ACCT_ID, SA_ID FROM CI_SA FETCH FIRST 5 ROW ONLY";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
		    while(rs.next()){
		    //Retrieve by column name
		    	String acctID  = rs.getString("ACCT_ID");
		    	String saID = rs.getString("SA_ID");

		        //Display values
		        System.out.println("Acct ID: " + acctID + " ~~~~ SA ID: " + saID);
		        
		      }
		    //STEP 6: Clean-up environment
		    rs.close();
		    stmt.close();
		    con.close();
		} catch(ClassNotFoundException cnf) {
			System.out.println("No Driver");
			System.out.println(cnf.getLocalizedMessage());
		} catch(SQLException se){
			System.out.println(se.getLocalizedMessage());
		}
	}
	
	public ResultSet executeQuery(Connection connect, String query) throws SQLException{
		stmt = connect.createStatement();
		rs = stmt.executeQuery(query);
	    return rs;
	}
	
	public void cleanUp(Connection connect) throws SQLException{
		//STEP 6: Clean-up environment
		if(rs != null)
			rs.close()
			;
		if(stmt != null)
			stmt.close();
		
		if(connect != null)
			connect.close();
	}
	
	
}
