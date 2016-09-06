package test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class abstractTests 
{
	@After
	public  void afterClass() throws Exception
	{
		Connection conn = src.TestConnection.getConnection();
		conn.rollback();
	}

}
