package model;

import java.util.ArrayList;

import contract.IBoulderDashModel;
import contract.tile.ITile;
import model.tile.FactoryCorrespondance;
import model.tile.Tile;
import model.tile.factories.AirFactory;
import model.tile.factories.BorderFactory;
import model.tile.factories.DiamondFactory;
import model.tile.factories.DirtFactory;
import model.tile.factories.EnemyFactory;
import model.tile.factories.PlayerFactory;
import model.tile.factories.RockFactory;
import model.tile.factories.WallFactory;

public class BoulderDashModel implements IBoulderDashModel {
	private static IBoulderDashModel INSTANCE = null;
	private ITile controllable = null;
	private ArrayList<ITile> tickable;
	
	public BoulderDashModel(int id) throws RuntimeException {
		if(INSTANCE!=null) 
			throw new RuntimeException("BoulderDashModel is already instancied !");
		INSTANCE = this;
		this.setupTileCorrespondances();
	}
	
	
	public static final IBoulderDashModel getInstance() {
		return INSTANCE;
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
	public void setControllable(ITile tile) {
		this.controllable = tile;
	}
	
	@Override
	public ITile getControllable() {
		return this.controllable;
	}
	
	@Override
	public void addTickable(ITile tile) {
		tickable.add(tile);
	}
}
