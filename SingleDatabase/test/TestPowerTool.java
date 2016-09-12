import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritance.
 * Created by Nick Martinez on 9/11/16.
 */
public class TestPowerTool extends InheritableTest
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Testing basic insertion of PowerTool into database.
     */
    @Test
    public void testInsertPowerTool()
    {
        final String upc = "1231231234";
        final int manufacturerID = 13;
        final int price = 39900;
        final String description = "Pnematic Nail Gun";
        final boolean batteryPowered = false;
        new PowerTool(upc, manufacturerID, price, description, batteryPowered);

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
            assertEquals(batteryPowered, rs.getBoolean("batteryPowered"));
        } catch (SQLException exception )
        {
            exception.printStackTrace();
        }
    }

    /**
     * We should be able to find a PowerTool record, and load a new PowerTool object
     * with data from the record.
     */
    @Test
    public void testFindPowerTool() throws SQLException
    {
        // insert
        PowerTool powerTool = new PowerTool("1231231234", 13, 39900, "Pnematic Nail Gun", false);

        // find
        PowerTool powerHammer = new PowerTool(powerTool.getId());

        assertEquals(powerHammer.getId(), powerTool.getId());
        assertEquals(powerHammer.getUpc(), powerTool.getUpc());
        assertEquals(powerHammer.getManufacturerID(), powerTool.getManufacturerID());
        assertEquals(powerHammer.getPrice(), powerTool.getPrice());
        assertEquals(powerHammer.getDescription(), powerTool.getDescription());
    }

    /**
     * If there is no record in the database, then throw an exception.
     */
    @Test
    public void testPowerToolNotFound() throws SQLException
    {
        exception.expect(SQLException.class);
        exception.expectMessage("Record not found.");
        new PowerTool(-1);
    }
}
