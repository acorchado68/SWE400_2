package domain.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Tool;

public class TestTool extends CTITestCase{


	@Test
	public void testFinderConstructor() {

		try {
			resultSet.first();
			do
			{
				for(int i = 1; i < 6; i++)
				{

					Object object = resultSet.getObject(i);
					objArray.add(object);
				}
				Tool tool = new Tool(objArray);
				objArray.clear();
				assertTrue(tool.getId() == 12);
				assertTrue(tool.getUpc().equals("ABC123"));
				assertTrue(tool.getManufacturerId() == 15);
				assertTrue(tool.getPrice() == 1345);
				assertTrue(tool.getDescription().equals("This is a thing!"));
			}while(resultSet.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}

