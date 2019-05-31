package contract.tile;

import contract.IBoulderDashModel;

public interface ITile {
	public ISprite getSprite();
	public IPosition getPosition();
	public ITileMap getMap();
	
	public void update();
	/*
	 * return: true is player can go else false
	 * Can player pass ? not ? push ?
	 */
	public boolean collide(ICollideAction ac);
	
	/*
	 * falling object, explosion
	 */
	public void damage(IDamageAction ac);
	
	/*
	 * Remove tile
	 * 
	 */
	public void delete();
	
	public void pick(IPickAction ac);
	
	/*
	 * return: true is move success else false
	 * 
	 */
	public boolean move(IMoveAction ac);
	
	//Require to use showboard
	public boolean isMovable();
	
	public IRenderObject toRenderObject();
	public IBoulderDashModel getModel();
	public void setPosition(IPosition futurePosition);
	
	public String description();
}
