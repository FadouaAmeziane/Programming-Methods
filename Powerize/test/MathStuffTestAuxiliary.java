//# BEGIN SKELETON
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test cases for auxiliary methods in {@code MathStuff}.
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 18.02.2017</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public class MathStuffTestAuxiliary {

//# BEGIN TODO Test cases for auxiliary functions
    List<MathStuff.Power> expResult = new ArrayList<>();
    /**
     * Invokes factorize(n) and checks for expected result.
     *
     * @param n  number
     * @param expResult  expected list
     * @pre {@code 2 <= n}
     */
    private void checkFactorize(int n) {
        System.out.println("factorize(" + n + ")");
        List<MathStuff.Power> result = MathStuff.factorize(n);
        for(int i = 0; i < result.size(); i++){
            assertEquals("base", expResult.get(i).base, result.get(i).base);
            assertEquals("exponent", expResult.get(i).exponent, result.get(i).exponent);
        }
    }
    /**
     * Invokes gcd(a,b) and checks for expected result
     * 
     * @param a number
     * @param b number
     * @param exp expected result
     * @pre {@code 0 < a && 0 < b}
     */
    private void checkGcd(long a, long b, long exp){
        System.out.println("gcd(" + a + ", " + b + ")");
        long result = MathStuff.gcd(a, b);
        assertEquals("result", exp, result);
    }
    
    // Test cases for factorize(int)
    // test for boudary case n = 2
    @Test
    public void factorizeTest1(){
        expResult.add(new MathStuff.Power(2, 1));
        checkFactorize(2);
    }
    
    // test for n = 10
    @Test
    public void factorizeTest2(){
        expResult.add(new MathStuff.Power(2, 1));
        expResult.add(new MathStuff.Power(5, 1));
        checkFactorize(10);
    }
    
    // test for n = 8
    @Test
    public void factorizeTest3(){
        expResult.add(new MathStuff.Power(2, 3));
        checkFactorize(8);
    }
    
    // test for n = 100
    @Test
    public void factorizeTest4(){
        expResult.add(new MathStuff.Power(2, 2));
        expResult.add(new MathStuff.Power(5, 2));
        checkFactorize(100);
    }
    
    // test for n = 600
    @Test
    public void factorizeTest5(){
        expResult.add(new MathStuff.Power(2, 3));
        expResult.add(new MathStuff.Power(3, 1));
        expResult.add(new MathStuff.Power(5, 2));
        checkFactorize(600);
    }
    
    // Test cases for gcd(a,b)
    
    @Test
    public void gcdTest1(){
        checkGcd(1, 1, 1);
    }
    @Test
    public void gcdTest2(){
        checkGcd(10, 20, 10);
    }
    @Test
    public void gcdTest3(){
        checkGcd(13, 1, 1);
    }
    @Test
    public void gcdTest4(){
        checkGcd(17, 19, 1);
    }
    @Test
    public void gcdTest5(){
        checkGcd(64, 96, 32);
    }
    @Test
    public void gcdTest6(){
        checkGcd(21680680, 12, 4);
    }
//# END TODO

}
//# END SKELETON
