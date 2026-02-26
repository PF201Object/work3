package User;

import Admin.Customer;
import Admin.Product;
import Admin.Sale;
import Admin.User;
import Main.Login;
import User.Profile;

public class UserDashboard extends javax.swing.JFrame {

    public UserDashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        customerBtn = new java.awt.Button();
        productBtn = new java.awt.Button();
        saleBtn = new java.awt.Button();
        logoutBtn = new java.awt.Button();
        Profile = new java.awt.Button();

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
        panel.add(customerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, 40));

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
        panel.add(productBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 40));

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
        panel.add(saleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 90, 40));

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
        panel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 90, 40));

        Profile.setBackground(new java.awt.Color(255, 204, 204));
        Profile.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Profile.setLabel("PROFILE");
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfileMouseExited(evt);
            }
        });
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });
        panel.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 40));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseEntered
        Profile.setBackground(new java.awt.Color(102,153,255));
    }//GEN-LAST:event_ProfileMouseEntered

    private void ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseExited
        Profile.setBackground(new java.awt.Color(255,204,204));
    }//GEN-LAST:event_ProfileMouseExited

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed
        Profile ac = new Profile();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ProfileActionPerformed

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
                new UserDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Profile;
    private java.awt.Button customerBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private java.awt.Button logoutBtn;
    private javax.swing.JPanel panel;
    private java.awt.Button productBtn;
    private java.awt.Button saleBtn;
    // End of variables declaration//GEN-END:variables
}