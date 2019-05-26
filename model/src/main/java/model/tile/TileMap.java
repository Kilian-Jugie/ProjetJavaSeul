package model.tile;

import java.util.ArrayList;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.factories.AirFactory;

public class TileMap implements ITileMap {
	private ArrayList<ArrayList<ITile>> map;

	@Override
	public ITile getTileAt(IPosition position) {
		return map.get(position.getY()).get(position.getX());
	}

	@Override
	public void setTileAt(ITile tile, IPosition position) {
		map.get(position.getY()).set(position.getX(), tile);
	}

	@Override
	public void setAirAt(IPosition position) {
		this.setTileAt(AirFactory.createAir(Position.fromIPosition(position), this), position);
	}

}
