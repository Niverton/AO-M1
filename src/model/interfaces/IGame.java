package model.interfaces;

import model.BadBoys;
import model.Candies;
import model.Directions;
import model.Labyrinth;
import model.ListObject;
import model.Player;

public interface IGame {
	public Labyrinth getLabyrinth();
	public void movePlayer(Directions dir);
	public void moveBadBoys(); 
	public BadBoys getBadBoys();
	public Player getPlayer();
	public ListObject getListObject();
	public Candies getCandies();
	public int getScore();
	public void setScore(int s);
	public boolean isEnd();
	public boolean getLoose();
}
