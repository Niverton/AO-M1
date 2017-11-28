package model;

import java.util.Random;
import java.util.Vector;

import model.directions.Directions;
import model.directions.East;
import model.directions.North;
import model.directions.South;
import model.directions.West;
import model.graph.Edge;
import model.graph.Edge.Type;
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
		this.openRandomDoor(16);

	}
	/**
	 * 
	 * @param vertex position de dï¿½part du futur joueur 
	 * construction du labirynthe 
	 */
	private void BuildLabyrinth(Vertex vertex){

		Directions direction[] = new Directions[4]; 
		Vector<Directions> list = new Vector<Directions >( );
		list.add(new North());
		list.add(new East());
		list.add(new South());
		list.add(new West());
		Random random = new Random();
		for(int i=0; i< direction.length; ++i){
			int index = random.nextInt(list.size());
			direction[i] = list.get(index); 
			list.remove(index); 

		}

		for(int i=0 ; i < direction.length ; i++){
			Directions dir = direction[i];
			if(vertex.inBorders(0, size, dir) && graph.doesntExist(vertex, dir) ){
				int x = vertex.getX(); 
				int y = vertex.getY();
				int xt =x, yt= y; 
				switch (dir.getName()){
				case "NORTH": yt --; break; 
				case "SOUTH": yt++; break; 
				case "EAST": xt++; break; 
				case "WEST": xt--; break;
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

		return   (vertex.inBorders(0, size, dir)) && !graph.isConnected(vertex, dir) ; 
	}
	public boolean isOpenDoor(Vertex vertex, Directions dir){
		return graph.isOpenDoor(vertex, dir);
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
	 * Ouvre des portes de façon aléatoire.
	 */
	public void openRandomDoor(int nb){
		Directions directions[] = new Directions[4]; 
		directions[0] = new East(); 
		directions[1] = new North(); 
		directions[2] = new South(); 
		directions[3] = new West();
		for(int j=0 ; j< nb ; j++){
			for(int i=0; i< 1000 ; ++i){
				Vertex v = graph.randomVertex();
				if(v != null){
					Random random = new Random();
					
					Directions dir  = directions[random.nextInt(directions.length)];
					if( this.isWall(v, dir)){
						Vertex vertex2 = graph.getTarget(v, dir);
						if(vertex2 != null){
							Edge edge = graph.getEdge ( v , vertex2 ) ;
							if(edge == null){
								graph.addEdge(v, vertex2, new Edge(Type.OPENED_DOOR));

								break; 
							}
						}
					}

				}
			}

		}
	}


}
