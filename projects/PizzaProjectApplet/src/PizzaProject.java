import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/*
 * Rose Dillon, Jeremy Krovitz
 * CSci 1130-91
 * Summer 2017
 *
 * This is the PizzaApplet class. It draws the images to the Applet, sets up the main
 * parts of the GUI, and initializes the submit and clear buttons for customer contact
 * information.
 */

public class PizzaProject extends JApplet implements ActionListener {
    private JScrollPane pane;
    private JButton submitJButton = new JButton("Order"), cancelJButton = new JButton("Cancel");
    private JPanel addressAllPanel,addressFieldsAndOutputPanel, pizzaJPanel, buttonsJPanelForPizzaOrder, headerJPanel, pizzaSizesAndToppingsJPanel, orderSummaryJPanel;
    private Image pizzaPlaceTitleImage, pepperoniImg, cheesePizzaImg, mushroomsImg,
            greenPepperImg, olivesImg;
    private ImageIcon pizzaPlaceTitleImageIcon;
    private JLabel sizes = new JLabel("<html><font size = +2 color = #FF8700> Pizza Sizes:  </font></html>");
    private JLabel toppings = new JLabel("<html><font size = +2 color = #FF8700>Pizza Toppings: </font></html>");
    private JLabel pizzaPlaceTitleLabel;
    private ButtonGroup pizzaSizesGroup;
    private JRadioButton smallJRadioButton = new JRadioButton("Small"),
            mediumJRadioButton = new JRadioButton("Medium"), largeJRadioButton = new JRadioButton("Large");
    private JCheckBox pepperoniJCheckBox = new JCheckBox("Pepperoni"), mushroomJCheckBox = new JCheckBox("Mushroom"),
            greenPepperJCheckBox = new JCheckBox("Green Pepper"), olivesJCheckBox = new JCheckBox("Olives");
    private JTextArea orderSummaryJTArea = new JTextArea(1, 20);
    private Color mamaMiaGreen = new Color(67, 240, 112);
    private Color pizzaColor = new Color(216, 221, 176);
    public static final String ORDER_HEADER = "Mama Mia's Drop Dead Pizza\n1003 Please Call My Mama Drive\n" +  //Declared as public as it is accessed in the listener class.
            "Pizza Wonderland, SP, 00000\n440-589-1234 \n \n \n";
    private PizzaListener listener;
    private int x, y, width, height;
    private JPanel buttonsJPanelForCustomerInfo;
    private JPanel addressPanel;
    private JTextArea output;
    private JButton submit, clear;
    private String outputString;
    private CustomerInfoFields deliveryAddress;


    /**
     * In this method the headerJPanel and orderSummaryJPanel are initialized. Three helper methods are
     * called, two of them initialize objects, and the other is a helper init method that contains calls to
     * setup the GUI.
     */
    public void init() {
        headerJPanel = new JPanel();
        orderSummaryJPanel = new JPanel(new FlowLayout());
        initializingPizzaJPanelAndListener();
        initializingImages();
        initializePaneAndMethodCallsToSetUpGUI();
    }

    /**
     * Here we initialize and set pizzaJPanel's layout and also initialize an instance
     * of the PizzaListener class.
     */
    public void initializingPizzaJPanelAndListener() {
        pizzaJPanel = new JPanel();
        pizzaJPanel.setLayout(new BorderLayout());
        listener = new PizzaListener(pizzaJPanel, submitJButton, cancelJButton, buttonsJPanelForPizzaOrder, pane,
                orderSummaryJTArea, pizzaSizesGroup, smallJRadioButton, mediumJRadioButton, largeJRadioButton, pepperoniJCheckBox, mushroomJCheckBox, greenPepperJCheckBox,
                olivesJCheckBox, this);
    }

    /**
     * Here we initialize our pizza/topping images.
     */
    public void initializingImages(){
        pepperoniImg = getImage(getCodeBase(), "images/"+ "pepperoni.png");
        cheesePizzaImg = getImage(getCodeBase(), "images/" + "cheesePizza.png");
        mushroomsImg = getImage(getCodeBase(), "images/" + "mushrooms.png");
        greenPepperImg = getImage(getCodeBase(), "images/" + "greenPepper.png");
        olivesImg = getImage(getCodeBase(), "images/" + "olives.png");
    }

