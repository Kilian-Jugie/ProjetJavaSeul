package model.tile.decorators;

import contract.tile.ITile;

public class AIDecorator extends Decorator {

	public AIDecorator(ITile tile) {
		super(tile);
		decorated.getModel().addTickable(this);
	}
	
	@Override
	public void update() {
		
	}
	
}
