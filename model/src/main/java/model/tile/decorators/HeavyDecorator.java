package model.tile.decorators;

import model.tile.Tile;

public class HeavyDecorator extends Decorator {

	public HeavyDecorator(Tile tile) {
		super(tile);
	}
	
	@Override
	public void update() {
		//TODO: Game mechanic gravity
	}

}
