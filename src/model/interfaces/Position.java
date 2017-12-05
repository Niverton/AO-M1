package model.interfaces;



import javafx.geometry.Point2D;
import model.Directions;

public interface Position {
	public Point2D getPosition(); 
	public int getPosX(); 
	public int getPosY(); 
	public void setPosition(Point2D point) ;
}
