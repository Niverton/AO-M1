package model;

import model.Personnage.Directions;

public class Game {
	private  Labyrinth labyrinth; 
	private Player player; 
	private BadBoys badBoys; 
	private static Game instance; 
	private Game(){
		labyrinth = new Labyrinth(); 
		player = new Player(); 
		badBoys = new BadBoys();
	}
	public static Game getInstance(){
		if(instance == null)
			instance = new Game(); 
		return instance;
	}
	public Labyrinth getLabyrinth() {
		// TODO Auto-generated method stub
		return labyrinth;
	}
	public void movePlayer(Directions dir) {
		// TODO Auto-generated method stub
		player.move(dir);
	}
	public int getSizeLabyrinth(){
		return labyrinth.getSize();
	}
	public BadBoys getBadBoys(){
		return badBoys;
	}
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
}
