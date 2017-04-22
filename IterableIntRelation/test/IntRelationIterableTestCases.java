//# BEGIN SKELETON
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test cases for an {@link IntRelation} that implements
 * {@link Iterable<IntPair>}.  This class is to be extended to obtain
 * concrete test cases for an extension of {@link IntRelation}
 * that implements {@link Iterable<IntPair>}.
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 17.03.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public abstract class IntRelationIterableTestCases
        extends IntRelationTestCases {

    /** Additional test fixture: {@code instance} viewed as iterable. */
    protected Iterable<IntPair> iterable;

    /**
     * Sets {@code instance} and {@code iterable} to a newly constructed
     * iterable relation of given extent.
     * In test cases for iterators,
     * only {@code setIterable} must be called,
     * and not {@code setInstance}.
     * Afterwards, the constructed object can be used
     * through {@code instance} as an {@code IntRelation}, and
     * through {@code iterable} as an {@code Iterable<IntPair>}.
     *
     * @param n   extent
     * @post {@code instance} and {@code iterable} have been assigned
     *     the same object of an appropriate subtype of
     *     {@code IntRelation implements Iterable<IntPair>},
     *     with extent {@code n}
     */
    protected void setIterable(final int n) {
        setInstance(n);
        iterable = ((Iterable<IntPair>) instance);
    }

//# BEGIN TODO Test cases for the iterator
    @Test
    public void testIterator() {
        System.out.println("Iterator");
        setIterable(1);
        Iterator<IntPair> iter = iterable.iterator();
        assertFalse("Not empty collection", iter.hasNext());
        instance.add(0,0);
        iter = iterable.iterator();
        assertTrue("No next", iter.hasNext());
        assertTrue("No next", iter.hasNext());
        assertTrue("No next", iter.hasNext());
        IntPair aux = iter.next();
        assertFalse("Not empty", iter.hasNext());
    }
    @Test
    public void testExceptionIterator() {
        System.out.println("Iter exception");
        setIterable(1);
        Iterator<IntPair> iter = iterable.iterator();
        Class expected = NoSuchElementException.class;
        try {
            IntPair pair = iter.next();
            fail("should have thrown " + expected);
        } catch (Exception e) {
            System.out.println("  " + e.toString());
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }
//# END TODO

}
//# END SKELETON
