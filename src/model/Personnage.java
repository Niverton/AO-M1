package model;

import javafx.geometry.Point2D;
import model.interfaces.IPersonnage;



/**
 * 
 * @author laurent
 *
 */
public abstract class Personnage extends ObjectGame implements IPersonnage {
	
	/**
	 * 
	 *
	 */
	protected Personnage(){
		super();
	}
	
	/**
	 * 
	 * 
	 * @param posX l'abscisse (coordonnée X) initiale du personnage.
	 * @param posY l'ordonnée (coordonnée Y) initiale du personnage.
	 */
	protected Personnage ( int posX, int posY){
		super( posX, posY); 
	}
	
	/**
	 * 
	 * @param dir direction pour d�placer le personnage.
	 */
	public void move(Directions dir){
		switch(dir){
		case North: 
			this.setPosition(new Point2D(this.getPosX(), this.getPosY()-1));
			break; 
		case South:
			this.setPosition(new Point2D(this.getPosX(), this.getPosY()+1));
			break; 
		case West: 
			this.setPosition(new Point2D(this.getPosX()-1, this.getPosY()));
			break; 
		case East:
			this.setPosition(new Point2D(this.getPosX()+1, this.getPosY()));
			break;
		}
	}

	
}
