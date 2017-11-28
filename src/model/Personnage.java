package model;

import javafx.geometry.Point2D;
import model.graph.Graph.Directions;


/**
 * 
 * @author laurent
 *
 */
public abstract class Personnage extends Object {
	
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
	public void move(model.Labyrinth.Directions dir){
		switch(dir){
		case NORTH: 
			this.setPosition(new Point2D(this.getPosX(), this.getPosY()-1));
			break; 
		case SOUTH:
			this.setPosition(new Point2D(this.getPosX(), this.getPosY()+1));
			break; 
		case WEST: 
			this.setPosition(new Point2D(this.getPosX()-1, this.getPosY()));
			break; 
		case EAST:
			this.setPosition(new Point2D(this.getPosX()+1, this.getPosY()));
			break;
		}
	}

	
}
