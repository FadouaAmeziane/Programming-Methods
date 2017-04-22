
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * An implementation of Iterable and extension of IntRelationArrays
 *
 * @author bogdanfloris
 * 
 * <!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 17.03.2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class IntRelationArraysIterable extends IntRelationArrays implements Iterable<IntPair>{

    public IntRelationArraysIterable(int n) {
        super(n);
    }

    @Override
    public Iterator<IntPair> iterator() {
        Iterator<IntPair> iter = new Iterator<IntPair>() {
            
            private int currentIndex = 0;
            
            @Override
            public boolean hasNext() {
                while (currentIndex < extent() * extent() && !relation[currentIndex / extent()][currentIndex % extent()]) {
                    currentIndex++;
                }
                return (currentIndex < extent() * extent());
            }

            @Override
            public IntPair next() throws NoSuchElementException {
                if(!hasNext()) {
                    throw new NoSuchElementException("End of array");
                }
                currentIndex++;
                return new IntPair((currentIndex - 1)/ extent(), (currentIndex - 1) % extent());
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iter;
    }
}
