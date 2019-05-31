package model.tile.decorators;

import contract.IBoulderDashModel;
import contract.tile.ICollideAction;
import contract.tile.IDamageAction;
import contract.tile.IMoveAction;
import contract.tile.IPickAction;
import contract.tile.IPosition;
import contract.tile.IRenderObject;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;

public class Decorator implements ITile {
	ITile decorated;

	public Decorator(ITile tile) {
		this.decorated = tile;
	}
	
	@Override
	public ISprite getSprite() {
		return this.decorated.getSprite();
	}

	@Override
	public IPosition getPosition() {
		return this.decorated.getPosition();
	}

	@Override
	public ITileMap getMap() {
		return this.decorated.getMap();
	}

	@Override
	public void update() {
		this.decorated.update();
	}

	@Override
	public boolean collide(ICollideAction ac) {
		return this.decorated.collide(ac);
	}

	@Override
	public void damage(IDamageAction ac) {
		this.decorated.damage(ac);
		
	}

	@Override
	public void delete() {
		this.decorated.delete();
	}

	@Override
	public void pick(IPickAction ac) {
		this.decorated.pick(ac);
	}

	@Override
	public boolean move(IMoveAction ac) {
		return this.decorated.move(ac);
	}

	@Override
	public boolean isMovable() {
		return this.decorated.isMovable();
	}

	@Override
	public IRenderObject toRenderObject() {
		return this.decorated.toRenderObject();
	}

	@Override
	public IBoulderDashModel getModel() {
		return this.decorated.getModel();
	}

	@Override
	public void setPosition(IPosition futurePosition) {
		this.decorated.setPosition(futurePosition);
		
	}

	@Override
	public String description() {
		return this.decorated.description()+"+NonDescriptibleDecorator";
	}
	
}
