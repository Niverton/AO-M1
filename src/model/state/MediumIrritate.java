package model.state;

import model.BadBoy;

/**
 * @author laurent
 */
public class MediumIrritate implements State {

    @Override
    public void moreIrritate(BadBoy bad) {
        bad.setState(new VeryIrritate());
    }

    @Override
    public void lowerIrritate(BadBoy bad) {
        bad.setState(new Nice());
    }

    /**
     * @return l'etat courrant.
     */
    public String toString() {
        return "Medium";
    }

}
