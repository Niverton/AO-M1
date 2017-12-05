package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.CandyType;

public class Candies {
	/*
	 * Le temps avant qu'un bonbon expire (en s);
	 */
	private final static int duration = 30;
	
	private Pane pane;
	private List<Candy> list;
	private Random rand;
	
	public Candies() {
		
		list = new ArrayList<>();
		rand = new Random();
	}
	
	public void add(int min, int max) {
		int x = rand.nextInt(min);
		int y = rand.nextInt(max);
		//TODO Plus grosse probabilité pour les scores plus faibles ? 
		CandyType t[] = CandyType.values();
		int type = rand.nextInt(t.length);
		Candy c = new Candy(pane, t[type], x, y);
		list.add(c);
		c.setTimeout(new Timeline(new KeyFrame(
				        Duration.seconds(duration),
				        ae -> { //Les lambdas c'est délicieux
				        	c.getEaten();
				        	list.remove(c);
				        })));
	}
	
	/*
	 * Vérifie si le joueur mange un bonbon, si oui le détruit et retourne la valeur du bonbon
	 * Sinon lance NullPointerException >:D
	 * (ou retourne 0)
	 */
	public int maybeEatenBy(Player p) {
		for (int i = 0; i < list.size(); i++) {
			Candy c = list.get(i);
			if (c.getPosition().equals(p.getPosition())) {
				list.remove(i);
				return c.getEaten();
			}
		}
		return 0;
	}
}
