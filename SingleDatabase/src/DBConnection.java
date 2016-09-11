import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritence
 * Created by Nick Martinez on 9/5/16.
 */
public class DBConnection
{
    private static Connection conn;

    private static boolean testMode = false;

    public static Connection getConnection() throws SQLException
    {
        String url = "jdbc:mysql://157.160.36.32:3306/swe400-21?autoReconnect=true";
        String username = "swe400_2";
        String password = "pwd4swe400_2F16";

        System.out.println("Connecting database...");

        conn = DriverManager.getConnection(url, username, password);

        if( testMode )
        {
            conn.setAutoCommit(false);
        }

        return conn;
    }

    /**
     * Sets whether DBConnection should return a connection in "test mode" or not.
     * @param state - true if in test mode, false if not to be in test mode
     */
    public static void setTestMode(boolean state)
    {
        testMode = state;
    }

}
