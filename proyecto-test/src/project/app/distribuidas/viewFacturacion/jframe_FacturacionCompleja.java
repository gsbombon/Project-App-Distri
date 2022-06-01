package project.app.distribuidas.viewFacturacion;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import project.app.distribuidas.db.MysqlConnect;
import project.app.distribuidas.viewLogin.jframe_mainOptions;

public class jframe_FacturacionCompleja extends javax.swing.JFrame {

    public jframe_FacturacionCompleja() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txt_numFac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        txt_ciudad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_detailsFactura = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_addArt = new javax.swing.JButton();
        btn_delArt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Numero de Factura");

        txt_numFac.setEditable(false);
        txt_numFac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numFac.setOpaque(true);

        jLabel3.setText("Fecha");

        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_ciudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ciudadActionPerformed(evt);
            }
        });

        jLabel4.setText("Cuidad de entrega");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("FACTURAS COMPLEJAS");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Detalle de Facturas");

        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtable_detailsFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtable_detailsFactura);

        jLabel5.setText("RUC CLIENTE");

        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jButton1.setText("Volver al Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_addArt.setText("Añadir Articulo");
        btn_addArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addArtActionPerformed(evt);
            }
        });

        btn_delArt.setText("Quitar Articulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_addArt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(btn_delArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_numFac, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(185, 185, 185))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))))
                    .addContainerGap(493, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txt_numFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_addArt)
                        .addGap(31, 31, 31)
                        .addComponent(btn_delArt)))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(26, 26, 26)
                    .addComponent(jLabel3)
                    .addGap(27, 27, 27)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(304, 304, 304)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ciudadActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String ruc = this.txt_ruc.getText();
        try {
            this.cargarCabecera(ruc);
            this.cargarDetalle(ruc);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println(""+ex.getMessage());
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        jframe_mainOptions fmo = new jframe_mainOptions();
        fmo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_addArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addArtActionPerformed
        jframe_addArt fa = new jframe_addArt();
        fa.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_addArtActionPerformed

    private void cargarCabecera(String ruc) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT NUMERO_CABECERA_FACTU,FECHA_CABECERA_FACTU,NOMBRE_CIU\n" +
                    "FROM cabecera_factura cf,cliente c,ciudad ciu\n" +
                    "WHERE c.CODIGO_CLI = cf.CODIGO_CLI AND c.CODIGO_CIU = ciu.CODIGO_CIU AND c.RUC_CLI = ? ";
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        ps.setString(1, ruc);
        rs = ps.executeQuery();
        
        while (rs.next()) {
                this.txt_numFac.setText(rs.getString("NUMERO_CABECERA_FACTU"));
                this.txt_fecha.setText(String.valueOf(rs.getString("FECHA_CABECERA_FACTU")));
                this.txt_ciudad.setText(rs.getString("NOMBRE_CIU"));
        }
    }
    
   public int numCabecera(String ruc){
       int nC = 0;
       
       return nC;
   }
    
    private void cargarDetalle(String ruc) throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
        this.jtable_detailsFactura.setModel(modelo);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT a.NOMBRE_ART, a.PRECIO_ART, df.CANTIDAD_DETALLE_COMPROBANTE_FACTURA ,df.PRECIO__DETALLE_COMPROBANTE_FACTURA\n" +
                        "FROM detalle_comprobante_factura df,articulo a,cliente c,cabecera_factura cf\n" +
                        "WHERE df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND df.CODIGO_ART = a.CODIGO_ART AND cf.CODIGO_CLI = c.CODIGO_CLI AND c.RUC_CLI=? ";
        
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        ps.setString(1, ruc);
        rs = ps.executeQuery();
        
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();

        modelo.addColumn("ARTICULO");
        modelo.addColumn("PRECIO U.");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO TOTAL");
        int[] anchos = {200, 150,150, 300};
        for (int i = 0; i < this.jtable_detailsFactura.getColumnCount(); i++) {
            this.jtable_detailsFactura.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        while (rs.next()) {
            Object[] filas = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                filas[i] = rs.getObject(i + 1);
            }
            modelo.addRow(filas);
        }
        
    }
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
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_FacturacionCompleja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addArt;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_delArt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_detailsFactura;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_numFac;
    private javax.swing.JTextField txt_ruc;
    // End of variables declaration//GEN-END:variables
}
