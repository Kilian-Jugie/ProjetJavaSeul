package model.tile.factories;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.CrushableDecorator;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.ExplosionCreatorDecorator;
import model.tile.decorators.IADecorator;
import model.tile.decorators.MovableDecorator;

public class EnemyFactory {
	private static final Sprite enemySprite = new Sprite("enemy.png");
	
	public static final ITile createEnemy(IPosition position, ITileMap map) {
		return new ExplosionCreatorDecorator(new IADecorator(new MovableDecorator(new CrushableDecorator(new ExplodableDecorator(new TileBasic(enemySprite, position, map))))));
	}
}
