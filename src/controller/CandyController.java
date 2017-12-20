package controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Candies;
import model.Game;
import view.CandyView;

/**
 * Le Controleur des bonbons.
 */
public class CandyController implements IController, Observer {

    /**
     * Borne inférieur de temps pour faire apparaître un nouveau bonbon.
     */
    private static final int MIN_T = 3;
    /**
     * Borne inférieur de temps pour faire apparaître un nouveau bonbon.
     */
    private static final int MAX_T = 10;

    private CandyView view;
    private Timeline  candyTimer;
    private Candies   candies;

    public CandyController() {
        candies = Game.getInstance().getCandies();
    }

    @Override
    public void start(Pane pane) {
        view = new CandyView(pane);
        setTimer();
    }

    @Override
    public synchronized void update(Observable gc, Object arg) {
        if (candyTimer.getStatus() == Animation.Status.STOPPED && !Game.getInstance().isEnd()) {
            setTimer();
        }
        view.update();
    }

    /**
     * Relance un timer pour faire apparaitre un nouveau bonbon.
     */
    private void setTimer() {
        Random rand = new Random();
        int timer = rand.nextInt(MAX_T - MIN_T) + MIN_T;
        System.out.println("Prochain bonbon dans " + timer + " secondes.");
        candyTimer = new Timeline(new KeyFrame(Duration.seconds(timer), ae -> { // Les lambdas c'est délicieux
            candies.add();

        }));
        candyTimer.play();
    }
}
