/**
 * Test cases for IntRelationArraysIterable.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class IntRelationArraysIterableTest
        extends IntRelationIterableTestCases {

    @Override
    protected void setInstance(final int n) {
        instance = new IntRelationArraysIterable(n);
    }

}
