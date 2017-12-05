package model.graph;

import model.Directions;

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
	/**
	 * 
	 * @param min position minimum 
	 * @param max position maximum 
	 * @param dir la direction a tester 
	 * @return si le sommet est bien entre min et max selon la direction donn�e.
	 */
	public boolean inBorders(int min, int max, Directions dir){
		switch (dir){
		case North: return this.getY() > min;
		case West: return this.getX() > min;
		case South: return this.getY() < max-1;
		case East: return this.getX() < max-1;

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
	 * affichage des coordon�es de notre objet Point2D
	 */
	public String toString(){
		return x+ " ->" + y;
	}
	/**
	 * @param arg0 le sommet � comparer.
	 */
	public int compareTo(Vertex arg0) {
		// TODO Auto-generated method stub
		if(this.getX() == arg0.getX() && this.getY() == arg0.getY())
			return 0;

		return 1;
	}

}
