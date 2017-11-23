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
	public PlayerController(Board board, GameController game){
	
		this.player = Player.getInstance(board);
		this.gameController = game;
	}
	
	public void start(Pane pane){
		v = new PlayerView(pane,player);
		v.view();
		v.setKeyPressed(this);
	}

	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getCode()== KeyCode.LEFT || arg0.getCode()== KeyCode.Q){
			player.moveLeft();
			
			
		}
		if(arg0.getCode()== KeyCode.DOWN || arg0.getCode()== KeyCode.S){
			player.movedown();
			
			
		}
		if(arg0.getCode()== KeyCode.RIGHT || arg0.getCode()== KeyCode.D){
			player.moveRight();
			
		}
		if(arg0.getCode()== KeyCode.UP || arg0.getCode()== KeyCode.Z){
			player.moveUp();
			
		}
		v.uptdate();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("test");
		//v.uptdate();
	}

	

	

	

	
}
