package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.stage.Stage;
import model.Game;
import view.GameView;

public class GameController implements Observer {
	private static GameController gameController;
	private GameView gameView;
	private LabyrinthController labyrinthController;
	private PlayerController playerController;
	private BadBoysController badBoysController;
	private Thread badBoysMove;
	private CandyController candyController;
	private DoorController doorController;
	private Game game;
	
	private GameController(){
		game = Game.getInstance();
		labyrinthController = new LabyrinthController(game.getLabyrinth());
		candyController = new CandyController();
		playerController = new PlayerController();
		badBoysController = new BadBoysController();
		
		doorController = new DoorController();
		// ajout des observer dans notre modèle. 
		game.addObserver(candyController);
		game.addObserver(playerController);
		game.addObserver(badBoysController);
		game.addObserver(this);
	}
	/**
	 * 
	 * @param primaryStage le stage du jeux. 
	 */
	public void start(Stage primaryStage){
		
		gameView = new GameView(primaryStage); 
		gameView.view();
		// on demarre tout les services 
		candyController.start(gameView.getPane());
		labyrinthController.start(gameView.getPane());
		playerController.start(gameView.getPane());
		badBoysController.start(gameView.getPane());
		doorController.start(gameView.getPane());
		
	}
	/**
	 * 
	 * @return l'unique instance de GameController. (on ne peut avoir qu'un seul jeux dï¿½marrï¿½ par lancement) 
	 */
	public static GameController getInstance(){
		if(gameController == null)
			gameController =  new GameController();
	return gameController;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		gameView.update();
	}
	


	
	
	
}
