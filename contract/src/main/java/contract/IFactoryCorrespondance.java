package contract;

import java.util.function.BiFunction;

import contract.tile.IPosition;
import contract.tile.ITile;
import contract.tile.ITileMap;

public interface IFactoryCorrespondance {

	BiFunction<IPosition, ITileMap, ITile> getFactory();

	char getChar();

}
