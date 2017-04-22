//# BEGIN SKELETON
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Observer (listener) that calculates the intersection of all combinations,
 * or of their complements (the eliminated numbers);
 * that is, the set of numbers common to all generated combinations,
 * or missing in all generated combinations.
 *
 * @author Tom Verhoeff (TU/e)
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 26.03.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class Intersector implements GeneratorListener {

    /**
     * Whether to maintain the intersection of the combination complements,
     * rather than of the combinations themselves.
     */
    private boolean complement;

    /** Intersection so far. */
    private Set<Integer> intersection;

    /**
     * Constructs initialized Intersector.
     *
     * @param maxNumber  largest number that can occur
     * @param complement  whether to intersect complements
     */
    public Intersector(final int maxNumber, final boolean complement) {
        intersection = new HashSet<Integer>();
        for (int i = 1; i <= maxNumber; ++ i) {
            intersection.add(i);
        }
        this.complement = complement;
    }

    /**
     * Gets current intersection.
     *
     * @return  current intersection
     */
    public Set<Integer> getIntersection() {
        return intersection; // leaks representation; breaks encapsulation
        // alternative: return new HashSet(intersection);
    }

    @Override
    public void combinationGenerated(Set<Integer> combination) {
//# BEGIN TODO Implementation of combinationGenerated
        if(!complement) {
            intersection.retainAll(combination);
        }
        else {
            intersection.removeAll(combination);
        }
//# END TODO
    }

}
//# END SKELETON
