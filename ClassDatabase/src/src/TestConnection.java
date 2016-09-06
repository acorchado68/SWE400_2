package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class  TestConnection {
	
	private static Connection conn;
	
	public TestConnection()
	{
		
	}
	
    public static Connection getConnection() throws SQLException 
    {
    	if(conn == null)
    	{
    	String url = "jdbc:mysql://157.160.36.32:3306/swe400-23?autoReconnect=true";
    	String username = "swe400_2";
    	String password = "pwd4swe400_2F16";

    	System.out.println("Connecting database...");	
    	conn = DriverManager.getConnection(url, username, password);
    	conn.setAutoCommit(false);
    	}
    	return conn;
   }  
    
  
}
       