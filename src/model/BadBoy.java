package model;

import model.state.Nice;
import model.state.State;
/**
 * 
 * @author laurent
 *
 */
public class BadBoy extends Personnage {
	private State state; 
	/**
	 * 
	 * @param board le labyrinth 
	 */
	public BadBoy( ) {
		super();
		state = new Nice();
		// TODO Auto-generated constructor stub
		
	}
	
	public BadBoy( int x, int y) {
		super(x,y);
		state = new Nice();
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * 
	 * @param t l'état dans lequel on veut mettre un méchant
	 */
	public void setState(State t){
		state = t;
	}
	/**
	 * 
	 * @return la chaine de carractère correspondant à l'état.
	 */
	public String getSateName(){
		return state.toString();
	}
	/**
	 * changement d'état. Rendre plus aggressif le méchant. 
	 */
	public void moreIrritate(){
		state.moreIrritate(this);
	}
	/**
	 * Changement d'état. Rendre moins agressif le méchant.
	 */
	public void lowerIrritate(){
		state.lowerIrritate(this);
	}
	

}
