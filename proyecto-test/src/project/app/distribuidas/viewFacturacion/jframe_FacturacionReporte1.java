
package project.app.distribuidas.viewFacturacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import project.app.distribuidas.db.MysqlConnect;
import project.app.distribuidas.viewLogin.jframe_mainOptions;

public class jframe_FacturacionReporte1 extends javax.swing.JFrame implements Printable {

    public jframe_FacturacionReporte1() throws SQLException {
        initComponents();
        loadCmbCity();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_print = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmb_ciudades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_detailsReport = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        date_inicio = new com.toedter.calendar.JDateChooser();
        date_fin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_genReport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_print.setBackground(new java.awt.Color(255, 255, 255));
        panel_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CUIDAD ");
        panel_print.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 106, -1, -1));

        cmb_ciudades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ciudadesActionPerformed(evt);
            }
        });
        panel_print.add(cmb_ciudades, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 106, 302, -1));

        jtable_detailsReport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable_detailsReport.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtable_detailsReport);

        panel_print.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 368, 627, 231));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("RANGO DE FECHAS");
        panel_print.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 199, -1, -1));

        date_inicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panel_print.add(date_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 169, 192, -1));

        date_fin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panel_print.add(date_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 232, 192, -1));

        jLabel4.setText("Fecha Inicio");
        panel_print.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 169, -1, -1));

        jLabel5.setText("Fecha Fin");
        panel_print.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 238, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Ventas por ciudad ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addContainerGap(396, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        panel_print.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 90));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("DETALLE DE REPORTE");
        panel_print.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 325, -1, -1));

        getContentPane().add(panel_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 620));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        btn_genReport.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_genReport.setText("Generar  Reporte");
        btn_genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genReportActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(51, 51, 51));
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Menu Principal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_genReport))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btn_genReport, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 230, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genReportActionPerformed
        Date fInicio = this.date_inicio.getDate();
        Date fFin = this.date_fin.getDate();
        long d_inicio = fInicio.getTime();
        long d_fin = fFin.getTime();
        java.sql.Date fecha_inicio = new java.sql.Date(d_inicio);
        java.sql.Date fecha_fin = new java.sql.Date(d_fin);        
        String cuidad = this.cmb_ciudades.getSelectedItem().toString();      
        DefaultTableModel modelo = new DefaultTableModel();
        this.jtable_detailsReport.setModel(modelo);
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = MysqlConnect.ConnectDB();

            String sql = "SELECT ciu.NOMBRE_CIU, cf.FECHA_CABECERA_FACTU, c.NOM_CLI,SUM(PRECIO__DETALLE_COMPROBANTE_FACTURA) as PRECIO \n" +
                            "FROM detalle_comprobante_factura df, cliente c, ciudad ciu, cabecera_factura cf\n" +
                            "WHERE df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND\n" +
                            "cf.CODIGO_CLI = c.CODIGO_CLI AND\n" +
                            "c.CODIGO_CIU = ciu.CODIGO_CIU AND\n" +
                            "ciu.NOMBRE_CIU = ?  AND cf.FECHA_CABECERA_FACTU BETWEEN ? AND ? group by cf.FECHA_CABECERA_FACTU;";

            ps = conn.prepareStatement(sql);
            ps.setString(1, cuidad);
            ps.setString(2, fecha_inicio.toString());
            ps.setString(3, fecha_fin.toString());
            rs = ps.executeQuery();     
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("CUIDAD");
            modelo.addColumn("FECHA FACTURA");
            modelo.addColumn("CLIENTE");
            modelo.addColumn("DOLARES VENIDOS");
            int[] anchos = {150, 150,150, 150};
            for (int i = 0; i < jtable_detailsReport.getColumnCount(); i++) {
                this.jtable_detailsReport.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_genReportActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        this.date_fin.setDate(null);
        this.date_inicio.setDate(null);
        this.reiniciarJTable(jtable_detailsReport);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            PrinterJob gap = PrinterJob.getPrinterJob();
            gap.setPrintable(this);
            boolean top = gap.printDialog();
            if(top){
                gap.print();
            }else{
                
            }
        } catch (PrinterException ex) {
            Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmb_ciudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ciudadesActionPerformed
        String filtrarFecha = "";

        String cuidad = this.cmb_ciudades.getSelectedItem().toString();

        DefaultTableModel modelo = new DefaultTableModel();
        this.jtable_detailsReport.setModel(modelo);
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = MysqlConnect.ConnectDB();
            String sql = "SELECT ciu.NOMBRE_CIU, cf.FECHA_CABECERA_FACTU, c.NOM_CLI,SUM(PRECIO__DETALLE_COMPROBANTE_FACTURA) as PRECIO \n" +
            "FROM detalle_comprobante_factura df, cliente c, ciudad ciu, cabecera_factura cf\n" +
            "WHERE df.NUMERO_CABECERA_FACTU = cf.NUMERO_CABECERA_FACTU AND\n" +
            "cf.CODIGO_CLI = c.CODIGO_CLI AND\n" +
            "c.CODIGO_CIU = ciu.CODIGO_CIU AND\n" +
            "ciu.NOMBRE_CIU = ? group by cf.FECHA_CABECERA_FACTU";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cuidad);
            System.out.println(""+ps.toString());
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("CUIDAD");
            modelo.addColumn("FECHA FACTURA");
            modelo.addColumn("CLIENTE");
            modelo.addColumn("DOLARES VENIDOS");
            int[] anchos = {150, 150,150, 150};
            for (int i = 0; i < this.jtable_detailsReport.getColumnCount(); i++) {
                this.jtable_detailsReport.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_ciudadesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        jframe_mainOptions mo = new jframe_mainOptions();
        mo.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
        TableColumnModel modCol = Tabla.getColumnModel();
        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
    }
    
    public void loadCmbCity() throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MysqlConnect.ConnectDB();
        
        String sql = "SELECT NOMBRE_CIU FROM ciudad";        
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();     
        
        while(rs.next()){
            this.cmb_ciudades.addItem(rs.getString("NOMBRE_CIU"));
        }
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
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jframe_FacturacionReporte1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_genReport;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cmb_ciudades;
    private com.toedter.calendar.JDateChooser date_fin;
    private com.toedter.calendar.JDateChooser date_inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtable_detailsReport;
    private javax.swing.JPanel panel_print;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pagForm, int index) throws PrinterException {
        if(index>0){
            return NO_SUCH_PAGE;
        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pagForm.getImageableX() + 30 , pagForm.getImageableY()+30);
        hub.scale(1.0,1.0);
        
        this.panel_print.printAll(graf);
        return PAGE_EXISTS;
    }
}
