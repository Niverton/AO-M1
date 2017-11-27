package model.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.traverse.BreadthFirstIterator;



public class Graph implements org.jgrapht.Graph<Vertex, Edge> {
	private Multigraph<Vertex,Edge> graph ;
	public enum Directions{
		NORTH, 
		SOUTH, 
		WEST, 
		EAST
	}
	
	public Graph(){
		graph = new Multigraph<>(Edge.class);
	}
	/**
	 * 
	 * @param vertex le sommet source 
	 * @param dir la direction du sommet cible 
	 * @return Retourne vrai si le sommet cible exsist
	 */
	public boolean doesntExist(Vertex vertex , model.Labyrinth.Directions  dir){

		
		if(getTarget(vertex, dir) != null){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param vertex sommet cource 
	 * @param dir direction pour trouver le sommet cible.
	 * @return vrai si le sommet source et le sommet cible sont connectés. 
	 */
	public boolean isConnected(Vertex vertex , model.Labyrinth.Directions  dir){
		Vertex target = this.getTarget(vertex, dir);
		
		return graph.containsEdge(vertex, target) || graph.containsEdge(target, vertex);
	}
	/**
	 * 
	 * @param vertex sommet source 
	 * @param dir direction ou trover le sommet destination 
	 * @return le sommet cible.
	 */
	public Vertex getTarget(Vertex vertex , model.Labyrinth.Directions  dir){
		Vertex target= null;
		switch (dir){
		case NORTH: target = new Vertex(vertex.getX(), vertex.getY()-1, 0);  
		break; 
		case SOUTH:  target = new Vertex(vertex.getX(), vertex.getY()+1, 0); 
		break; 
		case EAST:  target = new Vertex(vertex.getX()+1, vertex.getY(), 0); 
		break; 
		case WEST:  target = new Vertex(vertex.getX()-1, vertex.getY(), 0); 
		break;

		}
		return  this.getRefVertex(target);
	}

	/**
	 * 
	 * @param vertex sommmet créé
	 * @return le sommet qui correspont au sommet d graph. 
	 */
	public Vertex getRefVertex(Vertex vertex){
		BreadthFirstIterator<Vertex,Edge> iter = new BreadthFirstIterator<Vertex, Edge>(graph); 
		while(iter.hasNext()){
			Vertex v = iter.next();
			if(v.compareTo(vertex) ==0){
				return v;
			}
		}
		return null;
	}
	public Vertex randomVertex(){
	Set<Vertex> list =   graph.vertexSet();
		Random r = new Random(); 
		int t = r.nextInt(list.size()); 
		Iterator<Vertex> t1 = list.iterator();
		Vertex vertex = t1.next();
		for(int i =1; i< t ; ++i)
			vertex = t1.next();
		return vertex;
	}
	public boolean isOpenDoor(Vertex vertex , model.Labyrinth.Directions dir){
		Vertex target = this.getTarget(vertex, dir); 
		Edge e = this.getEdge(vertex, target); 
		return (e != null &&( e.getType() == Edge.Type.OPENED_DOOR));
	}
	@Override
	public Edge addEdge(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return graph.addEdge(arg0, arg1);
	}

	@Override
	public boolean addEdge(Vertex arg0, Vertex arg1, Edge arg2) {
		// TODO Auto-generated method stub
		return graph.addEdge(arg0, arg1, arg2);
	
	}

	@Override
	public boolean addVertex(Vertex arg0) {
		// TODO Auto-generated method stub
		return graph.addVertex(arg0);
		
	}

	@Override
	public boolean containsEdge(Edge arg0) {
		// TODO Auto-generated method stub
		return graph.containsEdge(arg0);
	}

	@Override
	public boolean containsEdge(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return graph.containsEdge(arg0, arg1);
	}

	@Override
	public boolean containsVertex(Vertex arg0) {
		// TODO Auto-generated method stub
		return graph.containsVertex(arg0);
	}

	@Override
	public Set<Edge> edgeSet() {
		// TODO Auto-generated method stub
		return graph.edgeSet();
	}

	@Override
	public Set<Edge> edgesOf(Vertex arg0) {
		// TODO Auto-generated method stub
		return graph.edgesOf(arg0);
	}

	@Override
	public Set<Edge> getAllEdges(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return graph.getAllEdges(arg0, arg1);
	}

	@Override
	public Edge getEdge(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return graph.getEdge(arg0, arg1);
	}

	@Override
	public EdgeFactory<Vertex, Edge> getEdgeFactory() {
		// TODO Auto-generated method stub
		return graph.getEdgeFactory();
	}

	@Override
	public Vertex getEdgeSource(Edge arg0) {
		// TODO Auto-generated method stub
		return graph.getEdgeSource(arg0);
	}

	@Override
	public Vertex getEdgeTarget(Edge arg0) {
		// TODO Auto-generated method stub
		return graph.getEdgeTarget(arg0);
	}

	@Override
	public double getEdgeWeight(Edge arg0) {
		// TODO Auto-generated method stub
		return graph.getEdgeWeight(arg0);
	}

	@Override
	public boolean removeAllEdges(Collection<? extends Edge> arg0) {
		// TODO Auto-generated method stub
		return graph.removeAllEdges(arg0);
	}

	@Override
	public Set<Edge> removeAllEdges(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return graph.removeAllEdges(arg0, arg1);
	}

	@Override
	public boolean removeAllVertices(Collection<? extends Vertex> arg0) {
		// TODO Auto-generated method stub
		return graph.removeAllVertices(arg0);
	}

	@Override
	public boolean removeEdge(Edge arg0) {
		// TODO Auto-generated method stub
		return graph.removeEdge(arg0);
	}

	@Override
	public Edge removeEdge(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return graph.removeEdge(arg0, arg1);
	}

	@Override
	public boolean removeVertex(Vertex arg0) {
		// TODO Auto-generated method stub
		return graph.removeVertex(arg0);
	}

	@Override
	public Set<Vertex> vertexSet() {
		// TODO Auto-generated method stub
		return graph.vertexSet();
	}
	

}
