package src;
import java.sql.SQLException;

import javax.tools.Tool;

import org.junit.runner.RunWith;

public class InventoryItemMapper extends Mapper
{
	
	public static void main(String args[]) throws SQLException
	{
		//NailMapper a = new NailMapper(7, "5a", 9, 10, 5, 20);
		PowerToolMapper pwt1 = new PowerToolMapper("6", 5, 10, "9", true);
		StripNailsMapper sn1 = new StripNailsMapper("4", 6, 5, 10, 30);
		//new ToolMapper(2, "9",5, 7, "5");
		//NailMapper Nail = new NailMapper(7);
		//Arraylist.add(Nail);
		
		//ToolMapper tool = new ToolMapper(2);
		//PowerToolMapper powTool = new PowerToolMapper(15);
		
		PowerToolXStripNailMapper link1 = new PowerToolXStripNailMapper(pwt1, sn1);
	}
	
	
	
}
