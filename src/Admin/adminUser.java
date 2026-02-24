package Admin;

import Main.Login;
import config.config;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class adminUser extends javax.swing.JFrame {
    
    private config con = new config();
    private TableRowSorter<TableModel> rowSorter;

    public adminUser() {
        initComponents();
        loadUserData();
        setupSearch();
        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Cashier" }));
    }
    
    private void loadUserData() {
        String sql = "SELECT User_ID as 'ID', Username, Full_Name as 'Full Name', Role, Last_Login as 'Last Login' FROM User";
        con.displayData(sql, userTable);
        rowSorter = new TableRowSorter<>(userTable.getModel());
        userTable.setRowSorter(rowSorter);
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
        usernameField.setText("");
        fullNameField.setText("");
        passwordField.setText("");
        roleCombo.setSelectedIndex(0);
        searchField.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        roleCombo = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("NATURAL COSMETICS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 550, 50));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        panel.setBackground(new java.awt.Color(255, 204, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userbtn.setBackground(new java.awt.Color(255, 204, 204));
        userbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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
        customerBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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

        productBtn.setBackground(new java.awt.Color(255, 204, 204));
        productBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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
        saleBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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
        logoutBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 400));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Full Name", "Role", "Last Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 580, 250));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 150, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Full Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));
        getContentPane().add(fullNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 150, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 150, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Role:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        getContentPane().add(roleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 150, 30));

        addBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 70, 30));

        updateBtn.setBackground(new java.awt.Color(255, 204, 204));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 70, 30));

        deleteBtn.setBackground(new java.awt.Color(255, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 70, 30));

        clearBtn.setBackground(new java.awt.Color(255, 204, 204));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 70, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Search:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 200, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            usernameField.setText(userTable.getValueAt(selectedRow, 1).toString());
            fullNameField.setText(userTable.getValueAt(selectedRow, 2).toString());
            roleCombo.setSelectedItem(userTable.getValueAt(selectedRow, 3).toString());
            passwordField.setText(""); // Don't show password
        }
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameField.getText().trim();
        String fullName = fullNameField.getText().trim();
        String password = passwordField.getText().trim();
        String role = roleCombo.getSelectedItem().toString();

        if (username.isEmpty() || fullName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        if (con.usernameExists(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists!");
            return;
        }

        String sql = "INSERT INTO User (Username, Password_Hash, Full_Name, Role) VALUES (?, ?, ?, ?)";
        con.addRecord(sql, username, password, fullName, role);
        
        JOptionPane.showMessageDialog(this, "User added successfully!");
        loadUserData();
        clearFields();
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a user to update!");
            return;
        }

        int userId = Integer.parseInt(userTable.getValueAt(selectedRow, 0).toString());
        String username = usernameField.getText().trim();
        String fullName = fullNameField.getText().trim();
        String password = passwordField.getText().trim();
        String role = roleCombo.getSelectedItem().toString();

        if (username.isEmpty() || fullName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        String sql;
        if (password.isEmpty()) {
            sql = "UPDATE User SET Username = ?, Full_Name = ?, Role = ? WHERE User_ID = ?";
            con.updateRecord(sql, username, fullName, role, userId);
        } else {
            sql = "UPDATE User SET Username = ?, Password_Hash = ?, Full_Name = ?, Role = ? WHERE User_ID = ?";
            con.updateRecord(sql, username, password, fullName, role, userId);
        }

        JOptionPane.showMessageDialog(this, "User updated successfully!");
        loadUserData();
        clearFields();
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this user?", 
            "Confirm Delete", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            int userId = Integer.parseInt(userTable.getValueAt(selectedRow, 0).toString());
            String sql = "DELETE FROM User WHERE User_ID = ?";
            con.deleteRecord(sql, userId);
            
            JOptionPane.showMessageDialog(this, "User deleted successfully!");
            loadUserData();
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
                new adminUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private java.awt.Button customerBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Button logoutBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField passwordField;
    private java.awt.Button productBtn;
    private javax.swing.JComboBox<String> roleCombo;
    private java.awt.Button saleBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTable userTable;
    private java.awt.Button userbtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}