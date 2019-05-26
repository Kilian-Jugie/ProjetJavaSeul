package model.tile.factories;

import contract.tile.ITile;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.ExplodableDecorator;

public class WallFactory {
	private static final Sprite wallSprite = new Sprite("wall.png");
	
	public static final ITile createWall(Position position, TileMap map) {
		return new ExplodableDecorator(new TileBasic(wallSprite, position, map));
	}
}
