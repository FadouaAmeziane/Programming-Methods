import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test cases for IntRelation, to be extended to obtain
 * concrete test cases for an extension of IntRelation.
 *
 * @author Tom Verhoeff (TU/e)
 */
/**
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 28.02.2017</b></font></p>
<!--//# END TODO -->
 */
// -----8<----- cut line -----8<-----
public abstract class IntRelationTestCases {

    /** Test fixture. */
    protected IntRelation instance;

    /**
     * Sets instance to a newly constructed relation of given extent.
     * (This is a kind of factory method; cf. Factory Method Design Pattern.)
     *
     * @param n   the given extent
     * @pre {@code 0 <= n}
     * @modifies {@code instance}
     * @post {@code instance.extent() == n && AF(instance) = [ ]}
     */
    protected abstract void setInstance(final int n);

    /** Tests the constructor with small extent values. */
    @Test
    public void testConstructor() {
        System.out.println("constructor(int)");
        for (int n = 0; n <= 3; ++ n) {
            setInstance(n);
            assertTrue("isRepOk()", instance.isRepOk());
        }
    }

    /** Tests the extent method with small relations. */
    @Test
    public void testExtent() {
        System.out.println("extent");
        for (int n = 0; n <= 3; ++ n) {
            setInstance(n);
            assertEquals("size", n, instance.extent());
            assertTrue("isRepOk()", instance.isRepOk());
        }
    }

    /**
     * Invokes areRelated(a, b) and checks the result.
     *
     * @param a  first element in pair
     * @param b  second element in pair
     * @param expResult  expected result
     */
    private void checkAreRelated(int a, int b, boolean expResult) {
        boolean result = instance.areRelated(a, b);
        assertEquals("areRelated(" + a + ", " + b + ")", expResult, result);
        assertTrue("isRepOk()", instance.isRepOk());
    }
    /**
     * Checks whether illegal parameters a and b throw expected exception
     * 
     * @param a
     * @param b
     */
    private void checkParameters1(int a, int b, Class expected){
        try {
            instance.areRelated(a, b);
            fail("Parameter n = " + a + " and " + b + "should have thrown exception " + expected);
        } catch (Exception e) {
            assertTrue("type; " + e.getClass().getName()
                + " should be instance of " + expected,
                expected.isInstance(e));
            assertNotNull("message should not be empty", e.getMessage());
        }
    }
    /**
     * Checks whether illegal parameters a and b throw expected exception
     * 
     * @param a
     * @param b
     */
    private void checkParameters2(int a, int b, Class expected){
        try {
            instance.add(a, b);
            fail("Parameter n = " + a + " and " + b + "should have thrown exception " + expected);
        } catch (Exception e) {
            assertTrue("type; " + e.getClass().getName()
                + " should be instance of " + expected,
                expected.isInstance(e));
            assertNotNull("message should not be empty", e.getMessage());
        }
    }
    /**
     * Checks whether illegal parameters a and b throw expected exception
     * 
     * @param a
     * @param b
     */
    private void checkParameters3(int a, int b, Class expected){
        try {
            instance.remove(a, b);
            fail("Parameter n = " + a + " and " + b + "should have thrown exception " + expected);
        } catch (Exception e) {
            assertTrue("type; " + e.getClass().getName()
                + " should be instance of " + expected,
                expected.isInstance(e));
            assertNotNull("message should not be empty", e.getMessage());
        }
    }

    /** Tests the areRelated method on empty relation. */
    @Test
    public void testAreRelated() {
        System.out.println("areRelated");
        setInstance(1);
        checkAreRelated(0, 0, false);
        setInstance(2);
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }

    /** Tests the add method. */
    @Test
    public void testAdd() {
        System.out.println("add");
        setInstance(2);
        instance.add(0, 1); // N.B. not a pair of equals
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        checkAreRelated(0, 0, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
        instance.add(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        checkAreRelated(0, 0, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }

    /** Tests the remove method. */
    @Test
    public void testRemove() {
        System.out.println("remove");
        setInstance(2);
        instance.remove(0, 1); // N.B. not a pair of equals
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
        instance.add(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        instance.remove(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }
    /**
     * Test for areRelated IllegalArgumentException
     */
    @Test
    public void testAreRelatedIllegalArgument1(){
        setInstance(2);
        checkParameters1(-1, 3, IllegalArgumentException.class);
    }
    /**
     * Test for add IllegalArgumentException
     */
    @Test
    public void testAddIllegalArgument1(){
        setInstance(2);
        checkParameters2(-1, 3, IllegalArgumentException.class);
    }
    /**
     * Test for remove IllegalArgumentException
     */
    @Test
    public void testRemoveIllegalArgument1(){
        setInstance(2);
        checkParameters3(-1, 3, IllegalArgumentException.class);
    }

}
