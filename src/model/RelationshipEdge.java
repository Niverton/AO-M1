package model;

import org.jgrapht.graph.DefaultEdge;

public class RelationshipEdge<point2D> extends DefaultEdge {


	private Point2D source; 
	private Point2D destination; 
	private Boolean open;

	public RelationshipEdge(Point2D v1, Point2D v2, Boolean open) {
		this.source = v1;
		this.destination = v2;
		this.open = open;
	}

	public Point2D getSource() {
		return this.source;
	}

	public Point2D getDestination() {
		return this.destination;
	}
	public Boolean isOpen(){
		return this.open;
	}
	public void setOpen(Boolean b){
		this.open = b;
	}
	
	public String toString() {
		return this.source.toString() + "=> "+ this.getDestination().toString() + " isOpen ?" + this.open;
	}
}
