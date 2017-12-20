package model;

import javafx.geometry.Point2D;

/**
 * La porte de sortie du jeu.
 */
public class Door extends NonMoveableObject {
    public Door(String porte, Point2D p) {
        super(porte, (int) p.getX(), (int) p.getY());
    }

    public Door(String porte, int x, int y) {
        super(porte, x, y);
    }

    public Door(String string) {
        super(string);
    }

}
