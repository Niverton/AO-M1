package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import com.sun.javafx.css.StyleCache.Key;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Board;
import model.Player;
import view.PlayerView;

public class PlayerController  implements EventHandler<KeyEvent>, Observer {
	private Player player; 
	
	private PlayerView v;
	
	public PlayerController(Board board){
	
		this.player = Player.getInstance(board);
		
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
		v.uptdate();
	}

	

	

	

	
}
