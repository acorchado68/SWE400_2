import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Nick Martinez and Andrew Corchado - Single Table Inheritance
 * Created by Andrew Corchado on 9/11/16.
 */
public class TestNail extends InheritableTest
{
    @Rule
    public final ExpectedException e = ExpectedException.none();

    /*
     * Test for inserting a nail into the database
     */
    @Test
    public void testInsertNail()
    {
        final String upc = "00112233445";
        final int manufacturerID = 10;
        final int price = 2099;
        final int length = 4;
        final int numberInBox = 30;
        new Nail(upc, manufacturerID, price, length, numberInBox);

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
            assertEquals(length, rs.getInt("length"));
            assertEquals(numberInBox, rs.getInt("numberInBox"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /*
     * Test for finding nail in database
     */
    @Test
    public void testFindNail()
    {
        //Create new nail
        Nail nail = new Nail("00112233445", 10, 2099, 4, 30);

        //Find nail based on DB-assigned ID
        Nail nailInDB = new Nail(nail.getId());

        assertEquals(nailInDB.getId(), nail.getId());
        assertEquals(nailInDB.getUpc(), nail.getUpc());
        assertEquals(nailInDB.getManufacturerID(), nail.getManufacturerID());
        assertEquals(nailInDB.getPrice(), nail.getPrice());
        assertEquals(nailInDB.getLength(), nail.getLength());
        assertEquals(nailInDB.getNumberInBox(), nail.getNumberInBox());
    }

    /*
     * Test for a missing nail, throws an SQLException
     */
    @Test
    public void testNotFound() throws SQLException
    {
        e.expect(SQLException.class);
        e.expectMessage("Nail not found");
        new Nail(-1);
    }


}
