package model.state;

import model.BadBoy;

/**
 * @author laurent
 */
public class Nice implements State {

    @Override
    public void moreIrritate(BadBoy bad) {
        bad.setState(new MediumIrritate());
    }

    @Override
    public void lowerIrritate(BadBoy bad) {
    }

    @Override
    public String toString() {
        return "Nice";
    }

}
