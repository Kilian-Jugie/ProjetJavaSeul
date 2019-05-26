package contract.tile;

public interface IMoveAction {
	public Direction getDirection();
	public CollideType getCollideType();
}
