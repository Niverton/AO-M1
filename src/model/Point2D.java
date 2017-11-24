package model;
/**
 * 
 * @author laurent
 *
 */
public class Point2D {
	private int x; 
	private int y; 
	/**
	 * 
	 * @param x position x
	 * @param y position y
	 */
	public Point2D(int x, int y){
		this.x = x; 
		this.y = y; 
	}
	/**
	 * 
	 * @return la position x
	 */
	public int getX(){
		return x; 
	}
	/**
	 * 
	 * @return la position y 
	 */
	public int  getY(){
		return y; 
	}
	/**
	 * affichage des coordonées de notre objet Point2D
	 */
	public String toString(){
		return x+ " ->" + y;
	}
}
