import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class PowerTool extends Tool
{
    private static final String insertQuery = "INSERT INTO " + DB_TABLE_NAME +
            " (upc, manufacturerID, price, description, length, batteryPowered, " +
            "numberInStrip, numberInBox, type) " +
            "VALUES (?,?,?,?,null,?,null,null,?);";
    private static final String selectQuery = "SELECT * FROM " + DB_TABLE_NAME +
            " WHERE id = (?);";

    protected boolean batteryPowered;

    /**
     * Creation constructor. Initializes a new PowerTool.
     * @param id - the id of the power tool
     * @param upc - the upc of the power tool
     * @param manufacturerID - the manufacturer ID of the power tool
     * @param price - the price of the power tool
     * @param description - the description of the power tool
     */
    public PowerTool(int id, String upc, int manufacturerID, int price, String description,
                     boolean batteryPowered)
    {
        super(id, upc, manufacturerID, price, description);
        this.batteryPowered = batteryPowered;
        insert();
    }

    /**
     * Finder constructor for Tool.
     * @param id - the id of the Tool
     */
    public PowerTool(int id)
    {
        super(id);
    }

    /** Maps PowerTool to database. */
    @Override
    protected void insert()
    {
        // id is generated by MySQL
        try(    Connection connection = TestConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(insertQuery) )
        {
            stmt.setString(1, upc);
            stmt.setInt(2, manufacturerID);
            stmt.setInt(3, price);
            stmt.setString(4, description);
            stmt.setBoolean(5, batteryPowered);
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
            description = rs.getString("description");
            batteryPowered = rs.getBoolean("batteryPowered");
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
        return "PowerTool";
    }

}
