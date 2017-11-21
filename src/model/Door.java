package model;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;

public class Door  extends Object{
	private static Door door; 
	private Door(Board b) {
		super(b);
		// TODO Auto-generated constructor stub
		Multigraph<Point2D,DefaultWeightedEdge> corridor = board.getCorridor();
		
		this.setPosition(new Point2D(board.getSize()-1,board.getSize()-1));
		}
	public static Door getInstance(Board board){
		if(door == null){
			return  new Door(board);
		}
		return door;
	}
	

}
