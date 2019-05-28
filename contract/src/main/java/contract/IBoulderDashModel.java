package contract;



import java.util.Observable;

import contract.tile.ITile;
import contract.tile.ITileMap;

public interface IBoulderDashModel {

	ITile getControllable();

	void addTickable(ITile tile);

	void setControllable(ITile tile);

	IFactoryCorrespondance getCorrespondance(char ch);

	ITileMap getMap();
	
	Observable getObservable();


	void initialize();
}
