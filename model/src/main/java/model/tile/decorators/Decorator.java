package model.tile.decorators;

import model.tile.Position;
import model.tile.Sprite;
import model.tile.Tile;
import model.tile.TileMap;

public class Decorator extends Tile {
	public Decorator(Sprite sprite, Position position, TileMap map) {
		super(sprite, position, map);
	}
	
}
