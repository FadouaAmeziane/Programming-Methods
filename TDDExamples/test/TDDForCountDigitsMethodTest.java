//# BEGIN SKELETON
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for countDigits method, of class TDDForCountDigitsMethod.
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 16.02.2017</b></font></p>
<!--//# END TODO -->
 */
// -----8<----- cut line -----8<-----
public class TDDForCountDigitsMethodTest {

    /** Subject Under Test.  Only static members are used. */
    private static final TDDForCountDigitsMethod SUT = null;

    /**
     * Invokes countDigits(n, r) and checks result against expectation.
     *
     * @param n  the number whose digits are counted
     * @param r  the radix
     * @param expResult  the expected result
     */
    private void checkCountDigits(long n, long r, int expResult) {
        System.out.println("countDigits(" + n + ", " + r + ")");
        int result = SUT.countDigits(n, r);
        assertEquals("result", expResult, result);
    }

//# BEGIN TODO Test cases
    /**
     * Checks whether illegal parameters n or r throw expected exception
     * 
     * @param n the number whose digits are counter
     * @param r the radix
     */
    private void checkParameters(long n, long r, Class expected){
        try {
            SUT.countDigits(n, r);
            fail("Parameter n = " + n + "should have thrown exception " + expected);
            fail("Parameter r = " + r + "should have thrown exception " + expected);
        } catch (Exception e) {
            assertTrue("type; " + e.getClass().getName()
                + " should be instance of " + expected,
                expected.isInstance(e));
            assertNotNull("message should not be empty", e.getMessage());
        }
    }
    /**
     * Test of countDigits method, of class TDDForCountDigitsMethod.
     * Boundary case: smallest n
     */
    @Test
    public void testCountDigits0(){
        checkCountDigits(0L, 10, 1);
    }
    /**
     * Test of countDigits method, of class TDDForCountDigitsMethod.
     * Boundary case: largest n with smallest result
     */
    @Test
    public void testCountDigits9() {
        checkCountDigits(9L, 10, 1);
    }

    // Test cases, phase 3
    /**
     * Test of countDigits method, of class TDDForCountDigitsMethod.
     * Boundary case: smallest n with result 2
     */
    @Test
    public void testCountDigits10() {
        checkCountDigits(10L, 10, 2);
    }

    // Test cases, phase 4: More systematic approach
    /**
     * Test of countDigits method, of class TDDForCountDigitsMethod.
     * Boundary cases: smallest and largest numbers with small results
     */
    @Test
    public void testCountDigitsSmall() {
        long n = 1L;
        for (int r = 0; r <= 5; ++ r) {
            // n == 10 ^ r
            checkCountDigits(n - 1, 10, Math.max(1, r));
            checkCountDigits(n, 10, r + 1);
            n *= 10;
        }
    }

    // Test cases, phase 5: Largest number
    /**
     * Test of countDigits method, of class TDDForCountDigitsMethod.
     * Boundary case: largest long value.
     * N.B. Overflow causes linear search to loop endlessly.
     */
    @Test(timeout = 1000)
    public void testCountDigitsMaxValue() {
        checkCountDigits(Long.MAX_VALUE, 10, 19);
    }
    /**
     * Test for radix = 2
     */
    @Test
    public void testCountDigitsRadix2(){
        checkCountDigits(10L, 2, 4);
    }
    /**
     * Test for radix = 2 Large value
     */
    @Test
    public void testCountDigitsRadix2LargeValue(){
        checkCountDigits(5000L, 2, 13);
    }
    /**
     * Test for radix = 2 MaxValue
     */
    @Test(timeout = 1000)
    public void testCountDigitsRadix2MaxValue(){
        checkCountDigits(Long.MAX_VALUE, 2, 63);
    }
    /**
     * Test for exception: n < 0
     */
    @Test
    public void testCountDigitsIllegalArgument1(){
        checkParameters(-1, 10, IllegalArgumentException.class);
    }
    /**
     * Test for exception: r < 2
     */
    @Test
    public void testCountDigitsIllegalArgument2(){
        checkParameters(10L, 1, IllegalArgumentException.class);
    }
    /**
     * Test for exception: n < 0 && r < 2
     */
    @Test
    public void testCountDigitsIllegalArgument3(){
        checkParameters(-1, 0, IllegalArgumentException.class);
    }
//# END TODO

}
//# END SKELETON
