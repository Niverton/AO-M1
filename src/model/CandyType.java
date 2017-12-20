package model;

import javafx.scene.image.Image;

/**
 * Les différents types de bonbons
 */
public enum CandyType {
    //@formatter:off
    Candy1("Candy1", "ressource/candy1.png", 100),
    Candy2("Candy2", "ressource/candy2.png", 200),
    Candy3("Candy3", "ressource/candy3.png", 300),
    Candy4("Candy4", "ressource/candy4.png", 400);
    //@formatter:on

    private CandyType(String name, String sprite, int value) {
        this.name = name;
        this.sprite = new Image(getClass().getResource(sprite).toExternalForm());
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    public Image sprite() {
        return sprite;
    }

    public int value() {
        return value;
    }

    private String name;
    private Image  sprite;
    private int    value;
}
