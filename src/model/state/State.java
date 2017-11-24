package model.state;

import model.BadBoy;
/**
 * 
 * @author laurent
 *
 */
public interface State {
	/**
	 * 
	 * @param bad rend le m�chant plus reactif
	 */
	public void moreIrritate(BadBoy bad);
	/**
	 * 
	 * @param bad le mechant. 
	 */
	public void lowerIrritate(BadBoy bad);
	/**
	 * 
	 * @return l'�tat courant.
	 */
	public  String toString();
}
