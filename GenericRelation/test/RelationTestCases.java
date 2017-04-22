//# BEGIN SKELETON
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Abstract test cases for {@link Relation}, to be extended to obtain
 * concrete test cases for an implementation of {@link Relation}.
 * Here we take {@code A = String} and {@code B = Integer}.
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 17.03.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public abstract class RelationTestCases {

    /** Test fixture. */
    protected Relation<String, Integer> instance;

    /**
     * Sets instance to a newly constructed relation.
     * Cf. Factory Method design pattern.
     */
    protected abstract void setInstance();

    @Before
    public void setUp() {
        setInstance();
    }
    
    /**
     * Invokes areRelated(a, b) and checks the result.
     *
     * @param a  first element in pair
     * @param b  second element in pair
     * @param expResult  expected result
     */
    private void checkAreRelated(String a, Integer b, boolean expected) {
        boolean result = instance.areRelated(a, b);
        assertEquals("areRelated(" + a + ", " + b + ")", expected, result);
        assertTrue("isRepOk()", instance.isRepOk());
    }

//# BEGIN TODO Test cases
    //Test the add method
    @Test
    public void testAdd() {
        System.out.println("add");
        setUp();
        assertTrue("IsRepOk()", instance.isRepOk());
        
        checkAreRelated("a", 10, false);
        instance.add("a", 10);
        checkAreRelated("a", 10, true);
        checkAreRelated("a", 20, false);
        instance.add("a", 20);
        checkAreRelated("a", 20, true);
    }
    //Test the remove method
    @Test
    public void testRemove() {
        System.out.println("remove");
        setUp();
        assertTrue("IsRepOk()", instance.isRepOk());
        
        checkAreRelated("a", 10, false);
        instance.add("a", 10);
        checkAreRelated("a", 10, true);
        instance.remove("a", 10);
        checkAreRelated("a", 10, false);
        instance.add("a", 10);
        checkAreRelated("a", 10, true);
        checkAreRelated("a", 20, false);
        instance.add("a", 20);
        checkAreRelated("a", 20, true);
        instance.remove("a", 20);
        checkAreRelated("a", 20, false);
        instance.remove("a", 10);
        checkAreRelated("a", 10, false);
    }
    //Test the relatedToFirst method
    @Test
    public void testRelatedToFirst() {
        System.out.println("relatedToFirst");
        setUp();
        assertTrue("IsRepOk()", instance.isRepOk());
        checkAreRelated("a", 10, false);
        instance.add("a", 10);
        checkAreRelated("a", 10, true);
        checkAreRelated("a", 20, false);
        instance.add("a", 20);
        checkAreRelated("a", 20, true);
        checkAreRelated("a", 30, false);
        instance.add("a", 30);
        checkAreRelated("a", 30, true);
        
        Set<Integer> expected = new HashSet<>();
        expected.add(10);
        expected.add(20);
        expected.add(30);
        Set<Integer> result = (HashSet<Integer>) instance.relatedToFirst("a");
        assertEquals("relatedToFirst()", expected, result);
    }
    // Test the iterator method
    @Test
    public void testIterator() {
        System.out.println("Iterator");
        setUp();
        Iterator<Pair<String, Integer>> iter = instance.iterator();
        assertFalse("Not empty collection", iter.hasNext());
        instance.add("a", 10);
        iter = instance.iterator();
        assertTrue("No next", iter.hasNext());
        assertTrue("No next", iter.hasNext());
        assertTrue("No next", iter.hasNext());
        Pair<String, Integer> aux = iter.next();
        assertFalse("Not empty", iter.hasNext());
    }
    // Test NoSuchElementException iterator
    @Test
    public void testExceptionIterator() {
        System.out.println("Iter exception");
        setUp();
        Iterator<Pair<String, Integer>> iter = instance.iterator();
        Class expected = NoSuchElementException.class;
        try {
            Pair<String, Integer> pair = iter.next();
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
    //Test NoSuchElementException remove method
    @Test
    public void testExceptionRemove1() {
        System.out.println("remove exception1");
        setUp();
        Class expected = NoSuchElementException.class;
        try {
            instance.remove("a", 10);
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
    //Test NoSuchElementException remove method
    @Test
    public void testExceptionRemove2() {
        System.out.println("remove exception2");
        setUp();
        instance.add("a", 10);
        Class expected = NoSuchElementException.class;
        try {
            instance.remove("a", 20);
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
    //Test NoSuchElementException relatedToFirst method
    @Test
    public void testExceptionRelatedToFirst() {
        System.out.println("relatedToFirst exception");
        setUp();
        Class expected = NoSuchElementException.class;
        try {
            instance.relatedToFirst("a");
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
