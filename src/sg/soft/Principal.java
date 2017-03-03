/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.soft;
import Clases.conectar;
import Interfaces.Bancos;
import Interfaces.Cheques;
import Interfaces.Clientes;
import Interfaces.Conciliacion;
import Interfaces.Depositos;
import Interfaces.Entradas;
import Interfaces.Facturacion;
import Interfaces.FacturarC;
import Interfaces.FacturarV;
import Interfaces.MantChk;
import Interfaces.MantDepositos;
import Interfaces.MantNotas;
import Interfaces.NotasDC;
import Interfaces.Proveedor;
import Interfaces.Recibos;
import Interfaces.Subastas;
import Interfaces.Traspaso;
import Interfaces.Usuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Principal extends javax.swing.JFrame {
JFileChooser RealizarBackupMySQL=new JFileChooser();
    conectar con;          
 
    /**
     * Creates new form Principal
     */
    public Principal() {

        initComponents();

    }
    
    private void close(){
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }      
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_pagos = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem15.setText("jMenuItem15");

        jMenuItem32.setText("jMenuItem32");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SG-SOFT - SUBASTAS  GANADERAS");
        setMaximumSize(new java.awt.Dimension(1182, 765));
        setMinimumSize(new java.awt.Dimension(1182, 765));
        setPreferredSize(new java.awt.Dimension(1182, 765));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Add-Folder-icon.png"))); // NOI18N
        jButton1.setText("ENTRADAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 160, 270, 145);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Gavel-Law-icon (1).png"))); // NOI18N
        jButton2.setText("SUBASTAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 160, 270, 145);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/peer-to-peer-icon (2).png"))); // NOI18N
        jButton3.setText("TRASPASOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 340, 270, 145);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/shop-cart-apply-icon.png"))); // NOI18N
        jButton4.setText("COMPRAS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(350, 340, 270, 145);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Invoice-icon.png"))); // NOI18N
        jButton5.setText("RECIBOS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(350, 520, 270, 145);

        btn_pagos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_pagos.setForeground(new java.awt.Color(0, 102, 102));
        btn_pagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Pay-Per-Click-icon.png"))); // NOI18N
        btn_pagos.setText("CHEQUES");
        btn_pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pagos);
        btn_pagos.setBounds(40, 520, 270, 145);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/run-icon.png"))); // NOI18N
        jButton6.setToolTipText("SALIR DEL SISTEMA");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setIconTextGap(-3);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(1110, 40, 50, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Desarrollado por: Lic. Juan C. Ducreux; Cel. 67309619; email: juanducreux@hotmail.com");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 680, 500, 14);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("00/00/0000");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(950, 90, 90, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("00:00:00");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1050, 90, 70, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("JUAN DUCREUX");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1000, 34, 140, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("ADMINISTRADOR");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1000, 60, 140, 13);

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/PORTADA 4.JPG"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1177, 758));
        jLabel1.setMinimumSize(new java.awt.Dimension(1177, 758));
        jLabel1.setPreferredSize(new java.awt.Dimension(1177, 758));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -70, 1470, 870);

        jMenu1.setText("Archivo     ");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/user_red.png"))); // NOI18N
        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Actions-list-add-user-icon.png"))); // NOI18N
        jMenuItem18.setText("Proveedores");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem18);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/wallet.png"))); // NOI18N
        jMenu7.setText("Facturacion");

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Sales-by-payment-method-icon.png"))); // NOI18N
        jMenuItem16.setText("Ventas");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/payment-icon.png"))); // NOI18N
        jMenuItem17.setText("Compras");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem17);

        jMenu1.add(jMenu7);
        jMenu1.add(jSeparator1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Database-Backup-icon.png"))); // NOI18N
        jMenuItem4.setText("Respaldo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator2);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Perspective-Button-Shutdown-icon.png"))); // NOI18N
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Banco     ");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/money-icon (1).png"))); // NOI18N
        jMenuItem6.setText("Cuentas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator3);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/cheque-icon.png"))); // NOI18N
        jMenu11.setText("Cheques");

        jMenuItem12.setText("Crear");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem12);

        jMenuItem31.setText("Mantenimiento");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem31);

        jMenu2.add(jMenu11);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/safe-icon.png"))); // NOI18N
        jMenu12.setText("Depositos");

        jMenuItem33.setText("Registrar");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem33);

        jMenuItem34.setText("Mantenimiento");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem34);

        jMenu2.add(jMenu12);

        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Bank-icon.png"))); // NOI18N
        jMenu13.setText("Notas Debito/Credito");

        jMenuItem35.setText("Registrar");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem35);

        jMenuItem36.setText("Mantenimiento");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem36);

        jMenu2.add(jMenu13);
        jMenu2.add(jSeparator4);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/cow-history-icon.png"))); // NOI18N
        jMenuItem10.setText("Conciliacion");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Reportes     ");

        jMenu9.setText("Listas de Maestros");

        jMenuItem26.setText("Lista de Clientes");
        jMenu9.add(jMenuItem26);

        jMenuItem27.setText("Lista de Proveedores");
        jMenu9.add(jMenuItem27);

        jMenuItem28.setText("Lista de Cuentas Bancarias");
        jMenu9.add(jMenuItem28);

        jMenuItem29.setText("Lista de Usuarios");
        jMenu9.add(jMenuItem29);

        jMenu4.add(jMenu9);

        jMenuItem19.setText("Entradas");
        jMenu4.add(jMenuItem19);

        jMenuItem20.setText("Subastas");
        jMenu4.add(jMenuItem20);

        jMenu8.setText("Banco");

        jMenuItem22.setText("Listas Cheques");
        jMenu8.add(jMenuItem22);

        jMenuItem21.setText("Listas Depositos");
        jMenu8.add(jMenuItem21);

        jMenuItem23.setText("Listas Notas Debito/Credito");
        jMenu8.add(jMenuItem23);

        jMenuItem24.setText("Conciliaciones Bancarias");
        jMenu8.add(jMenuItem24);

        jMenu4.add(jMenu8);

        jMenu10.setText("Otros Listados");

        jMenuItem25.setText("Estados de Cuenta");
        jMenu10.add(jMenuItem25);

        jMenuItem30.setText("Lista de Traspasos");
        jMenu10.add(jMenuItem30);

        jMenu4.add(jMenu10);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Configuracion     ");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/App-login-manager-icon.png"))); // NOI18N
        jMenuItem11.setText("Usuarios");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);
        jMenu5.add(jSeparator5);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Ayuda");

        jMenuItem13.setText("Contenido");
        jMenu6.add(jMenuItem13);
        jMenu6.add(jSeparator6);

        jMenuItem14.setText("Acerca De...");
        jMenu6.add(jMenuItem14);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Clientes cliente = new Clientes();
        cliente.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Usuarios user = new Usuarios();
        user.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
