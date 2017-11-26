package model;
/**
 * 
 * @author laurent
 *
 */
public class Player extends Personnage {
	
	public static Player player;
	/**
	 * 
	 * @param labirynth le labyrinth dans lequel va se déplacer le personnage.
	 */
	private Player (Labyrinth labyrinth){
		super(labyrinth); 
	}
	/**
	 * 
	 * @param board le plateau de jeux labyrithn  couloir et mur
	 * @return l'unique instance du joureur. 
	 */
	public static Player getInstance(Labyrinth labyrinth){
		if(player == null){
			player =  new Player(labyrinth); 
		}
		return player;
	}
	
	
}
