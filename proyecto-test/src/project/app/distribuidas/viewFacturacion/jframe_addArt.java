package project.app.distribuidas.viewFacturacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project.app.distribuidas.db.MysqlConnect;

public class jframe_addArt extends javax.swing.JFrame {

    private int idCabecera;
    private int idProduct; 
    private String precio;
    private String ruc;

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }
    
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    
    
    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }
    
    
    public jframe_addArt(int idCabecera,String ruc) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIdCabecera(idCabecera);
        this.setRuc(ruc);
        System.out.println("id factura"+this.getIdCabecera());
        
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
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Añadir Articulo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione articulo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cmb_articulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_articulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_articuloActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 277, 38));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Indique cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        btn_addArt.setBackground(new java.awt.Color(51, 51, 51));
        btn_addArt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_addArt.setForeground(new java.awt.Color(204, 204, 204));
        btn_addArt.setText("AÑADIR");
        btn_addArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addArtActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 137, 41));

        btn_cancel.setBackground(new java.awt.Color(51, 51, 51));
        btn_cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(204, 204, 204));
        btn_cancel.setText("CANCELAR");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 138, 41));

        jLabel4.setText("PRECIO UNT.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        txt_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_price.setText("$. ");
        getContentPane().add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 69, -1));

        sld_cantidad.setMajorTickSpacing(10);
        sld_cantidad.setMaximum(0);
        sld_cantidad.setPaintLabels(true);
        sld_cantidad.setPaintTicks(true);
        sld_cantidad.setPaintTrack(false);
        sld_cantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sld_cantidadStateChanged(evt);
            }
        });
        getContentPane().add(sld_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 277, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Seleccionada");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, -1));

        txt_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cantidad.setText(" ");
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 69, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
        
        try {
            jframe_FacturacionCompleja fc = new jframe_FacturacionCompleja();
            fc.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(jframe_addArt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_addArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addArtActionPerformed

        int codArticulo = this.getIdProduct();
        int numCabecera = this.getIdCabecera();
        int codDetalle = this.getIdCabecera();
        int cantidad = this.sld_cantidad.getValue();
        String precio = this.getPrecio();
        
        
        String sql = " INSERT INTO detalle_comprobante_factura VALUES (?,?,?,?,?); ";        
        try {
            this.savePricePivote(this.getRuc(), precio, codArticulo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = MysqlConnect.ConnectDB();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codArticulo);
            ps.setInt(2, numCabecera);
            ps.setInt(3, codDetalle);
            ps.setInt(4, cantidad);
            ps.setString(5, precio);
            System.out.println(""+ps.toString());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Articulo agredado \n CORRECTAMENTE ! ");
            this.setVisible(false);
            jframe_FacturacionCompleja fc = new jframe_FacturacionCompleja();
            fc.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(jframe_addArt.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al agregar articulo ! ");
        }
        
        

    }//GEN-LAST:event_btn_addArtActionPerformed

    private void cmb_articuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_articuloActionPerformed
        String artSelect = this.cmb_articulo.getSelectedItem().toString();
        String[] partes = artSelect.split("|"); 
        int idProduct = Integer.parseInt(partes[0]);
        this.setIdProduct(idProduct);
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
        String Sprince;
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
        
        this.setPrecio(String.valueOf(price));
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
    
    private void savePricePivote(String ruc,String cantidad,int id_articulo) throws SQLException{
        String nomClient = "";
        PreparedStatement ps = null;
        PreparedStatement psNC = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sqlNomCli = "SELECT NOM_CLI FROM cliente WHERE RUC_CLI='"+ruc+"'";
        psNC = conn.prepareStatement(sqlNomCli);
        rs = psNC.executeQuery();
        
        while(rs.next()){
            nomClient = rs.getString("NOM_CLI");
        }
        
        
        String sql = "UPDATE reporte_pivote SET "+nomClient+" = '"+cantidad+"' WHERE (id="+id_articulo+")";
        ps = conn.prepareStatement(sql);
        ps.execute();
        
    }
    
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider sld_cantidad;
    private javax.swing.JLabel txt_cantidad;
    private javax.swing.JLabel txt_price;
    // End of variables declaration//GEN-END:variables
}
