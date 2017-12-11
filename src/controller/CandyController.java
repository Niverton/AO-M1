package controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Candies;
import model.Game;
import view.CandyView;

public class CandyController implements IController, Observer {
	
	/*
	 * Les bornes du timer pour faire apparaitre les bonbons
	 */
	private static final int MIN_T = 3;
	private static final int MAX_T = 10;
	
	private CandyView view;
	private Timeline candyTimer;
	private Candies candies;
	
	public CandyController() {
		candies = Game.getInstance().getCandies();
	}
	
	
	@Override
	public void start(Pane pane) {
		System.out.println("CandyController.start");
		view = new CandyView(pane);
		
		setTimer();
	}
	
	
	
	@Override
	public void update(Observable gc, Object arg) {
		//System.out.println("CandyController update");
		
		if (candyTimer.getStatus() == Animation.Status.STOPPED) {
			setTimer();
		}
		
		view.update();
	}
	
	private void setTimer() {
		Random rand = new Random();
		int timer = rand.nextInt(MAX_T - MIN_T) + MIN_T;
		System.out.println("Prochain bonbon dans " + timer + " secondes.");
		candyTimer = new Timeline(new KeyFrame(
		        Duration.seconds(timer),
		        ae -> { //Les lambdas c'est délicieux
		        	candies.add();
		        	GameController.getInstance().change();
		        }));
		candyTimer.play();
	}
}
