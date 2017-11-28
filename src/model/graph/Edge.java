package model.graph;

import org.jgrapht.graph.DefaultEdge;


@SuppressWarnings("serial")
public class Edge extends DefaultEdge implements Comparable<Edge> {

	/**
	 * 
	 * @author laurent
	 *
	 */
	public enum Type{
		OPENED_DOOR, 
		CLOSE_DOOR, 
		CORRIDOR
	}
	private Type type;



	/**
	 * 
	 * @param type OPENED_DOOR, CLOSE_DOOR, CORRIDOR
	 */
	public Edge(Type type){
		super(); 
		this.type = type;
	}
	/**
	 * Defalut constructor
	 */
	public Edge(){
		super(); 
		this.type = Type.CORRIDOR;
	}

	/**
	 * @return la source de l'arrête
	 */
	public Vertex getSource() {
		return (Vertex) super.getSource();
	}
	/**
	 * @return la destination de l'arrète
	 * @return la poition de la destination
	 */
	public Vertex getTarget() {
		return (Vertex) super.getTarget();
	}
	/**
	 * 
	 * @return le type de l'arrête OPENED_DOOR, CLOSE_DOOR, CORRIDOR
	 */
	public Type getType(){
		return this.type;
	}
	/**
	 * 
	 * @param type {OPENED_DOOR, CLOSE_DOOR, CORRIDOR}
	 */
	public void setType(Type type){
		this.type = type;
	}


	/**
	 * Affiche les informations lié a notre arrête.
	 */
	public String toString() {
		return super.getSource().toString() + "=> "+ super.getTarget().toString();
	}

	/**
	 * @param arg0 l'arrête a comparer.
	 */
	public int compareTo(Edge arg0) {
		// TODO Auto-generated method stub
		int source = this.getSource().compareTo(arg0.getSource());
		if(source !=0){
			return source;
		}else{
			return this.getTarget().compareTo(arg0.getTarget());
		}

	}
}
