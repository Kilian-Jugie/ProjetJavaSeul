package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.MinableDecorator;

public class DirtFactory {
	private static final Sprite dirtSprite = new Sprite("dirt.png");
	
	public static final ITile createDirt(IPosition position, ITileMap map) {
		return new MinableDecorator(new TileBasic(dirtSprite, position, map));
	}
}
