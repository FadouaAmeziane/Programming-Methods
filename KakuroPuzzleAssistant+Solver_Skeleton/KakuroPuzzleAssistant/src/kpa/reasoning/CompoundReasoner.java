//# BEGIN SKELETON
package kpa.reasoning;

import kpa.model.KPuzzle;
import kpa.command.CompoundCommand;
import java.util.ArrayList;
import java.util.List;

/**
 * Applies multiple reasoners in sequence.
 * The sequence reflects the order in which reasoners were added.
 * Based on the Composite design pattern.
  *
 * @author Tom Verhoeff (Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Replace this line</b></font></p>
<!--//# END TODO-->
*/
public class CompoundReasoner extends Reasoner {

    /** The sequence of reasoners. */
    private final List<Reasoner> reasoners = new ArrayList<>();

    public CompoundReasoner(KPuzzle puzzle) {
        super(puzzle);
    }

    /**
     * Adds a reasoner.
     *
     * @param reasoner  reasoner to add
     * @pre {@code reasoner != null} and already set for {@code puzzle}
     * @throws IllegalArgumentException  if {@code strategy ! null ||
     *     strategy} is not for same puzzle
     */
    public void add(final Reasoner reasoner) {
        if (reasoner == null) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ".add().pre failed: reasoning == null");
        }
        reasoners.add(reasoner);
    }

    @Override
    public CompoundCommand apply() {

//# BEGIN TODO  Apply sequence of reasoners until first change
// Replace this line
//# END TODO

        return super.apply();
    }

}
//# END SKELETON
