package model;

import javafx.geometry.Point2D;

public class Door extends NonMoveableObject {

	public Door(String porte, Point2D p) {
		super(porte, (int)p.getX(),(int) p.getY());
		
	}
	public Door(String porte,int x, int y) {
		super(porte, x,y);
	}
	/*public static Door getInstance(java.lang.Object board) {
		// TODO Auto-generated method stub
		return null;
	}*/
	public Door(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

}