package model;

import javafx.animation.Timeline;
import javafx.scene.image.Image;

/**
 * Le modele d'un bonbon.
 */
public class Candy extends ObjectGame {
    private CandyType type;
    private Timeline  die;

    /**
     * @param t
     *            Le type du bonbon.
     * @param x
     * @param y
     */
    public Candy(CandyType t, int x, int y) {
        super(x, y);
        type = t;
    }

    /**
     * Enregistre le timer d'expiration du bonbon et le démarre.
     * @param t
     */
    public void setTimeout(Timeline t) {
        die = t;
        die.play();
    }

    /**
     * @return Le temps restant sur le timer
     */
    public double getTimeout() {
        return die.getTotalDuration().toSeconds();
    }

    public Image getSprite() {
        return type.sprite();
    }

    /**
     * @return Le score associé au bonbon
     */
    public int getValue() {
        return type.value();
    }

    @Override
    public String toString() {
        return type + " " + position;
    }
}
