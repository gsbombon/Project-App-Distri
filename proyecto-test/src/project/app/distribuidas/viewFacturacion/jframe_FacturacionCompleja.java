package project.app.distribuidas.viewFacturacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.app.distribuidas.db.MysqlConnect;
import project.app.distribuidas.viewLogin.jframe_mainOptions;

public class jframe_FacturacionCompleja extends javax.swing.JFrame {

    private int idCabecera;
    private int idDetalle;
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    

    public int getIdCabecera() {
        return idCabecera;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }
    
    
    public jframe_FacturacionCompleja() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarCmbRuc();
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
        cmb_listFacturas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btn_clean = new javax.swing.JButton();
        btn_modArt = new javax.swing.JButton();
        cmb_ruc = new javax.swing.JComboBox<>();

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
        btn_delArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delArtActionPerformed(evt);
            }
        });

        cmb_listFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_listFacturasMouseClicked(evt);
            }
        });
        cmb_listFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_listFacturasActionPerformed(evt);
            }
        });

        jLabel6.setText("Facturas registradas");

        btn_clean.setText("Limpiar");
        btn_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleanActionPerformed(evt);
            }
        });

        btn_modArt.setText("Modificar");
        btn_modArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modArtActionPerformed(evt);
            }
        });

        cmb_ruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_rucActionPerformed(evt);
            }
        });

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
                                    .addComponent(btn_delArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_modArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(txt_numFac, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(txt_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(cmb_ruc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(cmb_listFacturas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_clean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ruc, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_ruc))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txt_numFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 52, Short.MAX_VALUE)
                        .addComponent(btn_clean)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_listFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_addArt)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delArt)
                        .addGap(18, 18, 18)
                        .addComponent(btn_modArt)))
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
        //String ruc = this.txt_ruc.getText();
        String ruc_cmb = this.cmb_ruc.getSelectedItem().toString();
        String[] parts = ruc_cmb.split(" | ");
        int idCliente = Integer.parseInt(parts[0]);
        this.setIdCliente(idCliente);
        String ruc = parts[2];
        this.txt_ruc.setText(ruc);
        try {
            this.cmb_listFacturas.removeAllItems();
            this.cargarCmbFacturas(ruc);
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
        String ruc = this.txt_ruc.getText();
        jframe_addArt fa;
        try {
            fa = new jframe_addArt(this.getIdCabecera());
            fa.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_addArtActionPerformed

    private void cmb_listFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_listFacturasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_listFacturasMouseClicked

    private void cmb_listFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_listFacturasActionPerformed
        String ruc = this.txt_ruc.getText();
        String dateFact = this.cmb_listFacturas.getSelectedItem().toString();
        String[] partes = dateFact.split("|"); 
        this.setIdCabecera(Integer.parseInt(partes[0]));
        
        try {
            this.cargarCabecera(ruc,this.getIdCabecera());
            this.cargarDetalle(ruc,this.getIdCabecera());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_cmb_listFacturasActionPerformed

    private void btn_delArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delArtActionPerformed
        int Fila = this.jtable_detailsFactura.getSelectedRow();
        int codArt = Integer.parseInt(this.jtable_detailsFactura.getValueAt(Fila, 0).toString());
        int codCab =  this.getIdCabecera();
        int codDetalle = this.getIdCabecera();
        
        String path = "/delArtFac";
        String delCliente = path+";"+codArt+";"+codCab+";"+codDetalle;
        
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(delCliente);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            
             if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "Articulo Removido ! ");                
            }else{
                JOptionPane.showMessageDialog(null, "ERROR ! \n Articulo no eliminado ! ");

            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btn_delArtActionPerformed

    private void btn_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleanActionPerformed
        this.txt_ciudad.setText("");
        this.txt_fecha.setText("");
        this.txt_numFac.setText("");
        this.txt_ruc.setText("");
        this.cmb_listFacturas.removeAllItems();
        this.jtable_detailsFactura.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btn_cleanActionPerformed

    private void btn_modArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modArtActionPerformed
        int Fila = this.jtable_detailsFactura.getSelectedRow();
        int codArt = Integer.parseInt(this.jtable_detailsFactura.getValueAt(Fila, 0).toString());
        int codCab =  this.getIdCabecera();
        int codDetalle = this.getIdCabecera();
        int cantidadNew = Integer.parseInt(this.jtable_detailsFactura.getValueAt(Fila, 2).toString());
        
        String path = "/modArtFac";
        String delCliente = path+";"+codArt+";"+codCab+";"+codDetalle+";"+cantidadNew;
        
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(delCliente);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            
             if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "Cantidad actualizada ! ");                
            }else{
                JOptionPane.showMessageDialog(null, "Cantidad elegida, fuera de stock ! ");

            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println(""+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_modArtActionPerformed

    private void cmb_rucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_rucActionPerformed
        
    }//GEN-LAST:event_cmb_rucActionPerformed

    private void cargarCmbFacturas(String ruc) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT NUMERO_CABECERA_FACTU, FECHA_CABECERA_FACTU\n" +
                        "FROM cabecera_factura cf, cliente c \n" +
                        "WHERE cf.codigo_cli = c.codigo_cli AND c.RUC_CLI=?;";        
        ps = conn.prepareStatement(sql);
        ps.setString(1, ruc);
        rs = ps.executeQuery();
        System.out.println(""+ps.toString());
        
        while(rs.next()){
            this.cmb_listFacturas.addItem((rs.getString("NUMERO_CABECERA_FACTU"))+" | "+ rs.getString("FECHA_CABECERA_FACTU"));
        }
    }
    
    private void cargarCmbRuc() throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT CODIGO_CLI, RUC_CLI FROM cliente;";        
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();     
        
        while(rs.next()){
            this.cmb_ruc.addItem((rs.getString("CODIGO_CLI"))+" | "+ rs.getString("RUC_CLI"));
        }
    }
    
    private void cargarCabecera(String ruc,int idCabecera) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT NUMERO_CABECERA_FACTU,FECHA_CABECERA_FACTU,NOMBRE_CIU\n" +
                        "FROM cabecera_factura cf,cliente c,ciudad ciu\n" +
                        "WHERE c.CODIGO_CLI = cf.CODIGO_CLI AND c.CODIGO_CIU = ciu.CODIGO_CIU AND c.RUC_CLI = ? AND NUMERO_CABECERA_FACTU=?";
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        ps.setString(1, ruc);
        ps.setInt(2, idCabecera);
        rs = ps.executeQuery();
        
        while (rs.next()) {
                this.txt_numFac.setText(rs.getString("NUMERO_CABECERA_FACTU"));
                this.txt_fecha.setText(String.valueOf(rs.getString("FECHA_CABECERA_FACTU")));
                this.txt_ciudad.setText(rs.getString("NOMBRE_CIU"));
        }
    }
    
    public int codDetalle (String ruc,int idCabecera) throws SQLException{
        int codDetalle =0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        String sql = "SELECT CODIGO_DETALLE_COMPROBANTE_FACTURA\n" +
                        "FROM detalle_comprobante_factura df,cliente c,cabecera_factura cf\n" +
                        "WHERE  df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND c.CODIGO_CLI = cf.CODIGO_CLI AND c.RUC_CLI = ? AND df.NUMERO_CABECERA_FACTU=?\n" +
                        "LIMIT 1;";
        ps = conn.prepareStatement(sql);
        ps.setString(1, ruc);
        ps.setInt(2, idCabecera);
        rs = ps.executeQuery();
        
        while(rs.next()){
            codDetalle = rs.getInt("CODIGO_DETALLE_COMPROBANTE_FACTURA");
        }
        return codDetalle;
    }
    
    private void cargarDetalle(String ruc, int idCabecera) throws SQLException{
        DefaultTableModel modelo = new DefaultTableModel();
        this.jtable_detailsFactura.setModel(modelo);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT a.CODIGO_ART,a.NOMBRE_ART, df.CANTIDAD_DETALLE_COMPROBANTE_FACTURA, df.PRECIO__DETALLE_COMPROBANTE_FACTURA,(df.CANTIDAD_DETALLE_COMPROBANTE_FACTURA * df.PRECIO__DETALLE_COMPROBANTE_FACTURA)  AS MULTI\n" +
                        "FROM detalle_comprobante_factura df,articulo a,cliente c,cabecera_factura cf\n" +
                            "WHERE df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND df.CODIGO_ART = a.CODIGO_ART AND cf.CODIGO_CLI = c.CODIGO_CLI AND c.RUC_CLI=?  AND cf.NUMERO_CABECERA_FACTU = ?";
        
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        ps.setString(1, ruc);
        ps.setInt(2, idCabecera);
        rs = ps.executeQuery();
        
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();

        modelo.addColumn("CODIGO");
        modelo.addColumn("ARTICULO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO U.");
        modelo.addColumn("PRECIO TOTAL");
        int[] anchos = {150, 200, 150,150, 300};
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
                try {
                    new jframe_FacturacionCompleja().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(jframe_FacturacionCompleja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addArt;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_clean;
    private javax.swing.JButton btn_delArt;
    private javax.swing.JButton btn_modArt;
    private javax.swing.JComboBox<String> cmb_listFacturas;
    private javax.swing.JComboBox<String> cmb_ruc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_detailsFactura;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_numFac;
    private javax.swing.JTextField txt_ruc;
    // End of variables declaration//GEN-END:variables
}
