package model;
/**
 * 
 * @author laurent
 *
 */
public class Player extends Personnage {
	
	public static Player player;
	private Player (Board board){
		super(board); 
	}
	/**
	 * 
	 * @param board le plateau de jeux labyrithn  couloir et mur
	 * @return l'unique instance du joureur. 
	 */
	public static Player getInstance(Board board){
		if(player == null){
			player =  new Player(board); 
		}
		return player;
	}
	
	
}
