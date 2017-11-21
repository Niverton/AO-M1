package main;

import controller.BoardController;
import controller.GameController;
import controller.PlayerController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	protected static GameController gameController; 
	
	public static void main(String[] args){
		 gameController = GameController.getInstance();
		
		 Application.launch(Main.class, args); 
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		gameController.start(primaryStage); 
		
		
	}
	
}
