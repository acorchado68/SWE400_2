import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Andrew Corchado on 9/6/16.
 */
public class TestDatabase
{
    final String startTrans = "START TRANSACTION";
    final String rollback = "ROLLBACK";
    @Test
    public void testDatabaseRollback() throws SQLException
    {
        Connection conn = TestConnection.getConnection();
        Tool tool = new Tool(1, "012ABS", 2, 5, "Tool for testing");
        String insertTest = startTrans + ";\n" +  tool.constructQuery() + ";\n" + rollback + ";";
    }
}
