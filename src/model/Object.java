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
	public Point2D getPosition(){
		return position; 
	}
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
