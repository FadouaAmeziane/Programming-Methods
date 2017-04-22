//# BEGIN SKELETON
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for functional decomposition in {@code KeyCollectionDecomposed}.
 *
<!--//# BEGIN TODO: Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 11 February 2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KeyCollectionDecomposedTest extends AbstractKeyCollectionTestCases
{

    public KeyCollectionDecomposedTest() {
    }

    @Before
    public void setUp() {
        instance = new KeyCollectionDecomposed();
    }

//# BEGIN TODO: Test cases for auxiliary methods
    KeyCollectionDecomposed inst = new KeyCollectionDecomposed();
    int[][] key1;
    int[][] key2;
    int[] key1r;
    int[] key2r;
    
    private void checkIsRowConvertable(String msg, boolean expResult){
        boolean result = inst.isRowConvertable(key1r, key2r);
        assertEquals(msg, expResult, result);
    }
    
    private void checkIsConvertable(String msg, boolean expResult){
        boolean result = inst.isConvertable(key1, key2);
        assertEquals(msg, expResult, result);
    }
    //tests for isRowConvertable
    @Test
    public void IsRowConvTest1(){
        key1r = new int[]{ };
        key2r = new int[]{ };
        checkIsRowConvertable("No keys", true);
    }
    @Test
    public void IsRowConvTest2(){
        key1r = new int[]{1};
        key2r = new int[]{ };
        checkIsRowConvertable("Key2r empty", false);
    }
    @Test
    public void IsRowConvTest3(){
        key1r = new int[]{ };
        key2r = new int[]{1};
        checkIsRowConvertable("Key1r empty", false);
    }
    @Test
    public void IsRowConvTest4(){
        key1r = new int[]{1};
        key2r = new int[]{1};
        checkIsRowConvertable("Same", true);
    }
    @Test
    public void IsRowConvTest5(){
        key1r = new int[]{1};
        key2r = new int[]{2};
        checkIsRowConvertable("1 smaller", true);
    }
    @Test
    public void IsRowConvTest6(){
        key1r = new int[]{2};
        key2r = new int[]{1};
        checkIsRowConvertable("1 bigger", false);
    }
    @Test
    public void IsRowConvTest7(){
        key1r = new int[]{1,2};
        key2r = new int[]{2};
        checkIsRowConvertable("Diff length", false);
    }
    @Test
    public void IsRowConvTest8(){
        key1r = new int[]{1};
        key2r = new int[]{2,1};
        checkIsRowConvertable("Diff length", false);
    }
    @Test
    public void IsRowConvTest9(){
        key1r = new int[]{1,1};
        key2r = new int[]{2,2};
        checkIsRowConvertable("11 22", true);
    }
    //tests for isConvertable
    @Test
    public void IsConvTest4(){
        key1 = new int[][]{new int[]{ 1 }, new int[]{ 1 }};
        key2 = new int[][]{new int[]{ 1, 1 }, new int[]{ 1 }};
        checkIsConvertable("First row lengths differ", false);
    }
    @Test
    public void IsConvTest5(){
        key1 = new int[][]{new int[]{ 1 }, new int[]{ 1 }};
        key2 = new int[][]{new int[]{ 1 }, new int[]{ 1 ,1 }};
        checkIsConvertable("Second row length differ", false);
    }
    @Test
    public void IsConvTest6(){
        key1 = new int[][]{new int[]{ 1 }, new int[]{ 2 }};
        key2 = new int[][]{new int[]{ 2 }, new int[]{ 1 }};
        checkIsConvertable("First good, second no", false);
    }
    @Test
    public void IsConvTest7(){
        key1 = new int[][]{new int[]{ 1 }, new int[]{ 1 }};
        key2 = new int[][]{new int[]{ 2 }, new int[]{ 1 }};
        checkIsConvertable("Good", true);
    }
    @Test
    public void IsConvTest8(){
        key1 = new int[][]{new int[]{ 1 }, new int[]{ 1 }};
        key2 = new int[][]{new int[]{ 1 }, new int[]{ 2 }};
        checkIsConvertable("Good", true);
    }
    @Test
    public void IsConvTest9(){
        key1 = new int[][]{new int[]{ 2 }, new int[]{ 1 }};
        key2 = new int[][]{new int[]{ 1 }, new int[]{ 1 }};
        checkIsConvertable("First bigger", false);
    }
    @Test
    public void IsConvTest10(){
        key1 = new int[][]{new int[]{ 1 }, new int[]{ 2 }};
        key2 = new int[][]{new int[]{ 1 }, new int[]{ 1 }};
        checkIsConvertable("Second bigger", false);
    }
//# END TODO

}
//# END SKELETON
