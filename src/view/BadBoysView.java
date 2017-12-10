package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.BadBoy;
import model.BadBoys;
import model.Game;

public class BadBoysView extends BaseView {

	private Pane pane;
	private ImageView[] imagesView;
	private BadBoys badboys;

	/**
	 * 
	 * @param pane Le pane du jeu.
	 */
	public BadBoysView( Pane pane){
		this.pane = pane;
		this.badboys = Game.getInstance().getBadBoys();
	
	}

	/**
	 * 
	 * Initialise l'affichage du mechant sur l'écran et l'affiche une premiere fois.
	 */
	@Override
	public void view() {
		Image image = new Image ( getClass( ).getResource("ressource/bad.png").toExternalForm ( ) ) ;
		
		imagesView = new ImageView[badboys.getList().size()];
		int index = 0;
		for (BadBoy bb:badboys.getList()) {
			this.imagesView[index] = new ImageView ( image ) ;
			ImageView imageView = this.imagesView[index];
			pane.getChildren().add( imageView ) ;
			
			bb.getPosX();
			double xt = ( int ) ( ( WALL + bb.getPosX()* ( WALL+CELL) )* SPAN ) ;
			double yt = ( int ) ( ( WALL + bb.getPosY() * ( WALL+CELL) )  *SPAN ) ;
			imageView.setFitWidth(CELL*SPAN);
			imageView.setFitHeight(CELL*SPAN);
			imageView.setX ( xt) ;
			imageView.setY ( yt ) ;
			
			index++;
		}
		
	}


	/**
	 * 
	 * Actualise l'affichage du mechant sur l'écran.
	 */
	@Override
	public void update() {
		this.badboys = Game.getInstance().getBadBoys(); // update
		int index = 0;
		for (BadBoy bb : badboys.getList()) {
			double xt = ( int ) ( ( WALL + bb.getPosX()* ( WALL+CELL) )* SPAN ) ;
			double yt = ( int ) ( ( WALL + bb.getPosY() * ( WALL+CELL) )  *SPAN ) ;
	
			imagesView[index].setX ( xt) ;
			imagesView[index].setY ( yt );
			
			index++;
		}
	}
}
