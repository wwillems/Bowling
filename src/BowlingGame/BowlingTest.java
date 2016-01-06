package BowlingGame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.model.EachTestNotifier;
import org.omg.IOP.ExceptionDetailMessage;

import static org.junit.Assert.assertEquals;

/**
 * Created by williamwillems on 06/01/16.
 */
public class BowlingTest {

    private Game g;

    private void rollMany(int n, int pins) {
        for (int i = 0; i< n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(17,0);
        assertEquals(16, g.score());
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }
}
