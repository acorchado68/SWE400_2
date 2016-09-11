package domain.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestInventoryItem.class, TestStripNail.class, TestFastener.class, TestNail.class, TestTool.class,
		TestPowerTool.class, FactoryTest.class })
public class TestSuite {

}