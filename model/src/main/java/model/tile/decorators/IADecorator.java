package model.tile.decorators;

import model.tile.Tile;

public class IADecorator extends Decorator {

	public IADecorator(Tile tile) {
		super(tile);
		this.getModel().addTickable(this);
	}
	
	@Override
	public void update() {
		//TODO: game mechanic
	}

}
