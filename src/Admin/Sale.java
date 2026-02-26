package Admin;

import Main.Login;
import config.config;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import java.sql.*;

public class Sale extends javax.swing.JFrame {
    
    private config con = new config();
    private TableRowSorter<TableModel> rowSorter;

    public Sale() {
        initComponents();
        loadSaleData();
        loadCustomerCombo();
        setupSearch();
        loadPaymentMethods(); // Add this line
    }
    
    private void loadPaymentMethods() {
    paymentCombo.removeAllItems();
    paymentCombo.addItem("Select Payment");
    paymentCombo.addItem("Cash");
    paymentCombo.addItem("GCash");
    paymentCombo.addItem("Credit Card");
    paymentCombo.addItem("Bank Transfer");
}
    
    void loadSaleData() {
        String sql = "SELECT s.Sale_ID as 'ID', s.Sale_Date as 'Date', s.Total_Amount as 'Total', " +
                     "s.Payment_Method as 'Payment', s.Store_Location as 'Location', " +
                     "c.First_Name || ' ' || c.Last_Name as 'Customer' " +
                     "FROM Sale s LEFT JOIN Customer c ON s.Customer_ID = c.Customer_ID " +
                     "ORDER BY s.Sale_Date DESC";
        con.displayData(sql, saleTable);
        rowSorter = new TableRowSorter<>(saleTable.getModel());
        saleTable.setRowSorter(rowSorter);
    }
    
