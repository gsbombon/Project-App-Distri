package project.app.distribuidas.viewFacturacion;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import project.app.distribuidas.viewLogin.jframe_mainOptions;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import project.app.distribuidas.db.MysqlConnect;
import project.app.distribuidas.model.Cliente;
import project.app.distribuidas.model.Cobrador;


public class jframe_FacturacionSimple2 extends javax.swing.JFrame {

    public jframe_FacturacionSimple2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_cuidad = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txt_idCiudad = new javax.swing.JTextField();
        txt_cuidadBucar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardar.setText("Guardar Nuevo");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 298, -1));

        jtable_cuidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable_cuidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtable_cuidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_cuidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable_cuidad);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 375, 230));

        btnModificar.setBackground(new java.awt.Color(51, 51, 51));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(204, 204, 204));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 298, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Cuidad");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Regresar al menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 174, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nombre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 298, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 204, 204));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 30));

        txt_idCiudad.setEditable(false);
        txt_idCiudad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_idCiudad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_idCiudad.setEnabled(false);
        getContentPane().add(txt_idCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 227, 33));

        txt_cuidadBucar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_cuidadBucar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(txt_cuidadBucar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 212, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cuidad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 227, 33));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 298, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txt_nombre.getText();
        String path = "/addCiudad";
        String addCiudad = path+";"+nombre;
        Socket cliente = null;
        try {
            cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(addCiudad);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "CUIDAD AGREGADA ! ");
                txt_idCiudad.setText("");
                txt_nombre.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "FALLIDO ! ");
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jtable_cuidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_cuidadMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = MysqlConnect.ConnectDB();
            int Fila = this.jtable_cuidad.getSelectedRow();
            String codigo = this.jtable_cuidad.getValueAt(Fila, 0).toString();
            ps = conn.prepareStatement("SELECT * FROM ciudad WHERE CODIGO_CIU=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                this.txt_idCiudad.setText(rs.getString("CODIGO_CIU"));
                this.txt_nombre.setText(rs.getString("NOMBRE_CIU"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtable_cuidadMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int id = Integer.parseInt(this.txt_idCiudad.getText());        
        String nombre = txt_nombre.getText();        
        String path = "/modCiudad";
        String modCli = path+";"+id+";"+nombre;
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(modCli);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();

            if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "Datos modificados \n CORRECTAMENTE ! ");
                txt_idCiudad.setText("");
                txt_nombre.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar ! ");
            }
        } catch (IOException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jframe_mainOptions mo = new jframe_mainOptions();
        mo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int Fila = this.jtable_cuidad.getSelectedRow();
        int codigo = Integer.parseInt(this.jtable_cuidad.getValueAt(Fila, 0).toString());
        String path = "/delCiudad";
        String delCliente = path+";"+codigo;
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(delCliente);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "Registro eliminado CORRECTAMENTE ! ");
                txt_idCiudad.setText("");
                txt_nombre.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "ERRO ! \n Registro no eliminado ! ");
            }
        } catch (IOException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cuidad_buscar = txt_cuidadBucar.getText();
        String where = "";
        if (!"".equals(cuidad_buscar)) {
            where = "WHERE NOMBRE_CIU = '" + cuidad_buscar + "'";
        }
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            this.jtable_cuidad.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = MysqlConnect.ConnectDB();
            String sql = "SELECT * FROM ciudad " + where;
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Código");
            modelo.addColumn("Ciudad");
            int[] anchos = {300,300};
            for (int i = 0; i < this.jtable_cuidad.getColumnCount(); i++) {
                this.jtable_cuidad.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.txt_idCiudad.setText("");
        this.txt_nombre.setText("");        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_FacturacionSimple2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtable_cuidad;
    private javax.swing.JTextField txt_cuidadBucar;
    private javax.swing.JTextField txt_idCiudad;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
