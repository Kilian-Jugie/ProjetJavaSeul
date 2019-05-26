package model.tile.factories;

import contract.tile.ITile;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.HeavyDecorator;
import model.tile.decorators.PickableDecorator;

public class DiamondFactory {
	private static final Sprite diamondSprite = new Sprite("diamond.png");
	
	public static final ITile createDiamond(Position position, TileMap map) {
		return new PickableDecorator(new HeavyDecorator(new ExplodableDecorator(new TileBasic(diamondSprite, position, map))));
	}
}
