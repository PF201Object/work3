package Admin;

import Main.Login;
import config.config;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class Customer extends javax.swing.JFrame {
    
    private config con = new config();
    private TableRowSorter<TableModel> rowSorter;

    public Customer() {
        initComponents();
        loadCustomerData();
        setupSearch();
    }
    
    private void loadCustomerData() {
        String sql = "SELECT Customer_ID as 'ID', First_Name as 'First Name', Last_Name as 'Last Name', Email, Phone, Join_Date as 'Join Date' FROM Customer";
        con.displayData(sql, customerTable);
        rowSorter = new TableRowSorter<>(customerTable.getModel());
        customerTable.setRowSorter(rowSorter);
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
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        searchField.setText("");
    }
    
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    private boolean isValidPhone(String phone) {
        return phone.matches("^[0-9]{11}$");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        productBtn = new java.awt.Button();
        saleBtn = new java.awt.Button();
        logoutBtn = new java.awt.Button();
        userbtn = new java.awt.Button();
        customerBtn = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48));
        jLabel2.setText("NATURAL COSMETICS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 550, 50));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        panel.setBackground(new java.awt.Color(255, 204, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productBtn.setBackground(new java.awt.Color(255, 204, 204));
        productBtn.setFont(new java.awt.Font("Times New Roman", 1, 14));
        productBtn.setLabel("Product");
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

        saleBtn.setBackground(new java.awt.Color(255, 204, 204));
        saleBtn.setFont(new java.awt.Font("Times New Roman", 1, 14));
        saleBtn.setLabel("Sale");
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

        logoutBtn.setBackground(new java.awt.Color(255, 204, 204));
        logoutBtn.setFont(new java.awt.Font("Times New Roman", 1, 14));
        logoutBtn.setLabel("Logout");
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

        userbtn.setBackground(new java.awt.Color(255, 204, 204));
        userbtn.setFont(new java.awt.Font("Times New Roman", 1, 14));
        userbtn.setLabel("User");
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

        customerBtn.setBackground(new java.awt.Color(255, 204, 204));
        customerBtn.setFont(new java.awt.Font("Times New Roman", 1, 14));
        customerBtn.setLabel("Customer");
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

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 400));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "First Name", "Last Name", "Email", "Phone", "Join Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 580, 250));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setText("First Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));
        getContentPane().add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 130, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Last Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));
        getContentPane().add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 130, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Email:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("Phone:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 130, 30));

        addBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBtn.setFont(new java.awt.Font("Times New Roman", 1, 12));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 70, 30));

        updateBtn.setBackground(new java.awt.Color(255, 204, 204));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 1, 12));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 70, 30));

        deleteBtn.setBackground(new java.awt.Color(255, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 1, 12));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 70, 30));

        clearBtn.setBackground(new java.awt.Color(255, 204, 204));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 1, 12));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 70, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel6.setText("Search:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 200, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow >= 0) {
            firstNameField.setText(customerTable.getValueAt(selectedRow, 1).toString());
            lastNameField.setText(customerTable.getValueAt(selectedRow, 2).toString());
            emailField.setText(customerTable.getValueAt(selectedRow, 3).toString());
            phoneField.setText(customerTable.getValueAt(selectedRow, 4).toString());
        }
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address!");
            return;
        }

        if (!isValidPhone(phone)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid 11-digit phone number!");
            return;
        }

        if (con.emailExists(email)) {
            JOptionPane.showMessageDialog(this, "Email already exists!");
            return;
        }

        String sql = "INSERT INTO Customer (First_Name, Last_Name, Email, Phone) VALUES (?, ?, ?, ?)";
        con.addRecord(sql, firstName, lastName, email, phone);
        
        JOptionPane.showMessageDialog(this, "Customer added successfully!");
        loadCustomerData();
        clearFields();
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a customer to update!");
            return;
        }

        int customerId = Integer.parseInt(customerTable.getValueAt(selectedRow, 0).toString());
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address!");
            return;
        }

        if (!isValidPhone(phone)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid 11-digit phone number!");
            return;
        }

        String sql = "UPDATE Customer SET First_Name = ?, Last_Name = ?, Email = ?, Phone = ? WHERE Customer_ID = ?";
        con.updateRecord(sql, firstName, lastName, email, phone, customerId);
        
        JOptionPane.showMessageDialog(this, "Customer updated successfully!");
        loadCustomerData();
        clearFields();
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this customer?", 
            "Confirm Delete", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            int customerId = Integer.parseInt(customerTable.getValueAt(selectedRow, 0).toString());
            String sql = "DELETE FROM Customer WHERE Customer_ID = ?";
            con.deleteRecord(sql, customerId);
            
            JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
            loadCustomerData();
            clearFields();
        }
    }

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {
        adminUser ua = new adminUser();
        ua.setVisible(true);
        this.dispose();
    }

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {
        adminProduct ap = new adminProduct();
        ap.setVisible(true);
        this.dispose();
    }

    private void saleBtnActionPerformed(java.awt.event.ActionEvent evt) {
        adminSale as = new adminSale();
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
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private java.awt.Button customerBtn;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private java.awt.Button logoutBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField phoneField;
    private java.awt.Button productBtn;
    private java.awt.Button saleBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateBtn;
    private java.awt.Button userbtn;
    // End of variables declaration
}