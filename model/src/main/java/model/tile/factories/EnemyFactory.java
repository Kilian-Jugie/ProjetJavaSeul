package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.Sprite;
import model.tile.Tile;
import model.tile.decorators.AIDecorator;
import model.tile.decorators.CrushableDecorator;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.ExplosionCreatorDecorator;
import model.tile.decorators.MovableDecorator;

public class EnemyFactory {
	private static final ISprite sprite = new Sprite("enemy.png");
	
	public static final ITile createEnemy(IPosition position, ITileMap map) {
		return new CrushableDecorator(new ExplosionCreatorDecorator(new MovableDecorator(new ExplodableDecorator(new AIDecorator(new Tile(sprite, position, map))))));
	}
}
