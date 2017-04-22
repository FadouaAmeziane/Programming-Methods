package cp.command;

import cp.model.Counter;

/**
 * The reset command.
 * Illustrates a concrete command without parameters,
 * which needs to store something in order to revert it.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class ResetCommand extends Command {

    /** Previous state of the receiver, for revert() */
    private int oldCount;

    /**
     * Constructs a reset command for a given receiver.
     *
     * @param receiver  the given receiver
     */
    public ResetCommand(final Counter receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.execute();
        oldCount = receiver.getCount();
        receiver.reset();
    }

    @Override
    public void revert() {
        super.revert();
        receiver.setCount(oldCount);
    }

}
