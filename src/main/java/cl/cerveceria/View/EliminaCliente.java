package cl.cerveceria.View;


import cl.cerveceria.Controller.ClienteJpaController;
import cl.cerveceria.Model.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EliminaCliente extends javax.swing.JFrame {
    //Se instancia el controller
    ClienteJpaController controllerCliente = new ClienteJpaController();
    Cliente cliente = new Cliente();
    DefaultTableModel tablaVista;
    
    public EliminaCliente() {
        initComponents();
        getTablaListaClientes();
        
    }
    
    public int rutDeTabla(){
        int rutCliente = (int) tblListaCliente.getValueAt(this.tblListaCliente.getSelectedRow(), 0);
        return rutCliente;
    }
  

    public void getTablaListaClientes(){
        String col[] = {"RUN","DV","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","DIRECCIÓN", "COMUNA","TELÉFONO", "CORREO", "NOMBRE EMPRESA", "TIPO EMPRESA"};
        tablaVista = new DefaultTableModel(col, 0);
        Object[] tablaBD = new Object[11];
        List ls;
        try {
            ls = controllerCliente.findClienteEntities();
            for(int i = 0; i < ls.size(); i++){
                cliente = (Cliente)ls.get(i);
                tablaBD[0] = cliente.getNumrutCliente();
                tablaBD[1] = cliente.getDvrutCliente();
                tablaBD[2] = cliente.getNombreCliente();
                tablaBD[3] = cliente.getAppaternoCliente();
                tablaBD[4] = cliente.getApmaternoCliente();
                tablaBD[5] = cliente.getDireccionCliente();
                tablaBD[6] = cliente.getComunaCliente();
                tablaBD[7] = cliente.getTelefonoCliente();
                tablaBD[8] = cliente.getEmailCliente();
                tablaBD[9] = cliente.getNombreEmpresa();
                tablaBD[10] = cliente.getTipoEmpresa();
                tablaVista.addRow(tablaBD);
            }
            this.tblListaCliente.setModel(tablaVista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar datos");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group1 = new javax.swing.ButtonGroup();
        pnlClienteNuevoCliente = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnVentaVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaCliente = new javax.swing.JTable();
        lblRut = new javax.swing.JLabel();
        lblRutSet = new javax.swing.JLabel();
        lblDv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        pnlClienteNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar cliente"));
        pnlClienteNuevoCliente.setPreferredSize(new java.awt.Dimension(1366, 700));

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnVentaVolver.setText("Volver");
        btnVentaVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaVolverActionPerformed(evt);
            }
        });

        tblListaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RUN", "DV", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "DIRECCIÓN", "COMUNA", "TELÉFONO", "CORREO", "NOMBRE EMPRESA", "TIPO EMPRESA"
            }
        ));
        tblListaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaCliente);

        lblRut.setText("RUT:");

        lblRutSet.setText("12345678");

        lblDv.setText("9");

        javax.swing.GroupLayout pnlClienteNuevoClienteLayout = new javax.swing.GroupLayout(pnlClienteNuevoCliente);
        pnlClienteNuevoCliente.setLayout(pnlClienteNuevoClienteLayout);
        pnlClienteNuevoClienteLayout.setHorizontalGroup(
            pnlClienteNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteNuevoClienteLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(lblRut)
                .addGap(18, 18, 18)
                .addComponent(lblRutSet)
                .addGap(18, 18, 18)
                .addComponent(lblDv)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVentaVolver)
                .addGap(285, 285, 285))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1356, Short.MAX_VALUE)
        );
        pnlClienteNuevoClienteLayout.setVerticalGroup(
            pnlClienteNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteNuevoClienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlClienteNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnVentaVolver)
                    .addComponent(lblRut)
                    .addComponent(lblRutSet)
                    .addComponent(lblDv))
                .addGap(81, 81, 81)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlClienteNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlClienteNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        try {
            controllerCliente.destroy(Integer.parseInt(this.lblRutSet.getText()));
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar");
        }
        
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnVentaVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVentaVolverActionPerformed

    private void tblListaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaClienteMouseClicked
        this.lblRutSet.setText(this.tblListaCliente.getValueAt(this.tblListaCliente.getSelectedRow(), 0).toString());
        this.lblDv.setText(this.tblListaCliente.getValueAt(this.tblListaCliente.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tblListaClienteMouseClicked


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
            java.util.logging.Logger.getLogger(EliminaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new EliminaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Group1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVentaVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDv;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblRutSet;
    private javax.swing.JPanel pnlClienteNuevoCliente;
    private javax.swing.JTable tblListaCliente;
    // End of variables declaration//GEN-END:variables

}