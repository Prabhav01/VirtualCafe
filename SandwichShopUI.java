import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SandwichShopUI {
    private JFrame frame;
    private JCheckBox multigrainBox, italianBox, flatbreadBox, honeyoatBox;
    private JCheckBox turkeyBox, hamBox, roastbeefBox, chickenBox;
    private JCheckBox provoloneBox, pepperjackBox;
    private JCheckBox tomatoBox, lettuceBox, onionBox;
    private JSpinner quantitySpinner;
    private JTextArea orderArea;
    private double total = 0.0;
    private JComboBox<String> paymentMethodCombo;
    private JTextField cashField;
    private JTextField nameField, cardNumberField, cvvField, expiryField;

    public SandwichShopUI() {
        frame = new JFrame("Sandwich Shop Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());

        // === Meat & Cheese Panel ===
        JPanel BreadPanel = new JPanel(new GridLayout(0, 1));
        BreadPanel.setBorder(BorderFactory.createTitledBorder("Meat"));
        multigrainBox = new JCheckBox("Multigrain");
        italianBox = new JCheckBox("Italian");
        flatbreadBox = new JCheckBox("Flatbread");
        honeyoatBox = new JCheckBox("Honey Oat");
        BreadPanel.add(multigrainBox);
        BreadPanel.add(italianBox);
        BreadPanel.add(flatbreadBox);
        BreadPanel.add(honeyoatBox);

        // === Meat & Cheese Panel ===
        JPanel meatPanel = new JPanel(new GridLayout(0, 1));
        meatPanel.setBorder(BorderFactory.createTitledBorder("Meat"));
        hamBox = new JCheckBox("Ham");
        turkeyBox = new JCheckBox("Turkey");
        roastbeefBox = new JCheckBox("Roast Beef");
        chickenBox = new JCheckBox("Chicken");
        provoloneBox = new JCheckBox("Provolone");
        pepperjackBox = new JCheckBox("Pepper Jack");
        meatPanel.add(hamBox);
        meatPanel.add(turkeyBox);
        meatPanel.add(roastbeefBox);
        meatPanel.add(chickenBox);
        meatPanel.add(provoloneBox);
        meatPanel.add(pepperjackBox);

        // === Toppings 1 Panel ===
        JPanel toppings1Panel = new JPanel(new GridLayout(0, 1));
        toppings1Panel.setBorder(BorderFactory.createTitledBorder("Toppings 1"));
        lettuceBox = new JCheckBox("Lettuce");
        tomatoBox = new JCheckBox("Tomato");
        onionBox = new JCheckBox("Onion");
        toppings1Panel.add(lettuceBox);
        toppings1Panel.add(tomatoBox);
        toppings1Panel.add(onionBox);


        // === Quantity and Button ===
        JPanel actionPanel = new JPanel(new GridLayout(0, 1));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Order Options"));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        actionPanel.add(new JLabel("Quantity:"));
        actionPanel.add(quantitySpinner);
        JButton addButton = buttonFactory.createButton("Add to Order", e -> addToOrder());
        actionPanel.add(addButton);

        // === Top Options Layout ===
        JPanel optionsPanel = new JPanel(new GridLayout(1, 4));
        optionsPanel.add(meatPanel);
        optionsPanel.add(toppings1Panel);
        optionsPanel.add(actionPanel);

        // === Order Display ===
        orderArea = new JTextArea();
        orderArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderArea);

        // === Payment Panel ===
        JPanel paymentPanel = new JPanel(new GridLayout(0, 2));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment"));

        paymentMethodCombo = new JComboBox<>(new String[]{"Cash", "Credit Card"});
        paymentPanel.add(new JLabel("Payment Method:"));
        paymentPanel.add(paymentMethodCombo);

// Cash input
        paymentPanel.add(new JLabel("Cash Tendered:"));
        cashField = new JTextField();
        paymentPanel.add(cashField);

// Credit card inputs
        paymentPanel.add(new JLabel("Name on Card:"));
        nameField = new JTextField();
        paymentPanel.add(nameField);

        paymentPanel.add(new JLabel("Card Number:"));
        cardNumberField = new JTextField();
        paymentPanel.add(cardNumberField);

        paymentPanel.add(new JLabel("CVV:"));
        cvvField = new JTextField();
        paymentPanel.add(cvvField);

        paymentPanel.add(new JLabel("Expiry (MM/YY):"));
        expiryField = new JTextField();
        paymentPanel.add(expiryField);

// Pay Button
        JButton payButton = buttonFactory.createButton("Pay Now", e -> handlePayment());
        paymentPanel.add(new JLabel());  // spacer
        paymentPanel.add(payButton);

// Add to frame
        frame.add(paymentPanel, BorderLayout.SOUTH);

        frame.add(optionsPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addToOrder() {
        int quantity = (Integer) quantitySpinner.getValue();
        Sandwich sandwich = new PlainSandwich();

        // Apply decorators in groups
        if (multigrainBox.isSelected()) sandwich = new MultigrainBread(sandwich);
        if (italianBox.isSelected()) sandwich = new ItalianBread(sandwich);
        if (flatbreadBox.isSelected()) sandwich = new Flatbread(sandwich);
        if (honeyoatBox.isSelected()) sandwich = new HoneyOat(sandwich);

        if (hamBox.isSelected())     sandwich = new Ham(sandwich);
        if (turkeyBox.isSelected())  sandwich = new Turkey(sandwich);
        if (roastbeefBox.isSelected())  sandwich = new RoastBeef(sandwich);
        if (chickenBox.isSelected())  sandwich = new Chicken(sandwich);

        if (lettuceBox.isSelected()) sandwich = new Lettuce(sandwich);
        if (tomatoBox.isSelected())  sandwich = new Tomato(sandwich);
        if (onionBox.isSelected())  sandwich = new Onion(sandwich);

        double itemTotal = sandwich.getCost() * quantity;
        total += itemTotal;

        orderArea.append(String.format(
                "%s x%d\nSubtotal: $%.2f\n\n",
                sandwich.getDescription(), quantity, itemTotal
        ));
        orderArea.append(String.format("Current Total: $%.2f\n\n", total));
    }

    private void handlePayment() {
        double amount = total;

        PaymentStrategy strategy;
        String method = (String) paymentMethodCombo.getSelectedItem();

        if ("Cash".equals(method)) {
            try {
                double cash = Double.parseDouble(cashField.getText());
                strategy = new CashPayment(cash);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid cash amount.");
                return;
            }
        } else {
            String name = nameField.getText().trim();
            String cardNum = cardNumberField.getText().trim();
            String cvv = cvvField.getText().trim();
            String expiry = expiryField.getText().trim();

            if (name.isEmpty() || cardNum.isEmpty() || cvv.isEmpty() || expiry.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all credit card fields.");
                return;
            }

            strategy = new CreditCardPayment(name, cardNum, cvv, expiry);
        }

        boolean success = strategy.pay(amount);
        if (success) {
            JOptionPane.showMessageDialog(frame, "Payment successful! Thank you.");
            orderArea.append("\n=== PAYMENT COMPLETE ===\n\n");
            total = 0.0;
        } else {
            JOptionPane.showMessageDialog(frame, "Payment failed. Please try again.");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(SandwichShopUI::new);
    }
}
