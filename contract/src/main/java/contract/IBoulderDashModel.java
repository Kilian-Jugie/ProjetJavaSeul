package contract;

import contract.tile.ITile;

public interface IBoulderDashModel {

	ITile getControllable();

	void addTickable(ITile tile);

	void setControllable(ITile tile);

	IFactoryCorrespondance getCorrespondance(char ch);


}
