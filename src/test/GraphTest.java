package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Directions;
import model.graph.*;

public class GraphTest {
	Graph g;
	Vertex v1,v2,v3,v4,v5;
	Edge e1,e2,e3,e4;
	
    @Before
    public void setUp() throws Exception {
    	g = new Graph();
    	g.addVertex(v1 = new Vertex(1,1,0));
    	g.addVertex(v2 = new Vertex(0,1,1));
    	g.addVertex(v3 = new Vertex(2,1,2));
    	g.addVertex(v4 = new Vertex(1,0,3));
    	g.addVertex(v5 = new Vertex(1,2,4));
    	e1 = g.addEdge(v1, v2);
    	e2 = g.addEdge(v1, v3);
    	e3 = g.addEdge(v1, v4);
    	e4 = g.addEdge(v1, v5);
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
    }
}
