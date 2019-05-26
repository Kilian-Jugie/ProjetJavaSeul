package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;


public class BorderFactory {
	private static final Sprite borderSprite = new Sprite("border.png");
	
	public static final ITile createBorder(IPosition position, ITileMap map) {
		return new TileBasic(borderSprite, position, map);
	}
}
