package test;

import static org.junit.Assert.assertTrue;

import org.jgrapht.traverse.BreadthFirstIterator;
import org.junit.Test;

import model.Directions;
import model.Labyrinth;
import model.graph.Edge;
import model.graph.Vertex;

public class LabyrinthTest {

	

	@Test
	public void test() {
		Labyrinth l = new Labyrinth(10);
		/****
		 *  Test  de la taille du labyrithn
		 */
		assertTrue("test size Labyrithn echou�", l.getSize() == 10); 
		
		/****
		 * Test de isOpenDoor.  Et que tout les sommets sont accassible.
		 */
		int nbOpenDoor =0; 
		int nbSommet =0;
		
		BreadthFirstIterator<Vertex, Edge> b = new BreadthFirstIterator<>(l.getLabyrinth());
		while(b.hasNext()){
			nbSommet++;
			Vertex e =  b.next(); 
			Directions direct[] = Directions.values(); 
			for(Directions dir: direct){
			if( l.isOpenDoor(e, dir))
				nbOpenDoor++;
			}
			
				
		}
		// on doit en avoir 20 car on test chaque sommet et une arr�te � 2 sommets.
		assertTrue(" nombre incorrect de porte ouverte", nbOpenDoor == 20);
		// 10*10 sommet  BreadthFirstIterator est un parcours en profondeur 
		//donc cela prouve que notre graph est connexe et q'uil existe un chemin de a � b pour a�V et b�V
		//
		assertTrue(" Manque des sommets dans le graph construit", nbSommet == 100);
		
		
	}

}
