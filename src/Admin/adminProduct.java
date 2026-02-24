package Admin;

import Main.Login;
import config.config;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class adminProduct extends javax.swing.JFrame {
    
    private config con = new config();
    private TableRowSorter<TableModel> rowSorter;

    public adminProduct() {
        initComponents();
        loadProductData();
        setupSearch();
    }
    
    private void loadProductData() {
        String sql = "SELECT Product_ID as 'ID', Name, Description, Price, Stock_Quantity as 'Stock' FROM Product";
        con.displayData(sql, productTable);
        rowSorter = new TableRowSorter<>(productTable.getModel());
        productTable.setRowSorter(rowSorter);
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
        nameField.setText("");
        descField.setText("");
        priceField.setText("");
        stockField.setText("");
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
        productTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        stockField = new javax.swing.JTextField();
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

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        panel.setBackground(new java.awt.Color(255, 204, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Price", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 580, 250));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Description:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        getContentPane().add(descField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 150, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Price:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));
        getContentPane().add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Stock:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));
        getContentPane().add(stockField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 150, 30));

        addBtn.setBackground(new java.awt.Color(255, 204, 204));
        addBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 70, 30));

        updateBtn.setBackground(new java.awt.Color(255, 204, 204));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 70, 30));

        deleteBtn.setBackground(new java.awt.Color(255, 204, 204));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 70, 30));

        clearBtn.setBackground(new java.awt.Color(255, 204, 204));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 70, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Search:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, -1, -1));
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 200, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            nameField.setText(productTable.getValueAt(selectedRow, 1).toString());
            descField.setText(productTable.getValueAt(selectedRow, 2).toString());
            priceField.setText(productTable.getValueAt(selectedRow, 3).toString());
            stockField.setText(productTable.getValueAt(selectedRow, 4).toString());
        }
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameField.getText().trim();
        String desc = descField.getText().trim();
        String price = priceField.getText().trim();
        String stock = stockField.getText().trim();

        if (name.isEmpty() || price.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields!");
            return;
        }

        try {
            double priceValue = Double.parseDouble(price);
            int stockValue = Integer.parseInt(stock);
            
            String sql = "INSERT INTO Product (Name, Description, Price, Stock_Quantity) VALUES (?, ?, ?, ?)";
            con.addRecord(sql, name, desc, priceValue, stockValue);
            
            JOptionPane.showMessageDialog(this, "Product added successfully!");
            loadProductData();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number and Stock must be an integer!");
        }
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product to update!");
            return;
        }

        int productId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());
        String name = nameField.getText().trim();
        String desc = descField.getText().trim();
        String price = priceField.getText().trim();
        String stock = stockField.getText().trim();

        if (name.isEmpty() || price.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields!");
            return;
        }

        try {
            double priceValue = Double.parseDouble(price);
            int stockValue = Integer.parseInt(stock);
            
            String sql = "UPDATE Product SET Name = ?, Description = ?, Price = ?, Stock_Quantity = ? WHERE Product_ID = ?";
            con.updateRecord(sql, name, desc, priceValue, stockValue, productId);
            
            JOptionPane.showMessageDialog(this, "Product updated successfully!");
            loadProductData();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price must be a number and Stock must be an integer!");
        }
    }

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this product?", 
            "Confirm Delete", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            int productId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());
            String sql = "DELETE FROM Product WHERE Product_ID = ?";
            con.deleteRecord(sql, productId);
            
            JOptionPane.showMessageDialog(this, "Product deleted successfully!");
            loadProductData();
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
                new adminProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private java.awt.Button customerBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField descField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Button logoutBtn;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField priceField;
    private java.awt.Button productBtn;
    private javax.swing.JTable productTable;
    private java.awt.Button saleBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField stockField;
    private javax.swing.JButton updateBtn;
    private java.awt.Button userbtn;
    // End of variables declaration//GEN-END:variables
}