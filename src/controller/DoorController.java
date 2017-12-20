package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import view.DoorView;

/**
 * Controleur de la porte de sortie.
 */
public class DoorController implements IController, Observer {
    private DoorView d;

    public DoorController() {
    }

    @Override
    public void start(Pane pane) {
        d = new DoorView(pane);
        d.view();
    }

    @Override
    public void update(Observable o, Object arg) {
        d.update();
    }

}
