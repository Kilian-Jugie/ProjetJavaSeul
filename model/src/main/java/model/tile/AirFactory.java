package model.tile;

import contract.tile.ITile;

public class AirFactory {
	public static final ITile createAir(Position position, TileMap map) {
		return new TileBasic(Tile.airSprite, position, map);
	}
}
