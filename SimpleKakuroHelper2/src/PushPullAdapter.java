//# BEGIN SKELETON
import java.util.Set;

/**
 * Adapter that adapts an object of a class implementing
 * {@link GeneratorListener} (which works by pushing)
 * to act like a class implementing
 * {@code GeneratorObserver<Set<Integer>>} (which works by pulling).
 * Client code of this adapter can decide that pulling is not needed,
 * when the listener being adapted is not using the pushed data
 * (see the pull parameter in the constructor).
 * This could improve efficiency.
 *
 * @author Tom Verhoeff (TU/e)
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 26.03.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class PushPullAdapter implements GeneratorObserver<Set<Integer>> {

    /** The adapted listener. */
    private GeneratorListener listener;

    /** Whether to pull objects and pass them on, or to ignore them. */
    private final boolean pull;

    /**
     * Constructs a new {@link PushPullAdapter} that optionally
     * suppresses data pulling to improve performance.
     *
     * @param pull  whether to pull the object
     */
    public PushPullAdapter(GeneratorListener listener, boolean pull) {
        this.listener = listener;
        this.pull = pull;
    }

    /**
     * If pulling needed, pull the data and pass it on the listener interface;
     * if not pulling, pass {@code null} on the listener interface.
     *
     * @param generator  the originating generator
     */
    @Override
    public void objectGenerated(Generator<Set<Integer>> generator) {
//# BEGIN TODO Implementation of objectGenerated
        if (pull) {
            listener.combinationGenerated(generator.getObject());
        }
        else {
            listener.combinationGenerated(null);
        }
//# END TODO
    }

}
//# END SKELETON
