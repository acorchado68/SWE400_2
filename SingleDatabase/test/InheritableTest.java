import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritence.
 * Created by Andrew Corchado on 9/11/16.
 */
public abstract class InheritableTest
{
    protected Connection connection;

    /*
     * Start testing.
     */
    @Before
    public void before() throws SQLException
    {
        connection = DBConnection.getConnection();
        connection.setAutoCommit(false);
    }

    /*
     * Close testing and rollback.
     */
    @After
    public void after() throws SQLException
    {
        connection.rollback();
        connection.close();
    }

}
