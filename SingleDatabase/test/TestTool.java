import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritance
 * Created by Nick Martinez on 9/11/16.
 */
public class TestTool extends InheritableTest
{

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Testing basic insertion of Tool into database.
     */
    @Test
    public void testInsertTool()
    {
        final String upc = "0121232234";
        final int manufacturerID = 32;
        final int price = 899;
        final String description = "Ball Peen Hammer";
        new Tool(upc, manufacturerID, price, description);

        String query = "SELECT * FROM " + InventoryItem.getTableName() +
                " WHERE upc = (?);";

        try(PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.setString(1, upc);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            assertEquals(upc, rs.getString("upc"));
            assertEquals(manufacturerID, rs.getInt("manufacturerID"));
            assertEquals(price, rs.getInt("price"));
            assertEquals(description, rs.getString("description"));
        } catch (SQLException exception )
        {
            exception.printStackTrace();
        }
    }

    /**
     * We should be able to find a Tool record, and load a new Tool object
     * with data from the record.
     */
    @Test
    public void testFindTool() throws SQLException
    {
        // insert
        Tool tool = new Tool("0121232234", 32, 899, "Ball Peen Hammer");

        // find
        Tool hammer = new Tool(tool.getId());

        assertEquals(hammer.getId(), tool.getId());
        assertEquals(hammer.getUpc(), tool.getUpc());
        assertEquals(hammer.getManufacturerID(), tool.getManufacturerID());
        assertEquals(hammer.getPrice(), tool.getPrice());
        assertEquals(hammer.getDescription(), tool.getDescription());
    }

    /**
     * If there is no record in the database, then throw an exception.
     */
    @Test
    public void testFindToolNotFound() throws SQLException
    {
        exception.expect(SQLException.class);
        exception.expectMessage("Record not found.");
        new Tool(-1);
    }

}
