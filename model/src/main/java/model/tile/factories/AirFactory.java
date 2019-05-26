package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.decorators.UnCollidableDecorator;

public class AirFactory {
	private static final Sprite airSprite = new Sprite("air.png");
	
	public static final ITile createAir(IPosition position, ITileMap map) {
		return new UnCollidableDecorator(new TileBasic(airSprite, position, map));
	}
}