GenerarBackupMySQL();

    }//GEN-LAST:event_jMenuItem4ActionPerformed
void GenerarBackupMySQL(){
        int resp;
        Calendar c=Calendar.getInstance();
        String fecha=String.valueOf(c.get(Calendar.DATE));
        fecha=fecha+"-"+String.valueOf(c.get(Calendar.MONTH) + 1);
      fecha=fecha+"-"+String.valueOf(c.get(Calendar.YEAR));
      //String nombre=this.jTextField1.getText();
      //String pass=this.jTextField2.getText();
        resp=RealizarBackupMySQL.showSaveDialog(this);//JFileChooser de nombre RealizarBackupMySQL
        if (resp==JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar; se genera el Backup
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(RealizarBackupMySQL.getSelectedFile().toString())
                        +"_"+fecha+".sql");
                InputStreamReader irs;
                BufferedReader br;
                try (FileWriter fw = new FileWriter(backupFile)) {
                    Process child = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump --opt --password=root --user=root "
                            + "sg-soft");
                    irs = new InputStreamReader(child.getInputStream());
                    br = new BufferedReader(irs);
                    String line;
                    while( (line=br.readLine()) != null ) {
                        fw.write(line + "\n");
                    }
                }
                irs.close();
                br.close();

                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:"+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "RESPALDO REALIZADO CORRECTAMENTE","Verificar",JOptionPane.INFORMATION_MESSAGE);
        } else if (resp==JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,"PROCESO DE RESPALDO DE LA BASE DE DATOS CANCELADO");
        }
    }
    private void btn_pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagosActionPerformed
        Cheques ch = new Cheques();
        ch.setVisible(true); 
        
    }//GEN-LAST:event_btn_pagosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Entradas ent = new Entradas();
        ent.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Subastas suba = new Subastas();
        suba.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Traspaso cambio = new Traspaso ();
cambio.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
            FacturarC vent01 = new FacturarC();
    vent01.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
    FacturarV vent01 = new FacturarV();
    vent01.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 Recibos rcbo = new Recibos();
rcbo.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  Facturacion fact = new Facturacion();
fact.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
  if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
close();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
             Proveedor fact = new Proveedor();
fact.setVisible(true); 
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
                    Bancos fact = new Bancos();
fact.setVisible(true); 
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
                                  Conciliacion fact = new Conciliacion();
fact.setVisible(true); 
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
               MantChk fact = new MantChk();
fact.setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
              Cheques ch = new Cheques();
        ch.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
                       NotasDC cliente = new NotasDC();
        cliente.setVisible(true); 
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
                 Depositos fact = new Depositos();
fact.setVisible(true); 
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
         MantDepositos fact = new MantDepositos();
fact.setVisible(true); 
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
       MantNotas fact = new MantNotas();
       fact.setVisible(true); 
    }//GEN-LAST:event_jMenuItem36ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pagos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    // End of variables declaration//GEN-END:variables

    
}
