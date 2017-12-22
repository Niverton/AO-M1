package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Directions;
import model.graph.*;

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
    	g.addEdge(v1, v5, new Edge(Edge.Type.OPENED_DOOR));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        /*public boolean exists(Vertex vertex, Directions dir);

    	public boolean isConnected(Vertex vertex, Directions dir);

    	public Vertex getTarget(Vertex vertex, Directions dir);

    	public Vertex getRefVertex(Vertex vertex);

    	public Vertex randomVertex();

    	public boolean isOpenDoor(Vertex vertex, Directions dir);*/
        
        //Exists et gettarget
        assertTrue(g.exists(v1, Directions.West)); //v2
        assertFalse(g.exists(v5, Directions.North)); //Rien
        
        //isConnected et getrefvertex
        assertTrue(g.isConnected(v1, Directions.West)); //v2
        assertFalse(g.isConnected(v2, Directions.North)); //v6 mais pas relié
        
        //randomVertex
        assertNotNull(g.randomVertex());
        
        //isOpenDoor
        assertFalse(g.isOpenDoor(v1, Directions.South));
        assertTrue(g.isOpenDoor(v1, Directions.North)); //v5 porte
    }
}
