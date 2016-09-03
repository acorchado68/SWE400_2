
public class StripNailsMapper extends AbstractFastenerMapper 
{
	public StripNailsMapper(int id, String upc, int manufacturerID, int price, long length, int numberInStrip) 
	{
		super(id, upc, manufacturerID, price, length);
	}

	public StripNailsMapper(int id)
	{
		super(id);
	}
}
