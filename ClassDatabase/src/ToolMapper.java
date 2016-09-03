
public abstract class ToolMapper extends AbstractInventoryItemMapper 
{

	public ToolMapper(int id, String upc, int manufacturerID, int price, String description) 
	{
		super(id, upc, manufacturerID, price);
	}
	
	public ToolMapper(int id)
	{
		super(id);
	}
	
}
