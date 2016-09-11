import org.junit.After;
import org.junit.Before;

import java.sql.Connection;

/**
 * Created by Andrew Corchado on 9/11/16.
 */
public abstract class InheritableTest
{
    /*
     * Start testing
     */
    @Before
    public void before() throws Exception
    {
        DBConnection.setTestState(true);
    }

    /*
     * Close testing and rollback
     */
    @After
    public void after() throws Exception
    {
        Connection connection = DBConnection.getConnection();
        connection.rollback();
        DBConnection.setTestState(false);
    }
}
