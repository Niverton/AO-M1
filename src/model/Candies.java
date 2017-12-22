package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import view.CandyType;

/**
 * La liste des bonbons
 */
public class Candies {
    /**
     * Le temps avant qu'un bonbon expire (en s);
     */
    private final static int duration = 30;
    /**
     * Le Nombre max de bonbons simultanés
     */
    private final static int MAX      = 5;
    /**
     * Position min en X
     */
    private static final int X_MIN    = 0;
    /**
     * Position max en X
     */
    private static final int X_MAX    = 10;
    /**
     * Position min en Y
     */
    private static final int Y_MIN    = 0;
    /**
     * Position max en Y
     */
    private static final int Y_MAX    = 10;

    private List<Candy> list;
    private Random      rand;

    public Candies() {
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Ajotue un nouveau bonbon.
     * Le nouveau bonbon est placé aleatoirement sur le plateau.
     * Son type est tiré au sort.
     */
    public void add() {
        if (list.size() == MAX) {
            return;
        }
        int x = rand.nextInt(X_MAX - X_MIN) + X_MIN; // Entre MIN et MAX
        int y = rand.nextInt(Y_MAX - Y_MIN) + Y_MIN;

        CandyType[] t = CandyType.values();
        int type = rand.nextInt(t.length);
        Candy c = new Candy(t[type], x, y);
        list.add(c);
        c.setTimeout(new Timeline(new KeyFrame(Duration.seconds(duration), ae -> { // Les lambdas c'est délicieux
            list.remove(c);
            System.out.println("est supprimer" + c);
        })));
    }

    public List<Candy> getCandies() {
        return list;
    }

    /**
     * Vérifie s'il y a un bonbon au point donné, et le mange.
     * 
     * @param p_pos
     *            la position a tester
     * @return la valeur de score du bonbon mangé (0 si pas de bonbon)
     */
    public int maybeEaten(Point2D p_pos) {
        for (int i = 0; i < list.size(); i++) {
            Candy c = list.get(i);
            if (c.getPosition().equals(p_pos)) {
                int s = c.getValue();
                list.remove(i);
                System.out.println(c + " mangé pour " + s + " points.");
                return s;
            }
        }
        return 0;
    }
}
