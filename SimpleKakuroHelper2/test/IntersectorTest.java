import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test cases for class Intersector.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class IntersectorTest {

    /** The subject under test. */
    private Intersector instance;

    @Before
    public void setUp() {
        System.out.println("\nsetUp()");
    }

    /**
     * Test of getIntersection method, of class Intersector(m, false).
     */
    @Test
    public void testGetIntersectionFalse() {
        System.out.println("getIntersection, complement = false");
        Intersector instance = new Intersector(3, false);
        System.out.println("new Intersector(3, false)");
        Set<Integer> expResult = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 1, 2, 3 }));
        Set<Integer> result = instance.getIntersection();
        assertEquals("getIntersection()", expResult, result);
    }

    /**
     * Test of getIntersection method, of class Intersector(m, true).
     */
    @Test
    public void testGetIntersectionTrue() {
        System.out.println("getIntersection, complement = true");
        Intersector instance = new Intersector(3, true);
        System.out.println("new Intersector(3, true)");
        Set<Integer> expResult = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 1, 2, 3 }));
        Set<Integer> result = instance.getIntersection();
        assertEquals("getIntersection()", expResult, result);
    }

    /**
     * Test of combinationGenerated method, of class Intersector(m, false).
     */
    @Test
    public void testCombinationGeneratedFalse() {
        System.out.println("combinationGenerated, complement = false");
        Intersector instance = new Intersector(3, false);
        System.out.println("new Intersector(3, false)");
        Set<Integer> combination;
        combination = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 1, 3 }));
        instance.combinationGenerated(combination);
        System.out.println("combinationGenerated({ 1, 3 })");
        combination = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 1, 2 }));
        instance.combinationGenerated(combination);
        System.out.println("combinationGenerated({ 1, 2 })");
        Set<Integer> result = instance.getIntersection();
        Set<Integer> expResult = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 1 }));
        assertEquals("getIntersection()", expResult, result);
    }

    /**
     * Test of combinationGenerated method, of class Intersector(m, false).
     */
    @Test
    public void testCombinationGeneratedTrue() {
        System.out.println("combinationGenerated, complement = true");
        Intersector instance = new Intersector(3, true);
        System.out.println("new Intersector(3, true)");
        Set<Integer> combination;
        combination = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 1 }));
        instance.combinationGenerated(combination);
        System.out.println("combinationGenerated({ 1 })");
        combination = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 2 }));
        instance.combinationGenerated(combination);
        System.out.println("combinationGenerated({ 2 })");
        Set<Integer> result = instance.getIntersection();
        Set<Integer> expResult = new HashSet<Integer>(Arrays.asList(
            new Integer[] { 3 }));
        assertEquals("getIntersection()", expResult, result);
    }

}
