package contract.tile;


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
}
