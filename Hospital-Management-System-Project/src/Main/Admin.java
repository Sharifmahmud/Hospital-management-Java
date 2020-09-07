package Main;

import Admins.AdminActivity;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author omi
 */
public class Admin extends javax.swing.JFrame {

    PreparedStatement prp = null;
    ResultSet result = null;
    Connection connection = null;
    String username;

    public Admin() {
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Images/hospital.png"));
        this.setIconImage(ic.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aUserLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        aUserField = new javax.swing.JTextField();
        aPassField = new javax.swing.JPasswordField();
        dExitBtn = new javax.swing.JButton();
        aLoginBtn = new javax.swing.JButton();
        mLabel = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome Admin !");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1000, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 550));

        aUserLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        aUserLabel.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Password:");

        aUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aUserFieldActionPerformed(evt);
            }
        });

        dExitBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dExitBtn.setForeground(new java.awt.Color(103, 58, 119));
        dExitBtn.setText("Home");
        dExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dExitBtnActionPerformed(evt);
            }
        });

        aLoginBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        aLoginBtn.setForeground(new java.awt.Color(103, 58, 119));
        aLoginBtn.setText("Login");
        aLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aLoginBtnActionPerformed(evt);
            }
        });

        mLabel.setAlignment(java.awt.Label.CENTER);
        mLabel.setBackground(new java.awt.Color(103, 58, 119));
        mLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        mLabel.setForeground(new java.awt.Color(255, 255, 255));
        mLabel.setText("Hospital Management System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(aUserLabel)
                .addGap(10, 10, 10)
                .addComponent(aUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(aPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(dExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(aLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(mLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aUserLabel)
                    .addComponent(aUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(aPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dExitBtnActionPerformed
        Hospital hospital = new Hospital();
        hospital.setVisible(true);
        dispose();
    }//GEN-LAST:event_dExitBtnActionPerformed

    private void aLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aLoginBtnActionPerformed
        connection = Connector.ConnectDb();
        String user = aUserField.getText();
        String pass = String.valueOf(aPassField.getPassword());

        try {
            String sql = "select username, password from admin where username='" + user + "'";
            prp = connection.prepareStatement(sql);
            result = prp.executeQuery();
            result.first();
            if (pass.equals(result.getString("password"))) {
                AdminActivity adminActivity = new AdminActivity();
                adminActivity.setVisible(true);
                JOptionPane.showMessageDialog(null, "Login Succesful", "Welcome " + user, JOptionPane.INFORMATION_MESSAGE);
                dispose();
                username = user;
                adminActivity.User(username);
                connection.close();
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed", "Error", JOptionPane.WARNING_MESSAGE);
//                JOptionPane.showMessageDialog(null, "User or Password wrong.");
            }

        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "User or Password wrong.");
        }

    }//GEN-LAST:event_aLoginBtnActionPerformed

    private void aUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aUserFieldActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Admin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aLoginBtn;
    private javax.swing.JPasswordField aPassField;
    private javax.swing.JTextField aUserField;
    private javax.swing.JLabel aUserLabel;
    private javax.swing.JButton dExitBtn;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label mLabel;
    // End of variables declaration//GEN-END:variables
}