    private void loadCustomerCombo() {
        try {
            String sql = "SELECT Customer_ID, First_Name || ' ' || Last_Name as FullName FROM Customer ORDER BY FullName";
            Connection conn = config.connectDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            customerCombo.removeAllItems();
            customerCombo.addItem("Select Customer");
            
            while (rs.next()) {
                customerCombo.addItem(rs.getInt("Customer_ID") + " - " + rs.getString("FullName"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }
    
    private void setupSearch() {
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String searchText = searchField.getText();
                if (searchText.trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }
        });
    }
    
    private void clearFields() {
        totalField.setText("");
        paymentCombo.setSelectedIndex(0);
        locationField.setText("");
        customerCombo.setSelectedIndex(0);
        searchField.setText("");
    }
    
    private void openPaymentDialog() {
        String total = totalField.getText().trim();
        String location = locationField.getText().trim();
        String customer = customerCombo.getSelectedItem().toString();
        
        if (total.isEmpty() || location.isEmpty() || customerCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please fill all fields and select a customer first!");
            return;
        }
        
        try {
            double totalAmount = Double.parseDouble(total);
            String customerName = customer.substring(customer.indexOf("-") + 2); // Extract customer name
            
            PaymentDialog paymentDialog = new PaymentDialog(this, totalAmount, customerName, location);
            paymentDialog.setVisible(true);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total amount must be a number!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        userbtn = new java.awt.Button();
        customerBtn = new java.awt.Button();
        productBtn = new java.awt.Button();
        saleBtn = new java.awt.Button();
        logoutBtn = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        paymentCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        locationField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        processPaymentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("NATURAL COSMETICS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 550, 50));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        panel.setBackground(new java.awt.Color(255, 204, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userbtn.setLabel("User");
        userbtn.setBackground(new java.awt.Color(255, 204, 204));
        userbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        userbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userbtnMouseExited(evt);
            }
        });
        userbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbtnActionPerformed(evt);
            }
        });
        panel.add(userbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 40));

        customerBtn.setLabel("Customer");
        customerBtn.setBackground(new java.awt.Color(255, 204, 204));
        customerBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        customerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerBtnMouseExited(evt);
            }
        });
        customerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBtnActionPerformed(evt);
            }
        });
        panel.add(customerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, 40));

        productBtn.setLabel("Product");
        productBtn.setBackground(new java.awt.Color(255, 204, 204));
        productBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        productBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productBtnMouseExited(evt);
            }
        });
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });
        panel.add(productBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 40));

        saleBtn.setLabel("Sale");
        saleBtn.setBackground(new java.awt.Color(255, 204, 204));
        saleBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        saleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saleBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saleBtnMouseExited(evt);
            }
        });
        saleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleBtnActionPerformed(evt);
            }
        });
        panel.add(saleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, 40));

        logoutBtn.setLabel("Logout");
        logoutBtn.setBackground(new java.awt.Color(255, 204, 204));
        logoutBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        panel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 40));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 400));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Total Amount:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));
        getContentPane().add(totalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 120, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Payment Method:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        paymentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "", "" }));
        getContentPane().add(paymentCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 110, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Store Location:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));
        getContentPane().add(locationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 120, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Customer:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));
        getContentPane().add(customerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 110, 30));

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 70, 30));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 70, 30));

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 70, 30));

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 70, 30));

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Total", "Payment", "Location", "Customer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(saleTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 580, 250));

        jLabel6.setText("Search:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 200, 30));

        processPaymentBtn.setText("Process Payment");
        processPaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processPaymentBtnActionPerformed(evt);
            }
        });
        getContentPane().add(processPaymentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 130, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void processPaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {
        openPaymentDialog();
    }

    private void saleTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = saleTable.getSelectedRow();
        if (selectedRow >= 0) {
            totalField.setText(saleTable.getValueAt(selectedRow, 2).toString());
            paymentCombo.setSelectedItem(saleTable.getValueAt(selectedRow, 3).toString());
            locationField.setText(saleTable.getValueAt(selectedRow, 4).toString());
            
            String customer = saleTable.getValueAt(selectedRow, 5).toString();
            for (int i = 0; i < customerCombo.getItemCount(); i++) {
                if (customerCombo.getItemAt(i).toString().contains(customer)) {
                    customerCombo.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String total = totalField.getText().trim();
        String payment = paymentCombo.getSelectedItem().toString();
        String location = locationField.getText().trim();
        String customer = customerCombo.getSelectedItem().toString();

        if (total.isEmpty() || location.isEmpty() || customerCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields and select a customer!");
            return;
        }

        try {
            double totalAmount = Double.parseDouble(total);
            int customerId = Integer.parseInt(customer.split(" - ")[0]);
            
            String sql = "INSERT INTO Sale (Total_Amount, Payment_Method, Store_Location, Customer_ID) VALUES (?, ?, ?, ?)";
            con.addRecord(sql, totalAmount, payment, location, customerId);
            
            JOptionPane.showMessageDialog(this, "Sale recorded successfully!");
            loadSaleData();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total amount must be a number!");
        }
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = saleTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a sale to update!");
            return;
        }

        int saleId = Integer.parseInt(saleTable.getValueAt(selectedRow, 0).toString());
        String total = totalField.getText().trim();
        String payment = paymentCombo.getSelectedItem().toString();
        String location = locationField.getText().trim();
        String customer = customerCombo.getSelectedItem().toString();

        if (total.isEmpty() || location.isEmpty() || customerCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields and select a customer!");
            return;
        }

        try {
            double totalAmount = Double.parseDouble(total);
            int customerId = Integer.parseInt(customer.split(" - ")[0]);
            
            String sql = "UPDATE Sale SET Total_Amount = ?, Payment_Method = ?, Store_Location = ?, Customer_ID = ? WHERE Sale_ID = ?";
            con.updateRecord(sql, totalAmount, payment, location, customerId, saleId);
            
            JOptionPane.showMessageDialog(this, "Sale updated successfully!");
            loadSaleData();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total amount must be a number!");
        }
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = saleTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a sale to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this sale record?", 
            "Confirm Delete", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            int saleId = Integer.parseInt(saleTable.getValueAt(selectedRow, 0).toString());
            String sql = "DELETE FROM Sale WHERE Sale_ID = ?";
            con.deleteRecord(sql, saleId);
            
            JOptionPane.showMessageDialog(this, "Sale deleted successfully!");
            loadSaleData();
            clearFields();
        }
    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    // Navigation methods
    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {
        User ua = new User();
        ua.setVisible(true);
        this.dispose();
    }

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Product ap = new Product();
        ap.setVisible(true);
        this.dispose();
    }

    private void saleBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Sale as = new Sale();
        as.setVisible(true);
        this.dispose();
    }

    private void customerBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Customer ac = new Customer();
        ac.setVisible(true);
        this.dispose();
    }

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }

    // Mouse entered/exited methods
    private void userbtnMouseEntered(java.awt.event.MouseEvent evt) {
        userbtn.setBackground(new java.awt.Color(102,153,255));
    }

    private void userbtnMouseExited(java.awt.event.MouseEvent evt) {
        userbtn.setBackground(new java.awt.Color(255,204,204));
    }

    private void productBtnMouseEntered(java.awt.event.MouseEvent evt) {
        productBtn.setBackground(new java.awt.Color(102,153,255));
    }

    private void productBtnMouseExited(java.awt.event.MouseEvent evt) {
        productBtn.setBackground(new java.awt.Color(255,204,204));
    }

    private void saleBtnMouseEntered(java.awt.event.MouseEvent evt) {
        saleBtn.setBackground(new java.awt.Color(102,153,255));
    }

    private void saleBtnMouseExited(java.awt.event.MouseEvent evt) {
        saleBtn.setBackground(new java.awt.Color(255,204,204));
    }

    private void customerBtnMouseEntered(java.awt.event.MouseEvent evt) {
        customerBtn.setBackground(new java.awt.Color(102,153,255));
    }

    private void customerBtnMouseExited(java.awt.event.MouseEvent evt) {
        customerBtn.setBackground(new java.awt.Color(255,204,204));
    }

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {
        logoutBtn.setBackground(new java.awt.Color(102,153,255));
    }

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {
        logoutBtn.setBackground(new java.awt.Color(255,204,204));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private java.awt.Button customerBtn;
    private javax.swing.JComboBox customerCombo;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationField;
    private java.awt.Button logoutBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox paymentCombo;
    private javax.swing.JButton processPaymentBtn;
    private java.awt.Button productBtn;
    private java.awt.Button saleBtn;
    private javax.swing.JTable saleTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField totalField;
    private javax.swing.JButton updateBtn;
    private java.awt.Button userbtn;
    // End of variables declaration//GEN-END:variables
}