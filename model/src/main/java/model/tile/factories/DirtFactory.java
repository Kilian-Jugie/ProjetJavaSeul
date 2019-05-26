package model.tile.factories;

import contract.tile.ITile;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.MinableDecorator;

public class DirtFactory {
	private static final Sprite dirtSprite = new Sprite("dirt.png");
	
	public static final ITile createDirt(Position position, TileMap map) {
		return new MinableDecorator(new TileBasic(dirtSprite, position, map));
	}
}
