package model.graph;

import org.jgrapht.graph.DefaultEdge;

/**
 * Arrete du graphe.
 */
public class Edge extends DefaultEdge implements Comparable<Edge> {
    /**
     * ID de version de serialisation.
     * Inutile pour notre projet, mais semi-necessaire.
     */
    private static final long serialVersionUID = 7414571495849665788L;

    public enum Type {
        OPENED_DOOR, CLOSE_DOOR, CORRIDOR
    }

    private Type type;

    /**
     * @param type
     *            OPENED_DOOR, CLOSE_DOOR, CORRIDOR
     */
    public Edge(Type type) {
        super();
        this.type = type;
    }

    public Edge() {
        super();
        this.type = Type.CORRIDOR;
    }

    /**
     * @return la source de l'arrete
     */
    public Vertex getSource() {
        return (Vertex) super.getSource();
    }

    /**
     * @return la destination de l'arrete
     */
    public Vertex getTarget() {
        return (Vertex) super.getTarget();
    }

    /**
     * @return le type de l'arrete OPENED_DOOR, CLOSE_DOOR, CORRIDOR
     */
    public Type getType() {
        return this.type;
    }

    /**
     * @param type
     *            {OPENED_DOOR, CLOSE_DOOR, CORRIDOR}
     */
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.getSource().toString() + "=> " + super.getTarget().toString();
    }

    /**
     * @param other
     *            l'arrete a comparer.
     */
    public int compareTo(Edge other) {
        int source = this.getSource().compareTo(other.getSource());
        if (source != 0) {
            return source;
        } else {
            return this.getTarget().compareTo(other.getTarget());
        }

    }
}
