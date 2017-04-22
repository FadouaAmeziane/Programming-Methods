
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * An implementation of {@link IntEquRelation} using set of sets
 * containing the equivalence classes of the relation
 *
 * @author bogdanfloris
 */
/**
<!--//# BEGIN TODO Bogdan Floris, 0935036, 14.03.2017-->
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class IntEquRelationSetOfSets extends IntEquRelation {
    
    /**
     * Representation of the relation using set of sets
     * and extent
     */
    protected final Set<Set<Integer>> relation;
    protected final int extent;
    
    /**
     * Representation invariants
     * 
     * NotNull: relation != null
     * SetsNotNull: {@code (\forall i; relation.has(i); i != null)}
     * SetsInExtent: {@code (\forall i; relation.has(i);
     *     i subset of [0, 1 .. ,extent() - 1])}
     * ReflexiveRelation: {@code \forall elem; relation.contains(elem);
     *                      \forall i; EquClass(i).contains(i);}
     * SymmetricRelation: {@code \forall elem; relation.contains(elem);
     *                      \forall i, j; EquClass(i).contains(j) && EquClass(j).contains(i);}
     * TransitiveRelation: {@code \forall elem; relation.contains(elem);
     *                      \forall i, j, k; EquClass(i).contains(j) && EquClass(j).contains(k)
     *                                          => EquClass(i).contains(k);}
     * 
     * Abstraction function
     *
     * AF(this) = set of EquClass(a) such that EquClass(a).contains(b)
     */
    
    public IntEquRelationSetOfSets(final int n) throws IllegalArgumentException {
        super(n);
        if (n < 0) {
            throw new IllegalArgumentException(
                    "IntEqu.Relation.pre violated: n = " + n + " < 0");
        }
        
        relation = new HashSet<Set<Integer>>();
        extent = n;
        
        for (int i = 0; i < n; i++) {
            relation.add(new HashSet<Integer>(Arrays.asList(i)));
        }
    }
    
    @Override
    public boolean isRepOk() throws IllegalStateException {
        //NotNull
        if (relation == null) {
            throw new IllegalStateException(
                    "relation == null");
        }
        for (Set<Integer> set: relation) {
            //SetsNotNull
            if (set == null) {
                throw new IllegalStateException(
                        "set == null");
            }
            //Sets in Extent
            for (int j: set) {
                if (!(0 <= j && j < extent())) {
                    throw new IllegalStateException(
                            "integer in set not in extent");
                }
            }
        }
        // ReflexiveRelation
        for (int i = 0; i < extent(); ++i) {
            if (!(areRelated(i, i))) {
                throw new IllegalStateException(
                        "areRelated(" + i + "," + i + ") == false");
            }
        }
        // SymmetricRelation
        for (int i = 0; i < extent(); ++i) {
            for (int j = 0; j < extent(); ++j) {
                if (areRelated(i, j) != areRelated(j, i)) {
                    throw new IllegalStateException(
                        "areRelated(" + i + "," + j
                                + ") != areRelated(" + j + "," + i
                                + ")");
                }
            }
        }
        // TransitiveRelation
        for (int i = 0; i < extent(); ++i) {
            for (int j = 0; j < extent(); ++j) {
                for (int k = 0; k < extent(); ++k) {
                    if (areRelated(i, j) && areRelated(j, k)
                            && !(areRelated(i, k))) {
                        throw new IllegalStateException(
                            "areRelated(" + i + "," + j
                                    + ") && areRelated(" + j + "," + k
                                    + ") && !(areRelated(" + i + ","
                                    + k + "))");
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public int extent() {
        return extent;
    }
    
    @Override
    public boolean areRelated(int a, int b) throws IllegalArgumentException {
        if (!isValidPair(a, b)) {
            throw new IllegalArgumentException(
                    "not a valid pair");
        }        
        boolean result = false;        
        for (Set elem: relation) {
            if (elem.contains(a)) {
                result = elem.contains(b);
            }
        }
        return result;
    }   

    @Override
    public void add(int a, int b) throws IllegalArgumentException {
        if (!isValidPair(a, b)) {
            throw new IllegalArgumentException(
                    "not a valid pair");
        }
        if (a == b) {
            return;
        }        
        Set<Integer> toRemove = new HashSet<Integer>();        
        for (Set elem1: relation) {
            if (elem1.contains(a)) {
                for (Set elem2: relation) {
                    if (elem2.contains(b)) {
                        elem1.addAll(elem2);
                        toRemove = elem2;
                        System.out.println(relation);
                        break;
                    }
                }
                break;
            }
        }
        relation.remove(toRemove);
        System.out.println(relation);
    }

    @Override
    public Set<Integer> equClass(int a) throws IllegalArgumentException {
        if (a < 0) {
            throw new IllegalArgumentException(
                    "Parameter a = " + a + " < 0");
        }
        if (a >= extent()) {
            throw  new IllegalArgumentException(
                    "Parameter a = " + a + " >= extent()");
        }        
        Set<Integer> result = new HashSet<Integer>();        
        for (Set elem: relation) {
            if (elem.contains(a)) {
                result = elem;
            }
        }
        return result;
    }
}
