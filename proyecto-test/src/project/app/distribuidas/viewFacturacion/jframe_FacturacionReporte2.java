package project.app.distribuidas.viewFacturacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import project.app.distribuidas.db.MysqlConnect;


public class jframe_FacturacionReporte2 extends javax.swing.JFrame implements Printable {

    public jframe_FacturacionReporte2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_report2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_report2 = new javax.swing.JTable();
        btn_genReport = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_report2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Reporte por cliente y artículo ");

        jtable_report2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtable_report2);

        javax.swing.GroupLayout panel_report2Layout = new javax.swing.GroupLayout(panel_report2);
        panel_report2.setLayout(panel_report2Layout);
        panel_report2Layout.setHorizontalGroup(
            panel_report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_report2Layout.createSequentialGroup()
                .addGroup(panel_report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_report2Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel2))
                    .addGroup(panel_report2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panel_report2Layout.setVerticalGroup(
            panel_report2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_report2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        btn_genReport.setText("GENERAR REPORTE");
        btn_genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genReportActionPerformed(evt);
            }
        });

        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_report2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_genReport, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_genReport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addComponent(panel_report2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        try {
            PrinterJob gap = PrinterJob.getPrinterJob();
            gap.setPrintable((Printable) this);
            boolean top = gap.printDialog();
            if(top){
                    gap.print();
            }else{

            }
        } catch (PrinterException ex) {
                    java.util.logging.Logger.getLogger(jframe_FacturacionReporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void btn_genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genReportActionPerformed
        this.loadTableCruce();
    }//GEN-LAST:event_btn_genReportActionPerformed


    public void loadTableCruce(){
        DefaultTableModel modelo = new DefaultTableModel();
        this.jtable_report2.setModel(modelo);
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = MysqlConnect.ConnectDB();

            String sql = "SELECT * FROM lgh.reporte_pivote ";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();     
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantColm = rsMd.getColumnCount();
            System.out.println("cant Colum "+cantColm);
            int i = 0;
            
            String[] headers = new String[cantColm];
            
            while(rs.next() && i < cantColm ){
                i++;
                headers[i] = rsMd.getColumnName(i+1);
            }
            
            for( int j=0;j <cantColm;j++)
                modelo.addColumn(headers[j]);
                         
            int[] anchos = new int[cantColm];
            
            for(i = 0;i<cantColm;i++)
                anchos[i] = 100;
            
            for (i = 0; i < jtable_report2.getColumnCount(); i++) 
                this.jtable_report2.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            
            
            String sql2 = "SELECT * FROM lgh.reporte_pivote ";
            PreparedStatement ps2 = null;
            ResultSet rs2 = null;
            ps2 = conn.prepareStatement(sql2);
            rs2 = ps2.executeQuery();  
            
            int cantidadColumnas = rsMd.getColumnCount();
            int con=0;
            while (rs2.next()){
                con++;
                Object[] filas = new Object[cantidadColumnas];
                for (int p = 0; p < cantidadColumnas; p++) {
                    filas[p] = rs2.getObject(p + 1);
                }
                modelo.addRow(filas);
            }
            System.out.println("registros: "+con);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframe_FacturacionReporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframe_FacturacionReporte2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_genReport;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_report2;
    private javax.swing.JPanel panel_report2;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pagForm, int index) throws PrinterException {
        if(index>0){
            return NO_SUCH_PAGE;
        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pagForm.getImageableX() + 30 , pagForm.getImageableY()+30);
        hub.scale(1.0,1.0);
        
        this.panel_report2.printAll(graf);
        return PAGE_EXISTS;
    }
}
