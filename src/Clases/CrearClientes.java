/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Interfaces.Clientes;
import javax.swing.table.DefaultTableModel;
import Interfaces.buscarclientes;
/**
 *
 * @author Juan
 */
public class CrearClientes {
 Connection conectar;
 PreparedStatement guardarusuario;
 PreparedStatement cargar,cargar2,cargar3;
 ResultSet rs,rs2;
 DefaultTableModel tabla = new DefaultTableModel(); 
 Object[] filas = new Object[5];
 
    public CrearClientes(){
  // tabla = (DefaultTableModel) buscarclientes.Tbl_Clientes.getModel();
        }
      
     public void guardar(Integer idClientes, String Nombre, String Apellido, String Cedula, String Direccion, String Telefono1, String Telefono2, String Credito,String Imagen, String Estado, String Audito1,String Audito2,String Fecha1,String Fecha2){
     

             try {
                conectar conect = new conectar(); 
                 conect.conexion();
            guardarusuario=conect.con.prepareStatement("INSERT INTO clientes (idClientes, Nombre, Apellido, Cedula, Direccion,Telefono1, Telefono2,Credito,Imagen,Estado,Audito1,Audito2,Fecha1,Fecha2 ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            guardarusuario.setInt(1, idClientes);
            guardarusuario.setString(2, Nombre);
            guardarusuario.setString(3, Apellido);
            guardarusuario.setString(4, Cedula);
            guardarusuario.setString(5, Direccion);
            guardarusuario.setString(6, Telefono1);
            guardarusuario.setString(7, Telefono2);
            guardarusuario.setString(8, Credito);
            guardarusuario.setString(9, Imagen);
            guardarusuario.setString(10, Estado);
            guardarusuario.setString(11, Audito1);
            guardarusuario.setString(12, Audito2);
            guardarusuario.setString(13, Fecha1);
            guardarusuario.setString(14, Fecha2);
            guardarusuario.execute();
            conect.desconectar();
            JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"El Registro No Se Logro Realizar Error:" +ex);
                
            }
             
        
    }
    
     public void buscarpornombre(String nombre){
     try {
         tabla = (DefaultTableModel) buscarclientes.Tbl_Clientes.getModel();
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
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
     consulta="SELECT idClientes,Cedula, Nombre, Apellido, Direccion FROM clientes where Nombre ='"+ nombre +"' ORDER BY Nombre";
     //pasamos la consulta al preparestatement
     cargar=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     rs=cargar.executeQuery(consulta);
     //recorremos el resulset
    while (rs.next()){
        
                    filas[0]=rs.getInt("idClientes");
                    filas[1]=rs.getString("Cedula");
                    filas[2]=rs.getString("Nombre");
                    filas[3]=rs.getString("Apellido");
                    filas[4]=rs.getString("Direccion");
                                        
       tabla.addRow(filas);
    }
    rs.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
     }
    
    public void buscarporcedula( String Cedula){
     try {
         tabla = (DefaultTableModel) buscarclientes.Tbl_Clientes.getModel();
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
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
     consulta="SELECT idClientes,Cedula, Nombre, Apellido, Direccion FROM clientes where Cedula ='"+ Cedula +"' ORDER BY Nombre";
     //pasamos la consulta al preparestatement
     cargar=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     rs=cargar.executeQuery(consulta);
     //recorremos el resulset
    while (rs.next()){
        
                    filas[0]=rs.getInt("idClientes");
                    filas[1]=rs.getString("Cedula");
                    filas[2]=rs.getString("Nombre");
                    filas[3]=rs.getString("Apellido");
                    filas[4]=rs.getString("Direccion");
                                        
       tabla.addRow(filas);
    }
    rs.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
    
  public void buscarparaeditar(Integer Codigo){
  try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idClientes,Cedula, Nombre, Apellido, Direccion,Telefono1,Telefono2,Credito,Estado FROM clientes where idClientes ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    ;
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){
            Clientes.jTextFieldIDcliente.setText(String.valueOf(rs2.getInt("idClientes")) );                
            Clientes.jTextFieldCedula.setText(rs2.getString("Cedula"));
            Clientes.jTextFieldNombre.setText(rs2.getString("Nombre"));
            Clientes.jTextFieldApellido.setText(rs2.getString("Apellido"));
            Clientes.jTextFieldDireccion.setText(rs2.getString("Direccion"));
            Clientes.jTextFieldTelefono1.setText(rs2.getString("Telefono1"));
            Clientes.jTextFieldTelefono2.setText(rs2.getString("Telefono2"));
            Clientes.jComboBoxActivo.setSelectedItem(rs2.getString("Estado"));
            Clientes.jComboBoxCredito.setSelectedItem(rs2.getString("Credito"));
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
    
   public void editarclientes(Integer idClientes,String Nombre, String Apellido, String Cedula, String Direccion, String Telefono1, String Telefono2, String Credito,String Imagen, String Estado,String Audito2,String Fecha2){
       
        try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();  
    
     // creamos la consulta
     consulta="UPDATE clientes SET Nombre =?,Apellido=?,Cedula=?,Direccion=?,Telefono1=?,Telefono2=?,Credito=?,Imagen=?,Estado=?,Audito2=?,Fecha2=?  WHERE idClientes= ? ";
    //pasamos la consulta al preparestatement
    cargar3=conect.con.prepareStatement(consulta);
    cargar3.setString(1, Nombre);
    cargar3.setString(2, Apellido);
    cargar3.setString(3, Cedula);
    cargar3.setString(4, Direccion);
    cargar3.setString(5, Telefono1);
    cargar3.setString(6, Telefono2);
    cargar3.setString(7, Credito);
    cargar3.setString(8, Imagen);
    cargar3.setString(9, Estado);
    cargar3.setString(10, Audito2);
    cargar3.setString(11, Fecha2);
    cargar3.setInt(12, idClientes);
    cargar3.executeUpdate();    
    conect.desconectar(); 
    JOptionPane.showMessageDialog(null, "Registro Editado Satisfactoriamente");
        }catch(SQLException ex){
            
       JOptionPane.showMessageDialog(null,"Error" +ex);  
        
        }
       
   } 
    
}
