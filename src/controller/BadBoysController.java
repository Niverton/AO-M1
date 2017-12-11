package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import model.Game;
import view.BadBoysView;

public class BadBoysController  implements IController, Observer, Runnable{
	
	private BadBoysView v;
	private GameController gameController; 
	private Game game;
	/**
	 * 
	 * @param gameController l'unique instance de Game controller.
	 */
	public BadBoysController( GameController gameController){
	
		this.game = Game.getInstance();
		this.gameController = gameController;
	}
	/**
	 * 
	 * @param pane Le pane du jeu.
	 */
	public void start(Pane pane){
		v = new BadBoysView(pane);
		
		v.view();
	}

	/**
	 * @param o l'observable appelant 
	 * @param arg les arguments lanc� depuis l'observable.
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		v.update();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!game.isEnd()){
			game.moveBadBoys();
			this.gameController.change();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.yield();
		}
	}

}
