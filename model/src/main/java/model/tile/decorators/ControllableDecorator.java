package model.tile.decorators;

import model.tile.Tile;

public class ControllableDecorator extends Decorator {

	public ControllableDecorator(Tile tile) {
		super(tile);
		this.getModel().getController().setControllableObject(tile);
		
	}
	
	@Override
	public
	boolean isMovable() {
		return true;
	}

}
