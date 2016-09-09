package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Nail extends Fastener {
	private int numberInBox;
	private static int COLUMN_NUMINBOX = 4;
	private static int COLUMN_LENGTH = 5;

	/**
	 * Creation constructor
	 * 
	 * @param objArray
	 */
	public Nail(ArrayList<Object> objArray) {
		super(objArray);
	}

	/**
	 * The "Finder" Constructor
	 * 
	 * @param id
	 */
	public Nail(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.numberInBox = (Integer) objectArray.get(COLUMN_NUMINBOX);
		this.length = (Long) objectArray.get(COLUMN_LENGTH);
	}

	@Override
	protected boolean insert() {
		try {

			Connection connection = InventoryItem.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO Nail (upc,manufacturerID,price,numberInBox,length) VALUES (" + this.getUpc()
					+ "," + this.getManufacturerId() + "," + this.getPrice() + "," + this.numberInBox + ","
					+ this.length + ");");
			statement.close();
		} catch (SQLException e) {

			return false;
		}
		return true;
	}

	private static ArrayList<Object> findList(int id) {
		Connection connection = InventoryItem.getConnection();

		try {
			Statement statement = connection.createStatement();
			if (statement.execute("SELECT * FROM Nail WHERE id=" + id)) {
				ResultSet results = statement.getResultSet();
				results.first();
				ArrayList<Object> objArray = new ArrayList<Object>();
				for (int i = 1; i < 7; i++) {
					objArray.add(results.getObject(i));
				}
				return objArray;
				// return new Nail(objArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Object>();
	}

	@Override
	protected Nail find(int id) {
		ArrayList<Object> objArray = findList(id);
		if (objArray.isEmpty()) {
			return (Nail) null;
		}
		return new Nail(objArray);

	}

}
