package model.tile.decorators;

import contract.tile.IDamageAction;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileMap;

public class ExplodableDecorator extends Decorator {
	public ExplodableDecorator(Sprite sprite, Position position, TileMap map) {
		super(sprite, position, map);
	}

	@Override
	public void damage(IDamageAction ac) {
		switch(ac.getType()) {
		case EXPLOSION: {
			this.delete();
		}break;
		default: //Explicit default to stop eclipse to complain
			break;
		}
	}
}
