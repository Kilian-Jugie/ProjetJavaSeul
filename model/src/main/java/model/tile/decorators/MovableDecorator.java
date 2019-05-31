package model.tile.decorators;

import contract.tile.IMoveAction;
import contract.tile.IPosition;
import contract.tile.ITile;
import model.Position;
import model.tile.CollideAction;

public class MovableDecorator extends Decorator {

	public MovableDecorator(ITile tile) {
		super(tile);
	}
	
	@Override
	public boolean move(IMoveAction ac) {
		IPosition position = this.getPosition();
		
		IPosition futurePosition = new Position(position.getX(),position.getY()); //Create a deep copy to avoid reference to move player before checking collide()
		switch(ac.getDirection()) {
		case DOWN:
			futurePosition.setY(position.getY()+1);
			break;
		case LEFT:
			futurePosition.setX(position.getX()-1);
			break;
		case RIGHT:
			futurePosition.setX(position.getX()+1);
			break;
		case UP:
			futurePosition.setY(position.getY()-1);
			break;
		}
		
		if(this.getMap().getTileAt(futurePosition).collide(new CollideAction(ac.getDirection(), ac.getCollideType(), this.decorated))==true) {
			decorated.setPosition(futurePosition);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isMovable() {
		return true;
	}

	@Override
	public String description() {
		return decorated.description()+"+MovableDecorator";
	}
}
