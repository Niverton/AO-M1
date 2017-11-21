package model;

import model.state.State;
/**
 * 
 * @author laurent
 *
 */
public class BadBoy extends Personnage {
	private State state; 
	public BadBoy( Board board) {
		super(board);
		// TODO Auto-generated constructor stub
		
	}
	public void setState(State t){
		state = t;
	}
	public String getSate(){
		return state.toString();
	}
	public void moreIrritate(){
		state.moreIrritate(this);
	}
	public void lowerIrritate(){
		state.lowerIrritate(this);
	}

}
