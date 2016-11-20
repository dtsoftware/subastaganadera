/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Clases.validarusuario;
import java.awt.event.KeyEvent;
import sg.soft.Principal;


/**
 *
 * @author Juan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {

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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_iniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso al Sistema");
        setBackground(java.awt.Color.white);
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Inicio de Sesión");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 10, 340, 30);

        txtusuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtusuario);
        txtusuario.setBounds(160, 70, 180, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/key.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 130, 70, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Login-icon.png"))); // NOI18N
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 190, 130, 40);

        btn_iniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_iniciar.setForeground(new java.awt.Color(0, 51, 204));
        btn_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Apps-Dialog-Logout-icon.png"))); // NOI18N
        btn_iniciar.setText("  I n i c i a r   >>>>");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });
        btn_iniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_iniciarKeyPressed(evt);
            }
        });
        jPanel1.add(btn_iniciar);
        btn_iniciar.setBounds(160, 190, 310, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/user_red.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 70, 70, 32);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 440, 0);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 40, 460, 10);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/login_1.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 70, 110, 90);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("USUARIO");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 80, 90, 14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CONTRASEÑA");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 140, 90, 14);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(10, 180, 460, 10);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 8)); // NOI18N
        jLabel7.setText("SG-SOFT V 1.0");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(410, 0, 60, 20);

        txtcontra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraKeyTyped(evt);
            }
        });
        jPanel1.add(txtcontra);
        txtcontra.setBounds(160, 130, 180, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
     String id,clave,user; 
     
     validarusuario bususuario = new validarusuario(); 
     id=this.txtusuario.getText();
     clave=this.txtcontra.getText();
     user=bususuario.BusquedaUsuario(id, clave);
     
        if (user!=null){
           Principal prin = new Principal ();
           prin.setVisible(true);
           this.dispose();
        }else{
           txtusuario.setText(null);
           txtcontra.setText(null);
           txtusuario.grabFocus();
           
    }                                    
        
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void txtusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyPressed
        char cTeclaPresionada=evt.getKeyChar();
        if (cTeclaPresionada==KeyEvent.VK_ENTER){
            txtcontra.grabFocus();
    }//GEN-LAST:event_txtusuarioKeyPressed
    }
    private void txtcontraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyPressed
        char cTeclaPresionada=evt.getKeyChar();
        if (cTeclaPresionada==KeyEvent.VK_ENTER){
            btn_iniciar.grabFocus();
    }//GEN-LAST:event_txtcontraKeyPressed
    }
    private void btn_iniciarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_iniciarKeyPressed
        char cTeclaPresionada=evt.getKeyChar();
        if (cTeclaPresionada==KeyEvent.VK_ENTER){
            btn_iniciar.doClick();
    }//GEN-LAST:event_btn_iniciarKeyPressed
    }
    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        int caracteres = 15;
        
        if(txtusuario.getText().length()>=caracteres){
            evt.consume();
            
        }
        
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtcontraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyTyped
        int caracteres = 15;
        
        if(txtcontra.getText().length()>=caracteres){
            evt.consume();
            
        }
    }//GEN-LAST:event_txtcontraKeyTyped
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

}
