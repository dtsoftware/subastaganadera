/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Accesos;
import Clases.CrearUsuarios;
import static Interfaces.Usuarios.txtnombre;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Permisos extends javax.swing.JDialog {

    /**
     * Creates new form Permisos
     */
    public Permisos(java.awt.Frame Parent, boolean modal) {
        super(Parent, modal);
        initComponents();
        setLocationRelativeTo(Parent);
    }

    Permisos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Guardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BP01 = new javax.swing.JCheckBox();
        BP02 = new javax.swing.JCheckBox();
        BP03 = new javax.swing.JCheckBox();
        BP04 = new javax.swing.JCheckBox();
        BP06 = new javax.swing.JCheckBox();
        MA01 = new javax.swing.JCheckBox();
        MA02 = new javax.swing.JCheckBox();
        MA03 = new javax.swing.JCheckBox();
        MB03 = new javax.swing.JCheckBox();
        MB01 = new javax.swing.JCheckBox();
        MB04 = new javax.swing.JCheckBox();
        MR01 = new javax.swing.JCheckBox();
        MB05 = new javax.swing.JCheckBox();
        MB06 = new javax.swing.JCheckBox();
        MR03 = new javax.swing.JCheckBox();
        MR02 = new javax.swing.JCheckBox();
        MR04 = new javax.swing.JCheckBox();
        MB02 = new javax.swing.JCheckBox();
        MR05 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        MC01 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        BP05 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/login-icon (1).png"))); // NOI18N
        Guardar.setText("GUARDAR ACCESOS");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Apps-Dialog-Logout-icon.png"))); // NOI18N
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("BOTONES DEL VENTANA PRINCIPAL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("MENU ARCHIVO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("MENU BANCO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("MENU REPORTES");

        BP01.setSelected(true);
        BP01.setText("Entradas");

        BP02.setSelected(true);
        BP02.setText("Subastas");

        BP03.setSelected(true);
        BP03.setText("Compras");

        BP04.setSelected(true);
        BP04.setText("Ventas");

        BP06.setSelected(true);
        BP06.setText("Cheques");

        MA01.setForeground(new java.awt.Color(0, 0, 255));
        MA01.setSelected(true);
        MA01.setText("Clientes");

        MA02.setForeground(new java.awt.Color(0, 0, 255));
        MA02.setSelected(true);
        MA02.setText("Proveedores");

        MA03.setForeground(new java.awt.Color(0, 0, 255));
        MA03.setSelected(true);
        MA03.setText("Respaldo");

        MB03.setForeground(new java.awt.Color(0, 102, 0));
        MB03.setSelected(true);
        MB03.setText("Cuentas");

        MB01.setForeground(new java.awt.Color(0, 102, 0));
        MB01.setSelected(true);
        MB01.setText("Caja Chica");

        MB04.setForeground(new java.awt.Color(0, 102, 0));
        MB04.setSelected(true);
        MB04.setText("Cheques");

        MR01.setForeground(new java.awt.Color(0, 102, 102));
        MR01.setSelected(true);
        MR01.setText("Maestros");

        MB05.setForeground(new java.awt.Color(0, 102, 0));
        MB05.setSelected(true);
        MB05.setText("Notas D/C");

        MB06.setForeground(new java.awt.Color(0, 102, 0));
        MB06.setSelected(true);
        MB06.setText("Depositos");

        MR03.setForeground(new java.awt.Color(0, 102, 102));
        MR03.setSelected(true);
        MR03.setText("Subastas");

        MR02.setForeground(new java.awt.Color(0, 102, 102));
        MR02.setSelected(true);
        MR02.setText("Entradas");

        MR04.setForeground(new java.awt.Color(0, 102, 102));
        MR04.setSelected(true);
        MR04.setText("Banco");

        MB02.setForeground(new java.awt.Color(0, 102, 0));
        MB02.setSelected(true);
        MB02.setText("Conciliacion");

        MR05.setForeground(new java.awt.Color(0, 102, 102));
        MR05.setSelected(true);
        MR05.setText("Otros Listados");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setText("CONFIGURACION");

        MC01.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MC01.setForeground(new java.awt.Color(51, 0, 51));
        MC01.setSelected(true);
        MC01.setText("Usuarios");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("******** CONFIGURACION DE ACCESOS A MENUS Y BOTONES DE PANTALLA PRINCIPAL********");

        BP05.setSelected(true);
        BP05.setText("Traspaso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MC01)
                                    .addComponent(MA01)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(MB01))
                                            .addComponent(MR01)
                                            .addComponent(BP01))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BP02)
                                            .addComponent(MR02)
                                            .addComponent(MB02))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MA02)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(BP03)
                                                        .addComponent(MR03))
                                                    .addComponent(MB03))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(BP04, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(MB04)
                                                    .addComponent(MR04))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addComponent(MB06))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(MR05)
                                                    .addComponent(MB05)
                                                    .addComponent(MA03)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(BP05)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(BP06))))))
                                    .addComponent(jLabel2))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MA01, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MA02)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(MA03)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MB03)
                        .addComponent(MB04)
                        .addComponent(MB05)
                        .addComponent(MB01)
                        .addComponent(MB02)
                        .addComponent(MB06)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(MR01)
                    .addComponent(MR02)
                    .addComponent(MR03)
                    .addComponent(MR04)
                    .addComponent(MR05))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BP01)
                    .addComponent(BP02)
                    .addComponent(BP03)
                    .addComponent(BP04)
                    .addComponent(jLabel1)
                    .addComponent(BP05)
                    .addComponent(BP06))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(MC01))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar)
                    .addComponent(Guardar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        String iduser;
        iduser = Usuarios.txtusuario.getText();
        Accesos aux = new Accesos();
        aux.actualizaraccesos(iduser);
        this.dispose();
    }//GEN-LAST:event_GuardarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String usuario;
        usuario = Usuarios.txtusuario.getText();
        Accesos user = new Accesos();
        user.cargaraccesos(usuario);
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
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Permisos dialog = new Permisos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox BP01;
    public static javax.swing.JCheckBox BP02;
    public static javax.swing.JCheckBox BP03;
    public static javax.swing.JCheckBox BP04;
    public static javax.swing.JCheckBox BP05;
    public static javax.swing.JCheckBox BP06;
    public static javax.swing.JButton Guardar;
    public static javax.swing.JCheckBox MA01;
    public static javax.swing.JCheckBox MA02;
    public static javax.swing.JCheckBox MA03;
    public static javax.swing.JCheckBox MB01;
    public static javax.swing.JCheckBox MB02;
    public static javax.swing.JCheckBox MB03;
    public static javax.swing.JCheckBox MB04;
    public static javax.swing.JCheckBox MB05;
    public static javax.swing.JCheckBox MB06;
    public static javax.swing.JCheckBox MC01;
    public static javax.swing.JCheckBox MR01;
    public static javax.swing.JCheckBox MR02;
    public static javax.swing.JCheckBox MR03;
    public static javax.swing.JCheckBox MR04;
    public static javax.swing.JCheckBox MR05;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
