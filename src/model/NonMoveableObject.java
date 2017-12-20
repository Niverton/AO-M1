package model;

/**
 * Objet immobile du plateau.
 */
public class NonMoveableObject extends ObjectGame {
    private String name;

    /**
     * @param name
     *            le nom de l'objet.
     */
    public NonMoveableObject(String name) {
        super();
        this.name = name;
    }

    /**
     * @param name
     *            le nom de l'objet non mobile
     * @param x
     *            l'abscisse de l'objet
     * @param y
     *            l'ordonnee de l'objet
     */
    public NonMoveableObject(String name, int x, int y) {
        super(x, y);
        this.name = name;
    }

    /**
     * @return le nom de l'objet immobile.
     */
    public String getName() {
        return name;
    }

}
