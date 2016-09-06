package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;

import src.*;
import org.junit.Test;

public class TestsNail extends abstractTests 
{	
	@Test
	public void test() throws SQLException 
	{
		NailMapper example = new NailMapper(5, "absolute", 5, 10, 6, 5);
	}

}
