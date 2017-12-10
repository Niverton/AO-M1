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
	

	/**
	 * 
	 * @param pane Le pane du jeu.
	 */
	public PlayerView( Pane pane){
		this.pane = pane;
		this.player = Game.getInstance().getPlayer();
	
	}


	/**
	 * 
	 * @param playerController le controller du joueur.
	 */
	public void setKeyPressed(PlayerController playerController) {

		imageView.setOnKeyPressed(playerController);
	}

	/**
	 * 
	 * Initialise l'affichage du joueur sur l'écran et l'affiche une premiere fois.
	 */
	@Override
	public void view() {
		Image image = new Image ( getClass( ).getResource("ressource/smiley.jpg").toExternalForm ( ) ) ;
		imageView = new ImageView ( image ) ;
		imageView.setFocusTraversable(true);
		pane.getChildren().add( this.imageView ) ;
		
		player.getPosX();
		System.out.print(player.getPosX());
		System.out.print(player.getPosY());
		double xt = ( int ) ( ( WALL + player.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + player.getPosY() * ( WALL+CELL) )  *SPAN ) ;
		imageView.setFitWidth(CELL*SPAN);
		imageView.setFitHeight(CELL*SPAN);
		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;
		
	}


	/**
	 * 
	 * Actualise l'affichage du joueur.
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		double xt = ( int ) ( ( WALL + player.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + player.getPosY() * ( WALL+CELL) )  *SPAN ) ;

		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;
		
	}
}
