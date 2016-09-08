package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * DB ConnectionManager.java
 * @author Scott & Zachary 
 * Manages connecting to the database;
 */
public class  DBConnectionManager {
	
	private static Connection conn;
	private static boolean testMode = false;
	
	public DBConnectionManager()
	{
		
	}
	
	/**
	 * returns the connection to the database, if it is closed open a new one
	 * @return the connection to the database
	 * @throws SQLException
	 */
    public static Connection getConnection() throws SQLException 
    {
    	if(conn == null)
    	{
    	String url = "jdbc:mysql://157.160.36.32:3306/swe400-23?autoReconnect=true";
    	String username = "swe400_2";
    	String password = "pwd4swe400_2F16";

    	System.out.println("Connecting database...");	
    	conn = DriverManager.getConnection(url, username, password);
    	
    		if(testMode)
    		{
    		conn.setAutoCommit(false);
    		}
    	}
    	return conn;
   }  
    
  public static void setTestMode(boolean state)
  {
	  testMode = state;
  }
  
  public static void setConnection() throws SQLException
  {
	 conn.close();
	  
  }
    
}
       