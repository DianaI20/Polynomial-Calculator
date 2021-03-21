package myPackage.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polynomial {

    private List<Monomial> polynomialMembers;

    public Polynomial(List<Monomial> polynomialMembers) {
        this.polynomialMembers = polynomialMembers;
        Collections.sort(polynomialMembers, new MonomialSorter());
    }
    public Polynomial() {
        polynomialMembers = new ArrayList<>();
    }

    public Polynomial (String s) {
        this.polynomialMembers = new ArrayList<>();
        String expPattern1 = "([+-]?[^-+]+)";
        Pattern p = Pattern.compile(expPattern1);
        s = s.replace(" ", "");
        Matcher m = p.matcher(s);
        while (m.find()) {
            // if we do not have a coefficient
            String monomial = m.group(1);
            String[] arr = monomial.split("[xX]", 3);

            Double coeff = Double.valueOf(0);
            Integer deg = Integer.valueOf(0);
            if (arr.length == 2) {
                String re = arr[1].replace("^", "");

                if (arr[0].equals("") || arr[0].equals("+")) {
                    coeff = Double.valueOf(1);
                } else if(arr[0].equals("-"))
                    coeff = Double.valueOf(-1);
                else{
                    coeff = Double.parseDouble(arr[0]);

                }
                if (arr[1].equals("") || arr[1].equals("+")) {
                    deg = Integer.valueOf(1);
                } else {
                    deg = Integer.parseInt(re);
                }

            }
            if (arr.length == 1) {
                deg = 0;
                coeff = Double.parseDouble(arr[0]);
            }
            this.polynomialMembers.add(new Monomial(coeff, deg));
        }
    }

    public Double getLeadCoefficient() {
        return getPolynomialMembers().get(0).getCoefficient();
    }

    public Integer getPolynomialDegree() {
        return getPolynomialMembers().get(0).getExponent();
    }

    public List<Monomial> getPolynomialMembers() {
        return polynomialMembers;
    }

    public void setPolynomialMembers(List<Monomial> polynomialMembers) {
        this.polynomialMembers = polynomialMembers;
    }

    /* The function removes all the 0 terms from the polynomial */
    public Polynomial removeAllNullCoeff(){
        Polynomial res = new Polynomial();

        for( var i : polynomialMembers){
            if(i.getCoefficient() != 0)
               res.polynomialMembers.add(i);
        }
        return res;
    }
    /* Function for adding two polynomials*/
    public Polynomial plus(Polynomial p) {

        List<Monomial> sum = new ArrayList<>();
        int thisSize = polynomialMembers.size();
        int pSize = p.polynomialMembers.size();
        while (thisSize > 0 || pSize > 0) {
            Monomial m1, m2;
            m1 = thisSize == 0 ? null : polynomialMembers.get(thisSize - 1);
            m2 = pSize == 0 ? null : p.polynomialMembers.get(pSize - 1);
            if (m1 == null) {
                sum.add(m2);
                pSize--;
            } else if (m2 == null) {
                sum.add(m1); thisSize--;
            } else if (m1.getExponent() == m2.getExponent()) {
                sum.add(new Monomial(m1.getCoefficient() + m2.getCoefficient(), m1.getExponent()));
                thisSize--; pSize--;
            } else if (m1.getExponent() < m2.getExponent()) {
                sum.add(m1);
                thisSize--;
            } else {
                sum.add(m2);
                pSize--;
            }
        }
        Polynomial s = new Polynomial(sum);

        return s.removeAllNullCoeff();
    }

    /*Computing the difference between two polynomials. The result is computed as sum of the first polynomial and second one negated*/;
    public Polynomial minus(Polynomial p) {

        List<Monomial> negatedMonomials = new ArrayList<>();
        for (Monomial m : p.polynomialMembers) {
            negatedMonomials.add(m.negate());
        }
        Polynomial pNegated = new Polynomial(negatedMonomials);
        Polynomial res = this.plus(pNegated);
        return res;
    }

    public Polynomial derivative() {
        List<Monomial> derivative = new ArrayList<>();
        for (int i = 0; i < polynomialMembers.size(); i++) {
            derivative.add(polynomialMembers.get(i).derivative());
        }
        Polynomial p =  new Polynomial(derivative);
        return p.removeAllNullCoeff();
    }

    public Polynomial integral() {
        List<Monomial> integral = new ArrayList<>();
        for (Monomial polynomialMember : polynomialMembers) {
            integral.add(polynomialMember.integral());
        }
        return new Polynomial(integral).removeAllNullCoeff();
    }

    /* Operation for multiplying the polynomials. The first polynomial is multiplied with each term from the parameter and then the coefficients are
    added one with another.
     */
    public Polynomial multiply(Polynomial p) {
        List<Monomial> result = new ArrayList<>();
        Monomial multiplied;
        for (var i : this.polynomialMembers) {
            for (var j : p.polynomialMembers) {
                multiplied = i.multiply(j);
                boolean alreadyAdded = false;
                for (var k : result) {
                    if (k.getExponent() == multiplied.getExponent()) {
                        alreadyAdded = true;
                        k.setCoefficient(k.getCoefficient() + multiplied.getCoefficient());
                        break;
                    }
                }
                if (!alreadyAdded) {
                    result.add(multiplied);
                }
            }
        }
        return new Polynomial(result).removeAllNullCoeff();
    }

    /*Division operation - the function represents the long division. It is similar to the one made on paper
    * The first polynomial is divided by second polynomial */
    public Polynomial[] divides( Polynomial b ){
        Polynomial q = new Polynomial( );
        Polynomial r = this;
        while(  r.getPolynomialDegree() >= b.getPolynomialDegree()){

            Double coef = r.getLeadCoefficient() / b.getLeadCoefficient();
            Integer deg = r.getPolynomialDegree() - b.getPolynomialDegree();
            Polynomial t = new Polynomial();
            t.polynomialMembers.add(new Monomial(coef, deg));
            q = q.plus( t );
            r = r.minus( t.multiply(b) );
            r = r.removeAllNullCoeff();

        }
        q = q.removeAllNullCoeff();
        return new Polynomial[]{ q, r };
    }


    /* The function ovverides the string method and makes it applicable for polynomials to be printed in a readable form*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Monomial term : polynomialMembers) {
            if (first) {
                sb.append(term);
                first = false;
            } else {
                sb.append(" ");
                if (term.getCoefficient() > 0) {
                    sb.append("+ ");
                    sb.append(term);
                } else {
                    sb.append("- ");
                    sb.append(term.negate());
                }
            }
        }
        return sb.toString();
    }
/* The function converts the polynomial's coefficient into double, it is useful for printing result for diviion and integration*/
    public String toStringDb() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Monomial term : polynomialMembers) {
            if (first) {
                sb.append(term.toStringDouble());
                first = false;
            } else {
                sb.append(" ");
                if (term.getCoefficient() > 0) {
                    sb.append("+ ");
                    sb.append(term.toStringDouble());
                } else {
                    sb.append("- ");
                    sb.append(term.negate().toStringDouble());
                }
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial polynomial = (Polynomial) o;
        int count = 0;
        if(polynomialMembers.size() != polynomial.polynomialMembers.size())
            return false;
        for(var i : polynomialMembers){
            for(var j : polynomial.polynomialMembers){
                if(i.getExponent() == j.getExponent()) {
                    if(i.getCoefficient().equals(j.getCoefficient())) {
                        count++;
                    }
                }
            }
        }
        if(count == polynomialMembers.size())
            return  true;
        else
            return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(polynomialMembers);
    }
}

