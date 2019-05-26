package model.tile.decorators;

import model.tile.Tile;

public class ExplosionCreatorDecorator extends Decorator {

	public ExplosionCreatorDecorator(Tile tile) {
		super(tile);
	}
	
	private void makeExplosion() {
		//TODO: this
	}
	
	@Override
	public void delete() {
		this.makeExplosion();
		super.delete();
	}

}
