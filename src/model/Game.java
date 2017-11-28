package model;


import model.directions.Directions;
import model.graph.Vertex;


public class Game {
	private  Labyrinth labyrinth; 
	private Player player; 
	private BadBoys badBoys; 
	private static Game instance; 
	private ListObject listObject;
	private Game(){
		labyrinth = new Labyrinth(); 
		player = new Player(); 
		badBoys = new BadBoys();
		listObject = new ListObject();
	}
	/**
	 * 
	 * @return l'unique instance du jeux.
	 */
	public static Game getInstance(){
		if(instance == null)
			instance = new Game(); 
		return instance;
	}
	/**
	 * 
	 * @return l labyrinth
	 */
	public Labyrinth getLabyrinth() {
		// TODO Auto-generated method stub
		return labyrinth;
	}
	/**
	 * 
	 * @param dir la direction dans lequel deplacer le joueur.
	 */
	public void movePlayer(Directions dir) {
		// TODO Auto-generated method stub
		Vertex v = new Vertex(player.getPosX(), player.getPosY(),0);
		if(!labyrinth.isWall(v, dir))
			player.move(dir);
	}
	/**
	 * 
	 * @return les mechants 
	 */
	public BadBoys getBadBoys(){
		return badBoys;
	}
	/**
	 * 
	 * @return le joueur.
	 */
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	/**
	 * 
	 * @return les objets non mobile du jeux
	 */
	public ListObject getListObject(){
		return listObject;
	}
}
