package model.tile;

import contract.tile.Direction;
import contract.tile.ICollideAction;

public class CollideAction implements ICollideAction {
	private final Direction direction;
	
	public CollideAction(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}

}
