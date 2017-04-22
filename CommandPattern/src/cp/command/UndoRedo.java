//# BEGIN SKELETON
package cp.command; // <<<<< Comment this line out when submitting to peach!

import java.util.Iterator;
import java.util.Stack;

/**
 * Facilities for an undo-redo mechanism, on the basis of commands.
 *
 * @author Tom Verhoeff (TU/e, Eindhoven University of Technology)
<!--//# BEGIN TODO Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 27.04.2007</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class UndoRedo {

//# BEGIN TODO Representation in terms of instance variables, incl. rep. inv.
    /**
     * All commands in undoStack have been executed and can be undo
     * All commands in redoStack are un-executed and can be re-executed
     */
    Stack<Command> undoStack = new Stack<>();
    Stack<Command> redoStack = new Stack<>();
//# END TODO

    /**
     * Returns whether an {@code undo} is possible.
     *
     * @return whether {@code undo} is possible
     */
    public boolean canUndo() {
//# BEGIN TODO Implementation of canUndo
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
        return !redoStack.empty();
//# END TODO
    }

    /**
     * Returns command most recently done.
     *
     * @return command at top of undo stack
     * @throw IllegalStateException  if precondition failed
     * @pre {@code canUndo()}
     */
    public Command lastDone() throws IllegalStateException {
//# BEGIN TODO Implementation of lastDone
        if (!canUndo()) {
            throw new IllegalStateException("Cannot be undone");
        }
        return undoStack.pop();
//# END TODO
    }

    /**
     * Returns command most recently undone.
     *
     * @return command at top of undo stack
     * @throw IllegalStateException  if precondition failed
     * @pre {@code canRedo()}
     */
    public Command lastUndone() throws IllegalStateException {
//# BEGIN TODO Implementation of lastUndone
        if (!canRedo()) {
            throw new IllegalStateException("Cannot be redone");
        }
        return redoStack.pop();
//# END TODO
    }

    /**
     * Clears all undo-redo history.
     */
    public void clear() {
//# BEGIN TODO Implementation of clear
        undoStack.clear();
        redoStack.clear();
//# END TODO
    }

    /**
     * Adds given command to the do-history.
     * If the command was not yet executed,
     * it is first executed.
     *
     * @param command  the command to incorporate
     */
    public void did(final Command command) {
//# BEGIN TODO Implementation of did
        if (!command.isExecuted()) {
            command.execute();
            redoStack.clear();
        }
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
     */
    public void undo(final boolean redoable) throws IllegalStateException {
//# BEGIN TODO Implementation of undo
        if (!canUndo()) {
            throw new IllegalStateException("Can't undo");
        }
        Command toUndo = lastDone();
        toUndo.revert();
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
     */
    public void redo() throws IllegalStateException {
//# BEGIN TODO Implementation of redo
        if (!canRedo()) {
            throw new IllegalStateException("Can't redo");
        }
        Command toRedo = lastUndone();
        toRedo.execute();
        undoStack.push(toRedo);
//# END TODO
    }

    /**
     * Undo all done commands.
     *
     * @param redoable  whether to allow redo
     */
    public void undoAll(final boolean redoable) {
//# BEGIN TODO Implementation of undoAll
        Iterator<Command> undoIter = undoStack.iterator();
        while (undoIter.hasNext()) {
            undo(redoable);
        }
//# END TODO
    }

    /**
     * Redo all undone commands.
     */
    public void redoAll() {
//# BEGIN TODO Implementation of redoAll
        Iterator<Command> redoIter = redoStack.iterator();
        while (redoIter.hasNext()) {
            redo();
        }
//# END TODO
    }

}
//# END SKELETON
