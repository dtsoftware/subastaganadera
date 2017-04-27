/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Caja;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class ReciboCaja extends javax.swing.JFrame {

    /**
     * Creates new form ReciboCaja
     */
    public ReciboCaja() {
        initComponents();
         DefaultTableModel tabla1= (DefaultTableModel) ReciboCaja.registros.getModel();
        ReciboCaja.fecha.setDateFormatString("dd/MM/yyyy");
        Date date = new Date(); 
        ReciboCaja.fecha.setDate(date); 
        Caja ch = new Caja();        
        ReciboCaja.ID.setText(ch.buscarultimo().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalle = new javax.swing.JTextArea();
        ID = new javax.swing.JTextField();
        montoi = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        guardar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        montoa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        registros = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        ESTADO = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("C  R  E  A  C  Ó  N    D  E    N  U  E  V  A    C  A  J  A    M  E  N  U  D  A");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel6)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID CAJA:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 40, 54, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("FECHA:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(450, 40, 43, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DESCRIPCION:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 190, 88, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("NOMBRE DE CAJA:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 90, 112, 15);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(612, 248, 0, 100);

        detalle.setEditable(false);
        detalle.setColumns(20);
        detalle.setRows(5);
        jScrollPane1.setViewportView(detalle);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 650, 60);

        ID.setEditable(false);
        jPanel2.add(ID);
        ID.setBounds(140, 30, 86, 31);

        montoi.setEditable(false);
        jPanel2.add(montoi);
        montoi.setBounds(140, 130, 110, 31);
        jPanel2.add(fecha);
        fecha.setBounds(500, 30, 160, 32);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        guardar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Save-icon.png"))); // NOI18N
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        nuevo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Actions-list-add-icon.png"))); // NOI18N
        nuevo.setText("NUEVO");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Apps-system-software-update-icon.png"))); // NOI18N
        editar.setText("EDITAR");
        editar.setEnabled(false);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Misc-Delete-Database-icon.png"))); // NOI18N
        eliminar.setText("ELIMINAR");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Apps-Dialog-Logout-icon.png"))); // NOI18N
        salir.setText("CANCELAR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo)
                    .addComponent(editar)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 420, 650, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ESTADO:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(500, 140, 60, 15);

        Nombre.setEditable(false);
        jPanel2.add(Nombre);
        Nombre.setBounds(140, 80, 520, 31);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("MONTO INICIAL:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 140, 99, 15);

        montoa.setEditable(false);
        jPanel2.add(montoa);
        montoa.setBounds(380, 130, 110, 31);

        registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "FECHA", "DETALLE", "M. INICIAL", "M. ACTUAL", "ESTADO"
            }
        ));
        registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrosMouseClicked(evt);
            }
        });
        registros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registrosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(registros);
        if (registros.getColumnModel().getColumnCount() > 0) {
            registros.getColumnModel().getColumn(0).setMinWidth(60);
            registros.getColumnModel().getColumn(0).setMaxWidth(60);
            registros.getColumnModel().getColumn(2).setMinWidth(75);
            registros.getColumnModel().getColumn(2).setMaxWidth(75);
            registros.getColumnModel().getColumn(4).setMinWidth(75);
            registros.getColumnModel().getColumn(4).setMaxWidth(75);
            registros.getColumnModel().getColumn(5).setMinWidth(75);
            registros.getColumnModel().getColumn(5).setMaxWidth(75);
            registros.getColumnModel().getColumn(6).setMinWidth(75);
            registros.getColumnModel().getColumn(6).setMaxWidth(75);
        }

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 280, 650, 130);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("MONTO ACTUAL:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(270, 140, 110, 15);

        ESTADO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        jPanel2.add(ESTADO);
        ESTADO.setBounds(560, 130, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
if (((ReciboCaja.detalle.getText().trim().length()==0) || (ReciboCaja.montoi.getText().trim().length()==0)|| (ReciboCaja.ID.getText().trim().length()==0))){
         JOptionPane.showMessageDialog(null, "Los Campos No pueden Estar En Blanco");

         }else{ 
        Caja user = new Caja();
        user.guardarrecibo();
        Caja ch = new Caja();        
        ReciboCaja.ID.setText(ch.buscarultimo().toString());
        Limpiar();
        Habilitar();    
}
    }//GEN-LAST:event_guardarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        Habilitar();
        Limpiar();
        ReciboCaja.editar.setEnabled(false);
        ReciboCaja.eliminar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
                this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrosMouseClicked
        int filaseleccionada;

        try{
            filaseleccionada= ReciboCaja.registros.getSelectedRow();
            if (filaseleccionada==-1){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
            }else{
                DefaultTableModel modelotabla=(DefaultTableModel) ReciboCaja.registros.getModel();
                String Codigo = String.valueOf(modelotabla.getValueAt(filaseleccionada, 0));
                ReciboCaja.ID.setText(""+Codigo);
                String Name =(String) modelotabla.getValueAt(filaseleccionada, 1);
                ReciboCaja.Nombre.setText(""+Name);
                String cta =(String) modelotabla.getValueAt(filaseleccionada, 3);
                ReciboCaja.detalle.setText(""+cta);
                String mi = String.valueOf(modelotabla.getValueAt(filaseleccionada, 5));
                ReciboCaja.montoi.setText(""+mi);
                String ma =String.valueOf(modelotabla.getValueAt(filaseleccionada, 4));
                ReciboCaja.montoa.setText(""+ma);
                ReciboCaja.editar.setEnabled(true);
                ReciboCaja.eliminar.setEnabled(true);
                ReciboCaja.Nombre.setEditable(false);
                ReciboCaja.detalle.setEditable(false);
                ReciboCaja.montoi.setEditable(false);
                ReciboCaja.montoa.setEditable(false);
            }

        }catch (Exception ex){

            JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registrosMouseClicked

    private void registrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registrosKeyPressed

    }//GEN-LAST:event_registrosKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
               Caja buscar = new Caja();
        buscar.buscarregistros();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ReciboCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReciboCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReciboCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReciboCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReciboCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> ESTADO;
    public static javax.swing.JTextField ID;
    public static javax.swing.JTextField Nombre;
    public static javax.swing.JTextArea detalle;
    public static javax.swing.JButton editar;
    public static javax.swing.JButton eliminar;
    public static com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField montoa;
    public static javax.swing.JTextField montoi;
    private javax.swing.JButton nuevo;
    public static javax.swing.JTable registros;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
public void Limpiar(){
    
        ReciboCaja.detalle.setText("");
        ReciboCaja.montoi.setText("");
        ReciboCaja.montoa.setText("");
        ReciboCaja.Nombre.setText("");
           
}

public void Habilitar(){
    
        ReciboCaja.detalle.setEditable(true);
        ReciboCaja.montoi.setEditable(true);
        ReciboCaja.montoa.setEditable(true);
        ReciboCaja.Nombre.setEditable(true);
           
}
}
