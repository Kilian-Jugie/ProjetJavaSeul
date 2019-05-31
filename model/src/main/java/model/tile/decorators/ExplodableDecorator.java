package model.tile.decorators;

import contract.tile.IDamageAction;
import contract.tile.ITile;

public class ExplodableDecorator extends Decorator {

	public ExplodableDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public void damage(IDamageAction ac) {
		decorated.damage(ac);
		switch(ac.getType()) {
		case EXPLOSION:
			this.delete();
			break;
			default: break;
		}
	}
	
	@Override
	public String description() {
		return decorated.description()+"+ExplodableDecorator";
	}
	
}
