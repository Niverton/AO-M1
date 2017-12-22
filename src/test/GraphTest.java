package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.geometry.Point2D;
import model.Directions;
import model.graph.*;
import model.graph.Edge.Type;

public class GraphTest {
	Graph g;
	Vertex v1,v2,v3,v4,v5,v6;
	Edge e1,e2,e3,e4;
	
    @Before
    public void setUp() throws Exception {
    	g = new Graph();
    	g.addVertex(v1 = new Vertex(1,1,0));
    	g.addVertex(v2 = new Vertex(0,1,1));
    	g.addVertex(v3 = new Vertex(2,1,2));
    	g.addVertex(v4 = new Vertex(1,0,3));
    	g.addVertex(v5 = new Vertex(1,2,4));
    	g.addVertex(v6 = new Vertex(0,2,5));
    	e1 = g.addEdge(v1, v2);
    	e2 = g.addEdge(v1, v3);
    	e3 = g.addEdge(v1, v4);
    	g.addEdge(v1, v5, e4 = new Edge(Edge.Type.OPENED_DOOR));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGraph() {
        
        //exists et getTarget
        assertTrue("Test getTarget 1", g.getTarget(v1, Directions.West).compareTo(v2) == 0); //v2
        assertTrue("Test getTarget 2", g.getTarget(v5, Directions.South) == null); //Rien
        assertTrue("Test exists 1", g.exists(v1, Directions.West)); //v2
        assertFalse("Test exists 2", g.exists(v5, Directions.South)); //Rien
        
        //isConnected et getRefVertex
        Vertex vTest = new Vertex(1, 1, 6); // A la position de v1
        Vertex vTest2 = new Vertex(1, 5, 8); // A aucune position existante
        assertTrue("test getRefVertex 1", g.getRefVertex(vTest).compareTo(v1) == 0);
        assertTrue("test getRefVertex 2", g.getRefVertex(vTest2) == null);
        assertTrue("Test isConnected 1", g.isConnected(v1, Directions.West)); //v2
        assertFalse("Test isConnected 2", g.isConnected(v2, Directions.North)); //v6 mais pas relié
        
        //randomVertex
        assertNotNull("Test randomVertex", g.randomVertex());
        
        //isOpenDoor
        assertTrue("Test isOpenDoor 1", g.isOpenDoor(v1, Directions.South)); //v5 porte
        assertFalse("Test isOpenDoor 2", g.isOpenDoor(v1, Directions.North)); //v4, pas porte
    }
    
    @Test
    public void testEdge() {
    	
    	// getSource et getTarget
    	assertTrue("Test getSource 1", e1.getSource().compareTo(v1) == 0);
        Vertex vTest = new Vertex(1, 1, 6); // A la position de v1
    	assertTrue("Test getSource 2", e1.getSource().compareTo(vTest) == 0);
    	assertTrue("Test getTarget 1", e1.getTarget().compareTo(v2) == 0);
        vTest = new Vertex(0, 1, 6); // A la position de v2
    	assertTrue("Test getTarget 2", e1.getTarget().compareTo(vTest) == 0);
    	
    	// getType et setType
    	assertTrue("Test getType 1", e1.getType() == Type.CORRIDOR);
    	assertTrue("Test getType 2", e4.getType() == Type.OPENED_DOOR);
    	assertFalse("Test getType 3", e4.getType() == Type.CLOSE_DOOR);
    	e1.setType(Type.CLOSE_DOOR);
    	assertTrue("Test getType 4", e1.getType() == Type.CLOSE_DOOR);
    	
    	// compareTo
    	assertTrue("Test compareTo 1", e1.compareTo(e1) == 0);
    	assertTrue("Test compareTo 2", e4.compareTo(e4) == 0);
    	assertFalse("Test compareTo 3", e1.compareTo(e2) == 0);
    }
    
    @Test
    public void testVertex() {
    	// inBorders
    	assertTrue("Test inBorders 1", v1.inBorders(0, 3, Directions.West));
    	assertTrue("Test inBorders 2", v1.inBorders(0, 3, Directions.North));
    	assertTrue("Test inBorders 3", v1.inBorders(0, 3, Directions.East));
    	assertTrue("Test inBorders 4", v1.inBorders(0, 3, Directions.South));
    	assertFalse("Test inBorders 5", v2.inBorders(0, 3, Directions.West));
    	assertFalse("Test inBorders 6", v3.inBorders(0, 3, Directions.East));
    	assertFalse("Test inBorders 7", v4.inBorders(0, 3, Directions.North));
    	assertFalse("Test inBorders 8", v5.inBorders(0, 3, Directions.South));
    	
    	// getX, getY, getPosition
    	assertTrue("Test getX 1", v1.getX() == 1);
    	assertTrue("Test getX 2", v2.getX() == 0);
    	assertFalse("Test getX 2", v2.getX() == 3);
    	
    	assertTrue("Test getY 1", v1.getY() == 1);
    	assertTrue("Test getY 2", v4.getY() == 0);
    	assertFalse("Test getY 1", v1.getY() == 3);
    	
    	assertTrue("Test getPosition 1", v1.getPosition().equals(new Point2D(1,1)));
    	assertTrue("Test getPosition 2", v4.getPosition().equals(new Point2D(1,0)));
    	assertFalse("Test getPosition 1", v1.getPosition().equals(new Point2D(3,3)));
    	
    	// getNbr et setNbr
    	assertTrue("Test getNbr 1", v1.getNbr() == 0);
    	assertTrue("Test getNbr 2", v4.getNbr() == 3);
    	assertFalse("Test getNbr 3", v1.getNbr() == 3);
    	v1.setNbr(3);
    	assertTrue("Test setNbr 1", v1.getNbr() == 3);
    	
    	// equals et compareTo
    	Vertex vTest = new Vertex(1, 1, 7);
    	assertTrue("Test equals 1", v1.equals(v1));
    	assertTrue("Test equals 2", v1.equals(vTest));
    	assertFalse("Test equals 3", v4.equals(vTest));
    	assertTrue("Test compareTo 1", v1.compareTo(v1) == 0);
    	assertTrue("Test compareTo 2", v1.compareTo(vTest) == 0);
    	assertFalse("Test compareTo 3", v4.compareTo(vTest) == 0);
    }
}
