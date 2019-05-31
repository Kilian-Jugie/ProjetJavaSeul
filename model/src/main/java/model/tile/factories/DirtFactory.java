package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.MinableDecorator;

public class DirtFactory {
	private static final ISprite sprite = new Sprite("dirt.png");
	
	public static final ITile createDirt(IPosition position, ITileMap map) {
		return new MinableDecorator(new Tile(sprite, position, map));
	}
}
