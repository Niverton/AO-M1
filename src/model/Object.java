package model;

public abstract class Object {
	protected Point2D position; 
	protected Board board; 
	protected Point2D[][] ref;
	public Object( Board b){
		board = b;
		position = new Point2D(0,0);
		ref =board.getAllPosition();
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
		return position.getX();
	}
	/**
	 * 
	 * @return l'ordonné de l'objet 
	 */
	public int getPosY(){
		return position.getY();
	}
	/**
	 * 
	 * @param board le nouveau labyrinth
	 */
	public void setBoard(Board board){
		this.board = board;
	}
	
}
