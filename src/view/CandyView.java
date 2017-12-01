package view;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CandyView extends BaseView {
	
	public CandyView(Pane pane, Image im, Point2D pos) {
		this.pane = pane;
		sprite = new ImageView(im);
		sprite.setFitWidth(CELL*SPAN);
		sprite.setFitHeight(CELL*SPAN);
		sprite.setX((WALL + pos.getX() * (WALL+CELL)) * SPAN);
		sprite.setY((WALL + pos.getY() * (WALL+CELL)) * SPAN);
	}

	@Override
	public void view() {
		pane.getChildren().add(sprite);
	}

	@Override
	public void uptdate() {
		//Nothing to do
	}
	
	public void destroy() {
		pane.getChildren().remove(sprite);
	}
	
	private Pane pane;
	private ImageView sprite;

}
