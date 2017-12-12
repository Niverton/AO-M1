package model;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;
import view.CandyType;

public class Candy extends ObjectGame {
	private CandyType type;
	private Timeline die;
	
	public Candy(CandyType t, int x, int y) {
		super(x, y);
		type = t;
	}
	
	public void setTimeout(Timeline t) {
		die = t;
		die.play();
	}
	public double getTimeout(){
		return die.getTotalDuration().toSeconds();
	}
	
	public Image getSprite() {
		return type.sprite();
	}
	
	public int getValue() {
		return type.value();
	}
	
	/*
	 * @return: la valeur de score
	 */
	public int getEaten() {
		return type.value();
	}

	public String toString() {
		return type + " " + position;
	}
}
