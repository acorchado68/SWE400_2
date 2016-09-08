package test;

import static org.junit.Assert.*; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.ResultSetMetaData; 
import java.sql.SQLException; 
 
import org.junit.After; 
import org.junit.Before; 
 
import src.*; 
 
import org.junit.Test; 
 
public class TestsNail extends abstractTests  
{
  @Test 
  public void test() throws SQLException  
  { 
    String [] Checker = {"5", "5"}; 
    PreparedStatement stmt = null; 
    NailMapper example = new NailMapper(5, "absolute", 5, 10, 6, 5); 
    Connection conn = TestConnection.getConnection(); 
    String query = "Select * From Nail"; 
    stmt = conn.prepareStatement(query); 
    ResultSet rs = stmt.executeQuery(); 
    ResultSetMetaData rsmd = rs.getMetaData(); 
    int incrementer = rsmd.getColumnCount(); 
    int j = 0; 
    while (rs.next())  
    { 
      for(int i = 1 ; i <= incrementer; i++) 
      { 
        System.out.print(rs.getString(i) + " "); 
            
      } 
    } 
  } 
 
     
} 
