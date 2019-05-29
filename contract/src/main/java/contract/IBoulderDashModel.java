package contract;



import java.util.Observable;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;

public interface IBoulderDashModel {

	void addTickable(ITile tile);

	IFactoryCorrespondance getCorrespondance(char ch);

	ITileMap getMap();
	
	Observable getObservable();


	void initialize();

	void setController(IBoulderDashController controller);

	IBoulderDashController getController();

	ITile createAir(int x, int y);
}
