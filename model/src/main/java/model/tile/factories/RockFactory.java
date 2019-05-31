package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.HeavyDecorator;
import model.tile.decorators.MovableDecorator;
import model.tile.decorators.PushableDecorator;

public class RockFactory {
	private static final ISprite sprite = new Sprite("rock.png");
	
	public static final ITile createRock(IPosition position, ITileMap map) {
		return new HeavyDecorator(new ExplodableDecorator(new MovableDecorator(new PushableDecorator(new Tile(sprite, position, map)))));
	}
}
