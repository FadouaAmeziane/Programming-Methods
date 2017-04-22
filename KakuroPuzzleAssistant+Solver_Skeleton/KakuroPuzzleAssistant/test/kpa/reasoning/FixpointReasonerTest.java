package kpa.reasoning;

import java.util.Scanner;
import kpa.command.CompoundCommand;
import kpa.model.KCell;
import kpa.model.KPuzzle;
import static kpa.reasoning.ReasonerTest.PUZZLE;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for {@link FixpointReasoner}.
 *
 * @author wstomv
 */
public class FixpointReasonerTest {

    private KPuzzle puzzle;

    public FixpointReasonerTest() {
    }

    @Before
    public void setUp() {
        puzzle = new KPuzzle(new Scanner(PUZZLE), "Test");
    }

    /**
     * Test of apply method, of class FixpointReasoner.
     */
    @Test
    public void testApplyEmpty() {
        System.out.println("apply empty");
        Reasoner reasoner = new EntryWithOneEmptyCell(puzzle);
        FixpointReasoner instance = new FixpointReasoner(puzzle, reasoner);
        System.out.println(puzzle.gridAsString());
        CompoundCommand result = instance.apply();
        System.out.println(puzzle.gridAsString());
        assertEquals("result.size()", 0, result.size());
        assertTrue("result.executed", result.isExecuted());
        assertFalse("puzzle solved", puzzle.isSolved());
    }

    /**
     * Test of apply method, of class FixpointReasoner.
     */
    @Test
    public void testApplySolved() {
        System.out.println("apply solved");
        KCell cell11 = puzzle.getCell(1, 1);
        cell11.setState(1);
        Reasoner reasoner = new EntryWithOneEmptyCell(puzzle);
        FixpointReasoner instance = new FixpointReasoner(puzzle, reasoner);
        System.out.println(puzzle.gridAsString());
        CompoundCommand result = instance.apply();
        System.out.println(puzzle.gridAsString());
        assertEquals("result.size()", 3, result.size());
        assertTrue("result.executed", result.isExecuted());
        assertTrue("puzzle solved", puzzle.isSolved());
    }

    /**
     * Test of apply method, of class FixpointReasoner.
     */
    @Test
    public void testApplyUnsolvable1() {
        System.out.println("apply immediately unsolvable");
        KCell cell = puzzle.getCell(2, 1);
        cell.setState(2);
        Reasoner reasoner = new EntryWithOneEmptyCell(puzzle);
        FixpointReasoner instance = new FixpointReasoner(puzzle, reasoner);
        System.out.println(puzzle.gridAsString());
        CompoundCommand result = instance.apply();
        System.out.println(puzzle.gridAsString());
        assertNull("result null", result);
        assertFalse("puzzle not solved", puzzle.isSolved());
        assertTrue("puzzle unchanged", puzzle.getStateCount(KCell.EMPTY) == 3);
    }

    /**
     * Test of apply method, of class FixpointReasoner.
     */
    @Test
    public void testApplyUnsolvable2() {
        System.out.println("apply indirectly unsolvable");
        KCell cell = puzzle.getCell(1, 2);
        cell.setState(1);
        Reasoner reasoner = new EntryWithOneEmptyCell(puzzle);
        FixpointReasoner instance = new FixpointReasoner(puzzle, reasoner);
        System.out.println(puzzle.gridAsString());
        CompoundCommand result = instance.apply();
        System.out.println(puzzle.gridAsString());
        assertNull("result null", result);
        assertFalse("puzzle not solved", puzzle.isSolved());
        assertTrue("puzzle unchanged", puzzle.getStateCount(KCell.EMPTY) == 3);
    }

}
