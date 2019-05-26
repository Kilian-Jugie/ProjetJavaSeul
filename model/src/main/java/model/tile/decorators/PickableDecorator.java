package model.tile.decorators;

import contract.tile.ICollideAction;
import model.tile.PickAction;
import model.tile.Tile;

public class PickableDecorator extends Decorator {

	public PickableDecorator(Tile tile) {
		super(tile);
	}
	
	@Override
	public boolean collide(ICollideAction ac)  {
		boolean b = super.collide(ac);
		switch(ac.getType()) {
		case HUMAN: {
			ac.getOtherTile().pick(new PickAction(this));
			return true;
		}
		default: break;
		}
		return b;
	}
}
