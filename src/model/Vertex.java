package model;

import model.Board.Directions;

/**
 * 
 * @author laurent
 *
 */
public class Vertex   implements Comparable<Vertex>{
	private int x; 
	private int y; 
	private int nbr;
	/**
	 * 
	 * @param x position x
	 * @param y position y
	 */
	public Vertex(int x, int y, int nbr){
		this.x = x; 
		this.y = y; 
		this.nbr = nbr;
		
	}
	public boolean inBorders(int min, int max, Directions dir){
		switch (dir){
		case NORTH: return this.getY() > min;
		case WEST: return this.getX() > min;
		case SOUTH: return this.getY() < max-1;
		case EAST: return this.getX() < max-1;
		
		}
		return false;
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
	public int getNbr(){
		return this.nbr;
	}
	/**
	 * affichage des coordonées de notre objet Point2D
	 */
	public String toString(){
		return x+ " ->" + y;
	}
	public int compareTo(Vertex arg0) {
		// TODO Auto-generated method stub
		if(this.getX() == arg0.getX() && this.getY() == arg0.getY())
		return 0;
		
		return 1;
	}
	
}
