/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.IBoulderDashModel;
import model.BoulderDashModel;

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
		
    }
}
