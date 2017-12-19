package model;
/**
 * 
 * @author laurent
 *
 */
public class Player extends Personnage {
	private int life; 
	public Player (int nb){
		super(); 
		this.life = nb;
	}
	
	/**
	 * 
	 * 
	 * @param posX l'abscisse (coordonnée X) initiale du personnage.
	 * @param posY l'ordonnée (coordonnée Y) initiale du personnage.
	 */
	public Player (int posX, int posY){
		super( posX, posY); 
	}
	/**
	 * decremente la vie de notre player. 
	 */
	public void looseLife(){
		life --; 
	}

	public int getLife() {
		// TODO Auto-generated method stub
		return this.life;
	}
	/**
	 * 
	 * @param i le nombre de vies. 
	 */
	public void setLife(int i) {
		// TODO Auto-generated method stub
		this.life = i;
	}


	
	
	
	
	
}
