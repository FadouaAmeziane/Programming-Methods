package cp.command;

import cp.model.Counter;

/**
 * Base class to represent an executable and revertable command,
 * applied to a Counter.
 * Concrete command classes extend this base class,
 * by adding parameters (when needed), revert state (when needed), and
 * overriding execute() and revert().
 *
 * This base class can already be used as a command that does nothing.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class Command {

    /** The receiving Counter. */
    protected final Counter receiver;

    /** Execution state. */
    private boolean executed;

    /**
     * Constructs a command for a given receiver.
     *
     * @param receiver  the given receiver
     * @pre {@code receiver != null}
     */
    public Command(final Counter receiver)
            throws NullPointerException {
        if (receiver == null) {
            throw new NullPointerException("Command(Counter).pre violated: "
                    + "receiver == null");
        }
        this.receiver = receiver;
        this.executed = false;
    }

    /**
     * Gets execution status of this command.
     *
     * @return execution status
     */
    public boolean isExecuted() {
        return executed;
    }

    /**
     * Executes the command.
     * A concrete command will override this method.
     *
     * @throws IllegalStateException  if {@code executed}
     * @pre {@code ! executed && }
     *   precondition of the command holds in the receiver
     * @post {@code executed}
     */
    public void execute() throws IllegalStateException {
        if (executed) {
            throw new IllegalStateException("Command.execute().pre violated: "
                    + "command was already executed");
        }
        executed = true;
    }

    /**
     * Reverts the command.
     * A concrete command will override this method.
     *
     * @pre {@code executed && }
     *   precondition of the reversal holds in the receiver
     * @post {@code ! executed}
     */
    public void revert() throws IllegalStateException {
        if (! executed) {
            throw new IllegalStateException("Command.revert().pre violated: "
                    + "command was not yet executed");
        }
        executed = false;
    }

}
