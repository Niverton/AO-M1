package controller;

import java.util.Observable;

import javafx.stage.Stage;
import model.Labyrinth;
import view.GameView;

public class GameController  extends Observable {
	private static GameController gameController;
	private Labyrinth labyrinth; 
	private GameView gameView;
	private LabyrinthController labyrinthController;
	private PlayerController playerController;
	private DoorController doorController;
	private GameController(){
		this.labyrinth = new Labyrinth(); 
		labyrinthController = new LabyrinthController(labyrinth);
		playerController = new PlayerController(labyrinth, this);
		doorController = new DoorController(labyrinth);
		addObserver(playerController);
	}
	/**
	 * 
	 * @param primaryStage le stage du jeux. 
	 */
	public void start(Stage primaryStage){
		gameView = new GameView(labyrinth,primaryStage); 
		gameView.view();
		
		labyrinthController.start(gameView.getPane());
		playerController.start(gameView.getPane());
		doorController.start(gameView.getPane());
		
		
	}
	/**
	 * 
	 * @return l'unique instance de GameController. (on ne peut avoir qu'un seul jeux démarré par lancement) 
	 */
	public static GameController getInstance(){
		if(gameController == null)
			gameController =  new GameController();
	return gameController;
	}
	/**
	 * Appeler depuis les observer pour avertir tous les autres controller d'un changement ( changement de position d'un personnage par exemple) 
	 */
	public void change(){
		gameView.uptdate();
		 setChanged();
         //notify observers for change
		 this.notifyObservers();
       
        
	}
	


	
	
	
}
