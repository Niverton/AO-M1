package model;

import org.jgrapht.graph.DefaultEdge;

public class RelationshipEdge<point2D> extends DefaultEdge {


	private Point2D source; 
	private Point2D destination; 
	private Boolean open;

	/**
	 * 
	 * @param v1 la source de l'arr�te
	 * @param v2 la destination de l'arr�te 
	 * @param open marquage de l'arr�te avec boole�n. deux �tat possible pour l'arr�te
	 */
	public RelationshipEdge(Point2D v1, Point2D v2, Boolean open) {
		this.source = v1;
		this.destination = v2;
		this.open = open;
	}
	/**
	 * @return la source de l'arr�te
	 */
	public Point2D getSource() {
		return this.source;
	}
	/**
	 * @return la destination de l'arr�te
	 * @return la poition de la destination
	 */
	public Point2D getDestination() {
		return this.destination;
	}
	/**
	 * 
	 * @return l'�tat de l'arr�te.
	 */
	public Boolean isOpen(){
		return this.open;
	}
	/**
	 * 
	 * @param b le ouvelle �tat de l'arr�te
	 */
	public void setOpen(Boolean b){
		this.open = b;
	}
	/**
	 * Affiche les informations li� a notre arr�te.
	 */
	public String toString() {
		return this.source.toString() + "=> "+ this.getDestination().toString() + " isOpen ?" + this.open;
	}
}
