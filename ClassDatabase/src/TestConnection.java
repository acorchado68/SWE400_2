import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class TestConnection {
	public static Connection conn;
    public static void main(String[] args) throws SQLException 
    {

    	String url = "jdbc:mysql://157.160.36.32:3306/swe400-23?autoReconnect=true";
    	String username = "swe400_2";
    	String password = "pwd4swe400_2F16";

    	System.out.println("Connecting database...");

    	conn = DriverManager.getConnection(url, username, password);
    	viewTable();
    	try (Connection connection = conn) {
    	    System.out.println("Database connected!");
    	} catch (SQLException e) {
    	    throw new IllegalStateException("Cannot connect the database!", e);
    	}
   }
    
    
    public static ResultSet viewTable()
    {
    	PreparedStatement stmt = null;
    	try{
    			String query = "describe InventoryItem";
    			stmt = conn.prepareStatement(query);
    			ResultSet rs = stmt.executeQuery();
    			ResultSetMetaData rsmd = rs.getMetaData();
    			int columnsNumber = rsmd.getColumnCount();
    			while(rs.next())
    			{
    				for(int i = 1; i <= columnsNumber; i++)
    				{
    					if(i > 1)System.out.println(", ");
    					String columnValue = rs.getString(i);
    					System.out.print(columnValue + " " + rsmd.getColumnName(i));
    				}
    				System.out.print("");
    			}
    			return rs;
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return null;
    	
    }
    
}
       