package model;

import javafx.geometry.Point2D;

/**
 * 
 * @author laurent
 *
 */
public abstract class Personnage extends Object {

	/**
	 * 
	 * @param labyrinth le labyrinthe dans lequel va se d�placer le personnage.
	 */
	protected Personnage(Labyrinth labyrinth){
		super(labyrinth);
	}
	
	/**
	 * 
	 * @param labyrinth le labyrinthe dans lequel va se d�placer le personnage.
	 * @param posX l'abscisse (coordonnée X) initiale du personnage.
	 * @param posY l'ordonnée (coordonnée Y) initiale du personnage.
	 */
	protected Personnage (Labyrinth labyrinth, int posX, int posY){
		super(labyrinth, posX, posY); 
	}
	
	
	/**
	 * 
	 * @return Teste si le personnage peut aller a gauche.
	 */
	private boolean canLeft(){
		
		
		return false;
	}
	/**
	 * 
	 * @return Teste si le personnage peut aller a droite. 
	 */
	private boolean canRight(){
		
		
		return false;
	}
	/**
	 * 
	 * @return Teste si le personnage peut aller en haut.
	 */
	private boolean canUp(){
		
		
		return false;
	}
	/**
	 * 
	 * @return Teste si le personnage peut aller en bas.
	 */
	private boolean canDown(){
		
		
		return false;
	}
	
	
	/**
	 * Deplacement du personnage vers la droite si c'est possible.
	 */
	public void moveRight(){
		if(this.canRight()){
			this.setPosition(new Point2D(this.getPosX()+1, this.getPosY()));
		}
			
	}
	/**
	 * Deplacement du personnage vers la gauche si c'est possible.
	 */
	public void moveLeft(){
		if(this.canLeft()){
			this.setPosition(new Point2D(this.getPosX()-1, this.getPosY()));
		}
			
	}
	/**
	 * Deplacement du personnage vers le haut si c'est possible.
	 */
	public void moveUp(){
		if(this.canUp()){
			this.setPosition(new Point2D(this.getPosX(), this.getPosY()-1));
		}
			
	}
	/**
	 * Deplacement du personnage vers le bas si c'est possible.
	 */
	public void moveDown(){
		if(this.canDown()){
			this.setPosition(new Point2D(this.getPosX(), this.getPosY()+1));
		}
			
	}
}
