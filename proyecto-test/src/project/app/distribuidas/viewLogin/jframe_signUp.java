package project.app.distribuidas.viewLogin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project.app.distribuidas.viewFacturacion.jframe_FacturacionSimple1;


public class jframe_signUp extends javax.swing.JFrame {

    public jframe_signUp() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        btn_createUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_signIn = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txt_confirPass = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Confirma contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        txt_user.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_user.setForeground(new java.awt.Color(51, 51, 51));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_user.setName("txt_user"); // NOI18N
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 220, 40));

        btn_createUser.setBackground(new java.awt.Color(51, 51, 51));
        btn_createUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_createUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_createUser.setText("Crear Cuenta");
        btn_createUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_createUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 461, 50));

        jLabel4.setText("Ya tengo una cuenta ?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, 30));

        btn_signIn.setBackground(new java.awt.Color(51, 51, 51));
        btn_signIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_signIn.setForeground(new java.awt.Color(255, 255, 255));
        btn_signIn.setText("Inciar Sesion");
        btn_signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signInActionPerformed(evt);
            }
        });
        getContentPane().add(btn_signIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 230, 50));

        txt_pass.setForeground(new java.awt.Color(51, 51, 51));
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 220, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        txt_confirPass.setForeground(new java.awt.Color(51, 51, 51));
        txt_confirPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_confirPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_confirPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confirPassActionPerformed(evt);
            }
        });
        getContentPane().add(txt_confirPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 220, 40));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Registrarme");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 410, 550));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createUserActionPerformed
        String newUser = this.txt_user.getText();
        String newPass = this.txt_pass.getText();
        String confirNewPass = this.txt_confirPass.getText();
        
        if(newPass.equals(confirNewPass) && !"".equals(newUser)){
            
            String path = "/addNewUser";
            String addNewUser = path+";"+newUser+";"+newPass;

            try {
                Socket cliente = new Socket("localhost",4444);
                ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
                mensaje.writeObject(addNewUser);

                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                String mensaje2 = (String) entrada.readObject();

                if(mensaje2.equals("1")){
                    JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO ! ");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO ! ");
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error en ingreso de datos !");
            limpiar();
        }
        
    }//GEN-LAST:event_btn_createUserActionPerformed

    
    public void limpiar(){
        this.txt_user.setText("");
        this.txt_pass.setText("");
        this.txt_confirPass.setText("");
    }
    private void btn_signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signInActionPerformed
        jframe_signIn si = new jframe_signIn();
        si.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_signInActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_confirPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confirPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confirPassActionPerformed

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
            java.util.logging.Logger.getLogger(jframe_signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_signUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createUser;
    private javax.swing.JButton btn_signIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txt_confirPass;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
