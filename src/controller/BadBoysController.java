package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;
import view.BadBoysView;

public class BadBoysController  implements IController, Observer{

	private BadBoysView v; 
	private Game game;
	private Timeline move; 
	/**
	 * 
	 * @param gameController l'unique instance de Game controller.
	 */
	public BadBoysController(){

		this.game = Game.getInstance();
		this.move = new Timeline(new KeyFrame(
		        Duration.seconds(0.1),
		        ae -> { //Les lambdas c'est dÃ©licieux
		        	game.moveBadBoys(); 
		        	
		        })); 
		this.move.setCycleCount(Timeline.INDEFINITE); // on répête a l'infini cela s'arrêtera dans le update.
		
		
	}
	/**
	 * 
	 * @param pane Le pane du jeu.
	 */
	public void start(Pane pane){
		v = new BadBoysView(pane);
		//service.start();
		this.move.play(); 
		v.view();
	}

	/**
	 * @param o l'observable appelant 
	 * @param arg les arguments lancï¿½ depuis l'observable.
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(Game.getInstance().isEnd()){
			this.move.stop(); 
		}
		
		v.update();
	}

	


}
