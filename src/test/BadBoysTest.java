/**
 * 
 */
package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.geometry.Point2D;
import model.BadBoy;
import model.BadBoys;

/**
 * @author laurent
 *
 */
public class BadBoysTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/**
		 * On teste les constructeurs.
		 */
		BadBoys badboys = new BadBoys();
		ArrayList<BadBoy> bbs = badboys.getList();
		assertTrue("Test BadBoys() a échoué ", bbs.size() == 1 && bbs.get(0).getPosX() == 5 && bbs.get(0).getPosY() == 5);
		
		badboys = new BadBoys(5);
		bbs = badboys.getList();
		assertTrue("Test BadBoys(INT) a échoué ", badboys.getNumber() == 5);
		
		/**
		 * Puis les ajouts/retirements.
		 */
		badboys.addBadBoy(new Point2D(8, 7));
		BadBoy bb = bbs.get(badboys.getNumber()-1);
		assertTrue("Test addBadBoy(Point2D) a échoué", bb.getPosX()==8 && bb.getPosY() == 7);
		
		badboys.removeBadBoy(bb);
		for (BadBoy b : bbs) {
			assertTrue("Test removeBadBoy(BadBoy) a échoué", b != bb);
		}
		
		badboys.removeBadBoys(2);
		assertTrue("Test removeBadBoys(INT) a échoué ", badboys.getNumber() == 3);
		
		/**
		 * Puis le placement des méchants à certaines positions.
		 */
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		points.add(new Point2D(1, 2)); points.add(new Point2D(3, 4)); points.add(new Point2D(5, 6));
		badboys.setAllInitialPos(points);
		assertTrue("Test 1 setAllInitialPos a échoué ",
				bbs.get(0).getPosX() == 1 && bbs.get(0).getPosY() == 2 &&
				bbs.get(1).getPosX() == 3 && bbs.get(1).getPosY() == 4 &&
				bbs.get(2).getPosX() == 5 && bbs.get(2).getPosY() == 6);
		points = new ArrayList<Point2D>();
		points.add(new Point2D(12, 42));
		badboys.setAllInitialPos(points);
		assertTrue("Test 2 setAllInitialPos a échoué ",
				bbs.get(0).getPosX() == 1 && bbs.get(0).getPosY() == 2 &&
				bbs.get(1).getPosX() == 3 && bbs.get(1).getPosY() == 4 &&
				bbs.get(2).getPosX() == 5 && bbs.get(2).getPosY() == 6);
	}

}
