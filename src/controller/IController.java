package controller;

import javafx.scene.layout.Pane;

/**
 * Interface commune aux controleurs.
 */
public interface IController {
    /**
     * Démarre le controleur et lance la vue.
     * @param pane
     *            Le groupe du jeux ( labyrithn, joueur, mechants)
     */
    public void start(Pane pane);
}
