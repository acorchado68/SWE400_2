package test;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class abstractTests 
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		Connection conn = src.TestConnection.getConnection();
		conn.rollback();
	}

}
