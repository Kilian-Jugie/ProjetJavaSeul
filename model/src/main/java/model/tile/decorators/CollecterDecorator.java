package model.tile.decorators;

import contract.tile.IPickAction;
import contract.tile.ITile;

public class CollecterDecorator extends Decorator {

	private int diamonds = 0;
	
	public CollecterDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public void pick(IPickAction ac) {
		++this.diamonds;
		ac.getPickedTile().delete();
		System.out.println("Picked Diamond : "+diamonds);
	}
	
	@Override
	public String description() {
		return decorated.description()+"+CollecterDecorator";
	}

}
