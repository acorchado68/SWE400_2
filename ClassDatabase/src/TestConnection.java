import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class TestConnection {
	
	public static Connection conn;
    public static Connection getConnection() throws SQLException 
    {
    	String url = "jdbc:mysql://157.160.36.32:3306/swe400-23?autoReconnect=true";
    	String username = "swe400_2";
    	String password = "pwd4swe400_2F16";

    	System.out.println("Connecting database...");

    	conn = DriverManager.getConnection(url, username, password);
    
    	return conn;
   }  
}
       