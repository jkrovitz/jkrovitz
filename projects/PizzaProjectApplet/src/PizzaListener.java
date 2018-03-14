import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

/*
 * Rose Dillon, Jeremy Krovitz
 * CSci 1130-91
 * Summer 2017
 *
 * This is the PizzaListener class. It instantiates the JRadioButtons, JCheckBoxes,
 * and JButtons. It also calculates the cost of the pizza and prints
 * it to the text area. 
 */

public class PizzaListener implements ActionListener, ItemListener {

    //These are our instance variables.
    private int totalLargeChecks, totalMediumChecks, totalSmallChecks,
            totalPepperoniChecks, totalGreenPepperChecks, totalMushroomChecks,
            totalOliveChecks;
    private JButton submit, cancel;
    private JPanel buttonsJPanel, pizzaJPanel;
    private JTextArea orderSummaryJTArea;
    private JScrollPane pane;
    private JCheckBox[]toppingsJCheckBoxArray;
    private JRadioButton[]sizesJRadioButtonArray;
    private ButtonGroup pizzaSizesGroup;
    private JRadioButton small, medium, large;
    private JCheckBox pepperoni, mushroom, greenPepper, olives;
    private PizzaProject project;
    private static final double LARGE_PRICE = 10.99, MEDIUM_PRICE = 9.99,
            SMALL_PRICE = 8.99, PEPPERONI_PRICE = 1.99,
            GREEN_PEPPER_PRICE = 0.99, MUSHROOM_PRICE = 0.99,
            OLIVE_PRICE = 0.99;
    private String subTotalPriceString;
    private String roundedSalesTax;
    private String roundedOrderTotal;



    /**
     * This is the pizza listener constructor.
     * @param pizzaJPanel a JPanel that contains all panels of the GUI within it.
     * @param submit submit order.
     * @param cancel cancel order.
     * @param buttonsJPanel contains the cancel and submit button.
     * @param pane JScroll pane added to the JTextArea, OrderSummaryJTArea.
     * @param orderSummaryJTArea pizza order summary is printed to this text area.
     * @param pizzaSizesGroup ButtonGroup for pizza sizes.
     * @param small JButton for small pizza.
     * @param medium JButton for medium pizza.
     * @param large JButton for large pizza.
     * @param pepperoni JButton for pepperoni.
     * @param mushroom JButton for mushroom.
     * @param greenPepper JButton for green pepper.
     * @param olives JButton for olives.
     * @param project an object that is an instance of the PizzaProject class.
     */
    public PizzaListener(JPanel pizzaJPanel, JButton submit, JButton cancel, JPanel buttonsJPanel, JScrollPane pane, JTextArea
            orderSummaryJTArea, ButtonGroup pizzaSizesGroup, JRadioButton small, JRadioButton medium, JRadioButton large,
                         JCheckBox pepperoni, JCheckBox mushroom, JCheckBox greenPepper,
                         JCheckBox olives, PizzaProject project) {
        this.pizzaJPanel = pizzaJPanel;
        this.pane = pane;
        this.submit = submit;
        this.cancel = cancel;
        this.buttonsJPanel = buttonsJPanel;
        this.orderSummaryJTArea = orderSummaryJTArea;
        this.pizzaSizesGroup = pizzaSizesGroup;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.pepperoni = pepperoni;
        this.mushroom = mushroom;
        this.greenPepper = greenPepper;
        this.olives = olives;
        this.project = project;
        initializeArrays();
    }

    /**
     * Calls to methods to initialize arrays.
     */
    private void initializeArrays(){
        initializeSizesArray();
        initializeToppingsArray();
    }

    /**
     * This method initializes the sizesJRadioButtonArray.
     */
    private void initializeSizesArray() {
        sizesJRadioButtonArray = new JRadioButton[3];
        sizesJRadioButtonArray[0] = small;
        sizesJRadioButtonArray[1] = medium;
        sizesJRadioButtonArray[2] = large;
    }

