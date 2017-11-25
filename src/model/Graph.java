package model;

import java.util.Collection;
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
	
	public Graph(int size){
		graph = new Multigraph<>(Edge.class);
	}
	public boolean doesntExist(Vertex vertex , model.Board.Directions  dir){

		
		if(getDest(vertex, dir) != null){
			return false;
		}
		return true;
	}
	public boolean isConnected(Vertex vertex , model.Board.Directions  dir){
		Vertex target = this.getDest(vertex, dir);
		
		return graph.containsEdge(vertex, target);
	}
	public Vertex getDest(Vertex vertex , model.Board.Directions  dir){
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
	public Vertex getRefVertex(Vertex vertex){
		BreadthFirstIterator<Vertex,Edge> iter = new BreadthFirstIterator(graph); 
		while(iter.hasNext()){
			Vertex v = iter.next();
			if(v.compareTo(vertex) ==0){
				return v;
			}
		}
		return null;
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
