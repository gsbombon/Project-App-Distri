/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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

/**
 *
 * @author pocho
 */
public class jframe_FacturacionSimple1 extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    
    public jframe_FacturacionSimple1() throws IOException, ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);   
        this.loadCmbCity();
    }

    public void consultar() {
        String login = "/tablaCobrador";
        try {
            // CLIENTE UDP 
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(login);
            ObjectInputStream recepcion = new ObjectInputStream(cliente.getInputStream());
            ArrayList<Cobrador> Cobras = (ArrayList<Cobrador>) recepcion.readObject();
            
            Object[] cobrador = new Object[4];
            modelo = (DefaultTableModel) jtable_clientes.getModel();
            for(int i = 0;i<Cobras.size();i++){
                cobrador [0] = Cobras.get(i).getId_cobrador();
                cobrador [1] = Cobras.get(i).getCedula_cobrador();
                cobrador [2] = Cobras.get(i).getNombre_cobrador();
                cobrador [3] = Cobras.get(i).getDireccion_cobrador();
                modelo.addRow(cobrador);
            }
            jtable_clientes.setModel(modelo);

                cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) { 
           Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
       
    }
    
    public void loadTable() throws IOException, ClassNotFoundException, SQLException{
        String accion = "/tablaClientes";
        int cantidadColumnas = 3;
        // ENVIO A LA BASE DE DATOS
        Socket cliente = new Socket("localhost",4444);
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
        mensaje.writeObject(accion);
        
        //Mensaje que receptas
        ObjectInputStream objectInput = new ObjectInputStream(cliente.getInputStream());
        Object object = objectInput.readObject();
        clientes =  (ArrayList<Cliente>) object;
        
        System.out.println(clientes.get(1));
       
        cliente.close();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        txt_rucCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_clientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_cuidad = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_ciudades = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("RUC");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 246, -1, -1));

        txt_ruc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 243, 211, -1));

        txt_rucCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_rucCli.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(txt_rucCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 469, 300, -1));

        jLabel5.setText("RUC:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 472, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 282, 211, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Direccion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 326, -1, -1));

        txt_dir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_dir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(txt_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 323, 211, -1));

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardar.setText("Guardar Nuevo");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 160, 170, 50));

        jtable_clientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable_clientes.setForeground(new java.awt.Color(51, 51, 51));
        jtable_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtable_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 620, 200));

        jButton1.setText("Regresar al menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 760, 250, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Nombre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 285, -1, -1));

        txt_cuidad.setEditable(false);
        txt_cuidad.setBackground(new java.awt.Color(255, 255, 255));
        txt_cuidad.setForeground(new java.awt.Color(51, 51, 51));
        txt_cuidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt_cuidad.setEnabled(false);
        getContentPane().add(txt_cuidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 200, 37, -1));

        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 160, 210, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 371, 280, 52));

        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 160, -1, -1));

        jLabel4.setText("Cuidad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 203, -1, -1));

        cmb_ciudades.setBackground(new java.awt.Color(204, 204, 204));
        cmb_ciudades.setForeground(new java.awt.Color(51, 51, 51));
        cmb_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ciudadesActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_ciudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 200, 208, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Clientes");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(482, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 130));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 204, 204));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(51, 51, 51));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(204, 204, 204));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(444, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(btnBuscar)
                .addContainerGap(357, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 640, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int Fila = this.jtable_clientes.getSelectedRow();
        int codigo = Integer.parseInt(this.jtable_clientes.getValueAt(Fila, 0).toString());
                
        String path = "/delCliente";
        String delCliente = path+";"+codigo;
        
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(delCliente);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            
             if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "Registro eliminado CORRECTAMENTE ! ");                
                txt_ruc.setText("");
                txt_nombre.setText("");
                txt_dir.setText("");
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
        String ruc_buscar = txt_rucCli.getText();
        String where = "";
        if (!"".equals(ruc_buscar)) {
            where = "AND RUC_CLI = '" + ruc_buscar + "'";
        }
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            this.jtable_clientes.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = MysqlConnect.ConnectDB();

            String sql = "SELECT CODIGO_CLI,RUC_CLI,NOM_CLI,DIR_CLI,NOMBRE_CIU FROM cliente c, ciudad ciu WHERE c.CODIGO_CIU = ciu.CODIGO_CIU " + where;
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Código");
            modelo.addColumn("RUC");    
            modelo.addColumn("Nombre");
            modelo.addColumn("Direccion");
            modelo.addColumn("Nom Ciudad");
            int[] anchos = {50, 50, 150, 150, 150};
           /*
            for (int i = 0; i < this.jtable_clientes.getColumnCount(); i++) {
                this.jtable_clientes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            */
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String ruc = txt_ruc.getText();
        String nombre = txt_nombre.getText();
        String dir = txt_dir.getText();
        int id_city = Integer.parseInt(this.txt_cuidad.getText());
        String path = "/addClient";
        String addCliente = path+";"+ruc+";"+nombre+";"+dir+";"+id_city;
        
        try {
            addPivote(nombre);
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(addCliente);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            
             if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "CREADO ! ");
                txt_ruc.setText("");
                txt_nombre.setText("");
                txt_dir.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "FALLIDO ! ");

            }
        } catch (IOException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jtable_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable_clientesMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_cuidad = 0;
        try {
            Connection conn = MysqlConnect.ConnectDB();

            int Fila = this.jtable_clientes.getSelectedRow();
            String codigo = this.jtable_clientes.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT CODIGO_CLI,RUC_CLI,NOM_CLI,DIR_CLI,NOMBRE_CIU,ciu.CODIGO_CIU "
                                        + "FROM cliente c, ciudad ciu WHERE c.CODIGO_CIU = ciu.CODIGO_CIU AND C.CODIGO_CLI =?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                id_cuidad = Integer.parseInt(rs.getString("CODIGO_CIU"))-1;
                System.out.println(""+id_cuidad);
                this.txt_id.setText(rs.getString("CODIGO_CLI"));
                this.txt_cuidad.setText(rs.getString("CODIGO_CIU"));
                this.txt_ruc.setText(rs.getString("RUC_CLI"));
                this.cmb_ciudades.setSelectedIndex(id_cuidad);
                this.txt_nombre.setText(rs.getString("NOM_CLI"));
                this.txt_dir.setText(rs.getString("DIR_CLI"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtable_clientesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // int Fila = this.jtable_clientes.getSelectedRow();
        int id = Integer.parseInt(txt_id.getText());
        int id_cuidad = Integer.parseInt(this.txt_cuidad.getText());
        String ruc = txt_ruc.getText();
        String nombre = txt_nombre.getText();
        String dir = txt_dir.getText();
        String path = "/modCliente";
        String modCli = path+";"+id+";"+id_cuidad+";"+ruc+";"+nombre+";"+dir;
        
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(modCli);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje2 = (String) entrada.readObject();
            
             if(mensaje2.equals("1")){
                JOptionPane.showMessageDialog(null, "Datos modificados \n CORRECTAMENTE ! ");                
                txt_ruc.setText("");
                txt_nombre.setText("");
                txt_dir.setText("");
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

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.txt_id.setText("");
        this.txt_cuidad.setText("");
        this.txt_ruc.setText("");
        this.txt_nombre.setText("");
        this.txt_dir.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmb_ciudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ciudadesActionPerformed
        int id_ciudad = 0;
        String cuidad = this.cmb_ciudades.getSelectedItem().toString();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT CODIGO_CIU FROM ciudad WHERE NOMBRE_CIU=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cuidad);
            rs = ps.executeQuery();     
            
            while(rs.next()){
                id_ciudad = rs.getInt("CODIGO_CIU");
            }
        
            this.txt_cuidad.setText(String.valueOf(id_ciudad));
            
        } catch (SQLException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_cmb_ciudadesActionPerformed

    public void addPivote(String col) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        String sql = "ALTER TABLE reporte_pivote ADD COLUMN "+col+" VARCHAR(20) NULL DEFAULT 0 AFTER articulos";
        ps = conn.prepareStatement(sql);
        ps.execute(); 
    }
    
    public void modPivote(String oldName,String newName) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        String sql = "ALTER TABLE reporte_pivote CHANGE COLUMN "+oldName+" "+newName+" VARCHAR(20) NULL DEFAULT '0'";        
        ps = conn.prepareStatement(sql);
        ps.execute();
    }
    
    private void btnBuscar(){
        String ruc_buscar = txt_rucCli.getText();
        String path = "/findClientes";
        String buscar = path+";"+ruc_buscar;
        
        DefaultTableModel modelo = new DefaultTableModel();
        jtable_clientes.setModel(modelo);
        
        modelo.addColumn("ID");
        modelo.addColumn("Cuidad");
        modelo.addColumn("RUC");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        try {
            Socket cliente = new Socket("localhost",4444);
            ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
            mensaje.writeObject(buscar);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) entrada.readObject();
            
            Object[] clienteObj = new Object[5];
            modelo = (DefaultTableModel) this.jtable_clientes.getModel();
            for(int i=0;i<clientes.size();i++){
                clienteObj[0] = clientes.get(i).getId();
                clienteObj[1] = clientes.get(i).getId_cuidad();
                clienteObj[2] = clientes.get(i).getRuc();
                clienteObj[3] = clientes.get(i).getNombre();
                clienteObj[4] = clientes.get(i).getDireccion();
                modelo.addRow(clienteObj);
            }
            
            this.jtable_clientes.setModel(modelo);
            
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void limpiar(){
        this.txt_id.setText("");
        this.txt_cuidad.setText("");
        this.txt_ruc.setText("");
        this.txt_nombre.setText("");
        this.txt_dir.setText("");
    }
    
    public void loadCmbCity() throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT CODIGO_CIU, NOMBRE_CIU FROM ciudad";        
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();     
        
        while(rs.next()){
            this.cmb_ciudades.addItem(rs.getString("NOMBRE_CIU"));
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
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jframe_FacturacionSimple1().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(jframe_FacturacionSimple1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmb_ciudades;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtable_clientes;
    private javax.swing.JTextField txt_cuidad;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_rucCli;
    // End of variables declaration//GEN-END:variables
}
