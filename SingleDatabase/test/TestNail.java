import org.junit.Before;
import org.junit.Test;

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
    /*
     * Create and insert a nail
     */
    @Test
    public void testCreateNail()
    {
        final String upc = "00112233445";
        Nail nail = new Nail(upc, 32, 10, 12, 6);
        String query = "SELECT * FROM " + InventoryItem.getTableName() +
                " WHERE upc = (?);";

        try( Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setString(1, upc);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            assertEquals(upc, rs.getString("upc"));
            System.out.println(rs.getString("upc"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
