package model.tile.decorators;

import contract.tile.IDamageAction;
import contract.tile.ITile;

public class CrushableDecorator extends Decorator {

	public CrushableDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public void damage(IDamageAction ac) {
		decorated.damage(ac);
		switch(ac.getType()) {
		case PHYSIC:
			this.delete();
			break;
		default: break;
		}
	}
	
	@Override
	public String description() {
		return decorated.description()+"+CrushableDecorator";
	}

}
