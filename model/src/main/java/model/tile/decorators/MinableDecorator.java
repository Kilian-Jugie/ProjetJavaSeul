package model.tile.decorators;

import contract.tile.ICollideAction;
import contract.tile.ITile;

public class MinableDecorator extends Decorator {

	public MinableDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public boolean collide(ICollideAction ac) {
		switch(ac.getType()) {
		case HUMAN: {
			this.delete();
			return true;
		}
		default: return this.decorated.collide(ac);
		}
	}
	
	@Override
	public String description() {
		return decorated.description()+"+MinableDecorator";
	}
	
}
