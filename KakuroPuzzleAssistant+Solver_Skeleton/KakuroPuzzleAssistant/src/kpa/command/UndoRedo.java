//# BEGIN SKELETON
package kpa.command; // <<<<< Comment this line out when submitting to peach!

import java.util.Iterator;
import java.util.Stack;

/**
 * Facilities for an undo-redo mechanism, on the basis of commands.
 *
 * @author Tom Verhoeff (TU/e, Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red">Bogdan Floris, 0935036, 2.04.2017<b></b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class UndoRedo {

//# BEGIN TODO Representation in terms of instance variables, incl. rep. inv.
    /**
     * All commands in undoStack have been executed and can be undo
     * All commands in redoStack are un-executed and can be re-executed
     */
    // the undo stack
    Stack<Command> undoStack = new Stack<>();
    // the redo stack
    Stack<Command> redoStack = new Stack<>();
//# END TODO

    /**
     * Returns whether an {@code undo} is possible.
     *
     * @return whether {@code undo} is possible
     */
    public boolean canUndo() {
//# BEGIN TODO Implementation of canUndo
        // we can undo if the undo stack is not empty
        return !undoStack.empty();
//# END TODO
    }

    /**
     * Returns whether a {@code redo} is possible.
     *
     * @return {@code redo().pre}
     */
    public boolean canRedo() {
//# BEGIN TODO Implementation of canRedo
        // we can redo if the redo stack is not empty
        return !redoStack.empty();
//# END TODO
    }

    /**
     * Returns command most recently done.
     *
     * @return command at top of undo stack
     * @throws IllegalStateException  if precondition failed
     * @pre {@code canUndo()}
     */
    public Command lastDone() throws IllegalStateException {
//# BEGIN TODO Implementation of lastDone
        if (!canUndo()) {
            // if the undo stack is empty throw exception
            throw new IllegalStateException("Cannot be undone");
        }
        // get the last done command from the stack
        return undoStack.peek();
//# END TODO
    }

    /**
     * Returns command most recently undone.
     *
     * @return command at top of redo stack
     * @throws IllegalStateException  if precondition failed
     * @pre {@code canRedo()}
     */
    public Command lastUndone() throws IllegalStateException {
//# BEGIN TODO Implementation of lastUndone
        if (!canRedo()) {
            // if the redo stack is empty throw exception
            throw new IllegalStateException("Cannot be redone");
        }
        // get the last undone command from the stack
        return redoStack.peek();
//# END TODO
    }

    /**
     * Clears all undo-redo history.
     *
     * @modifies {@code this}
     */
    public void clear() {
//# BEGIN TODO Implementation of clear
        // clears both stacks
        undoStack.clear();
        redoStack.clear();
//# END TODO
    }

    /**
     * Adds given command to the do-history.
     * If the command was not yet executed,
     * then it is first executed.
     *
     * @param command  the command to incorporate
     * @modifies {@code this}
     */
    public void did(final Command command) {
//# BEGIN TODO Implementation of did
        // if the given command is not executed
        if (!command.isExecuted()) {
            // then we execute it
            command.execute();
            // and clear the redo stack
            redoStack.clear();
        }
        // we push this command to the undo stack
        undoStack.push(command);
//# END TODO
    }

    /**
     * Undo the most recently done command, optionally allowing
     * it to be redone.
     *
     * @param redoable  whether to allow redo
     * @throws IllegalStateException  if precondition violated
     * @pre {@code canUndo()}
     * @modifies {@code this}
     */
    public void undo(final boolean redoable) throws IllegalStateException {
//# BEGIN TODO Implementation of undo
        // if we have nothing to undo throw exception
        if (!canUndo()) {
            throw new IllegalStateException("Can't undo");
        }
        // get the last done command
        Command toUndo = undoStack.pop();
        // revert it
        toUndo.revert();
        // if the command is redoable then push it to the redo stack
        if (redoable) {
            redoStack.push(toUndo);
        }
//# END TODO
    }

    /**
     * Redo the most recently undone command.
     *
     * @throws IllegalStateException  if precondition violated
     * @pre {@code canRedo()}
     * @modifies {@code this}
     */
    public void redo() throws IllegalStateException {
//# BEGIN TODO Implementation of redo
        // if we have nothing to redo throw exception
        if (!canRedo()) {
            throw new IllegalStateException("Can't redo");
        }
        // get the last undone command
        Command toRedo = redoStack.pop();
        // execute it
        toRedo.execute();
        // and push it to the undo stack
        undoStack.push(toRedo);
//# END TODO
    }

    /**
     * Undo all done commands.
     *
     * @param redoable  whether to allow redo
     * @modifies {@code this}
     */
    public void undoAll(final boolean redoable) {
//# BEGIN TODO Implementation of undoAll
        // initialize an iterator on the undo stack
        Iterator<Command> undoIter = undoStack.iterator();
        // iterate through all the commands on the undo stack
        while (undoIter.hasNext()) {
            // and call undo on each of them
            undo(redoable);
        }
//# END TODO
    }

    /**
     * Redo all undone commands.
     *
     * @modifies {@code this}
     */
    public void redoAll() {
//# BEGIN TODO Implementation of redoAll
        // initialize an iterator on the redo stack
        Iterator<Command> redoIter = redoStack.iterator();
        // iterate through all the commands on the redo stack
        while (redoIter.hasNext()) {
            // and call redo on each of them
            redo();
        }
//# END TODO
    }

}
//# END SKELETON