    /**
     * This is the method with calls to methods that are involved with setting
     * up the GUI.
     */
    public void initializePaneAndMethodCallsToSetUpGUI(){
        setUpHeader();
        setUpFooter(listener);
        initializePizzaSizesAndToppings(listener);
        pane = new JScrollPane();
        setUpOrderSummary();
        setPizzaPanelLayout();
    }

    /**
     * This is the paint method, which allows shapes, text,
     * images, etc. to be drawn to the applet.
     *
     * @param g This is an instance of the graphics class.
     */
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(pizzaColor);
        listener.toppingSelectedBeforePizzaSize();
        drawPizza(g2d);
    }

    /**
     * This method draws the pizza image corresponding with the
     * JCheckBox/JRadioButton selected.
     */
    private void drawPizza(Graphics2D g2d) {
        if (smallJRadioButton.isSelected()) {
            x = getWidth() / 2 - 100;
            y = getHeight() / 2 - 50;
            width = 135;
            height = 129;
        } else if (mediumJRadioButton.isSelected()) {
            x = getWidth() / 2 - 158;
            y = getHeight() / 2 - 75;
            width = 235;
            height = 225;
        } else if (largeJRadioButton.isSelected()) {
            x = getWidth() / 2 - 203;
            y = getHeight() / 2 - 100;
            width = 335;
            height = 321;
        }


        g2d.drawImage(cheesePizzaImg, x, y, width, height, this);


        if (pepperoniJCheckBox.isSelected()) {
            g2d.drawImage(pepperoniImg, x, y, width, height, this);
        }
        if (olivesJCheckBox.isSelected()) {
            g2d.drawImage(olivesImg, x, y, width, height, this);
        }
        if (greenPepperJCheckBox.isSelected()) {
            g2d.drawImage(greenPepperImg, x, y, width, height, this);
        }
        if (mushroomJCheckBox.isSelected()) {
            g2d.drawImage(mushroomsImg, x, y, width, height, this);
        }

    }


    /**
     * This method contains a series of helper methods that help setup
     * the header of the GUI.
     */
    private void setUpHeader() {
        addingTheLogo();
        addingTheLogoToAHeader();
        setUpJPanelContainingAllAddressRelatedPanels();
        setUpAddress();
        setUpFieldsAndOutputJPanel();
        setUpOutput();
        setUpButtons();
        addressAllJPanelAddingLayoutBackground();
        headerJPanelAddingLayoutBackground();
    }

    /**
     * In this method the headerJPanel is added to the pizzaJPanel, the
     * background is set to mamaMiaGreen, the picture is placed on the
     * JLabel, pizzaPlaceTitleLabel, which is then added to the applet.
     */
    private void addingTheLogo() {
        pizzaJPanel.add(headerJPanel);
        headerJPanel.setBackground(mamaMiaGreen);
        pizzaPlaceTitleImage = getImage(getCodeBase(), "images/" + "pizzaLogo2.png");
        pizzaPlaceTitleImageIcon = new ImageIcon(pizzaPlaceTitleImage);
        pizzaPlaceTitleLabel = new JLabel(pizzaPlaceTitleImageIcon);
        add(pizzaPlaceTitleLabel);
    }

    /**
     * A new panel is created, the background is set, the label pizzaPlaceTitleImage
     * is placed on the new panel, which is then given a border, and is placed
     * on the headerJPanel.
     */
    private void addingTheLogoToAHeader(){
        JPanel theNewPanel = new JPanel();
        theNewPanel.setBackground(mamaMiaGreen);
        theNewPanel.add(pizzaPlaceTitleLabel);
        theNewPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        headerJPanel.add(theNewPanel);
    }

    /**
     * This method sets up the panel that contains all of the panels relating to
     * the addres.
     */
    private void setUpJPanelContainingAllAddressRelatedPanels(){
        addressAllPanel = new JPanel();
        addressAllPanel.setLayout(new BorderLayout());
        addressAllPanel.setOpaque(true);
        addressAllPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * This method sets up the address panel and initializes the object that is
     * an instance of CustomerInfoFields called deliveryAddress.
     */
    private void setUpAddress(){
        addressPanel=new JPanel();
        BoxLayout box=new BoxLayout(addressPanel, BoxLayout.Y_AXIS);
        addressPanel.setLayout(box);
        deliveryAddress = new CustomerInfoFields("Home", this);
        addressPanel.add(deliveryAddress);
    }

    /**
     * This method sets up the addressFieldsAndOutput JPanel. This panel was created,
     * so that the two panels would be side by side in the applet.
     */
    private void setUpFieldsAndOutputJPanel() {
        addressFieldsAndOutputPanel = new JPanel(new GridLayout(1, 2));
        addressFieldsAndOutputPanel.add(addressPanel);
        addressFieldsAndOutputPanel.setOpaque(true);
        addressFieldsAndOutputPanel.setBackground(mamaMiaGreen);
    }

    /**
     * The output panel with the customer's contact information is created in this method.
     */
    private void setUpOutput(){
        JPanel outputPanel=new JPanel(new FlowLayout());
        output=new JTextArea(5,40);
        output.setText("Customer Contact Information");
        output.setLineWrap(true);
        output.setEditable(false);
        JScrollPane scroll=new JScrollPane(output);//scroll adds a scroll par and puts j panel in that scroll pane, soo we can scroll up and down the JTextARea
        outputPanel.add(scroll);
        addressFieldsAndOutputPanel.add(output);
    }


    /**
     * This method initializes a JPanel, JButtons, adds the JButtons to the 
     * JPanel, adds actionListeners to the JButtons, and sets the background
     * of the JPanel. 
     */
    private void setUpButtons(){
        buttonsJPanelForCustomerInfo=new JPanel(new FlowLayout());
        submit = new JButton( "Submit");
        clear = new JButton("Clear");
        buttonsJPanelForCustomerInfo.add(submit);
        buttonsJPanelForCustomerInfo.add(clear);
        submit.addActionListener(this);
        clear.addActionListener(this);
        buttonsJPanelForCustomerInfo.setOpaque(true);
        buttonsJPanelForCustomerInfo.setBackground(mamaMiaGreen);
    }

    /**
     * This panel adds the two address panels or the addressFieldsAndOutput Panel, in 
     * the Northern right corner of the applet and adds the buttonsJPanelForCustomerInfo right below the 
     * addressFieldsAndOutput Panel. 
     */
    private void addressAllJPanelAddingLayoutBackground(){
        addressAllPanel.add(addressFieldsAndOutputPanel, BorderLayout.NORTH);
        addressAllPanel.add(buttonsJPanelForCustomerInfo, BorderLayout.SOUTH);
        addressAllPanel.setOpaque(true);
        addressAllPanel.setBackground(mamaMiaGreen);
    }

    /**
     * This method adds the addressAllPanel to the headerJPanel, sets its layout and 
     * its background. It also adds the headerJPanel to the applet. 
     */
    private void headerJPanelAddingLayoutBackground(){
        headerJPanel.add(addressAllPanel);
        headerJPanel.setLayout(new GridLayout(1,    0));
        headerJPanel.setOpaque(true);
        headerJPanel.setBackground(mamaMiaGreen);
        add(headerJPanel);
    }

    /**
     * This action listener handles the button clicks on the
     * submit and clear JButtons for the customer information. 
     */
    public void actionPerformed(ActionEvent e) {
        JButton eventButton=(JButton)e.getSource();

        if(eventButton==submit){
            buildOutputString();
            output.append(outputString);
            outputString="";
            JTextField [] fieldsArray = {deliveryAddress.nameField,
                    deliveryAddress.phoneField, deliveryAddress.emailField,
                    deliveryAddress.streetField,deliveryAddress.cityField,
                    deliveryAddress.stateField, deliveryAddress.zipField };
            for (JTextField field : fieldsArray){
                field.setEnabled(false);
            }
            submit.setEnabled(false);
        }
        if(eventButton==clear){
            output.setText("");
            JTextField [] fieldsArray = {deliveryAddress.nameField,
                    deliveryAddress.phoneField, deliveryAddress.emailField,
                    deliveryAddress.streetField,deliveryAddress.cityField,
                    deliveryAddress.stateField, deliveryAddress.zipField };
            for (JTextField field : fieldsArray){
                field.setText("");
                field.setEnabled(true);
            }
            submit.setEnabled(true);
        }


    }

    public void buildOutputString(){
        //name, street, city, state, zip
        outputString="\n\nCustomer Name: " + deliveryAddress.nameField.getText() +
                "\nPhone: "+deliveryAddress.phoneField.getText() + "\nEmail: "+deliveryAddress.emailField.getText() + "\nStreet: "+deliveryAddress.streetField.getText()
                + "\nCity: "+deliveryAddress.cityField.getText() + "\nState: "+deliveryAddress.stateField.getText()
                + "\nZip: "+deliveryAddress.zipField.getText()+"\n";
    }

    //instantiates, initializes buttonsJPanelForPizzaOrder and add them to a group
    //register the buttonsJPanelForPizzaOrder and add the group to the applet
    private void setUpFooter(ActionListener controller) {
        buttonsJPanelForPizzaOrder = new JPanel();
        buttonsJPanelForPizzaOrder.setBackground(mamaMiaGreen);
        buttonsJPanelForPizzaOrder.add(submitJButton);
        buttonsJPanelForPizzaOrder.add(cancelJButton);
        submitJButton.addActionListener(controller);
        cancelJButton.addActionListener(controller);
        pizzaJPanel.add(buttonsJPanelForPizzaOrder);
        add(buttonsJPanelForPizzaOrder, BorderLayout.SOUTH);
    }

    /**
     * This method initializes the pizzaSizesAndToppingsJPanel and the 
     * pizzaSizesGroup. It also calls two methods - addingTheSizes and 
     * addingTheToppings. 
     * @param listener Listens for a JRadioButton/JCheckBox to be selected. 
     */
    private void initializePizzaSizesAndToppings(ItemListener listener) {
        pizzaSizesAndToppingsJPanel = new JPanel(new GridLayout(10, 1, 0, 0));
        pizzaSizesGroup = new ButtonGroup();
        addingTheSizes(listener);
        addingTheToppings(listener);
    }

    /**
     * This is one of the sub-methods of initializePizzaSizesAndToppings.
     * This method adds the sizes to the JPanel. It initializes an array and
     * loops over each of the sizes, or JRadioButtons, in the array, they
     * get an item listener, get added to the PizzaSizesGroup, and are then added
     * to the pizzaSizesAndToppingsJPanel. This satisfies the loop, array, and other
     * requirements outlined in the final project guidelines.
     */
    private void addingTheSizes(ItemListener listener) {
        pizzaSizesAndToppingsJPanel.add(sizes);
        JRadioButton[] pizzaSizeJRadioButtonArray = {smallJRadioButton, mediumJRadioButton, largeJRadioButton};
        for (JRadioButton aSizeJRadioButton: pizzaSizeJRadioButtonArray){
            aSizeJRadioButton.addItemListener(listener);
            pizzaSizesGroup.add(aSizeJRadioButton);
            pizzaSizesAndToppingsJPanel.add(aSizeJRadioButton);
        }

    }

    /**
     * This is one of the sub-methods of initializePizzaSizesAndToppings.
     * This method adds the toppings to the JPanel. It initializes an array and
     * loops over each of the toppings, or JCheckBoxes, in the array, they
     * get added to the applet, they get added to the pizzaSizesAndToppingsPanel,
     * they then get an ItemListener. This satisfies the loop, array, and other
     * requirements outlined in the final project guidelines.
     */
    private void addingTheToppings(ItemListener listener){
        pizzaSizesAndToppingsJPanel.add(toppings);
        JCheckBox [] toppingsArray = {pepperoniJCheckBox, mushroomJCheckBox,
                greenPepperJCheckBox, olivesJCheckBox};
        for (JCheckBox aJCheckBox: toppingsArray){
            add(aJCheckBox);
            pizzaSizesAndToppingsJPanel.add(aJCheckBox);
            aJCheckBox.addItemListener(listener);
        }

    }

    /**
     * This method instantiates and adds order summary panels to the applet.
     */
    private void setUpOrderSummary() {
        orderSummaryJTArea.setText(ORDER_HEADER);
        orderSummaryJTArea.setLineWrap(true);
        orderSummaryJTArea.setEditable(false);
        pane = new JScrollPane(orderSummaryJPanel);
        orderSummaryJPanel.setOpaque(true);
        orderSummaryJPanel.setBackground(Color.white);
        orderSummaryJPanel.add(orderSummaryJTArea);

    }

    /**
     * This method sets the border layout and adds the pizzaJPanel to the
     * applet.
     */
    public void setPizzaPanelLayout(){
        pizzaJPanel.add(pane, BorderLayout.EAST);
        pizzaJPanel.add(pizzaSizesAndToppingsJPanel, BorderLayout.WEST);
        pizzaJPanel.add(headerJPanel, BorderLayout.NORTH);
        pizzaJPanel.add(buttonsJPanelForPizzaOrder, BorderLayout. SOUTH);
        add(pizzaJPanel);
    }
}