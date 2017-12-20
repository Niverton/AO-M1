package model;

import javafx.geometry.Point2D;
import model.interfaces.IPosition;

/**
 * Un objet du plateau.
 */
public abstract class ObjectGame implements IPosition {
    protected Point2D position;

    protected ObjectGame() {
        position = new Point2D(0, 0);
    }

    /**
     * @param posX
     *            l'abscisse (coordonnée X) initiale du personnage.
     * @param posY
     *            l'ordonnée (coordonnée Y) initiale du personnage.
     */
    protected ObjectGame(int posX, int posY) {
        position = new Point2D(posX, posY);
    }

    /**
     * @return La position de l'objet.
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * @param p
     *            la nouvelle position de l'objet
     */
    public void setPosition(Point2D p) {
        position = p;
    }

    public int getPosX() {
        return (int) this.position.getX();
    }

    public int getPosY() {
        return (int) this.position.getY();
    }

}
