package model.tile;

import java.util.function.BiFunction;

import contract.IFactoryCorrespondance;
import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;

public class FactoryCorrespondance implements IFactoryCorrespondance {
	private final char ch;
	private final BiFunction<IPosition, ITileMap, ITile> factory;
	 
	public FactoryCorrespondance(final char ch, final BiFunction<IPosition, ITileMap, ITile> factory) {
		this.ch = ch;
		this.factory = factory;
	}
	
	@Override
	public char getChar() {
		return this.ch;
	}
	
	@Override
	public BiFunction<IPosition, ITileMap, ITile> getFactory() {
		return this.factory;
	}
}
