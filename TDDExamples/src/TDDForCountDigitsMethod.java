//# BEGIN SKELETON
/**
 * Illustrates Test-Driven Development of a single method.
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 16.02.2017</b></font></p>
<!--//# END TODO -->
*/
// -----8<----- cut line -----8<-----
public class TDDForCountDigitsMethod {

    /**
     * Counts the digits of a number.
     * This concerns a non-negative integer, assumed to be
     * written in positional notation without leading zeroes.
     * Robust version.
     *
<!--//# BEGIN TODO Contract-->
<p><font color="red"><b>
* @param n  the number whose digits are counted
* @param r  the radix
* @return  the number of digits in {@code n}
* @throws IllegalArgumentException if {@code n < 0 || r < 2}
* @pre {@code 0 <= n && 2 <= r}
* @post {@code \result = (\min int k; 1 <= k; n < 10 ^ k) }</b></font></p>
<!--//# END TODO-->
     */
    public static int countDigits(long n, long r)
            throws IllegalArgumentException {
//# BEGIN TODO Implementation
        if(n < 0){
            throw new IllegalArgumentException(
                "TDDForCountDigitsMethod.countDigits.pre violated: n = " + n + "< 0");
        }
        if(r < 2){
            throw new IllegalArgumentException(
                "TDDForCountDigitsMethod.countDigits.pre violated: r = " + r + "< 2");
        }
        int result = 1;
        while(r <= n){
            n /= r;
            ++ result;
        }
        return result;
//# END TODO
    }

}
//# END SKELETON
