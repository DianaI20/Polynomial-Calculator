package myPackage.view;

import javax.swing.*;
import java.awt.*;


public class PolynomialCalculator {

    private JFrame frame ;
    private JPanel mainPanel;
    private JLabel firstPolynomial;
    private JLabel secondPolynomial;
    private JLabel result;
    private JPanel polyPanel;
    private JTextField firstPolyTextField;
    private JTextField secondPolyTextField;
    private JPanel operationPanel;
    private JTextField instructionFieldTextField;
    private JButton additionButton;
    private JButton divisionButton;
    private JButton multiplicationButton;
    private JButton derivativeButton;
    private JButton integrationButton;
    private JTextField resultTextField;
    private JButton subtractionButton;
    private JButton clearButton;
    private JTextField chooseOpTextField;



    public PolynomialCalculator(String title) {

        frame = new JFrame(title); // create a JFrame with the specified title
        frame.add(mainPanel);   //adding the panels
        mainPanel.setVisible(true);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 400);
        mainPanel.setSize(420, 400);
        additionButton.setPreferredSize(new Dimension(40, 50));

        /*Specifying the dimensions for the buttons */
        subtractionButton.setPreferredSize(new Dimension(40, 50));
        divisionButton.setPreferredSize(new Dimension(40, 50));
        multiplicationButton.setPreferredSize(new Dimension(40, 50));
        integrationButton.setPreferredSize(new Dimension(40, 50));
        derivativeButton.setPreferredSize(new Dimension(40, 50));
        clearButton.setPreferredSize(new Dimension(40, 50));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getFirstPolynomial() {
        return firstPolynomial;
    }

    public void setFirstPolynomial(JLabel firstPolynomial) {
        this.firstPolynomial = firstPolynomial;
    }

    public JLabel getSecondPolynomial() {
        return secondPolynomial;
    }

    public void setSecondPolynomial(JLabel secondPolynomial) {
        this.secondPolynomial = secondPolynomial;
    }

    public JLabel getResult() {
        return result;
    }

    public void setResult(JLabel result) {
        this.result = result;
    }

    public JPanel getPolyPanel() {
        return polyPanel;
    }

    public void setPolyPanel(JPanel polyPanel) {
        this.polyPanel = polyPanel;
    }

    public JTextField getFirstPolyTextField() {
        return firstPolyTextField;
    }

    public void setFirstPolyTextField(JTextField firstPolyTextField) {
        this.firstPolyTextField = firstPolyTextField;
    }

    public JTextField getSecondPolyTextField() {
        return secondPolyTextField;
    }

    public void setSecondPolyTextField(JTextField secondPolyTextField) {
        this.secondPolyTextField = secondPolyTextField;
    }

    public JPanel getOperationPanel() {
        return operationPanel;
    }

    public void setOperationPanel(JPanel operationPanel) {
        this.operationPanel = operationPanel;
    }

    public JTextField getInstructionFieldTextField() {
        return instructionFieldTextField;
    }

    public void setInstructionFieldTextField(JTextField instructionFieldTextField) {
        this.instructionFieldTextField = instructionFieldTextField;
    }

    public JButton getAdditionButton() {
        return additionButton;
    }

    public void setAdditionButton(JButton additionButton) {
        this.additionButton = additionButton;
    }

    public JButton getDivisionButton() {
        return divisionButton;
    }

    public void setDivisionButton(JButton divisionButton) {
        this.divisionButton = divisionButton;
    }

    public JButton getMultiplicationButton() {
        return multiplicationButton;
    }

    public void setMultiplicationButton(JButton multiplicationButton) {
        this.multiplicationButton = multiplicationButton;
    }

    public JButton getDerivativeButton() {
        return derivativeButton;
    }

    public void setDerivativeButton(JButton derivativeButton) {
        this.derivativeButton = derivativeButton;
    }

    public JButton getIntegrationButton() {
        return integrationButton;
    }

    public void setIntegrationButton(JButton integrationButton) {
        this.integrationButton = integrationButton;
    }

    public JTextField getResultTextField() {
        return resultTextField;
    }

    public void setResultTextField(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }

    public JButton getSubtractionButton() {
        return subtractionButton;
    }

    public void setSubtractionButton(JButton subtractionButton) {
        this.subtractionButton = subtractionButton;
    }

    public JTextField getChooseOpTextField() {
        return chooseOpTextField;
    }

    public void setChooseOpTextField(JTextField chooseOpTextField) {
        this.chooseOpTextField = chooseOpTextField;
    }
}
