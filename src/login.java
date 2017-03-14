
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import testcrud.file_koneksi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Qoriatul Masfufah
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        btSignup = new javax.swing.JButton();
        btSignIn = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME ADMIN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 30, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 100, 70, 20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 140, 70, 20);
        jPanel1.add(tfUsername);
        tfUsername.setBounds(220, 100, 160, 30);
        jPanel1.add(tfPassword);
        tfPassword.setBounds(220, 140, 160, 30);

        btSignup.setBackground(new java.awt.Color(255, 204, 255));
        btSignup.setText("Sign Up");
        btSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });
        jPanel1.add(btSignup);
        btSignup.setBounds(119, 210, 80, 23);

        btSignIn.setBackground(new java.awt.Color(204, 255, 255));
        btSignIn.setText("Log In");
        btSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignInActionPerformed(evt);
            }
        });
        jPanel1.add(btSignIn);
        btSignIn.setBounds(220, 210, 80, 23);

        btExit.setBackground(new java.awt.Color(204, 255, 204));
        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        jPanel1.add(btExit);
        btExit.setBounds(321, 210, 70, 23);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 70, 370, 130);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 290);

        setBounds(0, 0, 496, 329);
    }// </editor-fold>//GEN-END:initComponents

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignupActionPerformed
        // TODO add your handling code here:
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        
        try{
            try (Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO `tb_akun`(`username`, `password`) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Selamat! anda berhasil sign up");
        }catch(Exception t){
            JOptionPane.showMessageDialog(null,"Mohon maaf, ulangi lagi prosedur");
        }
        
    }//GEN-LAST:event_btSignupActionPerformed

    private void btSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignInActionPerformed
        // TODO add your handling code here:
        
        Connection connection;
        PreparedStatement ps;
        
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_toko?zeroDateTimeBehavior=convertToNull",
                    "root", "");
            ps = connection.prepareStatement("SELECT username,password FROM tb_akun WHERE username = ? AND password = ?");
            ps.setString(1, tfUsername.getText());
            ps.setString(2, tfPassword.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new mainmenu().show();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"Ulangi sesuai prosedur!");
                tfPassword.setText("");
                tfUsername.requestFocus();
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Silakan isi form terlebih dahulu");
        }
        
    }//GEN-LAST:event_btSignInActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSignIn;
    private javax.swing.JButton btSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
