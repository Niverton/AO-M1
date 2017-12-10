package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import view.CandyType;

public class Candies {
	/*
	 * Le temps avant qu'un bonbon expire (en s);
	 */
	private final static int duration = 30;
	/*
	 * Le Nombre max de bonbons simultanés
	 */
	private final static int MAX = 5;
	
	
	private static final int X_MIN = 0;
	private static final int X_MAX = 10;
	
	private static final int Y_MIN = 0;
	private static final int Y_MAX = 10;
	
	private List<Candy> list;
	private Random rand;
	
	public Candies() {
		list = new ArrayList<>();
		rand = new Random();
	}
	
	public void add() {
		if (list.size() == MAX) {
			return;
		}
		int x = rand.nextInt(X_MAX - X_MIN) + X_MIN; // Entre MIN et MAX
		int y = rand.nextInt(Y_MAX - Y_MIN) + Y_MIN;
		//TODO Plus grosse probabilité pour les scores plus faibles ?
		CandyType t[] = CandyType.values();
		int type = rand.nextInt(t.length);
		Candy c = new Candy(t[type], x, y);
		list.add(c);
		c.setTimeout(new Timeline(new KeyFrame(
				        Duration.seconds(duration),
				        ae -> { //Les lambdas c'est délicieux
				        	c.getEaten();
				        	list.remove(c);
				        })));
		System.out.println("Added candy " + c);
	}
	
	public List<Candy> getCandies() {
		return list;
	}
	
	public int maybeEaten(Point2D p_pos) {
		for (int i = 0; i < list.size(); i++) {
			Candy c = list.get(i);
			if (c.getPosition().equals(p_pos)) {
				int s = c.getEaten();
				System.out.println("Eating " + c + " for " + s + " points.");
				list.remove(i);
				return s;
			}
		}
		return 0;
	}
}
