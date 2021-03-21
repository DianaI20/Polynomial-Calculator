package myPackage.model;

import java.util.Comparator;

/* Used for sorting the polynomials by exponent*/
public class MonomialSorter implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        return (int) (o2.getExponent() - o1.getExponent());
    }
}
