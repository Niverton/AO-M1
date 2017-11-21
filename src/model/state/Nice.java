package model.state;

import model.BadBoy;
/**
 * 
 * @author laurent
 *
 */
public class Nice implements State {

	@Override
	public void moreIrritate(BadBoy bad) {
		// TODO Auto-generated method stub
		bad.setState(new MediumIrritate());
	}

	@Override
	public void lowerIrritate(BadBoy bad) {
		// TODO Auto-generated method stub

	}
	public String toString(){
		return "nice";
	}

}
