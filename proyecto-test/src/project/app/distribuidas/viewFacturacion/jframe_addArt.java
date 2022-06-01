package project.app.distribuidas.viewFacturacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import project.app.distribuidas.db.MysqlConnect;

public class jframe_addArt extends javax.swing.JFrame {

    public jframe_addArt(int idCabecera,int idDetalle) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.cargarCmbArticulos();
        
    }

    private jframe_addArt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_articulo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_addArt = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_price = new javax.swing.JLabel();
        sld_cantidad = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Añadir Articulo");

        jLabel2.setText("Seleccione articulo");

        cmb_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_articuloActionPerformed(evt);
            }
        });

        jLabel3.setText("Indique cantidad");

        btn_addArt.setText("AÑADIR");
        btn_addArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addArtActionPerformed(evt);
            }
        });

        btn_cancel.setText("CANCELAR");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel4.setText("PRECIO UNT.");

        txt_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_price.setText("$. ");

        sld_cantidad.setMajorTickSpacing(10);
        sld_cantidad.setMaximum(0);
        sld_cantidad.setPaintLabels(true);
        sld_cantidad.setPaintTicks(true);
        sld_cantidad.setPaintTrack(false);
        sld_cantidad.setValue(0);
        sld_cantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld_cantidadStateChanged(evt);
            }
        });

        jLabel5.setText("Seleccionada");

        txt_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cantidad.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_addArt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmb_articulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sld_cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_price))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cantidad))
                            .addComponent(sld_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addArt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
        jframe_FacturacionCompleja fc = new jframe_FacturacionCompleja();
        fc.setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_addArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addArtActionPerformed
        
        
        

    }//GEN-LAST:event_btn_addArtActionPerformed

    private void cmb_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_articuloActionPerformed
        String artSelect = this.cmb_articulo.getSelectedItem().toString();
        String[] partes = artSelect.split("|"); 
        int idProduct = Integer.parseInt(partes[0]);
        try {
            float precio = priceArticulo(idProduct);
            this.txt_price.setText("$. "+precio);
            this.cargarSlidderCantidad(idProduct);
            
        } catch (SQLException ex) {
            Logger.getLogger(jframe_addArt.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_cmb_articuloActionPerformed

    private void sld_cantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sld_cantidadStateChanged
        this.txt_cantidad.setText(""+this.sld_cantidad.getValue());
    }//GEN-LAST:event_sld_cantidadStateChanged
    
    private void cargarSlidderCantidad(int idProducto)throws SQLException{
        int minSld = 0;
        int maxSld = 0;
        int spacing = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT STOCK_ART FROM articulo WHERE CODIGO_ART = ? ";        
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idProducto);
        rs = ps.executeQuery();
        while(rs.next()){
            maxSld=rs.getInt("STOCK_ART");
        }
        //spacing = maxSld /5;
        this.sld_cantidad.setMinimum(minSld);
        this.sld_cantidad.setMaximum(maxSld);
        this.sld_cantidad.setMajorTickSpacing(spacing);
        
    }
    
    private float priceArticulo(int idProducto) throws SQLException{
        float price=0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT PRECIO_ART FROM articulo WHERE CODIGO_ART = ? ";        
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idProducto);
        rs = ps.executeQuery();
        
        while(rs.next()){
            price = rs.getFloat("PRECIO_ART");
        }
        return price;
    }
    
    private void cargarCmbArticulos() throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT * FROM articulo\n" +
                        "WHERE NOT (STOCK_ART = 0) ";        
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        System.out.println(""+ps.toString());
        
        while(rs.next()){
            this.cmb_articulo.addItem((rs.getString("CODIGO_ART"))+" | "+ rs.getString("NOMBRE_ART"));
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
            java.util.logging.Logger.getLogger(jframe_addArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_addArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_addArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_addArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_addArt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addArt;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JComboBox<String> cmb_articulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSlider sld_cantidad;
    private javax.swing.JLabel txt_cantidad;
    private javax.swing.JLabel txt_price;
    // End of variables declaration//GEN-END:variables
}
