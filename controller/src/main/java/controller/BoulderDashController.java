package controller;

import java.awt.event.KeyEvent;

import contract.GameAction;
import contract.IBoulderDashController;
import contract.IBoulderDashView;
import contract.tile.ITile;

public class BoulderDashController implements IBoulderDashController {
	private final ITile controllableObject;
	private IBoulderDashView view;
	
	public BoulderDashController(ITile controllableObject) {
		this.controllableObject = controllableObject;
	}
	
	@Override
	public void actionPerform(GameAction ac) {
		//TODO
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
