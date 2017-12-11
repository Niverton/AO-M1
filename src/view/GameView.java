package view;



import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.Game;


public class GameView extends BaseView {
	protected Pane pane;
	private int nbrX; 
	private int nbrY;
	private Stage stage; 
	private Game game;
	protected static final Paint SCENECOLOR = Color.web("ecffff"); 
	public GameView(Stage stage){
		pane = new Pane();
		game = Game.getInstance();
		this.nbrX = game.getLabyrinth().getSize();
		this.nbrY =  game.getLabyrinth().getSize();
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
		//stage.setFullScreen(true);
		//stage.setFullScreenExitHint("");
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
	public void update() {
		// TODO Auto-generated method stub
		 System.out.println("rentre");
	
		if(Game.getInstance().isEnd()){
			ButtonType next = new ButtonType("Next level");
			ButtonType quit = new ButtonType("Quit");
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().setAll(next, quit);
			alert.setTitle("Win");
			alert.setHeaderText(null);
			//alert.setHeaderText("Change");
			alert.setContentText("You win");
			
			Optional<ButtonType> b = alert.showAndWait();
				
			if (b.get().equals(next)){
				
				alert.close();
			}
			if(b.get().equals(quit))
				System.exit(1);
			
		}
	}
	
}
