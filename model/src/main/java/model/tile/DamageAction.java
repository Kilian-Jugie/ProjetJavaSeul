package model.tile;

import contract.tile.DamageType;
import contract.tile.IDamageAction;

public class DamageAction implements IDamageAction {
	private final DamageType type;
	
	public DamageAction(DamageType type) {
		this.type = type;
	}
	
	@Override
	public DamageType getType() {
		return this.type;
	}

}
