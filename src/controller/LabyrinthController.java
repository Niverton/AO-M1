package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import model.Labyrinth;
import view.ViewLabyrinth;

/**
 * Controleur du labyrinthe.
 */
public class LabyrinthController implements IController, Observer {
    private ViewLabyrinth v;
    private Labyrinth     labyrinth;

    /**
     * @param labyrinth
     *            le labyrinthe du jeux.
     */
    public LabyrinthController(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    @Override
    public void start(Pane pane) {
        v = new ViewLabyrinth(labyrinth, pane);
        v.view();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
    }

}
