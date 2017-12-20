package model.graph;

import javafx.geometry.Point2D;
import model.Directions;

/**
 * Sommet du graphe.
 */
public class Vertex implements Comparable<Vertex> {
    private int x;
    private int y;
    private int nbr;

    /**
     * @param x
     *            position x
     * @param y
     *            position y
     */
    public Vertex(int x, int y, int nbr) {
        this.x = x;
        this.y = y;
        this.nbr = nbr;
    }

    /**
     * @param min
     *            position minimum
     * @param max
     *            position maximum
     * @param dir
     *            la direction a tester
     * @return si le sommet est bien entre min et max selon la direction donnee.
     */
    public boolean inBorders(int min, int max, Directions dir) {
        switch (dir) {
            case North:
                return this.getY() > min;
            case West:
                return this.getX() > min;
            case South:
                return this.getY() < max - 1;
            case East:
                return this.getX() < max - 1;

        }
        return false;
    }

    /**
     * @return la position x
     */
    public int getX() {
        return x;
    }

    /**
     * @return la position y
     */
    public int getY() {
        return y;
    }

    public Point2D getPosition() {
        return new Point2D(x, y);
    }

    /**
     * @return
     */
    public int getNbr() {
        return this.nbr;
    }

    @Override
    public String toString() {
        return "Vertex (" + x + "; " + y + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vertex)) return false;
        Vertex o = (Vertex) other;
        return (x == o.x) && (y == o.y);
    }
    
    @Override
    public int compareTo(Vertex other) {
        int dx = x - other.x;
        if (dx != 0) return dx;
        return y - other.y;
    }

    public void setNbr(int i) {
        this.nbr = i;
    }
}
