package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javafx.geometry.Point2D;
import model.Directions;
import model.Player;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player(5);
		assertTrue(player.getPosX() ==0); 
		assertTrue(player.getPosY() ==0); 
	}

	@Test
	public void testPlayerIntInt() {
		Player player = new Player(5,6); 
		assertTrue("Test player(INT, INT) a échoué ",player.getPosX() == 5 && player.getPosY() == 6);
		
		// test de chaque direction. 
		player.move(Directions.East);
		assertTrue("Player.move(East) a échoué ",player.getPosition().equals(new Point2D(6,6)));
		player.move(Directions.North);
		assertTrue("Player.move(East) a échoué ",player.getPosition().equals(new Point2D(6,5)));
		player.move(Directions.South);
		assertTrue("Player.move(East) a échoué ",player.getPosition().equals(new Point2D(6,6)));
		player.move(Directions.West);
		assertTrue("Player.move(East) a échoué ",player.getPosition().equals(new Point2D(5,6)));
		
	}

	@Test
	public void testPlayerLives() {
		Player player = new Player(2); 
		assertTrue("Initialisation du player(INT) a échoué", player.getLives() == 2); 
		player.setLives(5);
		assertTrue("Player.setLives(INT) a échoué", player.getLives() == 5); 
		player.loseLife();
		assertTrue("Player.loseLife() a échoué", player.getLives() == 4);
	}

}
