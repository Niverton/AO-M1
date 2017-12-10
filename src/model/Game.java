package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Point2D;
import model.graph.Vertex;


public class Game {
	private  Labyrinth labyrinth; 
	private Player player; 
	private BadBoys badBoys; 
	private static Game instance; 
	private ListObject listObject;
	private Candies candies; 
	private boolean end; 
	private int score; 
	private Door door;
	
	private Game(){
		labyrinth = new Labyrinth(16); 

		player = new Player();
		
		int nbBadBoys = 3;
		badBoys = new BadBoys(nbBadBoys);
		Random r = new Random();
		List<Point2D> lp = new ArrayList<Point2D>();
		for (int i = 0 ; i < nbBadBoys ; i++) {
			Point2D p = new Point2D(r.nextInt(16), r.nextInt(16));
			lp.add(p);
		}
		badBoys.setAllInitialPos(lp);
	
		listObject = new ListObject();
		candies = new Candies(); 
		candies.add();
		candies.add();
		door = new Door("door");
		end = false;
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
		
		if(!labyrinth.isWall(v, dir)){
			player.move(dir);
			if(player.getPosition().equals(door.getPosition())) {
				end = true;
			}
			
			Point2D p_pos = player.getPosition();
			score += candies.maybeEaten(p_pos);
		}
			
		System.out.println(player.getPosition() + " -------> "+ door.getPosition());
	}
	/**
	 * 
	 * @param dir la direction dans lequel deplacer le joueur.
	 * Pour le moment le déplacement est aléatoire :
	 * TODO - Améliorer ça avec l'algorithme de Manhattan
	 */
	public void moveBadBoys() {
		// On traite chaque BadBoy séparément
		for (BadBoy bb : badBoys.getList()) {
			Vertex v = new Vertex(bb.getPosX(), bb.getPosY(),0);
			
			Directions dir;
			
			// On récupère aléatoirement une direction valide pour qu'il se déplace
			do {
				Random r = new Random();
				int dir_int = r.nextInt(4);
				
				if (dir_int == 0) dir = Directions.North;
				else if (dir_int == 1) dir = Directions.East;
				else if (dir_int == 2) dir = Directions.South;
				else dir = Directions.West;
			
			} while (labyrinth.isWall(v, dir) || labyrinth.isOpenDoor(v, dir));
			
			// Puis on l'y déplace
			bb.move(dir);
		}
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
	public Door getDoor() {
		// TODO Auto-generated method stub
		return this.door;
	}
	
	public boolean isEnd(){
		return this.end;
	}
}
