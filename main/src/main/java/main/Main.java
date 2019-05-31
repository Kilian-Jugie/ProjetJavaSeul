/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.IBoulderDashController;
import contract.IBoulderDashModel;
import contract.IBoulderDashView;
import contract.tile.ITile;
import controller.BoulderDashController;
import model.BoulderDashModel;
import model.Position;
import model.tile.Tile;
import model.tile.factories.AirFactory;
import view.BoulderDashView;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	private static final int mapID = 1; 
	
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
		final IBoulderDashModel model = new BoulderDashModel(mapID);
		final IBoulderDashController controller = new BoulderDashController();
		model.setController(controller);
		final IBoulderDashView view = new BoulderDashView(model, controller);
		controller.setView(view);
		model.initialize();
		view.initialize();
		controller.start();
		
		
		/*ITile normal = new Tile(null,null,null);
		System.out.println(normal.collide(null));
		ITile air = AirFactory.createAir(null, null);
		System.out.println(air.collide(null));
		
		model.getMap().setAirAt(new Position(0,0));
		System.out.println(model.getMap().getTileAt(0, 0).description());*/
		
    }
}
