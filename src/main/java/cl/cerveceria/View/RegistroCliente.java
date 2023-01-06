package cl.cerveceria.View;


import cl.cerveceria.Controller.ClienteJpaController;
import cl.cerveceria.Model.Cliente;
import javax.swing.JOptionPane;


public class RegistroCliente extends javax.swing.JFrame {
    //Se instancia el controller
    ClienteJpaController controllerCliente = new ClienteJpaController();
    Cliente cliente = new Cliente();
    
    public RegistroCliente() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group1 = new javax.swing.ButtonGroup();
        pnlClienteNuevoCliente = new javax.swing.JPanel();
        pnlCliente = new javax.swing.JPanel();
        lblNombreCliente = new javax.swing.JLabel();
        lblPrimerApellido = new javax.swing.JLabel();
        lblSegundoApellido = new javax.swing.JLabel();
        lblRut = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        pnlDireccion = new javax.swing.JPanel();
        lblCalle = new javax.swing.JLabel();
        lblComuna = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtComuna = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnVentaSiguiente = new javax.swing.JButton();
        btnVentaLiampiar = new javax.swing.JButton();
        txtPrimerApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        opcRestaurant = new javax.swing.JRadioButton();
        opcSupermercado = new javax.swing.JRadioButton();
        opcRetail = new javax.swing.JRadioButton();
        lblRut1 = new javax.swing.JLabel();
        btnVentaVolver = new javax.swing.JButton();
        lblRut2 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        pnlClienteNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo cliente"));
        pnlClienteNuevoCliente.setPreferredSize(new java.awt.Dimension(1366, 700));

        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        lblNombreCliente.setText("Nombre");

        lblPrimerApellido.setText("Primer Apellido");

        lblSegundoApellido.setText("Segundo Apellido");

        lblRut.setText("RUT (12345678-9)");

        lblCorreo.setText("Correo electrónico");

        lblTelefono.setText("Teléfono");

        pnlDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección"));

        lblCalle.setText("Calle");

        lblComuna.setText("Comuna");

        lblNumero.setText("Número");

        txtComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComunaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDireccionLayout = new javax.swing.GroupLayout(pnlDireccion);
        pnlDireccion.setLayout(pnlDireccionLayout);
        pnlDireccionLayout.setHorizontalGroup(
            pnlDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDireccionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDireccionLayout.createSequentialGroup()
                        .addComponent(lblComuna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtComuna))
                    .addGroup(pnlDireccionLayout.createSequentialGroup()
                        .addComponent(lblCalle)
                        .addGap(32, 32, 32)
                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addComponent(lblNumero)
                .addGap(18, 18, 18)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        pnlDireccionLayout.setVerticalGroup(
            pnlDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDireccionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalle)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComuna)
                    .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btnVentaSiguiente.setText("Registrar");
        btnVentaSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentaSiguienteMouseClicked(evt);
            }
        });
        btnVentaSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaSiguienteActionPerformed(evt);
            }
        });

        btnVentaLiampiar.setText("Limpiar");
        btnVentaLiampiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentaLiampiarMouseClicked(evt);
            }
        });

        Group1.add(opcRestaurant);
        opcRestaurant.setText("Restaurant");

        Group1.add(opcSupermercado);
        opcSupermercado.setText("Supermercado");
        opcSupermercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcSupermercadoActionPerformed(evt);
            }
        });

        Group1.add(opcRetail);
        opcRetail.setText("Retail");

        lblRut1.setText("Tipo cliente");

        btnVentaVolver.setText("Volver");
        btnVentaVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaVolverActionPerformed(evt);
            }
        });

        lblRut2.setText("Nombre Empresa");

        txtNombreEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGap(810, 810, 810)
                        .addComponent(btnVentaVolver)
                        .addGap(18, 18, 18)
                        .addComponent(btnVentaLiampiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVentaSiguiente))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRut)
                            .addComponent(lblNombreCliente)
                            .addComponent(lblRut2))
                        .addGap(65, 65, 65)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblRut1)
                                .addGap(18, 18, 18)
                                .addComponent(opcRestaurant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opcSupermercado)
                                .addGap(18, 18, 18)
                                .addComponent(opcRetail))
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblPrimerApellido)
                                .addGap(28, 28, 28)
                                .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addGap(60, 60, 60)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(lblSegundoApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCliente)
                    .addComponent(lblPrimerApellido)
                    .addComponent(lblSegundoApellido)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRut)
                    .addComponent(lblCorreo)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRut2)
                        .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(opcRestaurant)
                        .addComponent(opcSupermercado)
                        .addComponent(opcRetail)
                        .addComponent(lblRut1)))
                .addGap(38, 38, 38)
                .addComponent(pnlDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVentaSiguiente)
                    .addComponent(btnVentaLiampiar)
                    .addComponent(btnVentaVolver))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlClienteNuevoClienteLayout = new javax.swing.GroupLayout(pnlClienteNuevoCliente);
        pnlClienteNuevoCliente.setLayout(pnlClienteNuevoClienteLayout);
        pnlClienteNuevoClienteLayout.setHorizontalGroup(
            pnlClienteNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteNuevoClienteLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlClienteNuevoClienteLayout.setVerticalGroup(
            pnlClienteNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteNuevoClienteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
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

    private void opcSupermercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcSupermercadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcSupermercadoActionPerformed

    private void btnVentaSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaSiguienteMouseClicked
        try {
            setearDatosCliente();
            controllerCliente.create(cliente);
            JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al insertar datos. El formulario no cumple requisitos o el cliente ya existe");
        }
        
    }//GEN-LAST:event_btnVentaSiguienteMouseClicked

    private void btnVentaLiampiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaLiampiarMouseClicked
        txtCalle.setText(null);
        txtComuna.setText(null);
        txtCorreo.setText(null);
        txtNombre.setText(null);
        txtNombreEmpresa.setText(null);
        txtNumero.setText(null);
        txtPrimerApellido.setText(null);
        txtRut.setText(null);
        txtSegundoApellido.setText(null);
        txtTelefono.setText(null);
        
    }//GEN-LAST:event_btnVentaLiampiarMouseClicked

    private void txtComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComunaActionPerformed
        
        
        
        
    }//GEN-LAST:event_txtComunaActionPerformed

    private void btnVentaVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVentaVolverActionPerformed

    private void btnVentaSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentaSiguienteActionPerformed

    private void txtNombreEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEmpresaActionPerformed

    private void setearDatosCliente(){
        cliente.setNumrutCliente(cuerpoRut());
        cliente.setDvrutCliente(dvRut());
        cliente.setNombreCliente(this.txtNombre.getText());
        cliente.setAppaternoCliente(this.txtPrimerApellido.getText());
        cliente.setApmaternoCliente(this.txtSegundoApellido.getText());
        cliente.setDireccionCliente(this.txtCalle.getText() +" "+ this.txtNumero.getText());
        cliente.setComunaCliente(this.txtComuna.getText());
        cliente.setTelefonoCliente(Integer.parseInt((this.txtTelefono.getText())));
        cliente.setEmailCliente(this.txtCorreo.getText());
        cliente.setTipoEmpresa(radioButtonSeleccionado());
        cliente.setNombreEmpresa(this.txtNombreEmpresa.getText());
 
    }
    
    private String dvRut(){
        String dvRut;
        dvRut = this.txtRut.getText();
        dvRut = dvRut.substring(dvRut.length() - 1);
        return dvRut.toUpperCase();
    }
    
    private int cuerpoRut(){
        int cuerpoRut;
        cuerpoRut = Integer.parseInt(this.txtRut.getText().substring(0,this.txtRut.getText().length()-2));
        return cuerpoRut;
    }
    
    private String radioButtonSeleccionado(){
        String seleccion = "";
        if (opcRestaurant.isSelected()){
            return seleccion = "Restaurant";
        }
        if (opcSupermercado.isSelected()){
            return seleccion = "Supermercado";
        }
        if (opcRetail.isSelected()){
            return seleccion = "Retail";
        }
        return seleccion;
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
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Group1;
    private javax.swing.JButton btnVentaLiampiar;
    private javax.swing.JButton btnVentaSiguiente;
    private javax.swing.JButton btnVentaVolver;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblComuna;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrimerApellido;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblRut1;
    private javax.swing.JLabel lblRut2;
    private javax.swing.JLabel lblSegundoApellido;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JRadioButton opcRestaurant;
    private javax.swing.JRadioButton opcRetail;
    private javax.swing.JRadioButton opcSupermercado;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlClienteNuevoCliente;
    private javax.swing.JPanel pnlDireccion;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtComuna;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
