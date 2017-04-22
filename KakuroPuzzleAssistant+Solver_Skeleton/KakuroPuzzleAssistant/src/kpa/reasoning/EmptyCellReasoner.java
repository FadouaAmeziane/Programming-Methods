//# BEGIN SKELETON
package kpa.reasoning;

import kpa.command.Command;
import kpa.command.CompoundCommand;
import kpa.model.KCell;
import kpa.model.KPuzzle;

/**
 * Abstract template class for reasoners based on empty cells,
 * using the Template Method design pattern.
 * The template method is {@code apply()}, and
 * the overridable hook method is {@code applyToCell()}.
 * It repeatedly looks for an empty cell and then applies
 * {@code applyToCell()}.
 * It stops on the first cell where it either finds a forced command
 * or a contradiction.
 * If no such cell is found, then it returns an empty list.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 2.04.2017</b></font></p>
<!--//# END TODO-->
 */
public abstract class EmptyCellReasoner extends Reasoner {

    public EmptyCellReasoner(KPuzzle puzzle) {
        super(puzzle);
    }

    @Override
    public CompoundCommand apply() {
        final CompoundCommand result = super.apply();

//# BEGIN TODO Apply reasoner to all empty cells, execute and return command
        // iterate over all empty cells
        for (KCell cell: puzzle.getCells()) {
            // if we found an empty cell
            if (cell.isEmpty()) {
                // get a command from applyToCell
                CompoundCommand command = applyToCell(cell);
                // if the command is null that means the puzzle is not solveable
                // so we return null
                if (command == null) {
                    return null;
                }
                // else if command is not empty we have found a good reasoning
                // so we can execute it and add it to the result
                // also we break from the for loop
                else if (command.size() > 0) {
                    command.execute();
                    result.addAll(command);
                    break;
                }
            }
        }
//# END TODO
        // return the result
        return result;
    }

    /**
     * Hook method to handle a single cell.
     * See {@link Reasoner#apply()} for what it returns when.
     * However, if a command is returned, it will not have been executed.
     *
     * @param cell  the empty cell
     * @throws NullPointerException  if {@code cell == null}
     * @return command to apply, or null if not applicable
     * @pre {@code cell != null && cell.isEmpty()}
     * @post {@code
     *      (\result == null  ==>  puzzle is not solvable and not modified) &&
     *      (\result.size() > 0  ==>  ! \result.isExecuted() && puzzle.isValid())}
     */
    CompoundCommand applyToCell(final KCell cell)
            throws NullPointerException {
        assert cell.isEmpty() :
                "cell at location " + cell.getLocation() + " not empty";
        return new CompoundCommand(false);
    }

}
//# END SKELETON
