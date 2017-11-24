package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GameView extends IView {
	protected Pane pane;
	private int nbrX; 
	private int nbrY;
	private Stage stage; 
	protected static final Paint SCENECOLOR = Color.GREY; 
	public GameView(Stage stage, int nbrX, int nbrY){
		pane = new Pane();
		this.nbrX = nbrX; 
		this.nbrY = nbrY; 
		this.stage = stage;
	}
	public void view() {
		// TODO Auto-generated method stub
		stage.setTitle("labyrinth");
		Scene scene = new Scene ( pane ,
				( (WALL + CELL) *nbrX + WALL) *SPAN,
				( (WALL + CELL) *nbrY + WALL) *SPAN ) ;
		scene.setFill (SCENECOLOR ) ;
		
		stage.setScene( scene ) ;
		stage.show();
	}
	/**
	 * 
	 * @return Le pane de jeux.
	 */
	public Pane getPane(){
		return pane;
	}
	@Override
	public void uptdate() {
		// TODO Auto-generated method stub
		
	}
	
}
