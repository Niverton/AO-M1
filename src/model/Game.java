package model;


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
	private Door door;
	private Game(){
		labyrinth = new Labyrinth(16); 
		player = new Player(); 
		badBoys = new BadBoys();
		listObject = new ListObject();
		candies = new Candies(); 
		door = new Door("door");
		
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
		
		///////////////////// POUR CANDY ////////.
		/****
		 * 
		 *  test si quand il se deplace est ce quil y a colision avec un des candy   avec player.getPosX(), player.getPosY()
		 *  	Si tel est le cas remove Candy.  et score ++ 
		 * 
		 * 
		 */
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
	/**
	 * 
	 * @return la liste des bombons 
	 */
	public Candies getCandies(){
		return this.candies;
	}
	public void removeCandies(){
		//this.candies.removeAll(); 
	}
	/**
	 * 
	 * @return le score de la partie.
	 */
	public int  getSCore(){
		return this.score;
	}
	public Door getDoor() {
		// TODO Auto-generated method stub
		return this.door;
	}
}
