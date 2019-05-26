package model.tile.decorators;

import contract.tile.IPickAction;
import model.tile.Tile;

public class CollecterDecorator extends Decorator {

	public CollecterDecorator(Tile tile) {
		super(tile);
	}
	
	@Override
	public void pick(IPickAction ac) {
		++this.pickedDiamonds;
	}

}
