package model.state;

import model.BadBoy;
/**
 * 
 * @author laurent
 *
 */
public class VeryIrritate implements State {

	@Override
	public void moreIrritate(BadBoy bad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lowerIrritate(BadBoy bad) {
		// TODO Auto-generated method stub
		bad.setState(new MediumIrritate());
	}
	public String toString(){
		return "Irritate";
	}

}
