//# BEGIN SKELETON
/**
 * Abstract Data Type for mutable
 * <a href="http://en.wikipedia.org/wiki/Polynomial"><i>polynomials</i></a>
 * with integer coefficients and one real-valued indeterminate ({@code x}).
 * A polynomial has a
 * <a href="http://en.wikipedia.org/wiki/Degree_of_a_polynomial"><i>degree</i></a>:
 * the largest exponent with non-zero coefficient.
 * If all coefficients are zero, the degree is defined to be minus one
 * (in this ADT; elsewhere, you can find other definitions).
 * <p>
 * There are constructors for the zero polynomial and for a polynomial
 * of the form {@code c * x^n} (monomial) for given non-zero {@code c} and
 * non-negative {@code n}.
 * <p>
 * There are queries for getting the degree, the coefficient
 * of a term with given exponent, and the value of the polynomial
 * for a given value of the indeterminate {@code x}.
 * <p>
 * There are operations to add two polynomials and to multiply two polynomials.
 * <p>
 * Contracts will be expressed in terms of a model.
 * We ignore overflow problems.
 * <p>
<!--//# BEGIN TODO Model and public invariants -->
<p><font color="red"><b>
* Model: of the form {@code c1 * x^n + c2 * x^(n-1) + ... + cn * x^0} where
* n is the degree of the polynomial
* 
* @inv {@code 0 <= n}</b></font></p>
<!--//# END TODO-->
 *
<!--//# BEGIN TODO Name, student id, and date-->
<p><font color="red"><b>Bogdan Floris, 0935036, 8.03.2017</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public abstract class Polynomial {

    /**
     * Checks whether the representation invariants hold.
     *
     * @return whether the representation invariants hold
     * @throws IllegalStateException  if precondition violated
     * @pre representation invariants hold
     * @modifies None
     * @post {@code \result}
     */
    public abstract boolean isRepOk() throws IllegalStateException;

    /**
     * Constructs the zero polynomial (all coefficients are zero).
     *
     * @pre true
     * @post {@code this == 0}
     */
    public Polynomial() { }

    /**
     * Constructs a monomial (one-term polynomial) with given coefficient and
     * degree.
     *
     * @param c  the coefficient
     * @param n  the exponent
     * @pre {@code c != 0 && 0 <= n}
     * @throws IllegalArgumentException  if precondition violated
     * @post {@code this == c * x^n}
     */
    public Polynomial(int c, int n) throws IllegalArgumentException { }

//# BEGIN TODO Specifications of the operations
    /**
     * Returns the degree of this polynomial
     * 
     * @return degree of the polynomial or -1 if the zero polynomial
     * @pre {@code true}
     * @modifies none
     * @post {@code result == (\max i; 0 <= i < coef.length; coef[i] != 0;) || -1
     */
    public abstract int getDegree();
    
    /**
     * Returns the coefficient given the exponent
     * 
     * @param exponent the given exponent
     * @return the coefficient
     * @pre {@code getDegree() != 0}
     * @modifies none
     * @post {@code \result == c; coef[exponent] == c}
     */
    public abstract int getCoeff(int exponent);
    
    /**
     * Returns the value of the polynomial given the indeterminate x
     * 
     * @param x the indeterminate
     * @return {@code P(x)}
     * @pre {@code getDegree() != 0}
     * @modifies none
     * @post {@code \result == P(x)}
     */
    public abstract int value(int x);
    
    /**
     * Adds two polynomials
     * 
     * @param b the second polynomial
     * @return the addition of this and polynomial b
     * @pre {@code true}
     * @modifies none
     * @post {@code \result == this + b}
     */
    public abstract Polynomial add(Polynomial b);
    
    /**
     * Multiply two polynomials
     * 
     * @param b the second polynomial
     * @return the multiplication of this with polynomial b
     * @pre {@code true}
     * @modifies none
     * @post {@code \result == this * b}
     */
    public abstract Polynomial multiply(Polynomial b);
//# END TODO

}
//# END SKELETON
