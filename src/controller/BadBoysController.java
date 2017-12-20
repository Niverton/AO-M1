package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;
import view.BadBoysView;

/**
 * Controleur des mechants du jeu.
 * C'est un singleton.
 */
public class BadBoysController implements IController, Observer {
    private BadBoysView v;
    private Game        game;
    private Timeline    move;

    /**
     * @param gameController
     *            l'unique instance de Game controller.
     */
    public BadBoysController() {
        this.game = Game.getInstance();
        this.move = new Timeline(new KeyFrame(Duration.seconds(0.1), ae -> {
            game.moveBadBoys();
        }));
        this.move.setCycleCount(Timeline.INDEFINITE); // A arrêter dans update.
    }

    @Override
    public void start(Pane pane) {
        v = new BadBoysView(pane);
        // service.start();
        this.move.play();
        v.view();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (Game.getInstance().isEnd()) {
            this.move.stop();
        } else {
            this.move.play();
        }
        v.update();
    }
}
