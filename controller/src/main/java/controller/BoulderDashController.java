package controller;

import contract.IBoulderDashController;
import contract.tile.ITile;

public class BoulderDashController implements IBoulderDashController {
	private final ITile controllableObject;
	
	public BoulderDashController(ITile controllableObject) {
		this.controllableObject = controllableObject;
	}
}