    /**
     * This method initializes the toppingsJCheckBoxArray.
     */
    private void initializeToppingsArray(){
        toppingsJCheckBoxArray = new JCheckBox[4];
        toppingsJCheckBoxArray[0] = pepperoni;
        toppingsJCheckBoxArray[1] = mushroom;
        toppingsJCheckBoxArray[2] = greenPepper;
        toppingsJCheckBoxArray[3] = olives;
    }


    /**
     * This action listener handles the button clicks on the
     * submit button. It prints the sub total, the tax amount,
     * and the order total of the pizza to the text area.
     * @param e This variable represents the source of the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //initializes order variables
        double salesTax;
        double orderTotal;
        double subTotalPrice;
        String roundedSubTotalPrice;

        //adding order prices
        subTotalPrice = ( totalSmallChecks * SMALL_PRICE +  totalMediumChecks * MEDIUM_PRICE +
                totalLargeChecks * LARGE_PRICE + totalGreenPepperChecks * GREEN_PEPPER_PRICE +
                totalPepperoniChecks * PEPPERONI_PRICE + totalMushroomChecks * MUSHROOM_PRICE +
                totalOliveChecks * OLIVE_PRICE);
        roundedSubTotalPrice = formatDecimal(subTotalPrice);
        subTotalPriceString = String.valueOf(roundedSubTotalPrice);


        salesTax = subTotalPrice * 0.0725;
        roundedSalesTax = formatDecimal(salesTax);

        orderTotal = salesTax + subTotalPrice;
        roundedOrderTotal = formatDecimal(orderTotal);

        pizzaSizesGroup = new ButtonGroup();
        pizzaSizesGroup.add(small);
        pizzaSizesGroup.add(medium);
        pizzaSizesGroup.add(large);

        //Clicking the submit button prints the total for the order
        Object obj = e.getSource();
        if (obj == submit) {
            submitActionPerformedStatements();
        }

        //reset the order summary with is a JTextArea and than adds the header back after clearing the order
        if (obj == cancel) {
            cancelActionPerformedStatements();
        }
    }

    /**
     * This method is a helper method to actionPerformed. It executes the following statements
     * when the submit button is pressed.
     */
    private void submitActionPerformedStatements(){
        orderSummaryJTArea.append('\n' + " " + '\n' + "Order subtotal: " +
                "" + subTotalPriceString);
        orderSummaryJTArea.append('\n' + "Sales tax: " + roundedSalesTax);
        orderSummaryJTArea.append('\n' + "Order total: " + roundedOrderTotal);
        orderSummaryJTArea.append('\n' + "  " + '\n' + " " + '\n' + "Thank you " +
                "for ordering from" + '\n' + "Mama Mia's " + "Drop Dead Pizza!"
                + '\n');
        submit.setEnabled(false);
        for (JRadioButton sizeJRadioButton : sizesJRadioButtonArray){
            sizeJRadioButton.setEnabled(false);
        }
        for (JCheckBox toppingJCheckBox : toppingsJCheckBoxArray) {
            toppingJCheckBox.setEnabled(false);

        }
    }

    /**
     * This method is a helper method to actionPerformed. It executes the following statements
     * when the cancel button is pressed.
     */
    private void cancelActionPerformedStatements(){
        orderSummaryJTArea.setText("");
        orderSummaryJTArea.append(PizzaProject.ORDER_HEADER);
        for(JRadioButton sizeJRadioButton: sizesJRadioButtonArray){
            sizeJRadioButton.setEnabled(true);
        }
        for (JCheckBox toppingJCheckBox : toppingsJCheckBoxArray) {
            toppingJCheckBox.setEnabled(true);
            if (toppingJCheckBox.isSelected()) {
                toppingJCheckBox.setSelected(false);
            }

        }
        submit.setEnabled(true);
        orderSummaryJTArea.setText("");
        orderSummaryJTArea.append(PizzaProject.ORDER_HEADER);
    }

    /**
     * This method converts a decimal to a
     * dollar amount in String form. It keeps
     * two of the trailing zeros and also
     * rounds to the nearest hundredth.
     *
     * @param number A decimal value that needs
     *               to be converted to a dollar
     *               amount of type String.
     *
     * @return A dollar amount of type String.
     */
    private String formatDecimal(double number) {
        NumberFormat dollarFormatter = NumberFormat.getCurrencyInstance();
        return dollarFormatter.format(number);
    }

