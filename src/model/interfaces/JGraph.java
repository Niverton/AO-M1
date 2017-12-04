package model.interfaces;

import model.Directions;
import model.graph.Vertex;

public interface JGraph {
	public boolean doesntExist(Vertex vertex , Directions  dir);
	public boolean isConnected(Vertex vertex , Directions  dir);
	public Vertex getTarget(Vertex vertex , Directions  dir);
	public Vertex getRefVertex(Vertex vertex);
	public Vertex randomVertex();
	public boolean isOpenDoor(Vertex vertex , Directions dir);
	
}
