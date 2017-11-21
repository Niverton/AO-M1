package model;
/**
 * 
 * @author laurent
 *
 */
public abstract class Personnage extends Object {
	
	public Personnage(Board board){
		super(board);
	}
	/**
	 * 
	 * @return test si le personnage peu aller sur la gauche
	 */
	private boolean canLeft(){
		if(this.getPosX() > 0)
		return !board.getDoor().containsEdge(ref[this.getPosX()][this.getPosY()], ref[this.getPosX()-1][this.getPosY()]);
		
		return false;
	}
	/**
	 * 
	 * @return test si le personnage peu se d�placer a droite. 
	 */
	private boolean canRight(){
		if(this.getPosX() < board.getSize()-1)
		return !board.getDoor().containsEdge(ref[this.getPosX()][this.getPosY()], ref[this.getPosX()+1][this.getPosY()]);
		
		return false;
	}
	/**
	 * 
	 * @return test si le personnage peut aller en haut
	 */
	private boolean canUp(){
		if(this.getPosY() > 0)
		return !board.getDoor().containsEdge(ref[this.getPosX()][this.getPosY()], ref[this.getPosX()][this.getPosY()-1]);
		
		return false;
	}
	/**
	 * 
	 * @return test si le personnage peu aller en bas.
	 */
	private boolean canDown(){
		if(this.getPosY() < board.getSize()-1)
		return !board.getDoor().containsEdge(ref[this.getPosX()][this.getPosY()], ref[this.getPosX()][this.getPosY()+1]);
		
		return false;
	}
	/**
	 * deplacement a droite du personnage 
	 */
	public void moveRight(){
		if(this.canRight()){
			this.setPosition(new Point2D(position.getX()+1, position.getY()));
		}
			
	}
	public void moveLeft(){
		if(this.canLeft()){
			this.setPosition(new Point2D(position.getX()-1, position.getY()));
		}
			
	}
	public void moveUp(){
		if(this.canUp()){
			this.setPosition(new Point2D(position.getX(), position.getY()-1));
		}
			
	}
	public void movedown(){
		if(this.canDown()){
			this.setPosition(new Point2D(position.getX(), position.getY()+1));
		}
			
	}
}
