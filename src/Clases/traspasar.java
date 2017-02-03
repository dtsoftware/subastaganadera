/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Traspaso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tserng
 */
public class traspasar {
    ResultSet todos,rs2,rs;
    PreparedStatement animales,cargar2,cargar,entradas,detentradas;
     //DefaultTableModel tabla;
   
    Object[] filas1 = new Object[8]; 
    
    public traspasar(){}
    
    public void buscarnuevodueno(Integer Codigo){
      try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idClientes,Cedula, Nombre, Apellido FROM clientes where idClientes ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    
     cargar=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs=cargar.executeQuery(consulta);
           if (rs.next()){

                           Traspaso.jTextFieldCodigonuevodueno.setText(String.valueOf(rs.getInt("idClientes")) );                
                           Traspaso.jTextFieldNombrenuevodueno.setText(rs.getString("Nombre"));
                           Traspaso.jTextFieldApellidonuevodueno.setText(rs.getString("Apellido"));
                           Traspaso.jTextFieldCedulanuevodueno.setText(rs.getString("Cedula"));
                            rs.close();
                            cargar.close();
                            conect.desconectar();
                            Traspaso.jTextFieldCodigonuevodueno.setEnabled(false);
                          }
           else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
           conect.desconectar();
               }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
    
    public void buscardueno(Integer Codigo){
     try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idClientes,Cedula, Nombre, Apellido FROM clientes where idClientes ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){

                           Traspaso.jTextFieldDueno.setText(String.valueOf(rs2.getInt("idClientes")) );                
                           Traspaso.jTextFieldNombredueno.setText(rs2.getString("Nombre"));
                           Traspaso.jTextFieldApellidodueno.setText(rs2.getString("Apellido"));
                           Traspaso.jTextFieldCeduladueno.setText(rs2.getString("Cedula"));
                            rs2.close();
                            cargar2.close();
                            conect.desconectar();
                          }
           else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
           conect.desconectar();
               }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
    
    public void buscarparatraspasofiltro(String codigo){
    try {
     DefaultTableModel tabla= (DefaultTableModel) Traspaso.jTableTraspasos.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Traspaso.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Traspaso.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Traspaso.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
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
     
     // creamos la consulta
     consulta="SELECT idAnimal,Tipo,Sexo,Color,Peso,Ferrete,CodVendedor,idEntrada FROM entrada_detalle  where CodVendedor LIKE '"+ codigo +"%' and Fecha ='"+ fecha +"' and Estado='Por Subastar' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas1[0]=todos.getInt("idAnimal");
                    filas1[1]=todos.getString("Tipo");
                    filas1[2]=todos.getString("Sexo");
                    filas1[3]=todos.getString("Color");
                    filas1[4]=todos.getDouble("Peso");
                    filas1[5]=todos.getString("Ferrete");
                    filas1[6]=todos.getInt("CodVendedor");
                    filas1[7]=todos.getInt("idEntrada");
       tabla.addRow(filas1);
    }
    todos.close();
    animales.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
    
    public void guardartraspaso(Integer identrada, String fecha , Integer idanimal,Integer nuevocodigo){
    try{
    String consulta,consulta2;  
     conectar conect = new conectar(); 
     conect.conexion();  
    /*
     public void guardartraspaso(Integer identrada, String fecha , Integer idanimal,Integer nuevocodigo){
     // para traspaso en entradas
     consulta="UPDATE entradas SET CodCliente =? WHERE Fecha =? and idEntradas=?";
    //pasamos la consulta al preparestatement
    entradas=conect.con.prepareStatement(consulta);
    entradas.setInt(1, nuevocodigo);
    entradas.setString(2, fecha);
    entradas.setInt(3, identrada);    
    entradas.executeUpdate(); 
    entradas.close(); 
    */
    consulta2="UPDATE entrada_detalle SET traspasado='si', CodVendedor =? WHERE Fecha =? and idAnimal=?";
    //pasamos la consulta al preparestatement
    detentradas=conect.con.prepareStatement(consulta2);
    detentradas.setInt(1, nuevocodigo);
    detentradas.setString(2, fecha);
    detentradas.setInt(3, idanimal);    
    detentradas.executeUpdate(); 
    detentradas.close(); 
    
    conect.desconectar(); 
    JOptionPane.showMessageDialog(null, "Registro De Traspaso Realizado Satisfactoriamente");
    
    
    }catch(Exception ex){
     JOptionPane.showMessageDialog(null,"Error" +ex);    
    }
        
    
    }
    
    public void buscarparatraspaso(){
    try {
     DefaultTableModel tabla= (DefaultTableModel) Traspaso.jTableTraspasos.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Traspaso.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Traspaso.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Traspaso.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
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
     
     // creamos la consulta
     consulta="SELECT idAnimal,Tipo,Sexo,Color,Peso,Ferrete,CodVendedor, idEntrada FROM entrada_detalle  where Fecha ='"+ fecha +"' and Estado='Por Subastar' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas1[0]=todos.getInt("idAnimal");
                    filas1[1]=todos.getString("Tipo");
                    filas1[2]=todos.getString("Sexo");
                    filas1[3]=todos.getString("Color");
                    filas1[4]=todos.getDouble("Peso");
                    filas1[5]=todos.getString("Ferrete");
                    filas1[6]=todos.getInt("CodVendedor");
                    filas1[7]=todos.getInt("idEntrada");
       tabla.addRow(filas1);
    }
    todos.close();
    animales.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    }
    
}
