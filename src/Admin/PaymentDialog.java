package Admin;

import config.config;
import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentDialog extends JDialog {
    
    private JTextField totalField, paymentField, changeField;
    private JComboBox<String> paymentMethodCombo;
    private JButton processBtn, printBtn, cancelBtn;
    private JTextArea receiptArea;
    private JScrollPane receiptScroll;
    private double totalAmount;
    private String customerName;
    private String location;
    private config con;
    private adminSale parentFrame;
    
    public PaymentDialog(adminSale parent, double total, String customer, String storeLocation) {
        super(parent, "Process Payment", true);
        this.parentFrame = parent;
        this.totalAmount = total;
        this.customerName = customer;
        this.location = storeLocation;
        this.con = new config();
        
        setLayout(new BorderLayout(10, 10));
        setSize(600, 500);
        setLocationRelativeTo(parent);
        
        // Payment Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Payment Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Total Amount
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Total Amount:"), gbc);
        gbc.gridx = 1;
        totalField = new JTextField(15);
        totalField.setText(String.format("%.2f", total));
        totalField.setEditable(false);
        inputPanel.add(totalField, gbc);
        
        // Payment Method
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Payment Method:"), gbc);
        gbc.gridx = 1;
        paymentMethodCombo = new JComboBox<>(new String[]{"Cash", "Card", "GCash"});
        inputPanel.add(paymentMethodCombo, gbc);
        
        // Amount Paid
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Amount Paid:"), gbc);
        gbc.gridx = 1;
        paymentField = new JTextField(15);
        inputPanel.add(paymentField, gbc);
        
        // Change
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Change:"), gbc);
        gbc.gridx = 1;
        changeField = new JTextField(15);
        changeField.setEditable(false);
        inputPanel.add(changeField, gbc);
        
        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        processBtn = new JButton("Process Payment");
        printBtn = new JButton("Print Receipt");
        cancelBtn = new JButton("Cancel");
        
        processBtn.setBackground(new Color(255, 204, 204));
        printBtn.setBackground(new Color(255, 204, 204));
        cancelBtn.setBackground(new Color(255, 204, 204));
        
        printBtn.setEnabled(false);
        
        buttonPanel.add(processBtn);
        buttonPanel.add(printBtn);
        buttonPanel.add(cancelBtn);
        
        // Receipt Panel
        JPanel receiptPanel = new JPanel(new BorderLayout());
        receiptPanel.setBorder(BorderFactory.createTitledBorder("Receipt"));
        receiptArea = new JTextArea(10, 40);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        receiptArea.setEditable(false);
        receiptScroll = new JScrollPane(receiptArea);
        receiptPanel.add(receiptScroll, BorderLayout.CENTER);
        
        // Add all panels
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(topPanel, BorderLayout.NORTH);
        add(receiptPanel, BorderLayout.CENTER);
        
        // Action Listeners
        paymentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateChange();
            }
        });
        
        processBtn.addActionListener(e -> processPayment());
        printBtn.addActionListener(e -> printReceipt());
        cancelBtn.addActionListener(e -> dispose());
    }
    
    private void calculateChange() {
        try {
            double paid = Double.parseDouble(paymentField.getText().trim());
            double change = paid - totalAmount;
            changeField.setText(String.format("%.2f", change));
        } catch (NumberFormatException e) {
            changeField.setText("0.00");
        }
    }
    
    private void processPayment() {
        String payment = paymentField.getText().trim();
        String method = paymentMethodCombo.getSelectedItem().toString();
        
        if (payment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter amount paid!");
            return;
        }
        
        try {
            double paid = Double.parseDouble(payment);
            if (paid < totalAmount) {
                JOptionPane.showMessageDialog(this, "Insufficient payment amount!");
                return;
            }
            
            double change = paid - totalAmount;
            
            // Save to database
            String sql = "INSERT INTO Sale (Total_Amount, Payment_Method, Store_Location, Customer_ID, Sale_Date) VALUES (?, ?, ?, ?, ?)";
            
            // Get customer ID from customer name (you'll need to pass this from parent)
            int customerId = 1; // Default, you should get this properly
            
            con.addRecord(sql, totalAmount, method, location, customerId, new Date());
            
            // Generate receipt
            generateReceipt(paid, change, method);
            
            processBtn.setEnabled(false);
            printBtn.setEnabled(true);
            paymentField.setEditable(false);
            paymentMethodCombo.setEnabled(false);
            
            JOptionPane.showMessageDialog(this, "Payment processed successfully!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!");
        }
    }
    
    private void generateReceipt(double paid, double change, String method) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        
        StringBuilder receipt = new StringBuilder();
        receipt.append("================================\n");
        receipt.append("      NATURAL COSMETICS\n");
        receipt.append("================================\n");
        receipt.append("Date: ").append(date).append("\n");
        receipt.append("Customer: ").append(customerName).append("\n");
        receipt.append("Location: ").append(location).append("\n");
        receipt.append("--------------------------------\n");
        receipt.append("Payment Method: ").append(method).append("\n");
        receipt.append("Total Amount: PHP ").append(String.format("%.2f", totalAmount)).append("\n");
        receipt.append("Amount Paid: PHP ").append(String.format("%.2f", paid)).append("\n");
        receipt.append("Change: PHP ").append(String.format("%.2f", change)).append("\n");
        receipt.append("--------------------------------\n");
        receipt.append("      THANK YOU FOR SHOPPING!\n");
        receipt.append("================================\n");
        
        receiptArea.setText(receipt.toString());
    }
    
    private void printReceipt() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(new Printable() {
                @Override
                public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                    if (pageIndex > 0) {
                        return Printable.NO_SUCH_PAGE;
                    }
                    
                    Graphics2D g2d = (Graphics2D) graphics;
                    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                    
                    // Print the receipt
                    String[] lines = receiptArea.getText().split("\n");
                    int y = 20;
                    Font font = new Font("Monospaced", Font.PLAIN, 10);
                    g2d.setFont(font);
                    
                    for (String line : lines) {
                        g2d.drawString(line, 10, y);
                        y += 15;
                    }
                    
                    return Printable.PAGE_EXISTS;
                }
            });
            
            if (job.printDialog()) {
                job.print();
                JOptionPane.showMessageDialog(this, "Receipt printed successfully!");
                parentFrame.loadSaleData(); // Refresh parent table
                dispose();
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "Error printing: " + e.getMessage());
        }
    }
}