//# BEGIN SKELETON
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

// Class to illustrate Test-Driven Development of a generic Abstract Data Type.

/**
 * An implementation of {@link Relation} using a {@code Map} of {@code Set}s.
 *
 * @param <A>  the type of left-hand elements in the relation
 * @param <B>  the type of right-hand elements in the relation
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 17.03.2017</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public class RelationMapOfSets<A, B> implements Relation<A, B> {
//# BEGIN TODO Definition of class RelationMapOfSets
    
    protected Map<A, Set<B>> relation;
    
    /**
     * Representation invariants
     * 
     * NotNull: relation != null
     * 
     * Abstraction function: set of (a, b) such that relation.get(a).contains(b)
     */
    
    public RelationMapOfSets() {
        relation = new HashMap<A, Set<B>>();
    }
    
    @Override
    public boolean isRepOk() throws IllegalStateException {
        if (relation == null) {
            throw new IllegalStateException("relation is null");
        }
        return true;
    }

    @Override
    public boolean areRelated(A a, B b) {
        return relation.containsKey(a) && relation.get(a).contains(b);
    }

    @Override
    public void add(A a, B b) {
        if (!relation.containsKey(a)) {
            relation.put(a, new HashSet<B>());
        }
        relation.get(a).add(b);
    }

    @Override
    public void remove(A a, B b) throws NoSuchElementException {
        if (!relation.containsKey(a)) {
            throw new NoSuchElementException("a = " + a + "does not exist.");
        }
        if (!relation.get(a).contains(b)) {
            throw new NoSuchElementException("Pair a = " + a + ", b = " + b + " does not exist");
        }
        relation.get(a).remove(b);
    }

    @Override
    public Iterable<B> relatedToFirst(A a) throws NoSuchElementException {
        if (!relation.containsKey(a)) {
            throw new NoSuchElementException("a = " + a + "does not exist.");
        }
        return relation.get(a);
    }

    @Override
    public Iterator<Pair<A, B>> iterator() {
        Iterator<Pair<A, B>> iter;
        iter = new Iterator<Pair<A, B>>() {
            
            private final Iterator mapIter = relation.entrySet().iterator();
            private Iterator setIter = null;
            private Map.Entry<A, Set<B>> entry = null;
            
            @Override
            public boolean hasNext() {
                if (setIter == null) {
                    return mapIter.hasNext();
                }
                return setIter.hasNext();
            }

            @Override
            public Pair<A, B> next() throws NoSuchElementException {
                if(!hasNext()) {
                    throw new NoSuchElementException("No next element");
                }
                if (setIter == null) {
                    entry = (Map.Entry<A, Set<B>>)mapIter.next();
                    Set<B> aux = entry.getValue();
                    setIter = aux.iterator();
                }
                Pair<A, B> result = new Pair<>(entry.getKey(), (B)setIter.next());
                if (!setIter.hasNext()) {
                    setIter = null;
                }
                return result;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation not supported");
            }
            
        };
        return iter;
    }
    
//# END TODO
}
//# END SKELETON
