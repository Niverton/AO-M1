package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import controller.PlayerController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Board;
import model.Player;

public class PlayerView extends IView {

	private Pane pane;
	private ImageView imageView;
	private Player player;
	

	public PlayerView( Pane pane, Player player){
		this.pane = pane;
		this.player = player;
	
	}


	public void setKeyPressed(PlayerController playerController) {
		// TODO Auto-generated method stub
		imageView.setOnKeyPressed(playerController);
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		Image image = new Image ( getClass( ).getResource("ressource/smyley.jpg").toExternalForm ( ) ) ;
		imageView = new ImageView ( image ) ;
		imageView.setFocusTraversable(true);
		pane.getChildren().add( this.imageView ) ;
		
		double xt = ( int ) ( ( WALL + player.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + player.getPosY() * ( WALL+CELL) )  *SPAN ) ;
		imageView.setFitWidth(CELL*SPAN);
		imageView.setFitHeight(CELL*SPAN);

		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;
		
	}


	@Override
	public void uptdate() {
		// TODO Auto-generated method stub
		double xt = ( int ) ( ( WALL + player.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + player.getPosY() * ( WALL+CELL) )  *SPAN ) ;

		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;
		
	}
}
