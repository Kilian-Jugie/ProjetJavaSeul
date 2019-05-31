package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.CollecterDecorator;
import model.tile.decorators.ControllableDecorator;
import model.tile.decorators.CrushableDecorator;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.MovableDecorator;

public class PlayerFactory {
	private static final ISprite sprite = new Sprite("player.png");
	
	public static final ITile createPlayer(IPosition position, ITileMap map) {
		return new ControllableDecorator(new MovableDecorator(new CollecterDecorator(new CrushableDecorator(new ExplodableDecorator(new Tile(sprite, position, map))))));
	}
}
