/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Entradas;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/**
 *
 * @author Tserng
 */
public class Entradasubasta {
    ResultSet rs2;
    PreparedStatement cargar2,guardarentradas;
    DefaultTableModel tabla;
     
    public Entradasubasta(){
   
    }
    
    public void buscarcliente(Integer Codigo){
    try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idClientes,Cedula, Nombre, Apellido, Direccion FROM clientes where idClientes ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    ;
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){
            Entradas.jTextFieldCodigoG.setText(String.valueOf(rs2.getInt("idClientes")) );                
            Entradas.jTextFieldCedula.setText(rs2.getString("Cedula"));
            Entradas.jTextFieldNombre.setText(rs2.getString("Nombre"));
            Entradas.jTextFieldApellido.setText(rs2.getString("Apellido"));
            Entradas.jTextFieldDireccion.setText(rs2.getString("Direccion"));
          
            //imagen pendiente 
       
      rs2.close();
    conect.desconectar();
           }else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
           conect.desconectar();
            }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
    
    public void guardarentradas(){
    try {
    DefaultTableModel tabla= (DefaultTableModel) Entradas.jTableEntradaDeAnimales.getModel();
    conectar conect = new conectar(); 
    conect.conexion();
    //en esta clase debo guardar los datos del cliente y las entradas al sistema
    int codigocliente= Integer.parseInt(Entradas.jTextFieldCodigoG.getText());
    //int codigo=Integer.parseInt(Entradas.jTextFieldNumeroanimal.getText());
    
    //-----obtener la fecha----------------------
      String  dia = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
         
      
               
    //-------aki para guardar el contenido del jtable en la tabla detallesventas
    for (int i = 0; i < Entradas.jTableEntradaDeAnimales.getRowCount(); i++) {
    
    String numero =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 0));
    String tipo =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 1));
    String color =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 2));
    String sexo =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 3));
    String ferrete =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 4));
    int peso = Integer.parseInt(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 5)));
    String observacion =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 6));
    //int cantidad=Integer.parseInt(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 3)));
    //double costounitario=Double.parseDouble(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 4))); 
    //double total=Double.parseDouble(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 5))); 
  guardarentradas=conect.con.prepareStatement("INSERT INTO entradas ( Codigo, Fecha, CodCliente, Numero, Tipo, Color,Sexo,Ferrete,Peso,Observacion) VALUES (?,?,?,?,?,?,?,?,?,?)");
  //este es duplicando el numero consultar a juan el uso del codigo
  guardarentradas.setString(1,numero);
  guardarentradas.setString(2, fecha);
  guardarentradas.setInt(3, codigocliente);
  guardarentradas.setString(4, numero);
  guardarentradas.setString(5, tipo);
  guardarentradas.setString(6, color);
  guardarentradas.setString(7, sexo);
  guardarentradas.setString(8, ferrete);
  guardarentradas.setInt(9, peso);
  guardarentradas.setString(10, observacion);
  //guardarentradas.setInt(6, cantidad);
  //guardarentradas.setDouble(7, costounitario);
  //guardarentradas.setDouble(8, total); 
  guardarentradas.execute();
       }
    
    //-------------------hasta aki guardo en detallesventa-------------//
     //--------limpiar tabla------
      try {
            if (tabla != null) {
                while (tabla.getRowCount() > 0) {
                    tabla.removeRow(0);
                }
            }
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error" +ex);
        }
        //-----hasta aki limpiar tabla-----
    Entradas.jTextFieldCodigoG.setText("");
    Entradas.jTextFieldNombre.setText("");
    Entradas.jTextFieldApellido.setText("");
    Entradas.jTextFieldCedula.setText("");
    Entradas.jTextFieldDireccion.setText("");
    Entradas.jTextFieldCodigoG.requestFocus();
    JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
    
   /* 
    ventas.jButtonImprimir.setEnabled(true);
    ventas.jTextFieldDescuento.setText("0.00");
    ventas.jTextFieldSubTotal.setText("0.00");
    ventas.jTextFieldTotalventa.setText("0.00");
    */
    conect.desconectar();
    
        }catch(SQLException ex){
           
        JOptionPane.showMessageDialog(null, "Error" + ex);
        
        }
        
     
    
    }
    
    }


