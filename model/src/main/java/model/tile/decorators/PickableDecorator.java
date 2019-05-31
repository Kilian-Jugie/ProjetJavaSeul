package model.tile.decorators;

import contract.tile.ICollideAction;
import contract.tile.ITile;
import model.tile.PickAction;

public class PickableDecorator extends Decorator {

	public PickableDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public boolean collide(ICollideAction ac)  {
		switch(ac.getType()) {
		case HUMAN: {
			System.out.println(ac.getOtherTile().description());
			ac.getOtherTile().pick(new PickAction(this));
			return true;
		}
		default: return this.decorated.collide(ac);
		}
	}
	
	@Override
	public String description() {
		return decorated.description()+"+PickableDecorator";
	}
	
}
