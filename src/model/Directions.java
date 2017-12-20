package model;

/**
 * Les quatres points cardinaux du plateau.
 */
public enum Directions {
    North("North"), East("East"), South("South"), West("West");

    Directions(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private String name;
}
