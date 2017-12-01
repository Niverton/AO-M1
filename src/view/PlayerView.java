package view;

import controller.PlayerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Game;
import model.Player;

public class PlayerView extends BaseView {

	private Pane pane;
	private ImageView imageView;
	private Player player;
	

	public PlayerView( Pane pane){
		this.pane = pane;
		this.player = Game.getInstance().getPlayer();
	
	}


	public void setKeyPressed(PlayerController playerController) {
		// TODO Auto-generated method stub
		//imageView.setOnKeyPressed(playerController);
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		Image image = new Image ( getClass( ).getResource("ressource/smyley.jpg").toExternalForm ( ) ) ;
		imageView = new ImageView ( image ) ;
		imageView.setFocusTraversable(true);
		pane.getChildren().add( this.imageView ) ;
		
		player.getPosX();
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
