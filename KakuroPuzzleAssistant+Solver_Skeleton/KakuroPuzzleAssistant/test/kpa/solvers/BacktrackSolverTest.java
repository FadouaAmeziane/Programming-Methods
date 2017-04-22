package kpa.solvers;

import java.util.Scanner;
import kpa.command.Command;
import kpa.model.KPuzzle;
import kpa.reasoning.Reasoner;
import static kpa.reasoning.ReasonerTest.PUZZLE;
import kpa.reasoning.EntryWithOneEmptyCell;
import kpa.reasoning.FixpointReasoner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for {@link BacktrackSolver}.
 *
 * @author wstomv
 */
public class BacktrackSolverTest {

    private KPuzzle puzzle;

    public BacktrackSolverTest() {
    }

    @Before
    public void setUp() {
        puzzle = new KPuzzle(new Scanner(PUZZLE), "Test");
    }

    /**
     * Test of solve method, of class BacktrackSolver.
     */
    @Test
    public void testSolveWithoutReasoner() {
        System.out.println("solve w/o reasoner");
        BacktrackSolver instance = new BacktrackSolver(puzzle, null);
        boolean expResult = true;
        System.out.println(puzzle.gridAsString());
        boolean result = instance.solve();
        System.out.println(puzzle.gridAsString());
        assertEquals("return value", expResult, result);
        assertTrue("puzzle solved", puzzle.isSolved());
        assertEquals("commands size", 4, instance.getCommands().size());
    }

    /**
     * Test of solve method, of class BacktrackSolver.
     */
    @Test
    public void testSolveWithSimpleReasoner() {
        System.out.println("solve with simple reasoner");
        Reasoner reasoner = new EntryWithOneEmptyCell(puzzle);
        BacktrackSolver instance = new BacktrackSolver(puzzle, reasoner);
        boolean expResult = true;
        System.out.println(puzzle.gridAsString());
        boolean result = instance.solve();
        System.out.println(puzzle.gridAsString());
        assertEquals("return value", expResult, result);
        assertTrue("puzzle solved", puzzle.isSolved());
        assertEquals("commands size", 5, instance.getCommands().size());
    }

    /**
     * Test of solve method, of class BacktrackSolver.
     */
    @Test
    public void testSolveWithFixpointReasoner() {
        System.out.println("solve with fixpoint");
        Reasoner reasoner = new EntryWithOneEmptyCell(puzzle);
        reasoner = new FixpointReasoner(puzzle, reasoner);
        BacktrackSolver instance = new BacktrackSolver(puzzle, reasoner);
        boolean expResult = true;
        System.out.println(puzzle.gridAsString());
        boolean result = instance.solve();
        System.out.println(puzzle.gridAsString());
        assertEquals("return value", expResult, result);
        assertTrue("puzzle solved", puzzle.isSolved());
        assertEquals("commands size", 3, instance.getCommands().size());
    }

}
