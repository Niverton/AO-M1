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
	public static Player getInstance(Board board){
		if(player == null){
			return new Player(board); 
		}
		return player;
	}
	
	
}
