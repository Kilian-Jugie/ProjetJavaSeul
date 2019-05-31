package model.tile.decorators;

import contract.tile.ICollideAction;
import contract.tile.ITile;

public class UnCollidableDecorator extends Decorator {

	public UnCollidableDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public boolean collide(ICollideAction ac) {
		return true;
	}
	
	@Override
	public String description() {
		return this.decorated.description()+"+UnCollidableDecorator";
	}
	
}
