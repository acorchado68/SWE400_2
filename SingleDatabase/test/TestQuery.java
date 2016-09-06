import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Nick Martinez on 9/5/16.
 */
public class TestQuery
{

    @Test
    public void BasicQueryTest() throws SQLException
    {
        Connection conn = TestConnection.getConnection();
        Tool tool = new Tool(85, "05XYZ", 121, 5, "This is a tool");
    }
}
