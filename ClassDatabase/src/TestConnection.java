import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class TestConnection {
	
    public static Connection getConnection(String[] args) throws SQLException 
    {
    	Connection conn;
    	String url = "jdbc:mysql://157.160.36.32:3306/swe400-23?autoReconnect=true";
    	String username = "swe400_2";
    	String password = "pwd4swe400_2F16";

    	System.out.println("Connecting database...");

    	conn = DriverManager.getConnection(url, username, password);
    	try (Connection connection = conn) {
    	    System.out.println("Database connected!");
    	} catch (SQLException e) {
    	    throw new IllegalStateException("Cannot connect the database!", e);
    	}
    	return conn;
   }  
}
       