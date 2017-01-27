/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Subastas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tserng
 */
public class subastas {
    ResultSet rs2,animal;
    PreparedStatement cargar2,cargaranimal,guardarsubastas;
    DefaultTableModel tabla;
    
    public subastas(){
    }
    
     public void buscarcliente(Integer Codigo){
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
            Subastas.jTextFieldCodigoComprador.setText(String.valueOf(rs2.getInt("idClientes")) );                
            Subastas.jTextFieldCeduladelcomprador.setText(rs2.getString("Cedula"));
            Subastas.jTextFieldNombredelcomprador.setText(rs2.getString("Nombre") + " " + rs2.getString("Apellido"));
            //Subastas.jTextFieldApellido.setText(rs2.getString("Apellido"));
           // Entradas.jTextFieldDireccion.setText(rs2.getString("Direccion"));
          
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
     
     public void buscaranimal(Integer Codigo, String fecha){
     try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idAnimal,Tipo, Color, Sexo,Ferrete,Peso FROM entrada_detalle where idAnimal ='"+ Codigo +"' and Fecha ='"+ fecha +"'   ";
     //pasamos la consulta al preparestatement
    
     cargaranimal=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     animal=cargaranimal.executeQuery(consulta);
           if (animal.next()){
            Subastas.jTextFieldNanimal.setText(String.valueOf(animal.getInt("idAnimal")) );                
            Subastas.jTextFieldTipo.setText(animal.getString("Tipo"));
            Subastas.jTextFieldColor.setText(animal.getString("Color"));
            Subastas.jTextFieldSexo.setText(animal.getString("Sexo"));
            Subastas.jTextFieldFerrete.setText(animal.getString("Ferrete"));
            Subastas.jTextFieldPeso.setText(String.valueOf(animal.getDouble("Peso")));
            Subastas.jTextFieldPesoNeto.setText(String.valueOf(animal.getDouble("Peso")));
            //Subastas.jTextFieldApellido.setText(rs2.getString("Apellido"));
           // Entradas.jTextFieldDireccion.setText(rs2.getString("Direccion"));
          
            //imagen pendiente 
       
      animal.close();
    conect.desconectar();
           }else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
           conect.desconectar();
            }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
     }
}
