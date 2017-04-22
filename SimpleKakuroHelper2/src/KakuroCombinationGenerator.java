//# BEGIN SKELETON
import java.util.HashSet;
import java.util.Set;

/**
 * Observable generator of Kakuro combinations.
 *
 * @author Tom Verhoeff (TU/e)
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 26.03.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KakuroCombinationGenerator implements Generator<Set<Integer>> {

    /**
     * Largest number in a Kakuro combination, with {@code 0 <= maxNumber}.
     */
    private int maxNumber;

    /** The registered observer. */
    private GeneratorObserver<Set<Integer>> observer;

    /** The most recently generated object. */
    private Set<Integer> object;

    /**
     * Constructs a generator without observer.
     */
    public KakuroCombinationGenerator() {
        this.observer = null;
        this.object = null;
        this.maxNumber = 9; // default
    }

    @Override
    public void setObserver(GeneratorObserver<Set<Integer>> observer) {
        this.observer = observer;
    }

    @Override
    public Set<Integer> getObject() {
        return new HashSet<Integer>(object); // copy to avoid interference
    }

    /**
     * Sets largest number.
     *
     * @param maxNumber  largest number that may occur
     * @pre {@code 0 <= maxNumber}
     */
    public void setMaxNumber(final int maxNumber) {
        if (maxNumber < 0) {
            throw new IllegalArgumentException(
                    "setMaxNumber precondition violated: maxNumber = "
                    + maxNumber);
        }
        this.maxNumber = maxNumber;
    }

    /**
     * Gets largest number.
     *
     * @return  largest number that may occur
     */
    public int getMaxNumber() {
        return this.maxNumber;
    }

    /** Counts number of {@code generate(Set<Integer>, int, int, int)} calls. */
    public long count = 0;

    /**
     * Generates all combinations (modulo order of digits) of
     * n distinct non-zero digits with sum s,
     * in lexicographic order (NOT ROBUST).
     *
     * @param n  number of digits for extension
     * @param s  digit sum for extension
     * @pre   {@code 0 <= n}
     * @post  each (sorted) combination of
     *        {@code n} distinct non-zero digits with sum {@code s}
     *        has been reported to the registered observer exactly once,
     *        in lexicographic order
     */
    public void generate(int s, int n) {
        count = 0;
        object = new HashSet<Integer>();
        generate(object, s, n, 1);
    }

    /**
     * Generates all ways (modulo order of digits) in which a given combination
     * can be extended by n distinct non-zero digits at least k and with sum s,
     * in lexicographic order (NOT ROBUST).
     *
     * @param c  given combination to be extended
     * @param n  number of digits for extension
     * @param s  digit sum for extension
     * @param k  lower bound for digits in extension
     * @pre   {@code 0 <= n && && 1 <= k &&
     *        (\forall i; i : c; i < k)}
     * @modifies None
     * @post  each (sorted) way of extending {@code c} with
     *        {@code n} distinct non-zero digits at least {@code k} and
     *        at most {@code maxNumber}, with sum {@code s},
     *        has been reported to the registered observer exactly once,
     *        in lexicographic order
     * @bound {@code n} (upper bound on number of recursive calls)
     */
    private void generate(Set<Integer> c, int s, int n, int k) {
        ++ count;
//# BEGIN TODO Recursive implementation of generate(Set<Integer>, int, int, int)
        if (n == 0) {
            observer.objectGenerated(this);
        }
        else {
            for(int d = k; d <= getMaxNumber(); d++) {
                if(n == 1) {
                    if((s - d) == 0) {
                        c.add(d);
                        generate(c, s - d, n - 1, d + 1);
                        c.remove(d);
                    }
                }
                else {
                    c.add(d);
                    generate(c, s - d, n - 1, d + 1);
                    c.remove(d);
                }
            }
        }
//# END TODO
    }

}
//# END SKELETON
