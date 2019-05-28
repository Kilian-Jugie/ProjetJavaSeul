package model.tile.decorators;

import contract.tile.IMoveAction;
import contract.tile.IPosition;
import model.tile.CollideAction;
import model.tile.Tile;

public class MovableDecorator extends Decorator {

	public MovableDecorator(Tile tile) {
		super(tile);
	}
	
	@Override
	public boolean move(IMoveAction ac) {
		IPosition futurePosition = this.getPosition();
		switch(ac.getDirection()) {
		case DOWN:
			futurePosition.setY(futurePosition.getY()-1);
			break;
		case LEFT:
			futurePosition.setX(futurePosition.getX()-1);
			break;
		case RIGHT:
			futurePosition.setX(futurePosition.getX()+1);
			break;
		case UP:
			futurePosition.setY(futurePosition.getY()+1);
			break;
		}
		return this.getMap().getTileAt(futurePosition).collide(new CollideAction(ac.getDirection(), ac.getCollideType(), this));
	}
	
	@Override
	public boolean isMovable() {
		return true;
	}

}
