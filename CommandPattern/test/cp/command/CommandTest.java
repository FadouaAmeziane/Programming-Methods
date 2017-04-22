package cp.command;

import cp.model.Counter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class Command.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class CommandTest {

    /**
     * Test of constructor method for exceptions, of class Command.
     */
    @Test
    public void testCommand() {
        System.out.println("Command(Counter)");
        try {
            Command instance = new Command(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected NullPointerException, but got " + e);
        }
    }

    /**
     * Test of execute method for exceptions, of class Command.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Command instance = new Command(new Counter());
        instance.execute();
        try {
            instance.execute();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected IllegalStateException, but got " + e);
        }
    }

    /**
     * Test of revert method for exceptions, of class Command.
     */
    @Test
    public void testRevert1() {
        System.out.println("revert");
        Command instance = new Command(new Counter());
        try {
            instance.revert();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected IllegalStateException, but got " + e);
        }
    }

    /**
     * Test of revert method for exceptions, of class Command.
     */
    @Test
    public void testRevert2() {
        System.out.println("revert");
        Command instance = new Command(new Counter());
        instance.execute();
        instance.revert();
        try {
            instance.revert();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Expected IllegalStateException, but got " + e);
        }
    }
    
}
