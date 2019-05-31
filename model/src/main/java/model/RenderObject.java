package model;

import java.awt.Image;
import java.awt.Point;

import contract.tile.IRenderObject;
import contract.tile.ITile;

public class RenderObject implements IRenderObject {

	ITile tile;
	
	public RenderObject(ITile tile) {
		this.tile = tile;
	}

	@Override
	public Image getImage() {
		return tile.getSprite().getImage();
	}

	@Override
	public int getX() {
		return tile.getPosition().getX();
	}

	@Override
	public int getY() {
		return tile.getPosition().getY();
	}
	

	@Override
	public Point getPosition() {
		return new Point(this.getX(), this.getY());
	}

}