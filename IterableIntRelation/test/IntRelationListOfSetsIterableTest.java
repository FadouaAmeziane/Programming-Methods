/**
 * Test cases for IntRelationListOfSets.
 *
 * @author Tom Verhoeff (TU/e)
 */
public class IntRelationListOfSetsIterableTest
        extends IntRelationIterableTestCases {

    @Override
    protected void setInstance(final int n) {
        instance = new IntRelationListOfSetsIterable(n);
    }

}
