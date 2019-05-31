package model.tile;

import contract.tile.IPickAction;
import contract.tile.ITile;

public class PickAction implements IPickAction {
	private final ITile tile;
	
	public PickAction(ITile tile) {
		this.tile = tile;
	}
	
	@Override
	public ITile getPickedTile() {
		return tile;
	}
}
