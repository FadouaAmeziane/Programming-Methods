package cp.command;

import cp.model.Counter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for class SetCommand.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class SetCommandTest {

    /**
     * Test of execute method, of class SetCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        final Counter counter = new Counter();
        final int newCount = 3;
        SetCommand instance = new SetCommand(counter, newCount);
        instance.execute();
        assertEquals("After execute()", newCount, counter.getCount());
    }

    /**
     * Test of revert method, of class SetCommand.
     */
    @Test
    public void testRevert() {
        System.out.println("revert");
        final Counter counter = new Counter();
        counter.increment();
        final int expected = counter.getCount();
        final int newCount = 3;
        SetCommand instance = new SetCommand(counter, newCount);
        instance.execute();
        instance.revert();
        assertEquals("After execute() and revert()",
                expected, counter.getCount());
    }
    
}
