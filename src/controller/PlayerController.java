package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Directions;
import model.Game;
import view.PlayerView;

public class PlayerController  implements EventHandler<KeyEvent>, Observer {
	
	private PlayerView v;
	private GameController gameController; 
	private Game game;
	/**
	 * 
	 * @param labyrinth le labyrinth courant.
	 * @param game l'unique instance de Game controller.
	 */
	public PlayerController( GameController gameController){
	
		this.game = Game.getInstance();
		this.gameController = gameController;
	}
	/**
	 * 
	 * @param pane Le pane du jeux.
	 */
	public void start(Pane pane){
		v = new PlayerView(pane);
		v.view();
		v.setKeyPressed(this);
	}

	/**
	 * @param arg0 l'�v�nement clavier capturer. 
	 */
	public void handle(KeyEvent arg0) {
		if(arg0.getCode()== KeyCode.LEFT || arg0.getCode()== KeyCode.Q){
			game.movePlayer(Directions.West);
			
			this.gameController.change();
		}
		if(arg0.getCode()== KeyCode.DOWN || arg0.getCode()== KeyCode.S){
			game.movePlayer(Directions.South);
			
			this.gameController.change();
		}
		if(arg0.getCode()== KeyCode.RIGHT || arg0.getCode()== KeyCode.D){
			game.movePlayer(Directions.East);
			this.gameController.change();
		}
		if(arg0.getCode()== KeyCode.UP || arg0.getCode()== KeyCode.Z){
			game.movePlayer(Directions.North);
			this.gameController.change();
		}
		
	}

	/**
	 * @param o l'observable appelant
	 * @param arg les arguments pass�s par l'observable.
	 */
	public void update(Observable o, Object arg) {
		v.update();
	}

	

	

	

	
}
