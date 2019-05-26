package model.tile;

import java.util.function.BiFunction;

import contract.tile.ITile;

public class FactoryCorrespondance {
	private final char ch;
	private final BiFunction<Position, TileMap, ITile> factory;
	 
	public FactoryCorrespondance(final char ch, final BiFunction<Position, TileMap, ITile> factory) {
		this.ch = ch;
		this.factory = factory;
	}
	
	public char getChar() {
		return this.ch;
	}
	
	public BiFunction<Position, TileMap, ITile> getFactory() {
		return this.factory;
	}
}
