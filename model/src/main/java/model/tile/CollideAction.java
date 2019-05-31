package model.tile;

import contract.tile.CollideType;
import contract.tile.Direction;
import contract.tile.ICollideAction;
import contract.tile.ITile;

public class CollideAction implements ICollideAction {
	private final Direction direction;
	private final CollideType type;
	private final ITile other;
	
	public CollideAction(Direction direction, CollideType type, ITile other) {
		this.direction = direction;
		this.type = type;
		this.other = other;
	}
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public CollideType getType() {
		return this.type;
	}

	@Override
	public ITile getOtherTile() {
		return this.other;
	}

}
