package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.SwingUtilities;

import contract.GameAction;
import contract.IBoulderDashController;
import contract.IBoulderDashModel;
import contract.IBoulderDashView;
import contract.tile.IRenderObject;
import contract.tile.ITile;
import contract.tile.ITileMap;
import fr.exia.showboard.BoardFrame;

public class BoulderDashView extends Observable implements IBoulderDashView, Runnable, KeyListener {
	private static final String windowName = "Boulder Dash";
	private static final int width = 20;
	private static final int height = 20;
	private static final int padding = 0;
	private static final Rectangle rectView = new Rectangle(padding,padding,width-padding,height-padding);
	private static final int windowWidth = 800;
	private static final int windowHeight = windowWidth;
	
	private final IBoulderDashController controller;
	private final IBoulderDashModel model;
	private boolean isInitialized = false;
	
	private ArrayList<KeyCorrespondance>  keyCorrespondances = new ArrayList<KeyCorrespondance>();
	BoardFrame frameView;
	
	@Override
	public final void addKeyCorrespondance(int keycode, GameAction action) {
		this.keyCorrespondances.add(new KeyCorrespondance(keycode, action));
	}
	
	@Override
	public final GameAction keyCodeToAction(int keycode) {
		for(int i=0; i<this.keyCorrespondances.size(); ++i) {
			if(keyCorrespondances.get(i).getKeyCode()==keycode)
				return keyCorrespondances.get(i).getAction();
		}
		return null;
	}

	public BoulderDashView(IBoulderDashModel model, IBoulderDashController controller) {
		this.model = model;
		this.controller = controller;
		
		
	}
	
	@Override
	public void initialize() {
		this.loadMapIntoRenderer(model.getMap());
		
		SwingUtilities.invokeLater(this);
	}
	
	private void initializeBF() {
		if(isInitialized==true) return; 
		isInitialized=true;
		frameView = new BoardFrame(BoulderDashView.windowName);
		frameView.setDimension(new Dimension(BoulderDashView.width, BoulderDashView.height));
		frameView.setDisplayFrame(BoulderDashView.rectView);
		frameView.setSize(BoulderDashView.windowWidth, BoulderDashView.windowHeight);
		this.addObserver(frameView.getObserver());
		frameView.addKeyListener(this);
	}
	
	@Override
	public void run() {
		if(isInitialized==false) initializeBF();
		frameView.setVisible(true);
	}
	
	public final void loadMapIntoRenderer(ITileMap map) {
		for(int i=0; i<map.getSize(); ++i) {
			for(int n=0; n<map.getSize(); ++n) {
				ITile tile = map.getTileAt(n,i);
				//System.out.println("tile: "+tile+" x: "+n+" y: "+i);
				if(i==2&&n==2) {
					System.out.println("Obj: "+tile+" move: "+tile.isMovable());
				}
				this.addTile(tile.toRenderObject(), tile.isMovable());
			}
		}
	}
	
	public final void addTile(IRenderObject toRender, boolean pawn) {
		if(isInitialized==false) initializeBF();
		if(pawn==true) {
			frameView.addPawn(toRender);
			ITile back = model.createAir(toRender.getX(), toRender.getY());
			IRenderObject rback = back.toRenderObject();
			frameView.addSquare(rback, rback.getX(), rback.getY());
		} else {
			frameView.addSquare(toRender, toRender.getX(), toRender.getY());
		}
	}
	
	@Override
	public final void refresh() {
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		controller.actionPerform(this.keyCodeToAction(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
}
