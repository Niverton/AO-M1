package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Candy;
import model.Game;

public class CandyView extends BaseView {
	private Pane pane;
	private List<ImageView> sprites;
	private Game g;

	public CandyView(Pane pane) {
		this.pane = pane;
		g = Game.getInstance();
		sprites = new ArrayList<ImageView>();
	}

	@Override
	public void view() {
		update();
	}

	@Override
	public void update() {
		//Les performances c'est pas grave on est en Java :D
		///pane.getChildren().removeAll(sprites);
		sprites.clear();

		List<Candy> candies = g.getCandies().getCandies();
		for (Candy c : candies) {
			ImageView v = new ImageView(c.getSprite()); 
			double xt = ( int ) ( ( WALL + c.getPosX() * ( WALL+CELL) )* SPAN ) ;
			double yt = ( int ) ( ( WALL + c.getPosY() * ( WALL+CELL) )  *SPAN ) ;
			v.setFitWidth(CELL*SPAN);
			v.setFitHeight(CELL*SPAN);
			v.setX(xt);
			v.setY(yt);
			sprites.add(v);
			Platform.runLater(new Runnable(){
				public void run(){

					pane.getChildren().add(v);
				}
			});
		}
	}

}

