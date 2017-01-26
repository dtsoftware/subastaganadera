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
/**
 *
 * @author Tserng
 */
public class Entradasubasta {
    ResultSet rs2;
    PreparedStatement cargar2,guardarentradas,guardardetallesentradas;
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
    int idEntrada=0;
    DefaultTableModel tabla= (DefaultTableModel) Entradas.jTableEntradaDeAnimales.getModel();
    conectar conect = new conectar(); 
    conect.conexion();
    animalesregistrados identra = new animalesregistrados();
    
    //en esta clase debo guardar los datos del cliente y las entradas al sistema
    int codigocliente= Integer.parseInt(Entradas.jTextFieldCodigoG.getText());
    //int codigo=Integer.parseInt(Entradas.jTextFieldNumeroanimal.getText());
    
    //-----obtener la fecha----------------------
      String  dia = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
          
      String estado="Por Subastar";
      String condicion="Contado";
   
      //codigo para guardar en tabla entradas.
  guardarentradas=conect.con.prepareStatement("INSERT INTO entradas ( Fecha, CodCliente, Condicion,Estado) VALUES (?,?,?,?)");
  //este es duplicando el numero consultar a juan el uso del codigo
  guardarentradas.setString(1, fecha);
   guardarentradas.setInt(2, codigocliente);
   guardarentradas.setString(3, condicion);
   guardarentradas.setString(4, estado);
  guardarentradas.execute();
 // guardarentradas.close();
      
      //hasta aki  tabla de entradas
      
         idEntrada=identra.buscarultimaentrada();
    //-------aki para guardar el contenido del jtable en la tabla detallesentradas
    for (int i = 0; i < Entradas.jTableEntradaDeAnimales.getRowCount(); i++) {
    
    String numero =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 0));
    String tipo =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 1));
    String sexo =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 2));
    String color =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 3));    
    String ferrete =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 4));
    //double peso = Integer.parseInt(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 5)));
    double peso = Double.parseDouble(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 5)));
    String observacion =String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 6));
    //int cantidad=Integer.parseInt(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 3)));
    //double costounitario=Double.parseDouble(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 4))); 
    //double total=Double.parseDouble(String.valueOf(Entradas.jTableEntradaDeAnimales.getValueAt(i, 5))); 
  guardardetallesentradas=conect.con.prepareStatement("INSERT INTO entrada_detalle ( idEntrada,idAnimal, Fecha, CodVendedor, Tipo, Color,Sexo,Ferrete,Peso,Observacion,Estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
  //este es duplicando el numero consultar a juan el uso del codigo
  guardardetallesentradas.setInt(1, idEntrada);
  guardardetallesentradas.setString(2,numero);
  guardardetallesentradas.setString(3, fecha);
  guardardetallesentradas.setInt(4, codigocliente);
  guardardetallesentradas.setString(5, tipo);
  guardardetallesentradas.setString(6, color);
  guardardetallesentradas.setString(7, sexo);
  guardardetallesentradas.setString(8, ferrete);
  guardardetallesentradas.setDouble(9, peso);
  guardardetallesentradas.setString(10, observacion);
  guardardetallesentradas.setString(11, estado);
 
  guardardetallesentradas.execute();
  
  
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
    //ACTUALIZA LA TABLA DE INGRESADOS
     animalesregistrados animal = new animalesregistrados();
     animal.cargaranimales();
        //animalesregistrados anima = new animalesregistrados();
       animal.machos();
       animal.hembras();
       animal.totalmachoshembras();
     //
    JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
    
   /* 
    ventas.jButtonImprimir.setEnabled(true);
    ventas.jTextFieldDescuento.setText("0.00");
    ventas.jTextFieldSubTotal.setText("0.00");
    ventas.jTextFieldTotalventa.setText("0.00");
    */
    guardarentradas.close();
    guardardetallesentradas.close();
    conect.desconectar();
    
        }catch(SQLException ex){
           
        JOptionPane.showMessageDialog(null, "Error" + ex);
        
        }
        
     
    
    }
    
    
    public void nuevaentrada(){
    
        try {
        DefaultTableModel tabla= (DefaultTableModel) Entradas.jTableEntradaDeAnimales.getModel();
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
    Entradas.jTextFieldFerrete.setText("");
    Entradas.jTextFieldPeso.setText("");
    Entradas.jTextAreaObservacion.setText("");
    Entradas.jTextFieldNumeroanimal.setText("");
    Entradas.jTextFieldCodigoG.requestFocus();
    
        }catch (Exception ex){
        JOptionPane.showMessageDialog(null,"Error" +ex);      
        }
    
    }
    
    }


