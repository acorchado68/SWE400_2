import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class StripNails extends Fastener
{
    private static final String insertQuery = "INSERT INTO " + DB_TABLE_NAME +
            " (upc, manufacturerID, price, description, length, batteryPowered, " +
            "numberInStrip, numberInBox, type) " +
            "VALUES (?,?,?,null,?,null,?,null,?);";
    private static final String selectQuery = "SELECT * FROM " + DB_TABLE_NAME +
            " WHERE id = (?);";

    protected int numberInStrip;

    /**
     * Creation constructor. Initializes a new StripNails.
     * @param id - the id of the strip nails
     * @param upc - the upc of the strip nails
     * @param manufacturerID - the manufacturer ID of the strip nails
     * @param price - the price of the strip nails
     * @param length - the length of the strip nails
     * @param numberInStrip - how many nails are in each strip?
     */
    public StripNails(int id, String upc, int manufacturerID, int price, int length,
                      int numberInStrip)
    {
        super(id, upc, manufacturerID, price, length);
        this.numberInStrip = numberInStrip;
        insert();
    }

    /**
     * Finder constructor for StripNails.
     * @param id - the id of the strip nails
     */
    public StripNails(int id)
    {
        super(id);
    }

    /** Maps StripNails to database. */
    @Override
    protected void insert()
    {
        // id is generated by MySQL
        try(Connection connection = TestConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(insertQuery) )
        {
            stmt.setString(1, upc);
            stmt.setInt(2, manufacturerID);
            stmt.setInt(3, price);
            stmt.setLong(4, length);
            stmt.setInt(5, numberInStrip);
            stmt.setString(6, getClassType());

            stmt.executeUpdate();
        } catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     *
     * @param id
     */
    @Override
    protected void find(int id)
    {
        try(    Connection connection = TestConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(selectQuery) ) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            id = rs.getInt("id");
            upc = rs.getString("upc");
            manufacturerID = rs.getInt("manufacturerID");
            price = rs.getInt("price");
            length = rs.getLong("length");
            numberInStrip = rs.getInt("numberInStrip");
        } catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Returns the class type.
     * @return - the class type
     */
    @Override
    public String getClassType()
    {
        return "StripNails";
    }

}