package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javafx.geometry.Point2D;
import model.Door;

public class DoorTest {

    @Test
    public void test() {
    	/**
    	 * On teste un à un les 3 constructeurs de Door avec les get appropriés.
    	 */
        Door d = new Door("laporte1");
        assertTrue("Test Door(String) échoué", d.getPosX()==0
        		&& d.getPosY()==0 && d.getName().equals("laporte1"));
        
        d = new Door("laporte2", 4, 10);
        assertTrue("Test Door(String) échoué", d.getPosX()==4
        		&& d.getPosY()==10 && d.getName().equals("laporte2"));
        
        Point2D p = new Point2D(7, 5);
        d = new Door("laporte3", p);
        assertTrue("Test Door(String) échoué", d.getPosX()==7
        		&& d.getPosY()==5 && d.getName().equals("laporte3"));
    }
}
