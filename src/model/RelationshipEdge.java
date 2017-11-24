package model;

import org.jgrapht.graph.DefaultEdge;

public class RelationshipEdge<point2D> extends DefaultEdge {


	private Point2D source; 
	private Point2D destination; 
	private Boolean open;

	/**
	 * 
	 * @param v1 la source de l'arrête
	 * @param v2 la destination de l'arrête 
	 * @param open marquage de l'arrête avec booleén. deux état possible pour l'arrête
	 */
	public RelationshipEdge(Point2D v1, Point2D v2, Boolean open) {
		this.source = v1;
		this.destination = v2;
		this.open = open;
	}
	/**
	 * @return la source de l'arrête
	 */
	public Point2D getSource() {
		return this.source;
	}
	/**
	 * @return la destination de l'arrète
	 * @return la poition de la destination
	 */
	public Point2D getDestination() {
		return this.destination;
	}
	/**
	 * 
	 * @return l'état de l'arrête.
	 */
	public Boolean isOpen(){
		return this.open;
	}
	/**
	 * 
	 * @param b le ouvelle état de l'arrête
	 */
	public void setOpen(Boolean b){
		this.open = b;
	}
	/**
	 * Affiche les informations lié a notre arrête.
	 */
	public String toString() {
		return this.source.toString() + "=> "+ this.getDestination().toString() + " isOpen ?" + this.open;
	}
}
