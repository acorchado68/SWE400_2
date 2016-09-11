import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class Nail extends Fastener
{
    private static final String insertQuery = "INSERT INTO " + DB_TABLE_NAME +
            " (upc, manufacturerID, price, description, length, batteryPowered, " +
            "numberInStrip, numberInBox, type) " +
            "VALUES (?,?,?,null,?,null,null,?,?);";
    private static final String selectQuery = "SELECT * FROM " + DB_TABLE_NAME +
            " WHERE id = (?);";

    protected int numberInBox;

    /**
     * Creation constructor. Initializes a new Nail.
     * @param id - the id of the nail
     * @param upc - the upc of the nail
     * @param manufacturerID - the manufacturer ID of the nail
     * @param price - the price of the nail
     * @param length - the length of the nail
     * @param numberInBox - how many nails are in each box?
     */
    public Nail(int id, String upc, int manufacturerID, int price, int length,
                      int numberInBox)
    {
        super(id, upc, manufacturerID, price, length);
        this.numberInBox = numberInBox;
        insert();
    }

    /**
     * Finder constructor for Nail.
     * @param id - the id of the nail
     */
    public Nail(int id)
    {
        super(id);
    }

    /** Maps Nail to database. */
    @Override
    protected void insert()
    {
        // id is generated by MySQL
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(insertQuery) )
        {
            stmt.setString(1, upc);
            stmt.setInt(2, manufacturerID);
            stmt.setInt(3, price);
            stmt.setLong(4, length);
            stmt.setInt(5, numberInBox);
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
        try(    Connection connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(selectQuery) ) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            id = rs.getInt("id");
            upc = rs.getString("upc");
            manufacturerID = rs.getInt("manufacturerID");
            price = rs.getInt("price");
            length = rs.getLong("length");
            numberInBox = rs.getInt("numberInStrip");
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
        return "Nail";
    }

}