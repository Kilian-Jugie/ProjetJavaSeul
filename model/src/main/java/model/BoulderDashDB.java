package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;

import contract.IBoulderDashModel;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Position;
import model.tile.TileMap;

public class BoulderDashDB {
	private Connection connection;
	private static BoulderDashDB INSTANCE = null;
	private boolean isConnected = false;
	
	private static int mapSize = 20;
	
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
		isConnected = true;
	}
	
	ITileMap getMapId(int id, IBoulderDashModel model) {
		final String sql = "{call getMapId(?)}";
		ITileMap ret = null;
		if(!isConnected) connect();
		try {
			final CallableStatement call = this.connection.prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			final int columnCount = resultSet.getMetaData().getColumnCount();
			//We initialize ret here to avoid useless initialization in case of SQLException during connection
			ret = new TileMap();
			ret.setSize(mapSize, mapSize);
			int currentLine = 0;
			while(resultSet.next()) {
				//ret.getMap().add(new ArrayList<ITile>());
				//ret.getMap().get(currentLine).ensureCapacity(columnCount);
				for(int i = 1; i<mapSize+1; ++i) { //First column is id so we skip
					
					int index = i+1;
					//Mouais à tester !!!
					ret.setTileAt(model.getCorrespondance(resultSet.getString(index).charAt(0)).getFactory().apply(new Position(i-1, currentLine), ret), new Position(i-1, currentLine));
				}
				
				++currentLine;
				if(currentLine==mapSize) break;
			}
		}
		catch(final SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
