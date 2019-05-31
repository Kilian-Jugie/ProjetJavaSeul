package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.HeavyDecorator;
import model.tile.decorators.PickableDecorator;
public class DiamondFactory {
	private static final ISprite sprite = new Sprite("diamond.png");
	
	public static final ITile createDiamond(IPosition position, ITileMap map) {
		return new ExplodableDecorator(new HeavyDecorator(new PickableDecorator(new Tile(sprite, position, map))));
	}
}
