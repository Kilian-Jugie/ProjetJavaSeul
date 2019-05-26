package model.tile.factories;

import contract.tile.ITile;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;


public class BorderFactory {
	private static final Sprite borderSprite = new Sprite("border.png");
	
	public static final ITile createBorder(Position position, TileMap map) {
		return new TileBasic(borderSprite, position, map);
	}
}
