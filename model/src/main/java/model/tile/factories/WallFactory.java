package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.ExplodableDecorator;

public class WallFactory {
	private static final ISprite sprite = new Sprite("wall.png");
	
	public static final ITile createWall(IPosition position, ITileMap map) {
		return new ExplodableDecorator(new Tile(sprite, position, map));
	}
}
