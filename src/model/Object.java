package model;

import javafx.geometry.Point2D;

public abstract class Object {
	protected Point2D position; 
	protected Board board; 
	
	public Object( Board b){
		board = b;
		
		
	}
	/**
	 * 
	 * @return la position de l'objet.
	 */
	public Point2D getPosition(){
		return position; 
	}
	/**
	 * 
	 * @param p la nouvelle position de l'objet
	 */
	public void setPosition(Point2D p){
		position = p; 
	}
	/**
	 * 
	 * @return abscisse de l'objet.
	 */
	public int getPosX(){
		return (int) position.getX();
	}
	/**
	 * 
	 * @return l'ordonné de l'objet 
	 */
	public int getPosY(){
		return (int)position.getY();
	}
	/**
	 * 
	 * @param board le nouveau labyrinth
	 */
	public void setBoard(Board board){
		this.board = board;
	}
	
}
