//# BEGIN SKELETON
package kpa.solvers;

import kpa.command.Command;
import kpa.command.CompoundCommand;
import kpa.command.SetCommand;
import kpa.model.KCell;
import kpa.model.KPuzzle;
import kpa.model.Location;
import kpa.reasoning.Reasoner;

/**
 * A simple recursive backtrack solver for Kakuro Puzzles.
 * It uses puzzle.getMinNumber() and puzzle.getMaxNumber()
 * to obtain the range of `digits' to try in an empty cell.
 * <p>
 One reasoner strategy can be injected via the constructor.
 If null, it will be ignored; otherwise, it will be invoked
 before looking for an empty cell and trying all possible `digits'.
 <p>
 * It makes sense for client code to supply a fixpoint strategy.
 *
 * @author Tom Verhoeff (Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 2.04.2017</b></font></p>
<!--//# END TODO-->
 */
public class BacktrackSolver extends AbstractSolver {

    /** The strategy to apply before speculating; null if no reasoner. */
    protected Reasoner reasoner;
    
    /* Rep. invariant:
     *  reasoner != null ==> reasoner.puzzle == this.puzzle
     */

    public BacktrackSolver(KPuzzle puzzle, final Reasoner reasoner) {
        super(puzzle);
        this.reasoner = reasoner;
    }
    
//# BEGIN TODO  Auxiliary methods
    /**
     * Returns this location if the cell in this location is empty
     * or the next empty location in the grid.
     * If we reached the end of the grid then it means there is
     * no empty location so we return null.
     * 
     * @param location the current location of the solver
     * @return {@code location} 
     */
    private Location getNextEmptyLocation(Location location) {
        // get the row index of this location
        int rowIndex = location.getRow();
        
        // get the column index of the location
        int colIndex = location.getColumn();
        
        // if this location is empty then we return it
        if (puzzle.getCell(rowIndex, colIndex).isEmpty()) {
            return location;
        }
        
        /** 
         * if we reached the end of the grid that means we found
         * no empty location so we return null
         */
        if (rowIndex == (puzzle.getRowCount() - 1) && colIndex == (puzzle.getColumnCount() - 1)) {
            return null;
        }
        /**
         * if we reached the end of the row, we increment the rowIndex
         * and reset the colIndex to 0
         */
        if (colIndex == (puzzle.getColumnCount() - 1)) {
            rowIndex++;
            colIndex = 0;
        }
        // else we just increment the colIndex
        else {
            colIndex++;
        }
        /**
         * if this next location in the grid is empty we can return it
         * else get another one by using recursion with the parameter as
         * the current location in the grid
         */
        if (puzzle.getCell(rowIndex, colIndex).isEmpty()) {
            return new Location(rowIndex % puzzle.getRowCount(), colIndex % puzzle.getColumnCount());
        }
        else {
            return getNextEmptyLocation(new Location(rowIndex, colIndex));
        }
    }
//# END TODO

    @Override
    public boolean solve() {
//# BEGIN TODO  Backtrack solver, using the reasoner if not null
        // solve the puzzle starting from the first cell
        return solve(new Location(0, 0));
//# END TODO
    }
    private boolean solve(Location currentLocation) {
        // get the next empty location in the grid
        currentLocation = getNextEmptyLocation(currentLocation);
        CompoundCommand reasonerComm = null;
        /**
         * If the currentLocation is null then this means there are no empty
         * cells in the grid so we can check if the puzzle is solved.
         * If it is, we can return true
         */
        if (currentLocation == null) {
            if(puzzle.isSolved()) {
                return true;
            }
        }
        /**
         * Else we get the cell at the current location and insert numbers from
         * the min number until the max number to see if any of it fit.
         * If we found a valid value then we can go on the next cell recursively
         */
        else {
            /**
             * if we have a reasoner(not null) apply it and store it
             * in reasonerComm. If reasonerComm is not null then we can push it
             * to the commands stack
             */
            if (reasoner != null) {
                reasonerComm = reasoner.apply();
                if (reasonerComm != null) {
                    commands.push(reasonerComm);
                }
            }
            // get the cell
            KCell cell = puzzle.getCell(
                    currentLocation.getRow(), currentLocation.getColumn());
            // iterate over all the possible values
            for (int i = puzzle.getMinNumber(); i <= puzzle.getMaxNumber(); i++) {
                // make a set command
                Command command = new SetCommand(cell, i);
                // execute it
                command.execute();
                // push it to the commands stack
                commands.push(command);
                // check to see if the value fits in the puzzle
                if (puzzle.isValid()) {
                    // recursion
                    if (solve(currentLocation)) {
                        return true;
                    }
                }
                // pop the command of the stack
                commands.pop();
                // revert it
                command.revert();

            }
        }
        /**
         * if reasonerComm is not null, pop it from the stack and revert it
         */
        if (reasonerComm != null) {
            commands.pop();
            reasonerComm.revert();
        }
        // no value fit in the cell so we return false
        return false;
    }

}
//# END SKELETON
