package cp.command;

import cp.model.Counter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Tests for class UndoRedo.
 *
 * @author Tom Verhoeff (TU/e, Eindhoven University of Technology)
 */
public class UndoRedoTest {

    /** The subject under test. */
    private UndoRedo instance;

    /** A command for testing. */
    private Command command;

    /** A counter for testing. */
    private Counter counter;

    /** Initializes the subject under test. */
    @Before
    public void setUp() {
        instance = new UndoRedo();
        counter = new Counter();
        command = new TestCommand();
    }

    /**
     * Test of canUndo method, of class UndoRedo.
     */
    @Test
    public void testCanUndo() {
        System.out.println("canUndo");
        boolean result = instance.canUndo();
        assertFalse("Result false when empty", result);

        command.execute();
        instance.did(command);
        result = instance.canUndo();
        assertTrue("Result when one command done", result);
    }

    /**
     * Test of canRedo method, of class UndoRedo.
     */
    @Test
    public void testCanRedo() {
        System.out.println("canRedo");
        boolean result = instance.canRedo();
        assertFalse("Result false when empty", result);

        command.execute();
        instance.did(command);
        instance.undo(true);
        result = instance.canRedo();
        assertTrue("Result when one command undone", result);
    }

    /**
     * Test of lastDone method, of class UndoRedo.
     */
    @Test
    public void testLastDone() {
        System.out.println("lastDone");
        instance.did(command);
        Command result = instance.lastDone();
        assertEquals("Result", command, result);
    }

    /**
     * Test of lastDone method, of class UndoRedo.
     */
    @Test
    public void testLastUndone() {
        System.out.println("lastUndone");
        instance.did(command);
        instance.undo(true);
        Command result = instance.lastUndone();
        assertEquals("Result", command, result);
    }

