package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;

import model.graph.Edge;
import model.graph.Graph;
import model.graph.Vertex;
/**
 * 
 * @author laurent
 *
 */

public class Labyrinth {
	/**
	 *  class singleton: il n'exista qu'un seul plateau de jeu. 
	 */

	public int size; 
	public enum Directions{
		NORTH, 
		SOUTH, 
		WEST, 
		EAST
		
	}
	private Graph graph ; 



	/**
	 * Instancie le labirynthe et les portes 
	 */
	public Labyrinth(){
		size = 16;
		graph = new Graph();
		Vertex base = new Vertex(0,0,0);
		graph.addVertex(base);
		this.BuildLabyrinth(base);

	}
	/**
	 * 
	 * @param vertex position de d�part du futur joueur 
	 * construction du labirynthe 
	 */
	private void BuildLabyrinth(Vertex vertex){
		
		Directions direction[] = new Directions[4]; 
		Vector<Directions> list = new Vector<Directions >( );
		for ( int i = 0 ; i < direction.length ; ++i )
			list.add( Directions.values( ) [ i ] ) ;
		Random random = new Random();
		for(int i=0; i< direction.length; ++i){
			int index = random.nextInt(list.size());
			direction[i] = list.get(index); 
			list.remove(index); 

		}
		System.out.println("\n\n");
		for(int i=0 ; i < direction.length ; i++){
			Directions dir = direction[i];
			if(vertex.inBorders(0, size, dir) && graph.doesntExist(vertex, dir) ){
				int x = vertex.getX(); 
				int y = vertex.getY();
				int xt =x, yt= y; 
				switch (dir){
				case NORTH: yt --; break; 
				case SOUTH: yt++; break; 
				case EAST: xt++; break; 
				case WEST: xt--; break;
				}
				Vertex next = new Vertex(xt, yt, vertex.getNbr()+1);
				graph.addVertex(next);
				graph.addEdge(vertex, next, new Edge(Edge.Type.CORRIDOR));
				BuildLabyrinth(next);
			}

		}
	}
	/**
	 * 
	 * @param vertex sommet source 
	 * @param dir la direction du target 
	 * @return si le sommet de le sommet source et le sommet target ont un mur entre eux.
	 */
	public boolean isWall(Vertex vertex, Directions dir){
		
		return !graph.isConnected(vertex, dir); 
	}

	
	/**
	 * 
	 * @return le graph contenant les couloirs. 
	 */
	public Graph getLabyrinth(){
		return graph; 
	}
	/**
	 * 
	 * @return la taille de notre labyrinth
	 */
	public int getSize(){
		return size;
	}
	/**
	 * Ouvre des portes de fa�on al�atoire.
	 */
	public void openRandomDoor(){

	}


}