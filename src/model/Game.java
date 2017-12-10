package model;


import javafx.geometry.Point2D;
import model.graph.Vertex;


public class Game {
	private  Labyrinth labyrinth; 
	private Player player; 
	private BadBoys badBoys; 
	private static Game instance; 
	private ListObject listObject;
	private Candies candies; 
	private boolean finish; 
	private int score; 
	
	private Game(){
		labyrinth = new Labyrinth(16); 
		player = new Player(); 
		badBoys = new BadBoys();
		listObject = new ListObject();
		candies = new Candies(); 
		candies.add();
		candies.add();
		score =0 ;
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
		return labyrinth;
	}
	/**
	 * 
	 * @param dir la direction dans lequel deplacer le joueur.
	 */
	public void movePlayer(Directions dir) {
		Vertex v = new Vertex(player.getPosX(), player.getPosY(),0);
		
		if(!labyrinth.isWall(v, dir))
			player.move(dir);
		
		Point2D p_pos = player.getPosition();
		score += candies.maybeEaten(p_pos);
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
		return player;
	}
	/**
	 * 
	 * @return les objets non mobile du jeux
	 */
	public ListObject getListObject(){
		return listObject;
	}
	/**
	 * 
	 * @return la liste des bonbons 
	 */
	public Candies getCandies(){
		return this.candies;
	}

	/**
	 * 
	 * @return le score de la partie.
	 */
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int s) {
		this.score = s;
	}
}
