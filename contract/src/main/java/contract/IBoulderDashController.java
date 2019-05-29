package contract;

import contract.tile.ITile;

public interface IBoulderDashController {

	void actionPerform(GameAction ac);
	void setView(IBoulderDashView view);
	
	void start();
	void setControllableObject(ITile tile);
}
