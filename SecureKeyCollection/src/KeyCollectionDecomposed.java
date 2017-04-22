//# BEGIN SKELETON
/**
 * Concrete class for graded homework assignment in Series 1 of 2IPC0,
 * where you provide a functional decomposition of {@code isSecure()}.
 * <p>
 * Write your code in this file between the lines marked by
 * //# BEGIN TODO ... and //# END TODO (do NOT remove these markers).
 * <p>
<!--//# BEGIN TODO: Name, id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 11 February 2017</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KeyCollectionDecomposed extends AbstractKeyCollection {

    @Override
    public  boolean isSecure(int[][][] keys)
    {
    //# BEGIN TODO: Functional decomposition; the top-level method
        for (int k1 = 0; k1 != keys.length; ++ k1) {
            for (int k2 = 0; k2 != keys.length; ++ k2) {
                if (k1 != k2) {
                    if(isConvertable(keys[k1],keys[k2])){
                        return false;
                    }
                }
            } // end for k2
        } // end for k1
        return true;
    //# END TODO
    }
        
//# BEGIN TODO: Functional decomposition; auxiliary method(s) with contracts
    /**
     * Determines whether key1 can be converted into key2
     * 
     * @param key1  first key
     * @param key2  second key
     * @return whether {@code key1} can be converted into {@code key2}
     * @pre {@code key1 != null && key2 != null
     *     && isKey(key2) && isKey(key2)}
     * @modifies None
     * @post {@code \result == (\forall r; key1.has(r);
     *             CR(key1[r], key2[r]))},<br>
     * where    
     * {@code
     *     CR(row1, row2) = row1.length == row2.length &&
     *             (\forall i; row1.has(i); row1[i] <= row2[i])}
     */
    public boolean isConvertable(int[][] key1, int[][] key2){
        for (int r = 0; r != N_ROWS; ++ r) {
            if(!isRowConvertable(key1[r],key2[r])){
                return false;
            }
        } // end for r
        return true;
    }
    
    /**
     * Determines whether row r of key1 can be converted into row r of key2
     * 
     * @param key1r  first key row r
     * @param key2r  second key row r
     * @return whether {@code key1r} can be converted into {@code key2r}
     * @pre {@code key1r != null && key2r != null}
     * @modifies None
     * @post {@code \result == row1.length == row2.length &&
     *             (\forall i; row1.has(i); row1[i] <= row2[i])}
     */
    public boolean isRowConvertable(int[] key1r, int[] key2r){
        if(key1r.length != key2r.length){
            return false;
        }
        for(int i = 0; i < key1r.length; i++){
            if(key1r[i] > key2r[i]){
                return false;
            }
        }
        return true;
    }
//# END TODO
        
}
//# END SKELETON
