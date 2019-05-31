package controller;

import java.awt.event.KeyEvent;

import contract.GameAction;
import contract.IBoulderDashController;
import contract.IBoulderDashView;
import contract.tile.CollideType;
import contract.tile.Direction;
import contract.tile.ITile;

public class BoulderDashController implements IBoulderDashController {
	private ITile controllableObject;
	private IBoulderDashView view;
	
	public BoulderDashController() {
	}
	
	@Override
	public void setControllableObject(ITile tile) {
		this.controllableObject = tile;
	}
	
	@Override
	public IBoulderDashView getView() {
		return this.view;
	}
	
	@Override
	public void actionPerform(GameAction ac) {
		if(controllableObject==null) {
			System.out.println("Controllable null !");
			return;
		}
		if(ac==null) return; //unhandled key
		switch(ac) {
		case MOVE_DOWN:
			controllableObject.move(new MoveAction(Direction.DOWN, CollideType.HUMAN));
			break;
		case MOVE_LEFT:
			controllableObject.move(new MoveAction(Direction.LEFT, CollideType.HUMAN));
			break;
		case MOVE_RIGHT:
			controllableObject.move(new MoveAction(Direction.RIGHT, CollideType.HUMAN));
			break;
		case MOVE_UP:
			controllableObject.move(new MoveAction(Direction.UP, CollideType.HUMAN));
			break;
		}
		view.refresh();
	}
	
	public void registerKeyCorrespondances() {
		view.addKeyCorrespondance(KeyEvent.VK_Z, GameAction.MOVE_UP);
		view.addKeyCorrespondance(KeyEvent.VK_Q, GameAction.MOVE_LEFT);
		view.addKeyCorrespondance(KeyEvent.VK_S, GameAction.MOVE_DOWN);
		view.addKeyCorrespondance(KeyEvent.VK_D, GameAction.MOVE_RIGHT);
	}

	@Override
	public void setView(IBoulderDashView view) {
		this.view = view;
	}

	@Override
	public void start() {
		this.registerKeyCorrespondances();
		
	}
	
}
