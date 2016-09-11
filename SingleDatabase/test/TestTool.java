import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritence
 * Created by Nick Martinez on 9/11/16.
 */
public class TestTool extends InheritableTest
{

    /**
     * Testing basic insertion of Tool into database.
     */
    @Test
    public void testInsertTool()
    {
        final String upc = "0121232234";
        Tool tool = new Tool(upc, 32, 899, "Ball Peen Hammer");

        String query = "SELECT * FROM " + InventoryItem.getTableName() +
                " WHERE upc = (?);";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query) )
        {
            stmt.setString(1, upc);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            assertEquals(upc, rs.getString("upc"));
            System.out.println(rs.getString("upc"));
        } catch (SQLException exception )
        {
            exception.printStackTrace();
        }
    }

}
