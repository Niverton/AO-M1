package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Labyrinth;
import model.Door;
import model.Player;

public class DoorView extends IView {
	private Labyrinth board;
	private Player player;
	private ImageView imageView;
	private Pane pane;
	private Door door;
	/**
	 * 
	 * @param board le labyrithn
	 * @param pane Le pane d'affichage 
	 * @param door la porte de sortie
	 */
	public DoorView(Labyrinth board, Pane pane, Door door){
		this.board = board;
		this.player = Player.getInstance(board);
		this.pane = pane;
		this.door = door;
	}
	@Override
	public void view() {
		// TODO Auto-generated method stub
		/*Image image = new Image ( getClass( ).getResource("ressource/door.jpg").toExternalForm ( ) ) ;
		imageView = new ImageView ( image ) ;
		imageView.setFocusTraversable(false);
		pane.getChildren().add( this.imageView ) ;
		
		double xt = ( int ) ( ( WALL + door.getPosX()* ( WALL+CELL) )* SPAN ) ;
		double yt = ( int ) ( ( WALL + door.getPosY() * ( WALL+CELL) )  *SPAN ) ;
		imageView.setFitWidth(CELL*SPAN);
		imageView.setFitHeight(CELL*SPAN);

		imageView.setX ( xt) ;
		imageView.setY ( yt ) ;*/
	}

	@Override
	public void uptdate() {
		// TODO Auto-generated method stub

	}

}
