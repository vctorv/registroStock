package cl.cerveceria.View;


import cl.cerveceria.Controller.MovimientoJpaController;
import cl.cerveceria.Model.Movimiento;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author victor
 */
public class InformeMovimientos extends javax.swing.JFrame {
    MovimientoJpaController movimientoController = new MovimientoJpaController();
    Movimiento movimiento = new Movimiento();

    /** Creates new form VentaProducto */
    public InformeMovimientos() {
        initComponents();
        getTablaMovimientos();
    }
    
    public void getTablaMovimientos(){
        String col[] = {"TIPO MOVIMIENTO","CANTIDAD"};
        DefaultTableModel tablaVista = new DefaultTableModel(col, 0);
        String[] tablaBD = new String[2];
        int contadorIngreso = 0;
        int contadorEgreso = 0;
        List ls;        
        try {
            ls = movimientoController.findMovimientoEntities();
            for (int i = 0; i < ls.size(); i++) {
                movimiento = (Movimiento)ls.get(i);
                if ("ingreso".equals(movimiento.getTipoMovimiento().toLowerCase())) {
                    contadorIngreso++;
                } else if ("egreso".equals(movimiento.getTipoMovimiento().toLowerCase())) {
                    contadorEgreso++;
                }
            }
                tablaBD[0] = "Ingreso";
                tablaBD[1] = String.valueOf(contadorIngreso);
                tablaVista.addRow(tablaBD);
                tablaBD[0] = "Egreso";
                tablaBD[1] = String.valueOf(contadorEgreso);
                tablaVista.addRow(tablaBD);
      
            this.tblStock.setModel(tablaVista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar datos");
        }
    }
   

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProductoNuevaVenta = new javax.swing.JPanel();
        btnProductoSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        pnlProductoNuevaVenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad de movimientos por tipo "));

        btnProductoSiguiente.setText("Volver");
        btnProductoSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoSiguienteActionPerformed(evt);
            }
        });

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "TIPO MOVIMIENTO", "CANTIDAD"
            }
        ));
        jScrollPane1.setViewportView(tblStock);

        javax.swing.GroupLayout pnlProductoNuevaVentaLayout = new javax.swing.GroupLayout(pnlProductoNuevaVenta);
        pnlProductoNuevaVenta.setLayout(pnlProductoNuevaVentaLayout);
        pnlProductoNuevaVentaLayout.setHorizontalGroup(
            pnlProductoNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoNuevaVentaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductoNuevaVentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProductoSiguiente)
                .addGap(127, 127, 127))
        );
        pnlProductoNuevaVentaLayout.setVerticalGroup(
            pnlProductoNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoNuevaVentaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductoSiguiente)
                .addContainerGap(573, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(pnlProductoNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlProductoNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductoSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoSiguienteActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnProductoSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(InformeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformeMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformeMovimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductoSiguiente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlProductoNuevaVenta;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables

}
