package model;

import java.awt.Image;

import javax.imageio.ImageIO;

import contract.tile.ISprite;

public class Sprite implements ISprite {
	Image image;
	
	public Sprite(String imgFileName) {
		try {
			this.image = ImageIO.read(getClass().getResource("/"+imgFileName));
		}
		catch(Exception e) {
			System.out.println(e.getMessage()+" : '"+imgFileName+"'");
			e.printStackTrace();
		}
	}
	
	@Override
	public Image getImage() {
		return this.image;
	}
}

