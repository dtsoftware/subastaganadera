/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Clases.animalesregistrados;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Tserng
 */
public class ModificarEntradas extends javax.swing.JFrame {

    /**
     * Creates new form ModificarEntradas
     */
    public ModificarEntradas() {
        initComponents();
        this.jDateChooserFecha.setDateFormatString("dd/MM/yyyy");
        Date date = new Date(); 
        this.jDateChooserFecha.setDate(date); 
        animalesregistrados animal = new animalesregistrados();
        animal.entradasparamodificar();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableModificarEntradas = new javax.swing.JTable();
        jButtonModificar = new javax.swing.JButton();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jButtonRefrezcar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacion = new javax.swing.JTextArea();
        jTextFieldNumeroanimal = new javax.swing.JTextField();
        jTextFieldFerrete = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<String>();
        jComboBoxColor = new javax.swing.JComboBox<String>();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCod_Vendedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldID_Entradas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigodebusqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Entradas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableModificarEntradas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTableModificarEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# De llegada", "Tipo", "Sexo", "Color", "Peso", "Ferrete", "Cod Vendedor", "Observaciones", "ID_ENTRADA"
            }
        ));
        jTableModificarEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableModificarEntradasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableModificarEntradas);

        jButtonModificar.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Developmer Folder.png"))); // NOI18N
        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificar.setMaximumSize(new java.awt.Dimension(115, 15));
        jButtonModificar.setMinimumSize(new java.awt.Dimension(115, 15));
        jButtonModificar.setPreferredSize(new java.awt.Dimension(115, 15));
        jButtonModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonRefrezcar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonRefrezcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graficos/Database-Backup-icon.png"))); // NOI18N
        jButtonRefrezcar.setText("Refrezcar");
        jButtonRefrezcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefrezcarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL ANIMAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("NUMERO");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("*FERRETE");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setText("DESCRIPCION");
        jLabel10.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel10AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("COLOR");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("TIPO");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setText("SEXO");

        jTextAreaObservacion.setColumns(20);
        jTextAreaObservacion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaObservacion);

        jTextFieldNumeroanimal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroanimalKeyTyped(evt);
            }
        });

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TE", "TA", "VA", "VF", "NA", "NO", "TO", "YG", "CB" }));

        jComboBoxColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BA", "NE", "CH", "RO", "AZ", "ZA", "AM", "HO", "AR", "PI " }));

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MACHO", "HEMBRA" }));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel17.setText("*PESO");

        jTextFieldPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("ID_Entrada");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Cod_Vendedor");

        jTextFieldID_Entradas.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNumeroanimal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel12)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jComboBoxTipo, 0, 77, Short.MAX_VALUE)
                                .addGap(42, 42, 42)
                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jComboBoxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jTextFieldFerrete, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(119, 119, 119)
                                .addComponent(jLabel17)
                                .addGap(93, 93, 93))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextFieldCod_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jTextFieldID_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(706, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumeroanimal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxColor)
                        .addComponent(jTextFieldFerrete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCod_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(120, Short.MAX_VALUE)
                    .addComponent(jTextFieldID_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Filtrar Datos Por Codigo");

        jTextFieldCodigodebusqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCodigodebusqueda.setForeground(new java.awt.Color(255, 0, 0));
        jTextFieldCodigodebusqueda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldCodigodebusquedaPropertyChange(evt);
            }
        });
        jTextFieldCodigodebusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodigodebusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigodebusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCodigodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButtonRefrezcar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jTextFieldCodigodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRefrezcar, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        ///Numero =?,Tipo=?,Sexo=?,Color=?,Ferrete=?,Peso=?,CodCliente=?,Codigo=?,Fecha=?,Observacion=?
        Integer numero,codigo,cod_cliente,idEntradas;
        String tipo,sexo,color,ferrete,fecha,observacion;
        double peso;
        try {
           if ((this.jTextFieldNumeroanimal.getText().trim().length()==0) || (this.jTextFieldFerrete.getText().trim().length()==0) || (this.jTextFieldPeso.getText().trim().length()==0)|| (this.jTextFieldID_Entradas.getText().trim().length()==0)|| (this.jTextFieldCod_Vendedor.getText().trim().length()==0)  ) {
         JOptionPane.showMessageDialog(null, "La Operacion No Se Puede Realizar( Debe Seleccionar Un Registro Y Editarlo )");
         }else{ 
            
         numero= Integer.parseInt(this.jTextFieldID_Entradas.getText());
         codigo=numero;
         tipo=this.jComboBoxTipo.getSelectedItem().toString();
         sexo=jComboBoxSexo.getSelectedItem().toString();
         color=jComboBoxColor.getSelectedItem().toString();
         ferrete=this.jTextFieldFerrete.getText();
         observacion=jTextAreaObservacion.getText();
         peso= Double.parseDouble(jTextFieldPeso.getText());
         cod_cliente= Integer.parseInt(this.jTextFieldCod_Vendedor.getText());
         idEntradas= Integer.parseInt(this.jTextFieldID_Entradas.getText());
         animalesregistrados editar = new   animalesregistrados();
         editar.guardareditados(numero, codigo, cod_cliente, idEntradas, tipo, sexo, color, ferrete, observacion, peso);
         
           }
        }catch (Exception ex){
        JOptionPane.showMessageDialog(null,"Error" +ex);  
        }

    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonRefrezcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefrezcarActionPerformed
        // TODO add your handling code here:
        animalesregistrados animal = new animalesregistrados();
        animal.entradasparamodificar();
    }//GEN-LAST:event_jButtonRefrezcarActionPerformed

    private void jTextFieldPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPesoKeyTyped

    private void jTextFieldNumeroanimalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroanimalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNumeroanimalKeyTyped

    private void jLabel10AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel10AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10AncestorAdded

    private void jTableModificarEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableModificarEntradasMouseClicked
        // TODO add your handling code here:
        Integer i = ModificarEntradas.jTableModificarEntradas.getSelectedRow();
        this.jTextFieldNumeroanimal.setText(ModificarEntradas.jTableModificarEntradas.getValueAt(i, 0).toString());
        this.jComboBoxTipo.setSelectedItem(ModificarEntradas.jTableModificarEntradas.getValueAt(i,1));
        this.jComboBoxSexo.setSelectedItem(ModificarEntradas.jTableModificarEntradas.getValueAt(i,2));
        this.jComboBoxColor.setSelectedItem(ModificarEntradas.jTableModificarEntradas.getValueAt(i,3));
        this.jTextFieldPeso.setText(ModificarEntradas.jTableModificarEntradas.getValueAt(i, 4).toString()); 
        this.jTextFieldFerrete.setText(ModificarEntradas.jTableModificarEntradas.getValueAt(i, 5).toString()); 
        this.jTextFieldCod_Vendedor.setText(ModificarEntradas.jTableModificarEntradas.getValueAt(i, 6).toString()); 
        this.jTextAreaObservacion.setText(ModificarEntradas.jTableModificarEntradas.getValueAt(i, 7).toString()); 
        this.jTextFieldID_Entradas.setText(ModificarEntradas.jTableModificarEntradas.getValueAt(i, 8).toString()); 
    }//GEN-LAST:event_jTableModificarEntradasMouseClicked

    private void jTextFieldCodigodebusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigodebusquedaKeyReleased
        // TODO add your handling code here:
       try {
      String codigo;
      // codigo= Integer.parseInt(jTextFieldCodigodebusqueda.getText());
      codigo= jTextFieldCodigodebusqueda.getText();
       animalesregistrados reg = new animalesregistrados();
       if (this.jTextFieldCodigodebusqueda.getText().trim().length()==0){
      // if(this.jTextFieldCodigodebusqueda.getText()==""){
             reg.entradasparamodificar();
      // evt.consume();
       }else{
     
       reg.cargaranimalesporcodigo(codigo);
       }
       evt.consume();
       }catch(Exception ex){
       JOptionPane.showMessageDialog(null,"Error" +ex);  
       }
        
       
    }//GEN-LAST:event_jTextFieldCodigodebusquedaKeyReleased

    private void jTextFieldCodigodebusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigodebusquedaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigodebusquedaKeyTyped

    private void jTextFieldCodigodebusquedaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldCodigodebusquedaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigodebusquedaPropertyChange

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
            java.util.logging.Logger.getLogger(ModificarEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarEntradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRefrezcar;
    public static javax.swing.JComboBox<String> jComboBoxColor;
    public static javax.swing.JComboBox jComboBoxSexo;
    public static javax.swing.JComboBox<String> jComboBoxTipo;
    public static com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTableModificarEntradas;
    public static javax.swing.JTextArea jTextAreaObservacion;
    private javax.swing.JTextField jTextFieldCod_Vendedor;
    private javax.swing.JTextField jTextFieldCodigodebusqueda;
    public static javax.swing.JTextField jTextFieldFerrete;
    private javax.swing.JTextField jTextFieldID_Entradas;
    public static javax.swing.JTextField jTextFieldNumeroanimal;
    public static javax.swing.JTextField jTextFieldPeso;
    // End of variables declaration//GEN-END:variables
}
