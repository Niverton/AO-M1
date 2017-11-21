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
	public int getPosX(){
		return position.getX();
	}
	public int getPosY(){
		return position.getY();
	}
	public void setBoard(Board board){
		this.board = board;
	}
	
}
