package model;

import javafx.geometry.Point2D;

public abstract class Object {
	protected Point2D position; 
	

	/**
	 * 
	 * @param l le labyrinthe dans lequel va se d�placer le personnage.
	 */
	protected Object( ){
	position = new Point2D(0,0);
		
	}

	/**
	 * 
	 * 
	 * @param posX l'abscisse (coordonnée X) initiale du personnage.
	 * @param posY l'ordonnée (coordonnée Y) initiale du personnage.
	 */
	protected Object( int posX, int posY){
	
		position = new Point2D(posX, posY);
		
	}

	/**
	 * 
	 * @return La position de l'objet.
	 */
	public Point2D getPosition(){
		return position; 
	}
	/**
	 * 
	 * @param p la nouvelle position de l'objet
	 */
	protected void setPosition(Point2D p){
		position = p; 
	}
	/**
	 * 
	 * @return L'abscisse de l'objet.
	 */
	public int getPosX(){
		return (int) position.getX();
	}
	/**
	 * 
	 * @return L'ordonn�e de l'objet 
	 */
	public int getPosY(){
		return (int)position.getY();
	}
	
	
}
