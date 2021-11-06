import java.sql.*;
import java.util.*;
public class dbtest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String pass = "12345";	
        
        

	}

}
