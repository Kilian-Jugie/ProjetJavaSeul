package model.tile.decorators;

import contract.tile.ICollideAction;
import model.tile.Tile;

public class PushableDecorator extends Decorator {

	public PushableDecorator(Tile tile) {
		super(tile);
	}
	
	@Override
	public boolean collide(ICollideAction ac) {
		//TODO
		return false;
	}

}
