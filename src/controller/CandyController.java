package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import model.Candies;
import model.Game;
import model.Player;

public class CandyController implements IController, Observer {
	private Candies candies;
	private Player p;
	
	public CandyController() {
		p = Game.getInstance().getPlayer();
	}
	
	@Override
	public void start(Pane pane) {
		candies = new Candies(pane);
		//TODO remove me
		candies.add();
	}
	
	@Override
	public void update(Observable gc, Object arg) {
		/* TODO
		 * Ne respecte pas assez le MVC ? (trop de logique dans le controller)
		 * 
		 * Vérifier timer, si temps écoulé ajouter un bonbon
		 * Peut être rajouter timer expiration de bonbon
		 * Avoir un maximum de bonbons simultanés
		 * 
		 */

		// TODO Récupèrer le score
		int score = candies.maybeEatenBy(p);
	}
}
