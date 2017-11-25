package model;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;

public class Door  extends Object{
	private static Door door; 
	/**
	 * 
	 * @param b labyrithn
	 */
	private Door(Board b) {
		super(b);
		// TODO Auto-generated constructor stub
		
		
		}
	/**
	 * 
	 * @param board le plateau de jeux. 
	 * @return l'unique instance de la porte. Il n'existe qu'une seul porte dans le jeux d'où le singleton
	 */
	public static Door getInstance(Board board){
		if(door == null){
			return  new Door(board);
		}
		return door;
	}
	

}
