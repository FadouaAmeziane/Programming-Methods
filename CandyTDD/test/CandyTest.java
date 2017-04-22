import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 *
<!--//# BEGIN TODO: Name, id, and date-->
<p><font color="red"><b>Replace this line</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line ----- 8< -----
public class CandyTest {

    final static Candy SUT = null; // to simplify method calls

    final static long MAXVALUE = 999999999999999999L;

    /**
     * Checks the result of SUT.divide(k, c).
     */
    private void check(long k, long c, boolean expected) {
        System.out.println("divide(" + k + ", " + c + ")");
        long result = SUT.divide(k, c);
        assertEquals("divide -> " + result, expected, 0 <= result);
        if (0 <= result) {
            assertTrue("range", result <= MAXVALUE);
            assertTrue("quotient", result * k == c);
        }
    }

    // Test cases

    /** The given example. */
    @Test
    public void testDivideGivenExample() {
        check(3, 15, true);
    }

//# BEGIN TODO: Additional test cases
    @Test
    public void testDivide1() {
        check(0, 0, true);
    }
    @Test
    public void testDivide2() {
        check(5, 17, false);
    }
    @Test
    public void testDivide3() {
        check(2, 0, true); 
    }
    @Test
    public void testDivide4() {
        check(0, 2, false);
    }
//# END TODO

}
