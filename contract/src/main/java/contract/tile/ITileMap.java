package contract.tile;

public interface ITileMap {
	public ITile getTileAt(IPosition position);
	public void setTileAt(ITile tile, IPosition position);
	public void setAirAt(IPosition position);
	
}
