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
	 * @param labyrinth le labyrinthe dans lequel va se d�placer le personnage.
	 */
	private Player (Labyrinth labyrinth){
		super(labyrinth); 
	}
	
	/**
	 * 
	 * @param labyrinth le labyrinthe dans lequel va se d�placer le personnage.
	 * @param posX l'abscisse (coordonnée X) initiale du personnage.
	 * @param posY l'ordonnée (coordonnée Y) initiale du personnage.
	 */
	private Player (Labyrinth labyrinth, int posX, int posY){
		super(labyrinth, posX, posY); 
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
