package model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author laurent
 *
 */
public class BadBoys {
	private ArrayList<BadBoy> lBadBoys; 
	private Board board; 
	/**
	 * 
	 * @param number le nombre de méchants initial.
	 */
	public BadBoys(int number, Board board){
		lBadBoys = new ArrayList<>(number);
		this.board = board;
	}
	/**
	 * 
	 * @param bad le mechant a suprimer.
	 */
	public void removeBadBoy(BadBoy bad ){
		lBadBoys.remove(bad);
	}
	/**
	 * 
	 * @param many nombre de mechant a supprimer
	 */
	public void removeBadBoys(int many){
		for(int i=0 ; i< many ; i++){
			this.lBadBoys.remove(0);
		}
	}
	/**
	 * 
	 * @param many le nombre de mechant a ajouter 
	 * @param pos la position a laquelle ils seront ajoutés.
	 */
	public void addBadBoy(int many, Point2D pos){
		for(int i=0 ; i< many ; i++){
			BadBoy b = new BadBoy(board);
			//b.setPosition(pos);
			this.lBadBoys.add(b);
		}
		
	}
	/**
	 * 
	 * @param p liste de positions des mechants a l'état initial. 
	 */
	public void setAllInitialPos(List<Point2D> p ){
		assert(  (p.size() != this.getNumber())) : "probleme set all position liste non conforme";
		int i =0;
		for(Point2D pos : p){
			//this.lBadBoys.get(i).setPosition(pos);
		}
	}
	/**
	 * 
	 * @return le nombre de méchants.
	 */
	private int getNumber() {
		// TODO Auto-generated method stub
		return this.lBadBoys.size();
	}
	/**
	 * 
	 * @return la liste des méchants.
	 */
	public ArrayList<BadBoy> getList(){
		return this.lBadBoys;
	}
}
