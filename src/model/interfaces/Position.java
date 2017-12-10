package model.interfaces;



import javafx.geometry.Point2D;

public interface Position {
	public Point2D getPosition(); 
	public int getPosX(); 
	public int getPosY(); 
	public void setPosition(Point2D point) ;
}
