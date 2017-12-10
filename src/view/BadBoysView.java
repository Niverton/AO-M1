package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.BadBoys;
import model.Game;

public class BadBoysView extends BaseView {

	private Pane pane;
	private ImageView imageView;
	private BadBoys badboys;
	

	public BadBoysView( Pane pane){
		this.pane = pane;
		this.badboys = Game.getInstance().getBadBoys();
	
	}

	@Override
	public void view() {
		// TODO Adapter le code de PlayerView aux BadBoys
		Image image = new Image ( getClass( ).getResource("ressource/bad.jpg").toExternalForm ( ) ) ;
		imageView = new ImageView ( image ) ;
		imageView.setFocusTraversable(true);
		pane.getChildren().add( this.imageView ) ;
		
	/*	player.getPosX();
		double xt = ( int ) ( ( WALL + player.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + player.getPosY() * ( WALL+CELL) )  *SPAN ) ;*/
		/*imageView.setFitWidth(CELL*SPAN);
		imageView.setFitHeight(CELL*SPAN);
		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;*/
		
	}


	@Override
	public void update() {
		// TODO Adapter le code de PlayerView aux BadBoys
		/*double xt = ( int ) ( ( WALL + player.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + player.getPosY() * ( WALL+CELL) )  *SPAN ) ;

		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;*/
		
	}
}
