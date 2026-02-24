package Main;

import config.config;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        fullName = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        confirmPass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("NATURAL COSMETICS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 550, 50));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Create Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 210, 40));
        getContentPane().add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 210, 40));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 210, 40));
        getContentPane().add(confirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 210, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Full Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Username");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Password");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 90, 50));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Have already an account");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_]{3,20}$");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6 && 
               Pattern.compile("[0-9]").matcher(password).find() &&
               Pattern.compile("[a-zA-Z]").matcher(password).find();
    }

    private boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s]{2,50}$");
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        config con = new config();

        String userName = username.getText().trim();
        String fullNameText = fullName.getText().trim();
        String userPass = password.getText().trim();
        String confirmPassText = confirmPass.getText().trim();
        // Empty fields validation
        if (userName.isEmpty() || fullNameText.isEmpty() || userPass.isEmpty() || confirmPassText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "All fields are required!",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Username validation
        if (!isValidUsername(userName)) {
            JOptionPane.showMessageDialog(this,
                "Username must be 3-20 characters and can only contain letters, numbers, and underscores",
                "Invalid Username",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Name validation
        if (!isValidName(fullNameText)) {
            JOptionPane.showMessageDialog(this,
                "Full name must be 2-50 characters and can only contain letters and spaces",
                "Invalid Name",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Password validation
        if (!isValidPassword(userPass)) {
            JOptionPane.showMessageDialog(this,
                "Password must be at least 6 characters and contain both letters and numbers",
                "Invalid Password",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirm password
        if (!userPass.equals(confirmPassText)) {
            JOptionPane.showMessageDialog(this,
                "Passwords do not match!",
                "Password Mismatch",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Username exists validation
        if (con.usernameExists(userName)) {
            JOptionPane.showMessageDialog(this,
                "Username already exists. Please choose another.",
                "Duplicate Username",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert user
        String sql = "INSERT INTO User(Username, Password_Hash, Full_Name) VALUES(?, ?, ?)";
        con.addRecord(sql, userName, userPass, fullNameText);

        JOptionPane.showMessageDialog(this,
            "Account created successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
        
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmPass;
    private javax.swing.JTextField fullName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}