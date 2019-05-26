package model.tile;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import contract.tile.ISprite;

public class Sprite implements ISprite {
	Image image;
	
	public Sprite(String imgFileName) {
		try {
			this.image = ImageIO.read(new File(imgFileName));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public Image getImage() {
		return this.image;
	}
}
