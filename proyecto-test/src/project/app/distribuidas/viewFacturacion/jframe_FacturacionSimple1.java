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

        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txt_ruc = new javax.swing.JTextField();
        txt_rucCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_clientes = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_cuidad = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_ciudades = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("RUC");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txt_ruc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setText("RUC:");

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Direccion");

        txt_dir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnGuardar.setText("Guardar Nuevo");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Clientes");

        jButton1.setText("Regresar al menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Nombre");

        txt_cuidad.setEditable(false);
        txt_cuidad.setEnabled(false);

        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel4.setText("Cuidad");

        cmb_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ciudadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(29, 29, 29)
                                .addComponent(txt_rucCli, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnBuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel2)
                                        .addGap(49, 49, 49)
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(cmb_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)))
                                        .addComponent(txt_cuidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_cuidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rucCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_clientes;
    private javax.swing.JTextField txt_cuidad;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_rucCli;
    // End of variables declaration//GEN-END:variables
}
