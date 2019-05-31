package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;

public class BorderFactory {
private static final ISprite sprite = new Sprite("border.png");
	
	public static final ITile createBorder(IPosition position, ITileMap map) {
		return new Tile(sprite, position, map);
	}
}
