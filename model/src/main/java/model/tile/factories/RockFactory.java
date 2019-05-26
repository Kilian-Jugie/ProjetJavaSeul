package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.HeavyDecorator;

public class RockFactory {
	private static final Sprite rockSprite = new Sprite("rock.png");
	
	public static final ITile createRock(IPosition position, ITileMap map) {
		return new HeavyDecorator(new ExplodableDecorator(new TileBasic(rockSprite, position, map)));
	}
}
