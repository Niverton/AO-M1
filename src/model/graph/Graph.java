package model.graph;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import model.Directions;
import model.interfaces.JGraph;

public class Graph extends SimpleGraph<Vertex, Edge> implements JGraph {
    /**
     * Voir model.graph.EdgeserialVersionUID
     */
    private static final long serialVersionUID = 5248255303355820387L;

    public Graph() {
        super(Edge.class);
    }

    /**
     * @param vertex
     *            le sommet source.
     * @param dir
     *            la direction du sommet cible
     * @return Retourne vrai si le sommet cible existe
     */
    public boolean exists(Vertex vertex, Directions dir) {
        return getTarget(vertex, dir) != null;
    }

    /**
     * @param vertex
     *            sommet cource
     * @param dir
     *            direction pour trouver le sommet cible.
     * @return vrai si le sommet source et le sommet cible sont connectes.
     */
    public boolean isConnected(Vertex vertex, Directions dir) {
        Vertex target = this.getTarget(vertex, dir);
        Vertex sourceRef = this.getRefVertex(vertex);
        return this.containsEdge(sourceRef, target) || this.containsEdge(target, sourceRef);
    }

    /**
     * @param vertex
     *            sommet source
     * @param dir
     *            direction ou trouver le sommet destination
     * @return le sommet cible.
     */
    public Vertex getTarget(Vertex vertex, Directions dir) {
        Vertex target = null;
        switch (dir) {
            case North:
                target = new Vertex(vertex.getX(), vertex.getY() - 1, 0);
            break;
            case South:
                target = new Vertex(vertex.getX(), vertex.getY() + 1, 0);
            break;
            case East:
                target = new Vertex(vertex.getX() + 1, vertex.getY(), 0);
            break;
            case West:
                target = new Vertex(vertex.getX() - 1, vertex.getY(), 0);
            break;
        }
        return this.getRefVertex(target);
    }

    /**
     * Trouve le sommet correspondant dans le graphe
     * @param vertex le sommet a trouver
     * @return le sommet trouve ou null
     */
    public Vertex getRefVertex(Vertex vertex) {
        BreadthFirstIterator<Vertex, Edge> iter = new BreadthFirstIterator<>(this);
        while (iter.hasNext()) {
            Vertex v = iter.next();
            if (v.compareTo(vertex) == 0) {
                return v;
            }
        }
        return null;
    }

    /**
     * @return un sommet du graphe tiré au hasard.
     */
    public Vertex randomVertex() {
        Set<Vertex> list = this.vertexSet();
        Random r = new Random();
        int t = r.nextInt(list.size());
        Iterator<Vertex> t1 = list.iterator();
        Vertex vertex = t1.next();
        for (int i = 1; i < t; ++i)
            vertex = t1.next();
        return vertex;
    }

    /**
     * @return si la face dir du sommet vertex est une porte ouverte.
     */
    public boolean isOpenDoor(Vertex vertex, Directions dir) {
        Vertex source = this.getRefVertex(vertex);
        Vertex target = this.getTarget(source, dir);
        Edge e1 = this.getEdge(source, target);
        return (e1 != null && (e1.getType() == Edge.Type.OPENED_DOOR));
    }

}
