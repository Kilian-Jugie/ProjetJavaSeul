package model.tile.decorators;

import contract.tile.ICollideAction;
import model.tile.Tile;

public class MinableDecorator extends Decorator {
	
	public MinableDecorator(Tile tile) {
		super(tile);
	}

	@Override
	public boolean collide(ICollideAction ac)  {
		boolean b = super.collide(ac);
		switch(ac.getType()) {
		case HUMAN: {
			this.delete();
			return true;
		}
		default: break;
		}
		return b;
	}
	
}
