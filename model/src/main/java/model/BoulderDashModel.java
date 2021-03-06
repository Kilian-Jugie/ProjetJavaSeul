package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.IBoulderDashController;
import contract.IBoulderDashModel;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.FactoryCorrespondance;
import model.Position;
import model.tile.Tile;
import model.tile.factories.AirFactory;
import model.tile.factories.BorderFactory;
import model.tile.factories.DiamondFactory;
import model.tile.factories.DirtFactory;
import model.tile.factories.EnemyFactory;
import model.tile.factories.PlayerFactory;
import model.tile.factories.RockFactory;
import model.tile.factories.WallFactory;

public class BoulderDashModel extends Observable implements IBoulderDashModel {
	private static IBoulderDashModel INSTANCE = null;
	private ArrayList<ITile> tickable = new ArrayList<ITile>();
	private ITileMap map;
	private IBoulderDashController controller = null;
	
	public BoulderDashModel(int id) throws RuntimeException {
		if(INSTANCE!=null) 
			throw new RuntimeException("BoulderDashModel is already instancied !");
		INSTANCE = this;
		
	}
	
	@Override
	public void setController(IBoulderDashController controller) {
		this.controller = controller;
	}
	
	@Override
	public IBoulderDashController getController() {
		return this.controller;
	}
	
	@Override
	public ITileMap getMap() {
		return map;
	}
	
	public static final IBoulderDashModel getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void initialize() {
		BoulderDashDB db = BoulderDashDB.getInstance();
		this.setupTileCorrespondances();
		map = db.getMapId(1, this);
		
	}
	
	private void setupTileCorrespondances() {
		Tile.correspondances.add(new FactoryCorrespondance('A', AirFactory::createAir));
		Tile.correspondances.add(new FactoryCorrespondance('D', DirtFactory::createDirt));
		Tile.correspondances.add(new FactoryCorrespondance('B', BorderFactory::createBorder));
		Tile.correspondances.add(new FactoryCorrespondance('N', DiamondFactory::createDiamond));
		Tile.correspondances.add(new FactoryCorrespondance('R', RockFactory::createRock));
		Tile.correspondances.add(new FactoryCorrespondance('W', WallFactory::createWall));
		Tile.correspondances.add(new FactoryCorrespondance('P', PlayerFactory::createPlayer));
		Tile.correspondances.add(new FactoryCorrespondance('E', EnemyFactory::createEnemy));
	}
	
	@Override
	public FactoryCorrespondance getCorrespondance(char ch)  {
		for(int i=0; i<Tile.correspondances.size(); ++i) {
			if(Tile.correspondances.get(i).getChar()==ch)
				return Tile.correspondances.get(i);
		}
		return null;
	}
	
	@Override
	public void addTickable(ITile tile) {
		tickable.add(tile);
	}

	@Override
	public Observable getObservable() {
		return this;
	}
	
	@Override
	public ITile createAir(int x, int y) {
		return AirFactory.createAir(new Position(x,y), map);
	}

}
