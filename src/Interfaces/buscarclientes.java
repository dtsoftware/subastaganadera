/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.*;
import Clases.CrearClientes;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import Clases.Entradasubasta;
/**
 *
 * @author Tserng
 */
public class buscarclientes extends javax.swing.JFrame {
    String Nombre,Cedula;
   
   // DefaultTableModel modelotabla=(DefaultTableModel) this.Tbl_Clientes.getModel();
    /**
     * Creates new form buscarclientes
     */
    public buscarclientes() {
       initComponents();
            
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
        btn_seleccionar = new javax.swing.JButton();
        jButtonEntrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cedula", "Nombre", "Apellido", "Direccion"
            }
        ));
        jScrollPane1.setViewportView(Tbl_Clientes);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seleccionaropciones.add(jRadioButtonNombre);
        jRadioButtonNombre.setText("Nombre");
        jRadioButtonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNombreActionPerformed(evt);
            }
        });

        seleccionaropciones.add(jRadioButtonCedula);
        jRadioButtonCedula.setText("Cedula");

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
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jRadioButtonNombre)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jRadioButtonCedula)
                    .addGap(18, 18, 18)
                    .addComponent(jButtonRealizarBusqueda)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldBuscar)
                        .addComponent(jRadioButtonNombre)
                        .addComponent(jRadioButtonCedula)
                        .addComponent(jButtonRealizarBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                    .addGap(18, 18, 18)))
        );

        btn_seleccionar.setText("SELECCIONAR REGISTRO");
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });

        jButtonEntrada.setText("SELECCIONAR REGISTRO");
        jButtonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_seleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
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

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        //la variable listacliente sirve para controlar el uso de la ventana busqueda de clientes segun el valor asignado
        int filaseleccionada; 
        if (Clientes.listacliente==1){ 
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
        //la opcion 2 será para la ventana de entradas listar los clientes 
        }
         
      
        
        //para opciones futuras
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void jButtonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradaActionPerformed
        // TODO add your handling code here:
        int filaseleccionada; 
        if (Entradas.listacliente2==2){
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
    }//GEN-LAST:event_jButtonEntradaActionPerformed

    /**
     * @param args the command line arguments
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarclientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tbl_Clientes;
    public static javax.swing.JButton btn_seleccionar;
    private javax.swing.JButton jButtonCancelar;
    public static javax.swing.JButton jButtonEntrada;
    private javax.swing.JButton jButtonRealizarBusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCedula;
    private javax.swing.JRadioButton jRadioButtonNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.ButtonGroup seleccionaropciones;
    // End of variables declaration//GEN-END:variables
}
