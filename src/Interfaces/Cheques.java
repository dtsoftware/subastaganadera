/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Cheque;
import Clases.CrearCheques;
import Clases.Numero_a_Letra;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Cheques extends javax.swing.JFrame {


    /**
     * Creates new form Cheques
     */
    public Cheques() {
        initComponents();
        jComboBox1.removeAllItems();
        this.jDateChooserFecha.setDateFormatString("dd/MM/yyyy");
        Date date = new Date(); 
        this.jDateChooserFecha.setDate(date);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Detalle = new javax.swing.JScrollPane();
        Detalle01 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonListarCliente = new javax.swing.JButton();
        txtmonto = new javax.swing.JTextField();
        Numero = new javax.swing.JTextField();
        montoletra = new javax.swing.JLabel();
        Beneficiario = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("I M P R E S I O N  D E  C H E Q U E S  D E L  S I S T E M A");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("No.");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(570, 80, 20, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Fecha:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(570, 120, 38, 15);

        Detalle01.setColumns(20);
        Detalle01.setRows(5);
        Detalle.setViewportView(Detalle01);

        jPanel5.add(Detalle);
        Detalle.setBounds(130, 290, 610, 62);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Observaciones");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(30, 300, 87, 15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("La suma de:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(30, 210, 73, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(jLabel2);
        jLabel2.setBounds(110, 240, 630, 0);

        jLabelCliente.setText("_____________________________________________________________________________");
        jPanel5.add(jLabelCliente);
        jLabelCliente.setBounds(110, 180, 462, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Paguese a la Orden de:");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(20, 130, 140, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("B/.");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(580, 160, 22, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("CTA:");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(22, 24, 28, 15);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(jComboBox1);
        jComboBox1.setBounds(60, 20, 180, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("N O M B R E  D E L  B A N C O");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(20, 70, 202, 17);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setText("N U M E R O  D E  C U E N T A  B A N C A R I A");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(20, 90, 229, 13);

        jButtonListarCliente.setText("Client/Prov");
        jButtonListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarClienteActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonListarCliente);
        jButtonListarCliente.setBounds(20, 160, 90, 23);

        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmontoKeyPressed(evt);
            }
        });
        jPanel5.add(txtmonto);
        txtmonto.setBounds(610, 150, 140, 30);
        jPanel5.add(Numero);
        Numero.setBounds(610, 70, 140, 30);
        jPanel5.add(montoletra);
        montoletra.setBounds(120, 220, 470, 19);
        jPanel5.add(Beneficiario);
        Beneficiario.setBounds(120, 170, 450, 20);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jRadioButton1.setText("P. a Vendedor");
        jPanel4.add(jRadioButton1);
        jRadioButton1.setBounds(20, 10, 110, 23);

        jRadioButton2.setText("P. de Gastos");
        jPanel4.add(jRadioButton2);
        jRadioButton2.setBounds(140, 10, 110, 23);

        jRadioButton4.setText("P. de Planilla");
        jPanel4.add(jRadioButton4);
        jRadioButton4.setBounds(260, 10, 100, 23);

        jButton4.setText("DETALLE");
        jPanel4.add(jButton4);
        jButton4.setBounds(370, 10, 130, 23);

        jPanel5.add(jPanel4);
        jPanel4.setBounds(250, 10, 510, 40);
        jPanel5.add(jDateChooserFecha);
        jDateChooserFecha.setBounds(610, 110, 140, 30);

        jLabel5.setText("__________________________________________________________________________________");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(110, 230, 510, 14);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(11, 13, 770, 380);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/wallet.png"))); // NOI18N
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(642, 16, 118, 41);

        jButtonImprimir.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.activeTitleGradient"));
        jButtonImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonImprimir.setForeground(new java.awt.Color(0, 0, 255));
        jButtonImprimir.setText("I n i c i a r   I m p r e c i ó n   d e   C h  e q u e s ");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonImprimir);
        jButtonImprimir.setBounds(12, 13, 530, 41);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
    String a,m,d,a1,a2,a3,a4,m1,m2,d1,d2,nombre,montoletras,observacion,ncheque;
    double monto;
      
    try{
      nombre=jLabelCliente.getText();
      montoletras=montoletra.getText();
      monto= Double.parseDouble(txtmonto.getText());
      observacion=Detalle01.getText();  
     
      ncheque= this.Numero.getText();
     //-----obtener la fecha-------- --------------
      String  dia = Integer.toString(jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year +"-"+ mes+ "-"+ dia); 
     //---------fin de obtener la fecha 20170314
 
   a =year;
  // m=mes;
   //d=dia;  
 
   //validando si el mes es de una cifra
   if (mes.length()==1) {
   m="0"+mes;
   }else{
   m=mes;
   }
   //validando si el dia es de una cifra
    if (dia.length()==1) {
   d="0"+dia;
   }else{
   d=dia;
   }   
     //separando el año
   a1 = a.substring(0,1);
   a2 = a.substring(1,2);
   a3= a.substring(2,3);
   a4 = a.substring(3,4);   
   //separando el mes
  m1 = m.substring(0,1);
  m2 = m.substring(1,2);   
   //separando el dia
    d1 = d.substring(0,1);
    d2 = d.substring(1,2);
   // Numero.setText(a1+a2+a3+a4+m1+m2+d1+d2);  
     
   Cheque ch = new Cheque();
   ch.guardarcheque(ncheque,nombre,monto, fecha, montoletras, observacion, a1, a2, a3, a4, m1, m2, d1, d2);
   //ch.imprimircheque2(ncheque);
    
    }catch(Exception ex){    
    JOptionPane.showMessageDialog(null, "Error:"+ex.getMessage());
    }finally{
    
    }
    
     
      
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void txtmontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyPressed
       char cTeclaPresionada=evt.getKeyChar();
        if (cTeclaPresionada==KeyEvent.VK_ENTER){
            Numero_a_Letra NumLetra = new Numero_a_Letra();
      String numero = txtmonto.getText();
      Cheques.montoletra.setText(NumLetra.Convertir(numero,true));
        }
    }//GEN-LAST:event_txtmontoKeyPressed

    private void jButtonListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarClienteActionPerformed
     try {
        buscarclientes list = new buscarclientes();
        list.setVisible(true); 
        buscarclientes.Validar="5";
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error:"+ex.getMessage());
        }
    }//GEN-LAST:event_jButtonListarClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CrearCheques llenar = new CrearCheques();
        llenar.llenarcombo();
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
            java.util.logging.Logger.getLogger(Cheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cheques().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Beneficiario;
    public static javax.swing.JScrollPane Detalle;
    public static javax.swing.JTextArea Detalle01;
    public static javax.swing.JTextField Numero;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonListarCliente;
    public static javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    public static javax.swing.JLabel montoletra;
    public static javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables
}
