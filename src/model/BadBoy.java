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
	/**
	 * 
	 * @param t l'�tat dans lequel on veut mettre un m�chant
	 */
	public void setState(State t){
		state = t;
	}
	/**
	 * 
	 * @return la chaine de carract�re correspondant � l'�tat.
	 */
	public String getStateName(){
		return state.toString();
	}
	/**
	 * changement d'�tat. Rendre plus aggressif le m�chant. 
	 */
	public void moreIrritate(){
		state.moreIrritate(this);
	}
	/**
	 * Changement d'�tat. Rendre moins agressif le m�chant.
	 */
	public void lowerIrritate(){
		state.lowerIrritate(this);
	}
	

}
