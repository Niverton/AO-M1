package controller;

import java.util.Observable;

import javafx.stage.Stage;
import model.Board;
import view.GameView;

public class GameController  extends Observable {
	private static GameController gameController;
	private Board board; 
	private GameView gameView;
	private BoardController boardController;
	private PlayerController playerController;
	private DoorController doorController;
	private GameController(){
		this.board = new Board(); 
		boardController = new BoardController(board);
		playerController = new PlayerController(board, this);
		doorController = new DoorController(board);
		addObserver(playerController);
	}
	
	public void start(Stage primaryStage){
		gameView = new GameView(primaryStage,board.getSize(), board.getSize()); 
		gameView.view();
		
		boardController.start(gameView.getPane());
		playerController.start(gameView.getPane());
		doorController.start(gameView.getPane());
		this.addObserver(playerController);
		
	}
	public static GameController getInstance(){
		if(gameController == null)
			gameController =  new GameController();
		
	return gameController;
	}
	public void change(){
	//	gameView.uptdate();
		 setChanged();
         //notify observers for change
		 this.notifyObservers();
        // playerController.update(this, null);
        
	}
	


	
	
	
}
