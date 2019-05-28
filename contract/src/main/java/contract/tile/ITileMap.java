package contract.tile;

import java.util.ArrayList;

public interface ITileMap {
	public ITile getTileAt(IPosition position);
	public void setTileAt(ITile tile, IPosition position);
	public void setAirAt(IPosition position);
	ArrayList<ArrayList<ITile>> getMap();
	
	public int getSize();
	ITile getTileAt(int x, int y);
	void setSize(int column, int lines);
}
