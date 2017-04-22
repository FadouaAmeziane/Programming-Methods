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
 * Test cases for {@link EmptyCellReasoner}.
 *
 * @author wstomv
 */
public class EmptyCellReasonerTest {

    private KPuzzle puzzle;

    public EmptyCellReasonerTest() {
    }

    @Before
    public void setUp() {
        puzzle = new KPuzzle(new Scanner(PUZZLE), "Test");
    }

    /**
     * Test of applyToCell method, of class EmptyCellReasoner.
     */
    @Test
    public void testApplyToCell() {
        System.out.println("applyToCell");
        EmptyCellReasoner instance = new EmptyCellReasonerImpl(puzzle);
        KCell cell = puzzle.getCell(1, 1);
        CompoundCommand result = instance.applyToCell(cell);
        assertEquals("result.size()", 0, result.size());
        assertFalse("result.executed", result.isExecuted());
    }

    /**
     * Test of apply method, of class EmptyCellReasoner.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        EmptyCellReasoner instance = new EmptyCellReasonerImpl(puzzle);
        CompoundCommand result = instance.apply();
        assertEquals("result.size()", 0, result.size());
        assertTrue("result.executed", result.isExecuted());
    }

    public class EmptyCellReasonerImpl extends EmptyCellReasoner {

        public EmptyCellReasonerImpl(KPuzzle puzzle) {
            super(puzzle);
        }
    }

}
