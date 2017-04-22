//# BEGIN SKELETON
import java.util.ArrayList;
import java.util.List;

/**
 * Library with static mathematical functions.
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 18.02.2017</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public abstract class MathStuff {

    /**
     * Returns exponentiation, taking care of overflow.
     *
     * @param a  the base
     * @param b  the exponent
     * @pre {@code 0 <= a && 0 <= b}
     * @return {@code a ^ b} if {@code a ^ b <= Integer.MAX_VALUE}
     *      else {@code Long.MAX_VALUE}
     * @throws IllegalArgumentException  if precondition violated
     */
    public static long power(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("power: negative argument");
        }
        // 0 <= a && 0 <= b
        long x = a; // see invariant
        int k = b; // see invariant
        long result = 1L; // see invariant

        // invariant: 0 <= k <= b && result * x^k == a^b
        while (k != 0) {
            if (k % 2 == 0) { // even exponent
                if (x <= Integer.MAX_VALUE) {
                    x *= x;
                } else {
                    x = Long.MAX_VALUE;
                }
                k /= 2;
            } else { // odd exponent
                if (result <= Integer.MAX_VALUE && x <= Integer.MAX_VALUE) {
                    result *= x;
                } else {
                    result = Long.MAX_VALUE;
                }
                k -= 1;
            }
            // invariant holds again, k has decreased
        }
        // k == 0, hence result == a^b

        if (result > Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return result;
    }

    /**
     * Record containing a base and an exponent.
     *
     * @inv {@code 0 <= base && 0 <= exponent}
     */
    public static class Power { // BEGIN RECORD TYPE

        /** The base. */
        public int base;

        /** The exponent. */
        public int exponent;

        /**
         * Constructs a Power with given base and exponent.
         *
         * @param base  the base
         * @param exponent  the exponent
         * @pre {@code 0 <= base && 0 <= exponent}
         * @post {@code \result.base == base && \result.exponent == exponent}
         */
        public Power(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

    } // END RECORD TYPE

    /**
     * Returns exponentiation.
     *
     * @param p  the base and exponent
     * @pre {@code p != null}
     * @return {@code power(p.base, p.exponent)}
     * @throws IllegalArgumentException  if precondition violated
     */
    public static long power(Power p) throws IllegalArgumentException {
        return power(p.base, p.exponent);
    }

    /**
     * Writes a number as a power with maximal exponent.
     *
     * @param n  the number to 'powerize'
     * @return  power decomposition of {@code n} with maximal exponent
     * @throws IllegalArgumentException  if precondition violated
     * @pre {@code 2 <= n}
     * @post {@code n == power(\result) &&
     *     (\forall int b, int e;
     *      2 <= b && 1 <= e && n == b ^ e;
     *      e <= \result.exponent)}
     */
    public static Power powerize(int n) throws IllegalArgumentException {
//# BEGIN TODO Implementation of powerize
        if(n < 2){
            throw new IllegalArgumentException(
                "MathStuff.powerize.pre violated: n = " + n + "< 2");
        }
        List<Power> factorization = factorize(n);
        long gcd = factorization.get(0).exponent;
        for(int i = 1; i < factorization.size(); i++){
            gcd = gcd(gcd, factorization.get(i).exponent);
        }
        long base = 1;
        for(int i = 0; i < factorization.size(); i++){
            factorization.get(i).exponent = factorization.get(i).exponent / (int)gcd;
            base = base * power(factorization.get(i));
        }
        Power result = new Power((int)base, (int)gcd);
        return result;
//# END TODO
    }

//# BEGIN TODO Contracts and implementations of auxiliary functions.
    /**
     * Factorizes a number in prime factors
     * 
     * @param number the number to factorize
     * @return array list of Powers with the prime factorization on n
     * @pre {@code 2 <= n}
     * @post {@code \forall i; \result.has(i); n == (\product power(\result(i))) }
     */
    public static List<Power> factorize(int number){
        int n = number;
        List<Power> factors = new ArrayList<>();
        for(int i = 2; i <= n / i; i++){
            int exponent = 0;
            while(n % i == 0){
                exponent++;
                n /= i;
            }
            if(exponent != 0){
                factors.add(new Power(i,exponent));
            }
        }
        if(n > 1){
            factors.add(new Power(n, 1));
        }
        return factors;
    }
    
    /** Returns the greatest common divisor of a and b.
     * 
     * @param a first number
     * @param b second number
     * @pre {@code 0 < a && 0 < b}
     * @return {@code \old(\max c; c divides a && c divides b; c)}
     */
    public static long gcd(long a, long b){
        while(a != 0 && b != 0){
            if(a > b){
                a = a % b;
            }
            else{
                b = b % a;
            }
        }
        return a + b;
    }
//# END TODO

}
//# END SKELETON
