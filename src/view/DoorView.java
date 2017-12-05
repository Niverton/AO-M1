package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
//import model.Game;
//import model.Door;
import model.Door;
import model.Game;

public class DoorView extends BaseView {

		private Pane pane;
		private ImageView imageView;
		private Door door;


		public DoorView( Pane pane){
		this.pane = pane;
		this.door = Game.getInstance().getDoor();
		
		}


		@Override
		public void view() {
			// TODO Auto-generated method stub
			Image image1 = new Image ( getClass( ).getResource("ressource/door.jpg").toExternalForm ( ) ) ;
			imageView = new ImageView ( image1 ) ;
			//imageView.setFocusTraversable(true);
			pane.getChildren().add( this.imageView ) ;
			
			double xt = ( int ) ( ( WALL + 15* ( WALL+CELL) )* SPAN ) ;
			double yt = ( int ) ( ( WALL + 15* ( WALL+CELL) )  *SPAN ) ;
			imageView.setFitWidth(CELL*SPAN);
			imageView.setFitHeight(CELL*SPAN);
			imageView.setX ( xt) ;
			imageView.setY ( yt ) ;
			
		}

			@Override
			public void uptdate() {
			   
			}


}