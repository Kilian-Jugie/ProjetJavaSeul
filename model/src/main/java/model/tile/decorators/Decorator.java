package model.tile.decorators;

import model.tile.Tile;

public class Decorator extends Tile {
	public Decorator(Tile tile) {
		super(tile.getSprite(), tile.getPosition(), tile.getMap());
	}
	
}
