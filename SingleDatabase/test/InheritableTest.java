import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritence.
 * Created by Andrew Corchado on 9/11/16.
 */
public class InheritableTest
{
    protected static Connection connection;
    protected static Savepoint sp;

    /*
     * Start testing.
     */
    @BeforeClass
    public static void before() throws SQLException
    {
        connection = DBConnection.getConnection();
        connection.setAutoCommit(false);
        sp = connection.setSavepoint();
    }

    /*
     * Close testing and rollback.
     */
    @AfterClass
    public static void after() throws SQLException
    {
        connection.rollback(sp);
        connection.close();
    }

}
