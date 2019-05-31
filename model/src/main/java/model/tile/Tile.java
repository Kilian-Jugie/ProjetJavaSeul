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
import model.RenderObject;

public class Tile implements ITile {
	private ISprite sprite;
	private IPosition position;
	private ITileMap map;
	private final IBoulderDashModel model = BoulderDashModel.getInstance();
	
	public static ArrayList<FactoryCorrespondance> correspondances = new ArrayList<FactoryCorrespondance>();
	
	public Tile(ISprite sprite, IPosition position, ITileMap map) {
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
		
	}

	@Override
	public boolean collide(ICollideAction ac) {
		return false;
	}

	@Override
	public void damage(IDamageAction ac) {
		
	}

	@Override
	public void delete() {
		this.map.setAirAt(this.position);
		this.getModel().getController().getView().refresh();
	}

	@Override
	public void pick(IPickAction ac) {
		
	}

	@Override
	public boolean move(IMoveAction ac) {
		return false;
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public IRenderObject toRenderObject() {
		return new RenderObject(this);
	}

	@Override
	public IBoulderDashModel getModel() {
		return this.model;
	}

	@Override
	public void setPosition(IPosition futurePosition) {
		this.position = futurePosition;
	}

	@Override
	public String description() {
		return "Tile";
	}

}
