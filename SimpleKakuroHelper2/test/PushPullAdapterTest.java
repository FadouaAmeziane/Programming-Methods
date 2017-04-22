import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Smoke tests for {@link PushPullAdapter}.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class PushPullAdapterTest {

    /** Expected pull count; set by test case. */
    private int expectedPullCount;

    /** Object generated. */
    private final Set<Integer> object0 = new HashSet<Integer>();

    class MyGenerator implements Generator<Set<Integer>> {

        /** Actual number of pulls. */
        public int pullCount = 0;

        @Override
        public void setObserver(GeneratorObserver<Set<Integer>> observer) {
            // ignored on purpose
        }

        @Override
        public Set<Integer> getObject() {
            ++ pullCount;
            return object0;
        }

    };

    /** Generator of strings. */
    private MyGenerator generator;

    /** Listener to be adapted. */
    private GeneratorListener listener;

    /** Adapter under test. */
    private PushPullAdapter instance;

    @Before
    public void setUp() {
        System.out.println("\nsetUp()");
        generator = new MyGenerator();
        listener = new GeneratorListener() {
            @Override
            public void combinationGenerated(Set<Integer> object) {
                if (expectedPullCount != 0) {
                    assertEquals("object", object0, object);
                } else {
                    assertEquals("object", null, object);
                }
            }
        };
    }

    /**
     * Test of objectGenerated method, of class PushPullAdapter.
     */
    @Test
    public void testObjectGenerated0() {
        System.out.println("objectGenerated, without pull");
        expectedPullCount = 0;
        instance = new PushPullAdapter(listener, expectedPullCount != 0);
        instance.objectGenerated(generator);
        assertEquals("pull count", expectedPullCount, generator.pullCount);
    }

    /**
     * Test of objectGenerated method, of class PushPullAdapter.
     */
    @Test
    public void testObjectGenerated1() {
        System.out.println("objectGenerated, with pull");
        expectedPullCount = 1;
        instance = new PushPullAdapter(listener, expectedPullCount != 0);
        instance.objectGenerated(generator);
        assertEquals("pull count", expectedPullCount, generator.pullCount);
    }

}
