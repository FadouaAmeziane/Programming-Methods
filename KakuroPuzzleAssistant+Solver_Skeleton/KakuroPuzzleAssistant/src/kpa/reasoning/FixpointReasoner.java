//# BEGIN SKELETON
package kpa.reasoning;

import kpa.command.CompoundCommand;
import kpa.model.KPuzzle;

/**
 * A reasoner that repeatedly applies a given reasoner
 * until the least fixed point is reached (a closure operation).
 * That is, the reasoner is repeated until either there is no further change,
 * or until an invalid state is reached,
 * in which case all previous changes are reverted.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 2.04.2017</b></font></p>
<!--//# END TODO-->
*/
public class FixpointReasoner extends ReasonerDecorator {

    public FixpointReasoner(KPuzzle puzzle, Reasoner reasoner) {
        super(puzzle, reasoner);
    }

    @Override
    public CompoundCommand apply() {
        final CompoundCommand result = super.apply();

//# BEGIN TODO repeatedly apply reasoner until no change occurs
        // while the puzzle is valid
        while (puzzle.isValid()) {
            // get the compound command from the reasoner
            CompoundCommand command = reasoner.apply();
            // if the command is null then the puzzle is unsolvable
            // so we revert every change and return null
            if(command == null) {
                result.revert();
                return null;
            }
            // if the command size is 0 then there can be no further change
            // so we break from the for loop
            else if (command.size() == 0) {
                break;
            }
            // else we add the command to the final result
            else {
                result.addAll(command);
            }
        }
//# END TODO
        // and return the result
        return result;
    }

}
//# END SKELETON
