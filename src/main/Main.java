package main;

import controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    protected static GameController gameController;

    public static void main(String[] args) {
        gameController = GameController.getInstance();
        Application.launch(Main.class, args);
    }

    public void start(Stage primaryStage) throws Exception {
        gameController.start(primaryStage);
    }
}
