package model.state;

import model.BadBoy;
/**
 * 
 * @author laurent
 *
 */
public class MediumIrritate implements State {

	@Override
	public void moreIrritate(BadBoy bad) {
		// TODO Auto-generated method stub
		bad.setState(new VeryIrritate());
	}

	@Override
	public void lowerIrritate(BadBoy bad) {
		// TODO Auto-generated method stub
		bad.setState(new Nice());
	}
	public String toString(){
		return "Medium";
	}

}
