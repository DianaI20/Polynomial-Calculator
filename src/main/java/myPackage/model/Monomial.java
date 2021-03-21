package myPackage.model;

import java.text.DecimalFormat;

public class Monomial {
    private Double coefficient;
    private Integer exponent;

    public Monomial() {
    }

    public Monomial(Double coefficient, Integer exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getExponent() {
        return exponent;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }

    /* This function performs addition for two monomials. It adds the coefficients for the terms with the same exponent*/
    public Monomial add(Monomial m) {
        if (getExponent() != m.getExponent())
            throw new RuntimeException("  Exponents not equal.");
        else
            return new Monomial(m.getCoefficient() + this.getCoefficient(), getExponent());
    }

    /* Function multiplies two monomials, by multiplying each coefficient and adding the exponents*/
    public Monomial multiply(Monomial m) {
        return new Monomial(this.getCoefficient() * m.getCoefficient(), m.getExponent() + getExponent());
    }

    /* Function performs the derivative on the specific monomial */
    public Monomial derivative() {
        if (getExponent() == 0)
            return new Monomial(0.0, 0);
        else
            return new Monomial(getCoefficient() * (getExponent().doubleValue()), getExponent() - 1);
    }

    /* Function computes the integral for the monomial*/
    public Monomial integral() {
            return new Monomial(getCoefficient() / (getExponent() + 1), getExponent() + 1);
    }

    /* Function returns the term with the negative sign*/
    public Monomial negate() {
        return new Monomial(coefficient * (-1), exponent);
    }

    @Override
    public String toString() {

        if (coefficient == 0) {
            return "0";
        }
        if (exponent == 0) {
            return "" + coefficient.intValue();
        }
        if (coefficient == 0) {
            if (exponent == 1) {
                return "x";
            } else {
                return "x^" + exponent;
            }
        }
        if (exponent == 1) {
            return coefficient.intValue() + "x";
        }
        return coefficient.intValue() + "x^" + exponent;
    }

    public String toStringDouble() {
        DecimalFormat df = new DecimalFormat("#.##");

        if (coefficient == 0) {
            return "0";
        }
        if (exponent == 0) {
            return "" + df.format(coefficient);
        }
        if (coefficient == 0) {
            if (exponent == 1) {
                return "x";
            } else {
                return "x^" + exponent;
            }
        }
        if (exponent == 1) {
            return df.format(coefficient) + "x";
        }
        return df.format(coefficient) + "x^" + exponent;
    }
}
