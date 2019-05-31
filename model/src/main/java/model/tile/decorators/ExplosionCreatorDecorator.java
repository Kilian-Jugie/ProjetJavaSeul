package model.tile.decorators;

import contract.tile.ITile;

public class ExplosionCreatorDecorator extends Decorator {

	public ExplosionCreatorDecorator(ITile tile) {
		super(tile);
	}

	@Override
	public void delete() {
		this.makeExplosion();
		super.delete();
	}
	
	private void makeExplosion() {
		//TODO
	}
	
	@Override
	public String description() {
		return decorated.description()+"+ExplosionCreatorDecorator";
	}
}
