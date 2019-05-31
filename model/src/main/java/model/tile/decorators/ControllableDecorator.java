package model.tile.decorators;

import contract.tile.ITile;

public class ControllableDecorator extends Decorator {

	public ControllableDecorator(ITile tile) {
		super(tile);
		decorated.getModel().getController().setControllableObject(this);
	}
	
	@Override
	public boolean isMovable() {return true;}

	@Override
	public String description() {
		return decorated.description()+"+ControllableDecorator";
	}
}
