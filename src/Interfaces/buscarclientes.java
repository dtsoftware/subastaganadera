/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.*;
import Clases.CrearClientes;
import javax.swing.table.DefaultTableModel;
import Clases.Entradasubasta;
import Clases.FacturasCompras;
import Clases.Cheque;
import Clases.ReciboAbonos;
import Clases.subastas;
/**
 *
 * @author Tserng
 */
public class buscarclientes extends javax.swing.JFrame {
    String Nombre,Cedula;
    public static Integer Aux;
   public static String Validar;
   // DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
    /**
     * Creates new form buscarclientes
     */
    public buscarclientes() {
       initComponents();
       CrearClientes busc = new CrearClientes();
       busc.buscartodos();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionaropciones = new javax.swing.ButtonGroup();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Clientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jRadioButtonNombre = new javax.swing.JRadioButton();
        jRadioButtonCedula = new javax.swing.JRadioButton();
        jButtonRealizarBusqueda = new javax.swing.JButton();
        Seleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Apps-Dialog-Logout-icon.png"))); // NOI18N
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        Tbl_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cedula", "Nombre", "Apellido", "Direccion"
            }
        ));
        jScrollPane1.setViewportView(Tbl_Clientes);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldBuscar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldBuscarPropertyChange(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jRadioButtonNombre.setBackground(new java.awt.Color(255, 255, 255));
        seleccionaropciones.add(jRadioButtonNombre);
        jRadioButtonNombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jRadioButtonNombre.setForeground(new java.awt.Color(0, 0, 255));
        jRadioButtonNombre.setSelected(true);
        jRadioButtonNombre.setText("Nombre");
        jRadioButtonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNombreActionPerformed(evt);
            }
        });

        jRadioButtonCedula.setBackground(new java.awt.Color(255, 255, 255));
        seleccionaropciones.add(jRadioButtonCedula);
        jRadioButtonCedula.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jRadioButtonCedula.setForeground(new java.awt.Color(0, 0, 255));
        jRadioButtonCedula.setText("Cedula");

        jButtonRealizarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Zoom-icon.png"))); // NOI18N
        jButtonRealizarBusqueda.setText("BUSCAR");
        jButtonRealizarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(jRadioButtonNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonCedula)
                .addGap(132, 132, 132))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(148, 148, 148)
                    .addComponent(jButtonRealizarBusqueda)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCedula)
                    .addComponent(jRadioButtonNombre))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRealizarBusqueda))
                    .addGap(18, 18, 18)))
        );

        Seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/login-icon (1).png"))); // NOI18N
        Seleccionar.setText("SELECCIONAR REGISTRO");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Seleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Seleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNombreActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadioButtonNombreActionPerformed

    private void jButtonRealizarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarBusquedaActionPerformed
        // TODO add your handling code here:
        try {
          if (this.jRadioButtonNombre.isSelected()==true)
                {
                
                CrearClientes busc = new CrearClientes();
                Nombre=this.jTextFieldBuscar.getText();
                busc.buscarpornombre(Nombre);
                
                }else if (this.jRadioButtonCedula.isSelected()==true){
                CrearClientes busc = new CrearClientes();
                Cedula=this.jTextFieldBuscar.getText();
                busc.buscarporcedula(Cedula);    
                    
                }
            
        }catch(Exception ex){
        
         JOptionPane.showMessageDialog(null, "ERROR");
        }
              
    }//GEN-LAST:event_jButtonRealizarBusquedaActionPerformed

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
       
              
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jTextFieldBuscarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldBuscarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarPropertyChange

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
        try {
          if (this.jRadioButtonNombre.isSelected()==true)
                {
                
                CrearClientes busc = new CrearClientes();
                Nombre=this.jTextFieldBuscar.getText();
                busc.buscarpornombre(Nombre);
                
                }else if (this.jRadioButtonCedula.isSelected()==true){
                CrearClientes busc = new CrearClientes();
                Cedula=this.jTextFieldBuscar.getText();
                busc.buscarporcedula(Cedula);    
                    
                }
                evt.consume();
        }catch(Exception ex){
        
         JOptionPane.showMessageDialog(null, "ERROR");
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
                 //la variable listacliente sirve para controlar el uso de la ventana busqueda de clientes segun el valor asignado
        int filaseleccionada; 
        if (Validar=="1"){  // LLAMADO DESDE VENTANA CLIENTES
        try{
            filaseleccionada= this.Tbl_Clientes.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }else{
              DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
              CrearClientes crear = new  CrearClientes ();
             Integer Codigo =(Integer) modelotabla.getValueAt(filaseleccionada, 0);
              crear.buscarparaeditar(Codigo);
              this.dispose();
            }

        }catch (Exception ex){

            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }
        }
        
        if (Validar=="2"){   // LLAMADO DESDE VENTANA ENTRADAS
             try{
           filaseleccionada= this.Tbl_Clientes.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }else{
            DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
              Entradasubasta buscar = new  Entradasubasta();
             Integer Codigo =(Integer) modelotabla.getValueAt(filaseleccionada, 0);
              buscar.buscarcliente(Codigo);
              this.dispose();
            }

        }catch (Exception ex){

            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }        
        }
  
        if (Validar=="3"){   // LLAMADO DESDE VENTANA RECIBOS
             try{
           filaseleccionada= this.Tbl_Clientes.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }else{
            DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
              ReciboAbonos buscar = new  ReciboAbonos();
             Integer Codigo =(Integer) modelotabla.getValueAt(filaseleccionada, 0);
              buscar.buscarcliente(Codigo);
              ReciboAbonos Factura = new ReciboAbonos();
                Factura.cargarfacturas();
              this.dispose();
            }

        }catch (Exception ex){

            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }        
        }
        
        if (Validar=="4"){   // LLAMADO DESDE VENTANA FACTURACION DE COMPRAS
             try{
           filaseleccionada= this.Tbl_Clientes.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }else{
            DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
              FacturasCompras buscar = new  FacturasCompras();
             Integer Codigo =(Integer) modelotabla.getValueAt(filaseleccionada, 0);
              buscar.buscarcliente(Codigo);
              this.dispose();
            }

        }catch (Exception ex){

            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }        
        }
        
        if (Validar=="5"){   // LLAMADO DESDE VENTANA CHEQUES
             try{
           filaseleccionada= this.Tbl_Clientes.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }else{
            DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
             Cheque buscar = new  Cheque();
             Integer Codigo =(Integer) modelotabla.getValueAt(filaseleccionada, 0);
              buscar.buscarcliente(Codigo);
              this.dispose();
            }

        }catch (Exception ex){

            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }        
        }
    }//GEN-LAST:event_SeleccionarActionPerformed

    /**
     * @param argrs
     */
    public static void main(String argrs[]) {
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
            java.util.logging.Logger.getLogger(buscarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new buscarclientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Seleccionar;
    public static javax.swing.JTable Tbl_Clientes;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRealizarBusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCedula;
    private javax.swing.JRadioButton jRadioButtonNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.ButtonGroup seleccionaropciones;
    // End of variables declaration//GEN-END:variables
}
