package model.tile;

import java.util.ArrayList;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;
import model.tile.factories.AirFactory;

public class TileMap implements ITileMap {
	private ArrayList<ArrayList<ITile>> map = new ArrayList<ArrayList<ITile>>();

	void setArraySize(ArrayList<Object> arr, int i) {
		for(int n=0; n<i; ++n) {
			arr.add(null);
		}
	}
	
	@Override
	public void setSize(int column, int lines) {
		map.ensureCapacity(lines);
		setArraySize(map, lines);
		for(int i=0; i<lines; ++i) {
			ArrayList<ITile> ar = map.get(i);
			ar = new ArrayList<ITile>();
			ar.ensureCapacity(column);
		}
	}
	
	@Override
	public ITile getTileAt(IPosition position) {
		return map.get(position.getY()).get(position.getX());
	}
	
	@Override
	public ITile getTileAt(int x, int y) {
		return this.getTileAt(new Position(x,y));
	}
	
	@Override
	public void setTileAt(ITile tile, IPosition position) {
		System.out.println("Position: "+position.getX()+":"+position.getY());
		map.get(position.getX()).set(position.getY(), tile);
		
	}

	@Override
	public void setAirAt(IPosition position) {
		this.setTileAt(AirFactory.createAir(position, this), position);

	}

	@Override
	public ArrayList<ArrayList<ITile>> getMap() {
		return this.map;
	}

	@Override
	public int getSize() {
		return map.size();
	}
}
