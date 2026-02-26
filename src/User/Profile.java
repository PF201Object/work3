package User;

import Main.Login;
import config.config;
import config.Session;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import Admin.adminDashboard; // Adjust package name as needed


public class Profile extends javax.swing.JFrame {
    
    private config con = new config();
    private byte[] currentImage = null;

    public Profile() {
        initComponents();
        loadUserProfile();
    }
    
    private void loadUserProfile() {
        int userId = Session.getUserId();
        String sql = "SELECT Username, Full_Name, Role, Last_Login, Profile_Image FROM User WHERE User_ID = ?";

        try (Connection conn = config.connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usernameLabel.setText(rs.getString("Username"));
                nameLabel.setText(rs.getString("Full_Name"));
                roleLabel.setText(rs.getString("Role"));
                lastLoginLabel.setText(rs.getString("Last_Login"));
                
                // Load profile image
                byte[] imgData = rs.getBytes("Profile_Image");
                if (imgData != null) {
                    currentImage = imgData;
                    ImageIcon icon = new ImageIcon(imgData);
                    Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    profileImage.setIcon(new ImageIcon(img));
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading profile: " + e.getMessage());
        }
    }
    private String getUserRole() {
    int userId = Session.getUserId();
    String sql = "SELECT Role FROM User WHERE User_ID = ?";
    
    try (Connection conn = config.connectDB();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            return rs.getString("Role");
        }
    } catch (SQLException e) {
        System.out.println("Error getting user role: " + e.getMessage());
    }
    return "USER"; // Default to USER if role not found
}
    
    private void updateProfile(String fullName, String username, byte[] image) {
        int userId = Session.getUserId();
        String sql;
        
        if (image != null) {
            sql = "UPDATE User SET Full_Name = ?, Username = ?, Profile_Image = ? WHERE User_ID = ?";
            con.updateRecord(sql, fullName, username, image, userId);
        } else {
            sql = "UPDATE User SET Full_Name = ?, Username = ? WHERE User_ID = ?";
            con.updateRecord(sql, fullName, username, userId);
        }
        
        JOptionPane.showMessageDialog(this, "Profile updated successfully!");
        loadUserProfile();
    }
    
