package view;

import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.Game;

public class GameView extends BaseView {
    protected Pane               pane;
    private int                  nbrX;
    private int                  nbrY;
    private Stage                stage;
    private Game                 game;
    protected static final Paint SCENECOLOR = Color.web("ecffff");

    /**
     * @param stage
     *            la fenetre principal.
     */
    public GameView(Stage stage) {
        pane = new Pane();
        game = Game.getInstance();
        this.nbrX = game.getLabyrinth().getSize();
        this.nbrY = game.getLabyrinth().getSize();
        this.stage = stage;
    }

    public void view() {
        stage.setTitle("labyrinth");
        Scene scene = new Scene(pane, ((WALL + CELL) * nbrX + WALL) * SPAN, ((WALL + CELL) * nbrY + WALL) * SPAN);
        scene.setFill(SCENECOLOR);
        stage.setScene(scene);
        // stage.setFullScreen(true);
        // stage.setFullScreenExitHint("");
        stage.show();
    }

    /**
     * @return Le pane de jeux.
     */
    public Pane getPane() {
        return pane;
    }

    @Override
    public void update() {
        if (Game.getInstance().isEnd()) {
            ButtonType next = new ButtonType("Next level");
            ButtonType quit = new ButtonType("Quit");
            ButtonType retry = new ButtonType("Retry");
            Platform.runLater(new Runnable() {
                public void run() {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    // alert.setHeaderText("Change");
                    if (Game.getInstance().getLose()) {
                        alert.getButtonTypes().setAll(retry);
                        alert.setTitle("You loose");
                        alert.setHeaderText(null);
                        alert.setContentText("You loose width score : " + game.getScore());
                    } else {
                        alert.getButtonTypes().setAll(retry, quit);
                        alert.setTitle("Win");
                        alert.setHeaderText(null);
                        alert.setContentText("You win width score : " + game.getScore());
                    }

                    Optional<ButtonType> b = alert.showAndWait();
                    if (!b.equals(ButtonData.OK_DONE)) {
                        if (b.get().equals(next)) {
                            alert.close();
                        }
                        if (b.get().equals(retry)) {
                            game.retry();
                        }
                        if (b.get().equals(quit))
                            System.exit(1);
                    }
                }
            });
        }
    }
}
