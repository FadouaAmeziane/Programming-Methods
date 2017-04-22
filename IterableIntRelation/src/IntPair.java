/**
 * A record type to hold a related pair of integers.
 * This is used by iterators over an {@link IntRelation}.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class IntPair { // BEGIN RECORD TYPE

    /** First element of pair. */
    public int a;

    /** Second element of pair. */
    public int b;

    /**
     * Constructs a default pair.
     */
    public IntPair() {
    }

    /**
     * Constructs a pair for two given integers.
     *
     * @param a  first element of pair
     * @param b  second element of pair
     */
    public IntPair(final int a, final int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

} // END RECORD TYPE
