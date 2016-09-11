import java.sql.*;
/**
 * Gateway
 * Created by Andrew Corchado on 9/6/16.
 */
public class DBConnection
{
    private static Connection conn;
    private static boolean testState = false;

    public static Connection getConnection() throws SQLException
    {
        if(conn == null)
        {
            String url = "jdbc:mysql://157.160.36.32:3306/swe400-21?autoReconnect=true";
            String username = "swe400_2";
            String password = "pwd4swe400_2F16";

            System.out.println("Connecting database...");
            conn = DriverManager.getConnection(url, username, password);

            if (testState)
            {
                conn.setAutoCommit(false);
            }
        }
        return conn;
    }
    public static void setTestState(boolean mode)
    {
        testState = mode;
    }

    public void closeConn() throws SQLException
    {
        conn.close();
    }
}