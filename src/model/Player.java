package model;

/**
 * Le modele du joueur.
 */
public class Player extends Personnage {
    private int lives;

    public Player(int nb) {
        super();
        this.lives = nb;
    }

    /**
     * @param posX
     *            l'abscisse (coordonnée X) initiale du personnage.
     * @param posY
     *            l'ordonnée (coordonnée Y) initiale du personnage.
     */
    public Player(int posX, int posY) {
        super(posX, posY);
    }

    /**
     * decremente le nombre de vies de notre joueur.
     */
    public void loseLife() {
        lives--;
    }

    /**
     * @return le nombre de vies actuel du joueur.
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * @param i
     *            le nombre de vies a donner au joueur.
     */
    public void setLives(int i) {
        this.lives = i;
    }

}
