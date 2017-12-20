package model.state;

import model.BadBoy;

/**
 * @author laurent
 */
public class VeryIrritate implements State {

    @Override
    public void moreIrritate(BadBoy bad) {
    }

    @Override
    public void lowerIrritate(BadBoy bad) {
        bad.setState(new MediumIrritate());
    }

    @Override
    public String toString() {
        return "Irritate";
    }

}
