
public class PowerToolMapper extends ToolMapper 
{

	public PowerToolMapper(int id, String upc, int manufacturerID, int price, String description, boolean batteryPowered) 
	{
		super(id, upc, manufacturerID, price, description);
		
	}

	public PowerToolMapper(int id)
	{
		super(id);
	}
}