    /**
     * Test of lastDone method for exceptions, of class UndoRedo.
     */
    @Test
    public void testLastDoneExceptions() {
        System.out.println("lastDone exceptions");
        Class expected = IllegalStateException.class;
        try {
            instance.lastDone();
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Test of lastDone method for exceptions, of class UndoRedo.
     */
    @Test
    public void testLastUndoneExceptions() {
        System.out.println("lastUndone exceptions");
        Class expected = IllegalStateException.class;
        try {
            instance.lastUndone();
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Test of clear method, of class UndoRedo.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        for (int i = 0; i != 4; ++ i) {
            final Command command = new TestCommand();
            instance.did(command);
        }
        for (int i = 0; i != 2; ++ i) {
            instance.undo(true);
        }
        // both stacks are not empty (contain two commands)
        instance.clear();
        assertFalse("not canUndo()", instance.canUndo());
        assertFalse("not canRedo()", instance.canRedo());
    }

    /**
     * Test of did method, of class UndoRedo.
     */
    @Test
    public void testDidExecuted() {
        System.out.println("did, command already executed");
        command.execute();
        instance.did(command);
        assertTrue("canUndo()", instance.canUndo());
        assertFalse("not canRedo()", instance.canRedo());
        assertEquals("lastDone", command, instance.lastDone());
   }

    /**
     * Test of did method, of class UndoRedo.
     */
    @Test
    public void testDidExecutedAfterUndo() {
        System.out.println(
                "did, non-empty Redo stack");
        // set it up
        instance.did(new TestCommand());
        instance.undo(true);
        assertTrue("canRedo(), after did(), undo(true)", instance.canRedo());
        // Redo stack is not empty

        instance.did(command);
        assertTrue("canUndo()", instance.canUndo());
        assertFalse("not canRedo(), Redo stack cleared",
                instance.canRedo()); // Especially this!
        assertEquals("lastDone", command, instance.lastDone());
   }

    /**
     * Test of did method for exceptions, of class UndoRedo.
     */
    @Test
    public void testDidNotExecuted() {
        System.out.println("did, command not yet executed");
        instance.did(command);
        assertTrue("isExecuted", command.isExecuted());
        assertTrue("canUndo()", instance.canUndo());
        assertFalse("not canRedo()", instance.canRedo());
        assertEquals("lastDone", command, instance.lastDone());
   }

    /**
     * Calls and checks undo().
     *
     * @param redoable  parameter for {@code undo()}
     */
    private void checkUndo(final boolean redoable) {
        final StringBuilder trace = new StringBuilder();
        final Command command = new TestCommand() {
             @Override
             public void revert() {
                 super.revert();
                 trace.append("R");
             }
         };
        instance.did(command);
        instance.undo(redoable);
        assertFalse("not isExecuted", command.isExecuted());
        assertFalse("not canUndo", instance.canUndo());
        assertEquals("canRedo() after undo(" + redoable + ")",
                redoable, instance.canRedo());
        if (redoable) {
            assertEquals("lastUndone", command, instance.lastUndone());
        }
        assertEquals("Trace", "R", trace.toString());
    }

    /**
     * Test of undo method, of class UndoRedo.
     */
    @Test
    public void testUndoRedoable() {
        System.out.println("undo(true)");
        checkUndo(true);
    }

    /**
     * Test of undo method, of class UndoRedo.
     */
    @Test
    public void testUndoNotRedoable() {
        System.out.println("undo(false)");
        checkUndo(false);
    }

    /**
     * Test of Undo method for exceptions, of class UndoRedo.
     */
    @Test
    public void testUndoExceptions() {
        System.out.println("Undo exceptions");
        Class expected = IllegalStateException.class;
        try {
            instance.undo(true);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Test of redo method, of class UndoRedo.
     */
    @Test
    public void testRedo() {
        System.out.println("redo");
        final StringBuilder trace = new StringBuilder();
        final Command command = new TestCommand() {
             @Override
             public void execute() {
                 super.execute();
                 trace.append("E");
             }
         };
        instance.did(command);
        instance.undo(true);
        instance.redo();
        assertTrue("isExecuted", command.isExecuted());
        assertEquals("Trace", "EE", trace.toString());
        assertEquals("lastDone", command, instance.lastDone());
    }

    /**
     * Test of Undo method for exceptions, of class UndoRedo.
     */
    @Test
    public void testLastRedoExceptions() {
        System.out.println("Undo exceptions");
        Class expected = IllegalStateException.class;
        try {
            instance.redo();
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls and checks undoAll().
     *
     * @param redoable  parameter for {@code undo()}
     */
    private void checkUndoAll(final boolean redoable) {
        final StringBuilder trace = new StringBuilder();
        for (final String message : new String[] { "A", "B", "C" }) {
             final Command command = new TestCommand() {
                 @Override
                 public void execute() {
                     super.execute();
                     trace.append("+" + message);
                 }
                 @Override
                 public void revert() {
                     super.revert();
                     trace.append("-" + message);
                 }
             };
             instance.did(command);
        }
        String expResult = "+A+B+C";
        assertEquals("Trace before undoAll", expResult, trace.toString());

        instance.undoAll(redoable);

        assertFalse("not canUndo(), after undoAll", instance.canUndo());
        expResult += "-C-B-A";
        assertEquals("Trace after undoAll", expResult, trace.toString());

        if (redoable) {
            // check that they are redoable
            while (instance.canRedo()) {
                instance.redo();
            }
            expResult += "+A+B+C";
            assertEquals("Trace after redo", expResult, trace.toString());
        } else {
            assertFalse("not canRedo(), after undoAll(false)",
                    instance.canRedo());
        }
    }

    /**
     * Test of undoAll method, of class UndoRedo.
     */
    @Test
    public void testUndoAllRedoable() {
        System.out.println("undoAll(true)");
        checkUndoAll(true);
    }

    /**
     * Test of undo method, of class UndoRedo.
     */
    @Test
    public void testUndoAllNotRedoable() {
        System.out.println("undoAll(false)");
        checkUndoAll(false);
    }

    /**
     * Test of redoAll method, of class UndoRedo.
     */
    @Test
    public void testRedoAll() {
        System.out.println("redoAll");
        final StringBuilder trace = new StringBuilder();
        for (final String message : new String[] { "A", "B", "C" }) {
             final Command command = new TestCommand() {
                 @Override
                 public void execute() {
                     super.execute();
                     trace.append("+" + message);
                 }
                 @Override
                 public void revert() {
                     super.revert();
                     trace.append("-" + message);
                 }
             };
             instance.did(command);
        }
        instance.undoAll(true);
        String expResult = "+A+B+C-C-B-A";
        assertEquals("Trace after undo", expResult, trace.toString());

        instance.redoAll();

        assertFalse("not canRedo(), after redoAll", instance.canRedo());
        expResult += "+A+B+C";
        assertEquals("Trace after redoAll", expResult, trace.toString());
        // check that they are undoable
        while (instance.canUndo()) {
            instance.undo(true);
        }
        expResult += "-C-B-A";
        assertEquals("Trace after redoAll", expResult, trace.toString());
    }

    private class TestCommand extends Command {

        public TestCommand() {
            super(counter);
        }

    }

}
