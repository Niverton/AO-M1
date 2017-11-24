package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;
/**
 * 
 * @author laurent
 *
 */

public class Board {
	/**
	 *  class singleton: il n'exista qu'un seul plateau de jeu. 
	 */
	
	public int size; 
	private static int NORTH =1; 
	private static int SOUTH =2; 
	private static int WEST = 3; 
	private static int EAST = 4; 
	private Multigraph<Point2D,DefaultWeightedEdge> corridor ; 
	private Multigraph<Point2D,RelationshipEdge<Point2D>> door ;
	private Point2D tab[][];
	
	/**
	 * Instancie le labirynthe et les portes 
	 */
	public Board(){
		size = 16;
		corridor = new Multigraph<>(DefaultWeightedEdge.class); 
		door = new Multigraph<>(RelationshipEdge.class); 
		corridor.addVertex(new Point2D(1,1)); 
		tab = new Point2D[size][size];
		for(int i =0 ; i < size ; i++){
			for( int j =0 ; j< size ; j++)
				tab[i][j] = new Point2D(i,j);
		}
		corridor.addVertex(tab[0][0]); 
		this.BuildLabyrinth(tab[0][0]);
		this.contructDoor();
	}
	/**
	 * 
	 * @param v position de d�part du futur joueur 
	 * construction du labirynthe 
	 */
	private void BuildLabyrinth(Point2D v){
		Random r = new Random(); 
		int c[] = new int[4]; 
		ArrayList<Integer> val = new ArrayList<Integer>();
		val.add(NORTH); 
		val.add(SOUTH); 
		val.add(EAST);
		val.add(WEST);
		int index =   r.nextInt(val.size());
		c[0] = val.get(index);
		val.remove(val.get(index));
		index =  r.nextInt(val.size());
		c[1] =  val.get(index);
		val.remove(val.get(index));
		index =  r.nextInt(val.size());
		c[2] =  val.get(index);
		val.remove(val.get(index));
		c[3] =  val.get(0);
		
		for(int i=0 ; i <4 ; i++){
			if(c[i] == NORTH){
				if( (v.getY()) >0 ){
					Point2D v_prim = tab[v.getX()][v.getY()-1];
					if( !corridor.containsVertex(v_prim)){
						corridor.addVertex(v_prim); 
						corridor.addEdge(v, v_prim); 
						this.BuildLabyrinth(v_prim);
					}
				}
			}
			if(c[i] == EAST){
				if( (v.getX()) < size-1  ){
					Point2D v_prim = tab[v.getX()+1][v.getY()];
					if( !corridor.containsVertex(v_prim)){
						corridor.addVertex(v_prim); 
						corridor.addEdge(v, v_prim); 
						this.BuildLabyrinth(v_prim);
					}
				}
			}
			if(c[i] == SOUTH){
				if( (v.getY()) < size -1  ){
					Point2D v_prim = tab[v.getX()][v.getY()+1];
					if( !corridor.containsVertex(v_prim)){
						corridor.addVertex(v_prim); 
						corridor.addEdge(v, v_prim); 
						this.BuildLabyrinth(v_prim);
					}
				}
			}
			if(c[i] == WEST){
				if( (v.getX()) >0){
					Point2D v_prim = tab[v.getX()-1][v.getY()];
					if(!corridor.containsVertex(v_prim)){
						corridor.addVertex(v_prim); 
						corridor.addEdge(v, v_prim); 
						this.BuildLabyrinth(v_prim);
					}

				}
			}
		}


	}
	/**
	 * Construction du graph des portes. ATTENTION instancier le labirythn avant. 
	 */
	private void contructDoor(){
		if(corridor != null)
		for(int i=0; i< size ; i++){
			for(int j =0; j< size ; ++j){
				Point2D v = tab[i][j];
				// if NORTH
				if( (v.getY()) >0){
					Point2D target = tab[i][j-1]; 
					if(corridor.getEdge(v, target) == null){
						door.addVertex(v); 
						door.addVertex(target);
						 door.addEdge(v, target, new RelationshipEdge<Point2D>(v,target,false));
					}
				}
				// if WEST
				if( (v.getX()) >0){
					Point2D target = tab[i-1][j]; 
					if(corridor.getEdge(v, target) == null){
						door.addVertex(v); 
						door.addVertex(target);
						 door.addEdge(v, target, new RelationshipEdge<Point2D>(v,target,false));
					}
				}
				// if SOUTH
				if( (v.getY()) < size-1){
					Point2D target = tab[i][j+1]; 
					if(corridor.getEdge(v, target) == null){
						door.addVertex(v); 
						door.addVertex(target);
						door.addEdge(v, target, new RelationshipEdge<Point2D>(v,target,false));
					}
				}
				// if EAST
				if( (v.getX()) < size -1){
					Point2D target = tab[i+1][j]; 
					if(corridor.getEdge(v, target) == null){
						door.addVertex(v); 
						door.addVertex(target);
						 door.addEdge(v, target, new RelationshipEdge<Point2D>(v,target,false));
					}
				}
			}

		}
	}
/**
 * 
 * @return return le tableau de des r�f�rences des positions 
 */
	public Point2D[][] getAllPosition(){
		return tab;
	}
	/**
	 * 
	 * @return le graph contenant les couloirs. 
	 */
	public Multigraph<Point2D,DefaultWeightedEdge> getCorridor(){
		return corridor; 
	}
	/**
	 * 
	 * @return la taille de notre labyrinth
	 */
	public int getSize(){
		return size;
	}
	/**
	 * 
	 * @return Le graph des portes. 
	 */
	public Multigraph<Point2D, RelationshipEdge<Point2D>> getDoor() {
		// TODO Auto-generated method stub
		return door;
	}
	public boolean isOpenDoor(Point2D source, Point2D destination){
		
		if(this.door.containsEdge(source, destination)){
			RelationshipEdge<Point2D> edge = this.door.getEdge(source, destination);
			
			return edge.isOpen();
		}else{
			
			return true;
		}
	}
	
}
