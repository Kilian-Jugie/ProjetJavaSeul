package model.tile.decorators;

import contract.tile.IDamageAction;
import model.tile.Tile;

public class ExplodableDecorator extends Decorator {
	public ExplodableDecorator(Tile tile) {
		super(tile);
	}

	@Override
	public void damage(IDamageAction ac) {
		super.damage(ac);
		switch(ac.getType()) {
		case EXPLOSION: {
			this.delete();
		}break;
		default: //Explicit default to stop eclipse to complain
			break;
		}
	}
}
