package myPackage.controller;


import myPackage.model.Monomial;
import myPackage.model.Polynomial;
import myPackage.view.PolynomialCalculator;

import javax.swing.*;
import java.security.Policy;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    private PolynomialCalculator polynomialCalculator;

    public MainController() {
    }

    public void initializeController() {
        polynomialCalculator = new PolynomialCalculator("Polynomial Calculator");
        addActionListeners();
    }

    public Polynomial[] getPolynomialsFromTextFields() {
        String poly1;
        String poly2;
        poly1 = polynomialCalculator.getFirstPolyTextField().getText();
        poly2 = polynomialCalculator.getSecondPolyTextField().getText();
        System.out.println(poly1);
        return new Polynomial[]{ new Polynomial(poly1), new Polynomial(poly2)};
    }

    public void addActionListeners(){
        try {
            polynomialCalculator.getAdditionButton().addActionListener(e -> {
                Polynomial p[] = getPolynomialsFromTextFields();
                Polynomial result = p[0].plus(p[1]);
                polynomialCalculator.getResultTextField().setText(result.toString());
                polynomialCalculator.getResultTextField().setVisible(true);
            });
            polynomialCalculator.getSubtractionButton().addActionListener(e -> {
                Polynomial p[] = getPolynomialsFromTextFields();
                Polynomial result = p[0].minus(p[1]);
                polynomialCalculator.getResultTextField().setText(result.toString());
                polynomialCalculator.getResultTextField().setVisible(true);
            });

            polynomialCalculator.getMultiplicationButton().addActionListener(e -> {
                Polynomial p[] = getPolynomialsFromTextFields();
                Polynomial result = p[0].multiply(p[1]);
                polynomialCalculator.getResultTextField().setText(result.toString());
                polynomialCalculator.getResultTextField().setVisible(true);
            });
            polynomialCalculator.getDerivativeButton().addActionListener(e -> {
                Polynomial p[] = getPolynomialsFromTextFields();
                Polynomial result = p[0].derivative();
                polynomialCalculator.getResultTextField().setText(result.toString());
                polynomialCalculator.getResultTextField().setVisible(true);
            });
            polynomialCalculator.getIntegrationButton().addActionListener(e -> {
                Polynomial p[] = getPolynomialsFromTextFields();
                Polynomial result = p[0].integral();
                polynomialCalculator.getResultTextField().setText(result.toStringDb());
                polynomialCalculator.getResultTextField().setVisible(true);
            });

            polynomialCalculator.getDivisionButton().addActionListener(e -> {
                Polynomial p[] = getPolynomialsFromTextFields();
                Polynomial result[] = p[0].divides(p[1]);
                polynomialCalculator.getResultTextField().setText("Quotient: " + result[0].toStringDb() + "  Remainder: " + result[1].toStringDb());
                polynomialCalculator.getResultTextField().setVisible(true);
            });
            polynomialCalculator.getClearButton().addActionListener(e -> {
                polynomialCalculator.getFirstPolyTextField().setText("");
                polynomialCalculator.getSecondPolyTextField().setText("");
                polynomialCalculator.getResultTextField().setText("All clear :)");
            });
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
