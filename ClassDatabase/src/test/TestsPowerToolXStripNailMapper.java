package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import src.DBConnectionManager;
import src.PowerToolMapper;
import src.PowerToolXStripNailMapper;
import src.StripNailsMapper;
import enums.PowerTools;
import enums.StripNails;

/**
 * TestPowerToolXStripNailMapper
 * @author Zachary & Scott
 * Tests for the link table between PowerTools and StripNails
 */
public class TestsPowerToolXStripNailMapper extends abstractTests 
{

	/**
	 * Test creating a link
	 * @throws SQLException
	 */
	@Test
	public void testCreationLinkTable() throws SQLException
	{
		StripNailsMapper sNMapper = new StripNailsMapper("SN", 13, 5, 1.3, 1);
		PowerToolMapper pTMapper = new PowerToolMapper("PT", 14, 4, "THIS IS A DISCRIPTION", true);
		
		PowerToolXStripNailMapper LinkMapper = new PowerToolXStripNailMapper(pTMapper, sNMapper);
		
		Connection conn = DBConnectionManager.getConnection();
		PreparedStatement query = conn.prepareStatement("Select * from PowerToolStripNail where PowerToolID = ? and StripNailID = ?;");
		query.setInt(1, LinkMapper.getPTMapper().getId());
		query.setInt(2, LinkMapper.getSNMapper().getId());
		
		ResultSet rs = query.executeQuery();
		rs.next();
		assertEquals(pTMapper.getId(),rs.getInt("PowerToolID"));
		assertEquals(sNMapper.getId(),rs.getInt("StripNailID"));
	}
	
	/**
	 * Test finder methods I use to make using enums easier 
	 * @throws SQLException
	 */
	@Test
	public void testFinders() throws SQLException
	{
		PowerTools powerTool = PowerTools.HITACHI_PNEUMATIC_NAILER;
		PowerToolMapper pwtool = new PowerToolMapper(powerTool.getUpc(), powerTool.getManufacturerID(), powerTool.getPrice(), powerTool.getDescription(), powerTool.isBatteryPowered());
		
		assertEquals(PowerToolXStripNailMapper.findPT(PowerTools.HITACHI_PNEUMATIC_NAILER).getId(), pwtool.getId());
		
		StripNails stripNail = StripNails.ROUND_HEAD_NAIL_STRIP;
		StripNailsMapper sn = new StripNailsMapper(stripNail.getUpc(), stripNail.getManufacturerID(), stripNail.getPrice(),stripNail.getLength() , stripNail.getNumberInStrip());
		
		assertEquals(PowerToolXStripNailMapper.findSN(StripNails.ROUND_HEAD_NAIL_STRIP).getId(), sn.getId());
			
	}
}
