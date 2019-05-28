package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.HeavyDecorator;
import model.tile.decorators.PushableDecorator;

public class RockFactory {
	private static final Sprite rockSprite = new Sprite("rock.png");
	
	public static final ITile createRock(IPosition position, ITileMap map) {
		return new PushableDecorator(new HeavyDecorator(new ExplodableDecorator(new TileBasic(rockSprite, position, map))));
	}
}
