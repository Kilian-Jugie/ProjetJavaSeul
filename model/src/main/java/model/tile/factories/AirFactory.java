package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.UnCollidableDecorator;

public class AirFactory {
	private static final ISprite sprite = new Sprite("air.png");
	
	public static final ITile createAir(IPosition position, ITileMap map) {
		return new UnCollidableDecorator(new Tile(sprite, position, map));
	}
}
