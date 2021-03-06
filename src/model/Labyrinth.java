package model;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

import org.jgrapht.traverse.BreadthFirstIterator;

import javafx.geometry.Point2D;
import model.graph.Edge;
import model.graph.Edge.Type;
import model.graph.Graph;
import model.graph.Vertex;

/**
 * Le labyrinthe de la partie.
 */
public class Labyrinth {
    private int   size;
    private Graph graph;

    public Labyrinth(int size) {
        this.size = size;
        graph = new Graph();
        Vertex base = new Vertex(0, 0, 0);
        graph.addVertex(base);
        this.buildLabyrinth(base);
        this.openRandomDoor(size);
    }

    /**
     * @param vertex
     *            position de depart du futur joueur
     */
    private void buildLabyrinth(Vertex vertex) {
        Directions direction[] = new Directions[4];
        Vector<Directions> list = new Vector<Directions>();
        list.addAll(Arrays.asList(Directions.values()));
        Random random = new Random();
        for (int i = 0; i < direction.length; ++i) {
            int index = random.nextInt(list.size());
            direction[i] = list.get(index);
            list.remove(index);
        }

        for (Directions dir : direction) {
            if (vertex.inBorders(0, size, dir) && !graph.exists(vertex, dir)) {
                int x = vertex.getX();
                int y = vertex.getY();
                int xt = x, yt = y;
                switch (dir) {
                    case North:
                        yt--;
                    break;
                    case South:
                        yt++;
                    break;
                    case East:
                        xt++;
                    break;
                    case West:
                        xt--;
                    break;
                }
                Vertex next = new Vertex(xt, yt, vertex.getNbr() + 1);
                graph.addVertex(next);
                graph.addEdge(vertex, next, new Edge(Edge.Type.CORRIDOR));
                buildLabyrinth(next);
            }

        }
    }

    /**
     * @param vertex
     *            sommet source
     * @param dir
     *            la direction du target
     * @return si la face dir de vertex est un mur
     */
    public boolean isWall(Vertex vertex, Directions dir) {
        return !graph.isConnected(vertex, dir);
    }

    /**
     * @param vertex
     *            sommet a tester
     * @param dir
     *            la direction a chercher
     * @return s'il s'agit d'un porte ouverte ou fermee.
     */
    public boolean isOpenDoor(Vertex vertex, Directions dir) {
        return graph.isOpenDoor(vertex, dir);
    }

    /**
     * @return le graph contenant les couloirs.
     */
    public Graph getLabyrinth() {
        return graph;
    }

    /**
     * @return la taille de notre labyrinth
     */
    public int getSize() {
        return size;
    }

    /**
     * Ouvre des portes de facon aleatoire.
     */
    public void openRandomDoor(int nb) {
        Directions directions[] = Directions.values();
        for (int j = 0; j < nb; j++) {
            for (int i = 0; i < 1000; ++i) {
                Vertex v = graph.randomVertex();
                if (v != null) {
                    Random random = new Random();

                    Directions dir = directions[random.nextInt(directions.length)];
                    if (this.isWall(v, dir)) {
                        Vertex vertex2 = graph.getTarget(v, dir);
                        if (vertex2 != null) {
                            Edge edge = graph.getEdge(v, vertex2);
                            graph.removeEdge(edge);

                            graph.addEdge(v, vertex2, new Edge(Type.OPENED_DOOR));

                            break;
                        }
                    }

                }
            }

        }
    }

    /**
     * @param source
     *            la cource de l'element a deplacer
     * @param target
     *            la destionation de l'objet a atteindre.
     */
    private void calculateManhattanDistance(Vertex source, Vertex target) {
        Queue<Vertex> fifo = new ArrayDeque<Vertex>();
        target.setNbr(1);
        fifo.add(target);
        while (!fifo.isEmpty()) {
            Vertex actual = fifo.remove();
            for (Directions dir : Directions.values()) {
                if (!this.isWall(actual, dir) && !this.isOpenDoor(actual, dir)) {
                    Vertex next = graph.getTarget(actual, dir);
                    if (next.getNbr() == 0) {
                        next.setNbr(actual.getNbr() + 1);
                        if (next != source)
                            fifo.add(next);
                    }
                }
            }
        }
    }

    /**
     * @param source
     *            source la cource de l'element a deplacer
     * @param target
     *            target la destionation de l'objet a atteindre.
     */
    private void launchManhattan(Vertex source, Vertex target) {
        for (Vertex vertex : graph.vertexSet()) {
            vertex.setNbr(0);
        }
        this.calculateManhattanDistance(source, target);
    }

    public Directions getNextDir(Vertex source, Vertex target) {
        Vertex sourceReal = graph.getRefVertex(source);
        Vertex targetReal = graph.getRefVertex(target);
        this.launchManhattan(sourceReal, targetReal);

        for (Directions dir : Directions.values()) {
        
        	Vertex v = null; 
        	
        		v = graph.getTarget(sourceReal, dir);
        	
            if (v != null && v.getNbr() == sourceReal.getNbr() - 1 && !this.isWall(sourceReal, dir)) {
                return dir;
            }
        }
        return null;
    }

    /**
     * TODO
     * 
     * @param source La position que l'on doit trouver le plus �loign�. 
     * @return la position la plus �loign� de source
     */
    public Point2D getFurther(Vertex source) {
        source = graph.getRefVertex(source);
        this.launchManhattan(source, source);
        BreadthFirstIterator<Vertex, Edge> it = new BreadthFirstIterator<>(this.graph);
        Point2D pos = new Point2D(0, 0);
        int nb = 0;
        while (it.hasNext()) {
            Vertex v = it.next();
            if (nb < v.getNbr()) {
                pos = v.getPosition();
            }
        }
        return pos;
    }

}
