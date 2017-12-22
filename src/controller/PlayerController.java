package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Directions;
import model.Game;
import view.PlayerView;

/**
 * Controleur
 */
public class PlayerController implements IController, EventHandler<KeyEvent>, Observer {

    private PlayerView v;
    private Game       game;

   
    public PlayerController() {
        this.game = Game.getInstance();
    }

    @Override
    public void start(Pane pane) {
        v = new PlayerView(pane);
        v.view();
        v.setKeyPressed(this);
    }

    /**
     * @param event
     *            l'evenement clavier capturer.
     */
    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.Q) {
            game.movePlayer(Directions.West);

        } else if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
            game.movePlayer(Directions.South);

        } else if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
            game.movePlayer(Directions.East);

        } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.Z) {
            game.movePlayer(Directions.North);

        }
    }

    /**
     * @param o
     *            l'observable appelant
     * @param arg
     *            les arguments passes par l'observable.
     */
    @Override
    public void update(Observable o, Object arg) {
        v.update();
    }

}
