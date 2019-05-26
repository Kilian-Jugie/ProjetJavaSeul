package model.tile.decorators;

import contract.tile.ICollideAction;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.Tile;
import model.tile.TileMap;

public class UnCollidableDecorator extends Decorator {
	public UnCollidableDecorator(Tile tile) {
		super(tile);
	}

	@Override
	public boolean collide(ICollideAction ac)  {
		return true;
	}
	
}
