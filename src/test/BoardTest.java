package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.jgrapht.graph.AsUndirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import model.Board;
import model.Point2D;
/**
 * 
 * @author laurent
 *
 */
public class BoardTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * Test du plateau de jeux. 
	 */
	public void test() {
		Board b =  new Board();
		Point2D[][] tab = b.getAllPosition();
		 Multigraph<Point2D,DefaultWeightedEdge> g = b.getCorridor();
		 // on verifie que toute les case sont presentent dans le graph. 
		 for(int i=0 ; i < tab.length ; i++){
			 for(int j=0 ; j< tab.length ; j++){
				 assertTrue("ne contien pas "+tab[i][j],g.containsVertex(tab[i][j]));
			 }
		 }
		 
		 // Pas besoin de tester si il existe un chemin car quand on ajoute un sommet on y ajoute une arrête vers le précédent sommet.( appel reccursif)
		 // Si tous les sommets sont présent c'est qu'ils sont connecter avec un autre sommet.
		 
		 // On verrifie si le graph door et corridor sont complémentaire.
		 BreadthFirstIterator iterCor = new BreadthFirstIterator<>(g); 
		 Multigraph<Point2D,DefaultWeightedEdge> door = b.getDoor();
		 while(iterCor.hasNext()){
			 Point2D  p = (Point2D) iterCor.next();
			 Set<DefaultWeightedEdge> df = g.edgesOf(p);
			 for(DefaultWeightedEdge e : df){
				 assertFalse(door.containsEdge(e));
			 }
		 }
	}

}
