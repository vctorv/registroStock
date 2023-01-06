package cl.cerveceria.View;



import cl.cerveceria.Controller.InventarioJpaController;
import cl.cerveceria.Model.Inventario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InformeStock extends javax.swing.JFrame {
    InventarioJpaController inventarioController = new InventarioJpaController();
    Inventario inventario = new Inventario();
    

    /** Creates new form VentaProducto */
    public InformeStock() {
        initComponents();
        getTablaStockTipoProducto();
   }
    
    /*private void getTabla(){
        String col[] = {"PRODUCTO","STOCK"};
        DefaultTableModel tablaVista = new DefaultTableModel(col, 0);
        Object[] tablaBD = new Object[2];
        List ls;
        try {
            ls = productoController.findProductoEntities();
            for(int i = 0; i < ls.size(); i++){
                producto = (Producto)ls.get(i);
                tablaBD[0] = producto.getNombreProducto();
                //tablaBD[1] = producto.getCantidadStock();
                tablaVista.addRow(tablaBD);
            }
            this.tblStock.setModel(tablaVista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar datos");
        }
    }*/
    
    public void getTablaStockTipoProducto(){
        String col[] = {"TIPO PRODUCTO","STOCK"};
        DefaultTableModel tablaVista = new DefaultTableModel(col, 0);
        String[] tablaBD = new String[3];
        int contadorLager = 0;
        int contadorAmbar = 0;
        int contadorStout = 0;
        List ls;        
        try {
            ls = inventarioController.findInventarioEntities();
            for (int i = 0; i < ls.size(); i++) {
                inventario = (Inventario)ls.get(i);
                if ("lager".equals(inventario.getProductoIdProducto().getTipoProducto().toLowerCase())) {
                    contadorLager = contadorLager + inventario.getStock();
                } else if ("ambar".equals(inventario.getProductoIdProducto().getTipoProducto().toLowerCase())) {
                    contadorAmbar = contadorAmbar + inventario.getStock();
                } else if ("stout".equals(inventario.getProductoIdProducto().getTipoProducto().toLowerCase())) {
                    contadorStout = contadorStout + inventario.getStock();
                }
            }
                tablaBD[0] = "Lager";
                tablaBD[1] = String.valueOf(contadorLager);
                tablaVista.addRow(tablaBD);
                tablaBD[0] = "Ambar";
                tablaBD[1] = String.valueOf(contadorAmbar);
                tablaVista.addRow(tablaBD);
                tablaBD[0] = "Stout";
                tablaBD[1] = String.valueOf(contadorStout);
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
        lblTest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        pnlProductoNuevaVenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad en stock por tipo"));

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
                "Producto", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblStock);

        javax.swing.GroupLayout pnlProductoNuevaVentaLayout = new javax.swing.GroupLayout(pnlProductoNuevaVenta);
        pnlProductoNuevaVenta.setLayout(pnlProductoNuevaVentaLayout);
        pnlProductoNuevaVentaLayout.setHorizontalGroup(
            pnlProductoNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductoNuevaVentaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(pnlProductoNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProductoSiguiente)
                    .addComponent(lblTest))
                .addGap(114, 114, 114))
        );
        pnlProductoNuevaVentaLayout.setVerticalGroup(
            pnlProductoNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoNuevaVentaLayout.createSequentialGroup()
                .addComponent(lblTest)
                .addGap(30, 30, 30)
                .addGroup(pnlProductoNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductoSiguiente))
                .addContainerGap(480, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(InformeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformeStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductoSiguiente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTest;
    private javax.swing.JPanel pnlProductoNuevaVenta;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables

}
