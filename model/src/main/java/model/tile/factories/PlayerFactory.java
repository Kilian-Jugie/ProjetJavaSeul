package model.tile.factories;

import contract.tile.ITile;
import model.tile.Position;
import model.tile.Sprite;
import model.tile.TileBasic;
import model.tile.TileMap;
import model.tile.decorators.ControllableDecorator;
import model.tile.decorators.CrushableDecorator;
import model.tile.decorators.ExplodableDecorator;
import model.tile.decorators.MovableDecorator;

public class PlayerFactory {
	private static final Sprite playerSprite = new Sprite("player.png");
	
	public static final ITile createPlayer(Position position, TileMap map) {
		return new ControllableDecorator(new MovableDecorator(new CrushableDecorator(new ExplodableDecorator(new TileBasic(playerSprite, position, map)))));
	}
}
