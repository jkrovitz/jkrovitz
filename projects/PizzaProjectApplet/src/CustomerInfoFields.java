import javax.swing.*;
import java.awt.*;

/*
 * Rose Dillon, Jeremy Krovitz
 * CSci 1130-91
 * Summer 2017
 *
 * This is the CustomerInfoFields class. It creates JTextFields for the customer to type their
 * information and it also creates JLabels to describe the information the customer needs to
 * input. The JTextFields and the JLabels get added to the JPanel called customerInfoJPanel.
 */

class CustomerInfoFields extends JPanel {
    //These are our instance variables.
    public JLabel name, phone, email, street, city, state, zip;
    public  JTextField nameField, phoneField, emailField, streetField,
            cityField, stateField, zipField;
    private JPanel customerInfoJPanel;
    private String addressType;
    private PizzaProject project;
    private Color mamaMiaGreen = new Color(67, 240, 112);

    CustomerInfoFields(String type, PizzaProject project) {
        //Setting up initial conditions of some of instance variables.
        customerInfoJPanel=new JPanel();
        GridLayout grid = new GridLayout(7, 2);
        setLayout(new BorderLayout());//setting CustomerInfoFields to border layout
        customerInfoJPanel.setLayout(grid);  //customerInfoJPanel is being set to grid
        JLabel typeLabel=new JLabel(addressType, JLabel.CENTER);
        add(typeLabel);
        this.addressType = type;
        this.project = project;

        //Method calls that will create the JLabels, JTextFields, and add them to the JPanel.
        createJLabels();
        setFontForJLabels();
        createJTextFields();
        addComponentsToJPanel();
    }

    /**
     * This method creates the JLabels.
     */
    private void createJLabels() {
        name = new JLabel("Name: ", JLabel.RIGHT);
        phone = new JLabel("Telephone: ", JLabel.RIGHT);
        email = new JLabel("Email: ", JLabel.RIGHT);
        street = new JLabel("Street: ", JLabel.RIGHT);
        city = new JLabel("City: ", JLabel.RIGHT);
        state = new JLabel("State: ", JLabel.RIGHT);
        zip = new JLabel("Zip: ", JLabel.RIGHT);
    }

    /**
     * This method sets the font of the JLabels.
     */
    private void setFontForJLabels(){
        JLabel [] arrayOfCustomerInfoJLabels= { name, phone, email, street, city, state, zip};
        for(JLabel aJLabel: arrayOfCustomerInfoJLabels) {
            aJLabel.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
            aJLabel.setOpaque(true);
            aJLabel.setBackground(mamaMiaGreen);
        }
    }

    /**
     * This method initializes the JTextFields.
     */
    private void createJTextFields() {
        nameField = new JTextField(40);
        phoneField = new JTextField(40);
        emailField = new JTextField(40);
        streetField = new JTextField(40);
        cityField = new JTextField(40);
        stateField = new JTextField(40);
        zipField = new JTextField(40);
    }


    /**
     * This method adds the JLabels and JTextFields to the customerInfoJPanel. The JPanel
     * then gets added.
     */
    private void addComponentsToJPanel() {
        customerInfoJPanel.add(name);
        customerInfoJPanel.add(nameField);
        customerInfoJPanel.add(phone);
        customerInfoJPanel.add(phoneField);
        customerInfoJPanel.add(email);
        customerInfoJPanel.add(emailField);
        customerInfoJPanel.add(street);
        customerInfoJPanel.add(streetField);
        customerInfoJPanel.add(city);
        customerInfoJPanel.add(cityField);
        customerInfoJPanel.add(state);
        customerInfoJPanel.add(stateField);
        customerInfoJPanel.add(zip);
        customerInfoJPanel.add(zipField);
        add(customerInfoJPanel);

    }
}
