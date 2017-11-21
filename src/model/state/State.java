package model.state;

import model.BadBoy;
/**
 * 
 * @author laurent
 *
 */
public interface State {
	public void moreIrritate(BadBoy bad);
	public void lowerIrritate(BadBoy bad);
	public  String toString();
}
