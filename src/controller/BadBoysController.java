package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.layout.Pane;
import model.Game;
import view.BadBoysView;

public class BadBoysController  implements IController, Observer{

	private BadBoysView v;
	private GameController gameController; 
	private Game game;
	private ScheduledService<Void> service;
	/**
	 * 
	 * @param gameController l'unique instance de Game controller.
	 */
	public BadBoysController( GameController gameController){

		this.game = Game.getInstance();
		this.gameController = gameController;

		service = new ScheduledService<Void>() { 

			@Override 
			protected Task<Void> createTask() { 
				return new Task<Void>() { 

					@Override 
					protected Void call() throws Exception { 
						// Faire le traitement ici. 
						game.moveBadBoys();
						gameController.change();
						try {
							Thread.sleep(120);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(game.isEnd()){
							System.out.println("stop");
							this.cancel(true);
						}
							
						Thread.yield();
						return null; 
					}                             
				}; 
			}                     
		};
	}
	/**
	 * 
	 * @param pane Le pane du jeu.
	 */
	public void start(Pane pane){
		v = new BadBoysView(pane);
		service.start();
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

	


}
