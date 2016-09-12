package test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class abstractTests 
{

	/**
	 * Creates test mode
	 * @throws Exception
	 */
	@Before
	public void beforeClass() throws Exception
	{
		src.DBConnectionManager.setTestMode(true);
	}
	/**
	 * Rolls back population of database before it actually
	 * commits to the live version
	 * @throws Exception
	 */
	@After
	public  void afterClass() throws Exception
	{
		Connection conn = src.DBConnectionManager.getConnection();
		conn.rollback();
		src.DBConnectionManager.setTestMode(false);
	}

}
