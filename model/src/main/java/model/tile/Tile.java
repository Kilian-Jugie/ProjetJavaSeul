package model.tile;

import java.util.ArrayList;

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
import model.BoulderDashModel;

public abstract class Tile implements ITile {
	private final ISprite sprite;
	private final IPosition position;
	private final ITileMap map; //Used to delete object
	private final IBoulderDashModel model = BoulderDashModel.getInstance();
	
	protected int pickedDiamonds = 0;
	
	protected IBoulderDashModel getModel() {
		return model;
	}
	
	public static ArrayList<FactoryCorrespondance> correspondances = new ArrayList<FactoryCorrespondance>();
	
	public Tile(ISprite iSprite, IPosition iPosition, ITileMap iTileMap) {
		this.sprite = iSprite;
		this.position = iPosition;
		this.map = iTileMap;
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
		return false; //Base: collision with tile
	}

	@Override
	public void damage(IDamageAction ac) {
		//Base: nothing to do
	}
	
	@Override
	public void delete() {
		map.setAirAt(this.position);
	}
	
	@Override
	public void pick(IPickAction ac) {
		//Base: nothing to do
	}
	
	@Override
	public boolean move(IMoveAction ac) {
		return false; //Object cannot move
	}
	
	@Override
	public boolean isMovable() {
		return false; //No movable by default
	}
	
	@Override
	public IRenderObject toRenderObject() {
		return new RenderObject(this);
	}
}
