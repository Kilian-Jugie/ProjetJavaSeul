package controller;

import contract.tile.CollideType;
import contract.tile.Direction;
import contract.tile.IMoveAction;

public class MoveAction implements IMoveAction {
	private final Direction direction;
	private final CollideType type;
	
	public MoveAction(final Direction direction, final CollideType type) {
		this.direction = direction;
		this.type = type;
	}
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public CollideType getCollideType() {
		return this.type;
		
	}

}
