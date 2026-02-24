package Admin;

import Main.Login;

public class adminDashboard extends javax.swing.JFrame {

    public adminDashboard() {
        initComponents();
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button customerBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private java.awt.Button logoutBtn;
    private javax.swing.JPanel panel;
    private java.awt.Button productBtn;
    private java.awt.Button saleBtn;
    private java.awt.Button userbtn;
    // End of variables declaration//GEN-END:variables
}