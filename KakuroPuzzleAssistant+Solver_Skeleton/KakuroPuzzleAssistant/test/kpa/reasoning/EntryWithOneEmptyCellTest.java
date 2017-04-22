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
 * Test cases for {@link EntryWithOneEmptyCell}.
 *
 * @author wstomv
 */
public class EntryWithOneEmptyCellTest {

    private KPuzzle puzzle;

    public EntryWithOneEmptyCellTest() {
    }

    @Before
    public void setUp() {
        puzzle = new KPuzzle(new Scanner(PUZZLE), "Test");
        System.out.println(puzzle);
        System.out.println(puzzle.gridAsString());
    }

    /**
     * Test of applyToCell method, of class EntryWithOneEmptyCell.
     */
    @Test
    public void testApplyToCell() {
        System.out.println("applyToCell");
        KCell cell11 = puzzle.getCell(1, 1);
        cell11.setState(1);
        KCell cell12 = puzzle.getCell(1, 2);
        EntryWithOneEmptyCell instance = new EntryWithOneEmptyCell(puzzle);
        System.out.println(puzzle.gridAsString());
        CompoundCommand result = instance.applyToCell(cell12);
        System.out.println(puzzle.gridAsString());
        assertEquals("result.size()", 1, result.size());
        assertFalse("result.executed", result.isExecuted());
        assertEquals("cell 1, 1 state", 1, cell11.getState());
        assertEquals("cell 1, 2 state", KCell.EMPTY, cell12.getState());
    }

    /**
     * Test of apply method, of class EntryWithOneEmptyCell.
     */
    @Test
    public void testApply() {
        System.out.println("apply");
        KCell cell11 = puzzle.getCell(1, 1);
        cell11.setState(1);
        KCell cell12 = puzzle.getCell(1, 2);
        EntryWithOneEmptyCell instance = new EntryWithOneEmptyCell(puzzle);
        System.out.println(puzzle.gridAsString());
        CompoundCommand result = instance.apply();
        System.out.println(puzzle.gridAsString());
        assertEquals("result.size()", 1, result.size());
        assertTrue("result.executed", result.isExecuted());
        assertEquals("cell 1, 1 state", 1, cell11.getState());
        assertEquals("new cell 1, 2 state", 2, cell12.getState());
    }

}
