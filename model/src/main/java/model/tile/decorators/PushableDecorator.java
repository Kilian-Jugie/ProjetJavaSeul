package model.tile.decorators;

import contract.tile.ICollideAction;
import contract.tile.ITile;

public class PushableDecorator extends Decorator {

	public PushableDecorator(ITile tile) {
		super(tile);
	}

	@Override
	public boolean collide(ICollideAction ac) {
		//TODO
		return false;
	}
	
	@Override
	public String description() {
		return decorated.description()+"+PushableDecorator";
	}
}
