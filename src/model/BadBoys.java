package model;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

/**
 * Liste des méchants du jeu.
 */
public class BadBoys {
    private List<BadBoy> lBadBoys;

    /**
     * @param number
     *            le nombre de mechants initial.
     */
    public BadBoys(int number) {
        lBadBoys = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            lBadBoys.add(new BadBoy());
        }
    }

    public BadBoys() {
        lBadBoys = new ArrayList<>();
        this.lBadBoys.add(new BadBoy(5, 5));
    }

    /**
     * @param bad
     *            le mechant a supprimer.
     */
    public void removeBadBoy(BadBoy bad) {
        lBadBoys.remove(bad);
    }

    /**
     * @param many
     *            nombre de mechants a supprimer
     */
    public void removeBadBoys(int many) {
        for (int i = 0; i < many; i++) {
            this.lBadBoys.remove(0);
        }
    }

    /**
     * @param pos
     *            la position a laquelle ils seront ajoutes.
     */
    public void addBadBoy(Point2D pos) {
        BadBoy b = new BadBoy();
        b.setPosition(pos);
        this.lBadBoys.add(b);
    }

    /**
     * @param p
     *            liste de positions des mechants a l'etat initial.
     */
    public void setAllInitialPos(List<Point2D> p) {
        if (p.size() != this.getNumber())
            return; // probleme set all position : liste non conforme
        // On ne retourne pas d'Exception : Le programmeur fait ce qu'il veut.

        int i = 0;
        for (Point2D pos : p) {
            this.lBadBoys.get(i++).setPosition(pos);
        }
    }

    /**
     * @return le nombre de mechants.
     */
    public int getNumber() {
        return this.lBadBoys.size();
    }

    /**
     * @return la liste des mechants.
     */
    public List<BadBoy> getList() {
        return this.lBadBoys;
    }

}
