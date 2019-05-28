package contract.tile;

import java.awt.Image;
import java.awt.Point;

import fr.exia.showboard.IPawn;
import fr.exia.showboard.ISquare;

public interface IRenderObject extends ISquare, IPawn {
	Image getImage();
	
	int getX();
	int getY();
	
	Point getPosition();
}
