/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.app.distribuidas.viewLogin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.app.distribuidas.viewFacturacion.jframe_FacturacionSimple1;
import project.app.distribuidas.viewInventario.jframe_InventarioCompleja;
import project.app.distribuidas.viewInventario.jframe_InventarioReporte1;
import project.app.distribuidas.viewInventario.jframe_InventarioReporte2;
import project.app.distribuidas.viewInventario.jframe_InventarioSimple1;
import project.app.distribuidas.viewInventario.jframe_InventarioSimple2;

/**
 *
 * @author pocho
 */
public class jframe_mainOptions extends javax.swing.JFrame {

    /**
     * Creates new form jframe_mainOptions
     */
    public jframe_mainOptions() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_ComplejaI = new javax.swing.JMenuItem();
        menu_Articulo = new javax.swing.JMenuItem();
        menu_Mov = new javax.swing.JMenuItem();
        menu_Reporte1 = new javax.swing.JMenuItem();
        menu_Reporte2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("TIENDA LHG");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel2.setText("Henry Ordoñez");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel3.setText("Gerson Bombom");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel4.setText("Lizbeth Pumisacho");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Integrantes:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jMenu1.setText("Inventario");

        menu_ComplejaI.setText("Compleja");
        menu_ComplejaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ComplejaIActionPerformed(evt);
            }
        });
        jMenu1.add(menu_ComplejaI);

        menu_Articulo.setText("SimpleArticulo");
        menu_Articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ArticuloActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Articulo);

        menu_Mov.setText("SimpleTipoMov");
        menu_Mov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_MovActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Mov);

        menu_Reporte1.setText("Reporte1");
        menu_Reporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Reporte1ActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Reporte1);

        menu_Reporte2.setText("Reporte2");
        menu_Reporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Reporte2ActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Reporte2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Facturacion");

        jMenuItem1.setText("Compleja ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Simple Cuidad");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Simple Cliente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Reporte Ventas");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Reporte Cruzado");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cuentas por Cobrar");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jframe_FacturacionSimple1 fs1 = null;
        try {
            fs1 = new jframe_FacturacionSimple1();
        } catch (IOException ex) {
            Logger.getLogger(jframe_mainOptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jframe_mainOptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jframe_mainOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        fs1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menu_ArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ArticuloActionPerformed
        jframe_InventarioSimple1 is1 = new jframe_InventarioSimple1();
        is1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_ArticuloActionPerformed

    private void menu_MovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_MovActionPerformed
        jframe_InventarioSimple2 is2 = new jframe_InventarioSimple2();
        is2.setVisible(true);
        this.setVisible(false);    }//GEN-LAST:event_menu_MovActionPerformed

    private void menu_Reporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Reporte1ActionPerformed
        jframe_InventarioReporte1 ir1 = new jframe_InventarioReporte1();
        ir1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_Reporte1ActionPerformed

    private void menu_Reporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Reporte2ActionPerformed
        jframe_InventarioReporte2 ir2 = new jframe_InventarioReporte2();
        ir2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_Reporte2ActionPerformed

    private void menu_ComplejaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ComplejaIActionPerformed
        jframe_InventarioCompleja ic = new jframe_InventarioCompleja();
        ic.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_ComplejaIActionPerformed

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
            java.util.logging.Logger.getLogger(jframe_mainOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_mainOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_mainOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_mainOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_mainOptions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menu_Articulo;
    private javax.swing.JMenuItem menu_ComplejaI;
    private javax.swing.JMenuItem menu_Mov;
    private javax.swing.JMenuItem menu_Reporte1;
    private javax.swing.JMenuItem menu_Reporte2;
    // End of variables declaration//GEN-END:variables
}
