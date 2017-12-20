package model.state;

import model.BadBoy;

/**
 * @author laurent
 */
public interface State {
    /**
     * Augmente la difficulte
     * 
     * @param bad
     *            le mechant
     */
    public void moreIrritate(BadBoy bad);

    /**
     * Diminue la difficulte
     * 
     * @param bad
     *            le mechant
     */
    public void lowerIrritate(BadBoy bad);

    @Override
    public String toString();
}