    private boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_]{3,20}$");
    }
    
    private boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s]{2,50}$");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoutPanel = new java.awt.Panel();
        Logout = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        Back = new java.awt.Button();
        mainPanel = new java.awt.Panel();
        profileDisplayPanel = new java.awt.Panel();
        profileImage = new javax.swing.JLabel();
        roleText = new javax.swing.JLabel();
        nameText = new javax.swing.JLabel();
        usernameText = new javax.swing.JLabel();
        lastLoginText = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        lastLoginLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        editPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editNameField = new javax.swing.JTextField();
        editUsernameField = new javax.swing.JTextField();
        changeImageButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutPanel.setBackground(new java.awt.Color(255, 204, 204));
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setBackground(new java.awt.Color(255, 204, 204));
        Logout.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Logout.setLabel("BACK");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutMouseExited(evt);
            }
        });
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        logoutPanel.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jPanel1.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 90, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("NATURAL COSMETICS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, 50));

        Back.setBackground(new java.awt.Color(255, 204, 204));
        Back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Back.setLabel("BACK");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 100));

        mainPanel.setBackground(new java.awt.Color(240, 240, 240));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profileDisplayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileImage.setText("Profile Picture");
        profileImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        profileDisplayPanel.add(profileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 100));

        roleText.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        roleText.setText("Role:");
        profileDisplayPanel.add(roleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        nameText.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nameText.setText("Name:");
        profileDisplayPanel.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        usernameText.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        usernameText.setText("Username:");
        profileDisplayPanel.add(usernameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        lastLoginText.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lastLoginText.setText("Last Login:");
        profileDisplayPanel.add(lastLoginText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        roleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(102, 102, 102));
        profileDisplayPanel.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, 20));

        nameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        profileDisplayPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 220, 20));

        usernameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(102, 102, 102));
        profileDisplayPanel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 210, 20));

        lastLoginLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lastLoginLabel.setForeground(new java.awt.Color(102, 102, 102));
        profileDisplayPanel.add(lastLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 210, 20));

        mainPanel.add(profileDisplayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 140));

        editButton.setBackground(new java.awt.Color(255, 204, 204));
        editButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        editButton.setText("Edit Profile");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        mainPanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 100, 30));

        editPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Profile"));
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Full Name:");
        editPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Username:");
        editPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Profile Image:");
        editPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        editNameField.setFont(new java.awt.Font("Times New Roman", 0, 0)); // NOI18N
        editPanel.add(editNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, 30));

        editUsernameField.setFont(new java.awt.Font("Times New Roman", 0, 0)); // NOI18N
        editPanel.add(editUsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 30));

        changeImageButton.setBackground(new java.awt.Color(255, 204, 204));
        changeImageButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        changeImageButton.setText("Change Image");
        changeImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeImageButtonActionPerformed(evt);
            }
        });
        editPanel.add(changeImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 120, 30));

        saveButton.setBackground(new java.awt.Color(255, 204, 204));
        saveButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        editPanel.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 90, 30));

        cancelButton.setBackground(new java.awt.Color(255, 204, 204));
        cancelButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        editPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 90, 30));

        mainPanel.add(editPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 450, 210));

        changePasswordButton.setBackground(new java.awt.Color(255, 204, 204));
        changePasswordButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        changePasswordButton.setText("Change Password");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });
        mainPanel.add(changePasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 120, 30));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        Back.setBackground(new java.awt.Color(102,153,255));
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        Back.setBackground(new java.awt.Color(255,204,204));
    }//GEN-LAST:event_BackMouseExited

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
    String role = getUserRole();
    
    if ("ADMIN".equalsIgnoreCase(role)) {
        // Navigate to Admin Dashboard
        adminDashboard adminDashboard = new adminDashboard();
        adminDashboard.setVisible(true);
        this.dispose();
    } else {
        // Navigate to User Dashboard (Cashier)
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_BackActionPerformed

    private void LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutMouseEntered

    private void LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseExited
            int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to logout?", 
        "Confirm Logout", 
        JOptionPane.YES_NO_OPTION);
        
    if (confirm == JOptionPane.YES_OPTION) {
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_LogoutMouseExited

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed


    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        profileDisplayPanel.setVisible(false);
        editPanel.setVisible(true);
        editButton.setVisible(false);
        
        editNameField.setText(nameLabel.getText());
        editUsernameField.setText(usernameLabel.getText());
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        profileDisplayPanel.setVisible(true);
        editPanel.setVisible(false);
        editButton.setVisible(true);
    }

    private void changeImageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                BufferedImage bufferedImage = ImageIO.read(file);
                
                // Resize image to fit
                Image scaledImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                profileImage.setIcon(new ImageIcon(scaledImage));
                
                // Convert to byte array
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", baos);
                currentImage = baos.toByteArray();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage());
            }
        }
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String fullName = editNameField.getText().trim();
        String username = editUsernameField.getText().trim();

        if (fullName.isEmpty() || username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        if (!isValidName(fullName)) {
            JOptionPane.showMessageDialog(this, "Full name must be 2-50 characters and can only contain letters and spaces!");
            return;
        }

        if (!isValidUsername(username)) {
            JOptionPane.showMessageDialog(this, "Username must be 3-20 characters and can only contain letters, numbers, and underscores!");
            return;
        }

        // Check if username is already taken by another user
        if (!username.equals(usernameLabel.getText())) {
            String checkSql = "SELECT User_ID FROM User WHERE Username = ? AND User_ID != ?";
            try (Connection conn = config.connectDB();
                 PreparedStatement pst = conn.prepareStatement(checkSql)) {
                
                pst.setString(1, username);
                pst.setInt(2, Session.getUserId());
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Username already taken!");
                    return;
                }
            } catch (SQLException e) {
                System.out.println("Error checking username: " + e.getMessage());
            }
        }

        updateProfile(fullName, username, currentImage);
        
        profileDisplayPanel.setVisible(true);
        editPanel.setVisible(false);
        editButton.setVisible(true);
    }

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
        if (newPassword != null && !newPassword.trim().isEmpty()) {
            if (newPassword.length() < 6) {
                JOptionPane.showMessageDialog(this, "Password must be at least 6 characters!");
                return;
            }
            
            String confirmPassword = JOptionPane.showInputDialog(this, "Confirm new password:");
            if (confirmPassword != null && newPassword.equals(confirmPassword)) {
                String sql = "UPDATE User SET Password_Hash = ? WHERE User_ID = ?";
                con.updateRecord(sql, newPassword, Session.getUserId());
                JOptionPane.showMessageDialog(this, "Password updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Back;
    private java.awt.Button Logout;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeImageButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField editNameField;
    private javax.swing.JPanel editPanel;
    private javax.swing.JTextField editUsernameField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastLoginLabel;
    private javax.swing.JLabel lastLoginText;
    private java.awt.Panel logoutPanel;
    private java.awt.Panel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameText;
    private java.awt.Panel profileDisplayPanel;
    private javax.swing.JLabel profileImage;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel roleText;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameText;
    // End of variables declaration//GEN-END:variables
}