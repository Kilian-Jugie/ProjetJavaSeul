package model.tile;

import contract.tile.ICollideAction;
import contract.tile.IDamageAction;
import contract.tile.IPosition;
import contract.tile.ISprite;
import contract.tile.ITile;
import contract.tile.ITileMap;

public abstract class Tile implements ITile {
	private final Sprite sprite;
	private final Position position;
	private final TileMap map; //Used to delete object
	
	public static final Sprite airSprite = new Sprite("air.png");
	
	public Tile(Sprite sprite, Position position, TileMap map) {
		this.sprite = sprite;
		this.position = position;
		this.map = map;
	}

	@Override
	public ISprite getSprite() {
		return this.sprite;
	}

	@Override
	public IPosition getPosition() {
		return this.position;
	}
	
	@Override
	public ITileMap getMap() {
		return this.map;
	}
	
	@Override
	public void update() {
		//Base: nothing to do
	}
	
	@Override
	public boolean collide(ICollideAction ac) {
		return true; //Base: no collision with tile
	}

	@Override
	public void damage(IDamageAction ac) {
		//Base: nothing to do
	}
	
	@Override
	public void delete() {
		
	}
}
