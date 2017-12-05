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
		candies = new Candies();
		//TODO remove me
		// A CHANGER Pas le faire ici ajouter une methode dans ae qui le fait 
		//candies.add(0,10);
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
		//A CHANGER on ne retourne pas d'entier juste  et pas de param�tre p passe le directrment en meme temps que la vue. 
		//int score = candies.maybeEatenBy(p);
	}
}
