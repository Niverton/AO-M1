package model;

import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import view.CandyType;
import view.CandyView;

public class Candy extends ObjectGame {
	private CandyType type;
	private CandyView view;
	private Timeline die;
	
	public Candy(Pane pane, CandyType t, int x, int y) {
		super(x, y);
		type = t;
		view = new CandyView(pane,
					type.sprite(),
					getPosition());
		view.view();
	}
	
	public void setTimeout(Timeline t) {
		die = t;
		die.play();
	}
	
	/*
	 * @return: la valeur de score
	 */
	public int getEaten() {
		view.destroy();
		return type.value();
	}
}
