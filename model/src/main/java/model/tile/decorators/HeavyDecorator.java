package model.tile.decorators;

import contract.tile.ITile;

public class HeavyDecorator extends Decorator {

	public HeavyDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public String description() {
		return decorated.description()+"+HeavyDecorator";
	}
	
}
