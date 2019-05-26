package model.tile.decorators;

import contract.tile.IDamageAction;
import model.tile.Tile;

public class CrushableDecorator extends Decorator {
	
	public CrushableDecorator(Tile tile) {
		super(tile);
	}

	@Override
	public void damage(IDamageAction ac) {
		super.damage(ac);
		switch(ac.getType()) {
		case PHYSIC: {
			this.delete();
		}break;
		default: //Explicit default to stop eclipse to complain
			break;
		}
	}

}
