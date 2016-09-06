package test;

import static org.junit.Assert.*;
import src.*;
import org.junit.Test;

public class TestsNail extends abstractTests 
{

	@Test
	public void test() 
	{
		NailMapper example = new NailMapper(5, "absolute", 5, 10, 6, 5);
	}

}
