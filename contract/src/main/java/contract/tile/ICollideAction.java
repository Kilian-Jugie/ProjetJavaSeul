package contract.tile;

public interface ICollideAction {
	public Direction getDirection();
	public CollideType getType();
	public ITile getOtherTile();
}
