package cp.command;

import cp.model.Counter;

/**
 * The increment command.
 * Illustrates a concrete command without parameters,
 * and which does not have to store anything in order to revert it.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class IncrementCommand extends Command {

    /**
     * Constructs an increment command for a given receiver.
     *
     * @param receiver  the given receiver
     */
    public IncrementCommand(final Counter receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.execute();
        receiver.increment();
    }

    @Override
    public void revert() {
        super.revert();
        receiver.setCount(receiver.getCount() - 1);
    }

}
