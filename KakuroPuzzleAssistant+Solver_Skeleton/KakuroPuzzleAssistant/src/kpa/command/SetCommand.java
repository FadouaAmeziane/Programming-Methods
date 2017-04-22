//# BEGIN SKELETON
package kpa.command;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kpa.model.KCell;

/**
 * The command to set the state of a cell.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 2.04.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class SetCommand extends GenericCommand<KCell> {

//# BEGIN TODO Representation of command state
    /** The command's parameter.*/
    private final int newState;
    
    /** Previous state of the receiver, for revert() */
    private int oldState;
//# END TODO

    /**
     * Constructs a set command for a given receiver and new state.
     *
     * @param receiver  the given receiver
     * @param newState  the new state
     */
    public SetCommand(final KCell receiver, final int newState) {
        super(receiver);
//# BEGIN TODO Initialize command state
        this.newState = newState;
//# END TODO
    }

//# BEGIN TODO Operations
    @Override
    public void execute() {
        super.execute();
        // save the old state of the receiver in the oldState
        oldState = receiver.getState();
        // set the state of the receiver to the new one
        receiver.setState(newState);
    }
    
    @Override
    public void revert() {
        super.revert();
        // set the state of the receiver to the old state
        receiver.setState(oldState);
    }
    @Override
    public Collection<KCell> getCells() {
        Set<KCell> cells = new HashSet<>();
        //add the receiver cell in the set
        cells.add(receiver);
        return cells;
    }
//# END TODO

}
//# END SKELETON
