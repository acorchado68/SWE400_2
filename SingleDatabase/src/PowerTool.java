/**
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class PowerTool extends Tool
{
    protected boolean batteryPowered;

    public PowerTool(int id, String upc, int manufacturerID, int price,
                     String description, boolean batteryPowered)
    {
        super(id, upc, manufacturerID, price, description);
        this.batteryPowered = batteryPowered;
    }
}
