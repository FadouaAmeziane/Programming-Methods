package kpa.reasoning;

import java.util.Scanner;
import kpa.command.CompoundCommand;
import kpa.model.KPuzzle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for {@link Reasoner}.
 *
 * @author wstomv
 */
public class ReasonerTest {

    public final static String PUZZLE =
            "a 1 - 3 2\nb 1 - 7 2\na 1 | 4 2\na 2 | 6 2\n";

    /** Puzzle for testing. */
    private KPuzzle puzzle;

    public ReasonerTest() {
        puzzle = new KPuzzle(new Scanner(PUZZLE), "Test");
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of apply method, of class Reasoner.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        Reasoner instance = new Reasoner(puzzle);
        CompoundCommand result = instance.apply();
        assertEquals("result.size()", 0, result.size());
        assertTrue("result.executed", result.isExecuted());
    }

}
