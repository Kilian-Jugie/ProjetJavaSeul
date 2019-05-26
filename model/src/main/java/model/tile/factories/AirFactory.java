package model.tile.factories;

import contract.tile.ITile;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.UnCollidableDecorator;

public class AirFactory {
	private static final Sprite airSprite = new Sprite("air.png");
	
	public static final ITile createAir(Position position, TileMap map) {
		return new UnCollidableDecorator(new TileBasic(airSprite, position, map));
	}
}
