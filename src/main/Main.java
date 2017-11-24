package main;

import controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	protected static GameController gameController; 
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		 gameController = GameController.getInstance();
		
		 Application.launch(Main.class, args); 
	}
	/**
	 * @param primaryStage la fne^tre principal. 
	 * @exception Exception si erreur de lancement du stage.
	 */
	public void start(Stage primaryStage) throws Exception {
		
		gameController.start(primaryStage); 
		
		
	}
	
}
