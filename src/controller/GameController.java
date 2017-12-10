package controller;

import java.util.Observable;

import javafx.stage.Stage;
import model.Game;
import view.GameView;

public class GameController  extends Observable {
	private static GameController gameController;
	private GameView gameView;
	private LabyrinthController labyrinthController;
	private PlayerController playerController;
	private BadBoysController badBoysController;
	private CandyController candyController;
	private DoorController doorController;
	private Game game;
	
	private GameController(){
		game = Game.getInstance();
		labyrinthController = new LabyrinthController(game.getLabyrinth());
		playerController = new PlayerController(this);
		badBoysController = new BadBoysController(this);
		candyController = new CandyController();
		doorController = new DoorController();

		addObserver(playerController);
		addObserver(badBoysController);
		addObserver(candyController);
	}
	/**
	 * 
	 * @param primaryStage le stage du jeux. 
	 */
	public void start(Stage primaryStage){
		gameView = new GameView(primaryStage); 
		gameView.view();
		
		labyrinthController.start(gameView.getPane());
		playerController.start(gameView.getPane());
		badBoysController.start(gameView.getPane());
		candyController.start(gameView.getPane());
		doorController.start(gameView.getPane());
		
	}
	/**
	 * 
	 * @return l'unique instance de GameController. (on ne peut avoir qu'un seul jeux d�marr� par lancement) 
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
