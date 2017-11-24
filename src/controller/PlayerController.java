package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Board;
import model.Player;
import view.PlayerView;

public class PlayerController  implements EventHandler<KeyEvent>, Observer {
	private Player player; 
	
	private PlayerView v;
	private GameController gameController; 
	/**
	 * 
	 * @param board le plateau de jeux.
	 * @param game l'unique instance de Game controller.
	 */
	public PlayerController(Board board, GameController game){
	
		this.player = Player.getInstance(board);
		this.gameController = game;
	}
	/**
	 * 
	 * @param pane Le pane du jeux.
	 */
	public void start(Pane pane){
		v = new PlayerView(pane,player);
		v.view();
		v.setKeyPressed(this);
	}

	/**
	 * @param arg0 l'évènement clavier capturer. 
	 */
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getCode()== KeyCode.LEFT || arg0.getCode()== KeyCode.Q){
			player.moveLeft();
			
			this.gameController.change();
		}
		if(arg0.getCode()== KeyCode.DOWN || arg0.getCode()== KeyCode.S){
			player.movedown();
			
			this.gameController.change();
		}
		if(arg0.getCode()== KeyCode.RIGHT || arg0.getCode()== KeyCode.D){
			player.moveRight();
			this.gameController.change();
		}
		if(arg0.getCode()== KeyCode.UP || arg0.getCode()== KeyCode.Z){
			player.moveUp();
			this.gameController.change();
		}
		
	}

	/**
	 * @param o l'observable appelant
	 * @param arg les arguments passés par l'observable.
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		v.uptdate();
	}

	

	

	

	
}
