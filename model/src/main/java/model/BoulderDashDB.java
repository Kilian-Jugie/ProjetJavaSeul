package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

import contract.IBoulderDashModel;
import contract.tile.ITileMap;
import model.tile.Position;
import model.tile.TileMap;

public class BoulderDashDB {
	private Connection connection;
	private static BoulderDashDB INSTANCE = null;
	
	private BoulderDashDB() {}
	
	public static BoulderDashDB getInstance() {
		if(INSTANCE==null) INSTANCE = new BoulderDashDB();
		return INSTANCE;
	}
	
	void connect() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	ITileMap getMapId(int id, IBoulderDashModel model) {
		final String sql = "{call getMapId(?)}";
		ITileMap ret = null;
		
		try {
			final CallableStatement call = this.connection.prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			final int columnCount = resultSet.getMetaData().getColumnCount();
			//We initialize ret here to avoid useless initialization in case of SQLException during connection
			ret = new TileMap();
			int currentLine = 0;
			while(resultSet.next()) {
				for(int i = 0; i<columnCount; ++i) {
					int index = i+1; //Les handicapés qui ont fait ça se sont dit "tiens on va commencer les index à 1"
					//Mouais à tester !!!
					ret.setTileAt(model.getCorrespondance((char)resultSet.getInt(index)).getFactory().apply(new Position(i, currentLine), ret), new Position(i, currentLine));
				}
				++currentLine;
			}
		}
		catch(final SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