    /**
     * This method is executed with the selection and deselection
     * of JCheckBoxes and JRadioButtons.
     * @param e This variable represents the source of the event.
     */
    @Override
    public void itemStateChanged(ItemEvent e){
        String output = "";
        if(e.getSource() == small){
            if(small.isSelected()){
                totalSmallChecks++;
                output = "1 small pizza     \t $" + SMALL_PRICE + '\n';
            }

            else if(!small.isSelected()){
                totalSmallChecks--;
                output = "1 small pizza removed \t $" +  - SMALL_PRICE;
            }
        }
        if(e.getSource() == medium){
            if(medium.isSelected()){
                totalMediumChecks++;
                output = "1 medium pizza     \t $" + MEDIUM_PRICE + '\n';
            }

            else if(!medium.isSelected()){
                totalMediumChecks--;
                output = "1 medium pizza removed \t $" +  - MEDIUM_PRICE;
            }
        }

        if(e.getSource() == large){
            if(large.isSelected()){
                totalLargeChecks++;
                output = "1 large pizza     \t $" + LARGE_PRICE;
            } else {
                totalLargeChecks--;
                output = "1 large pizza removed           $" +  - LARGE_PRICE;
            }
        }



        if(e.getSource() == pepperoni){
            if(pepperoni.isSelected()){
                totalPepperoniChecks++;
                output = "pepperoni         \t $" + PEPPERONI_PRICE +'\n';
            }

            else if(!pepperoni.isSelected()){
                totalPepperoniChecks--;
                output = '\n' + "pepperoni removed \t $" +  - PEPPERONI_PRICE + '\n';
            }
        }

        if(e.getSource() == greenPepper){
            if(greenPepper.isSelected()){
                totalGreenPepperChecks++;
                output = "green pepper    \t $" + GREEN_PEPPER_PRICE + "\n";
            }

            else if(!greenPepper.isSelected()){
                totalGreenPepperChecks--;
                output = "green pepper removed \t $" +  - GREEN_PEPPER_PRICE + "\n";
            }
        }

        if(e.getSource() == mushroom){
            if(mushroom.isSelected()){
                totalMushroomChecks++;
                output = "mushrooms             \t $" + MUSHROOM_PRICE + "\n";
            }

            else if(!mushroom.isSelected()){
                totalMushroomChecks--;
                output = "mushrooms removed \t $" +  - MUSHROOM_PRICE + "\n";
            }
        }
        if(e.getSource() == olives){
            if(olives.isSelected()){
                totalOliveChecks++;
                output = "olives                \t $" + OLIVE_PRICE + "\n";
            }

            else if(!olives.isSelected()){
                totalOliveChecks--;
                output = "olives removed \t $" +  - OLIVE_PRICE + "\n";
            }
        }
        orderSummaryJTArea.append(output);
        project.repaint();
    }


    /**
     * This method will be called if any of the pizza toppings are checked before a
     * pizza size has been selected and will uncheck the JCheckBox, causing the
     * topping to be shown as getting removed on the JTextArea.
     */
    public void toppingSelectedBeforePizzaSize() {
        if ((pepperoni.isSelected() || mushroom.isSelected() || greenPepper.isSelected() || olives.isSelected()) && !small.isSelected() && !medium.isSelected() && !large.isSelected()) {
            if (pepperoni.isSelected()) {
                pepperoni.setSelected(false);
                sizeBeforeToppingsMessage();
            }

            if (mushroom.isSelected()) {
                mushroom.setSelected(false);
                sizeBeforeToppingsMessage();
            }

            if (greenPepper.isSelected()) {
                greenPepper.setSelected(false);
                sizeBeforeToppingsMessage();
            }

            if (olives.isSelected()) {
                olives.setSelected(false);
                sizeBeforeToppingsMessage();
            }
        }
    }

    /*
     * This is the method that tells a user they must select the pizza size before
     * their pizza toppings.
     */
    private void sizeBeforeToppingsMessage(){
        JOptionPane.showMessageDialog(project, "You must select a pizza size before" +
                " choosing a topping.");
    }
}