
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

public class jframe_FacturacionReporte1 extends javax.swing.JFrame implements Printable {

    public jframe_FacturacionReporte1() throws SQLException {
        initComponents();
        loadCmbCity();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_genReport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        panel_print = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb_ciudades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_detailsReport = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        date_inicio = new com.toedter.calendar.JDateChooser();
        date_fin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_genReport.setText("Generar \nReporte");
        btn_genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genReportActionPerformed(evt);
            }
        });
        getContentPane().add(btn_genReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, -1, 79));

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 115, 33));

        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 115, 77));

        panel_print.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Ventas por ciudad ");

        jLabel1.setText("CUIDAD ");

        cmb_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ciudadesActionPerformed(evt);
            }
        });

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

        jLabel3.setText("RANGO DE FECHAS");

        jLabel4.setText("Fecha Inicio");

        jLabel5.setText("Fecha Fin");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("DETALLE DE REPORTE");

        javax.swing.GroupLayout panel_printLayout = new javax.swing.GroupLayout(panel_print);
        panel_print.setLayout(panel_printLayout);
        panel_printLayout.setHorizontalGroup(
            panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_printLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(167, 167, 167)
                        .addComponent(cmb_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47)
                        .addComponent(date_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel5)
                        .addGap(60, 60, 60)
                        .addComponent(date_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(panel_printLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_printLayout.setVerticalGroup(
            panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_printLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cmb_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(date_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addGroup(panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_printLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(date_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jLabel6)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(panel_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, -1));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
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
