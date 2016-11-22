/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Interfaces.Clientes;
/**
 *
 * @author Juan
 */
public class CrearClientes {
 Connection conectar;
 PreparedStatement guardarusuario;

 
    public CrearClientes(){
    
    
    }
    
    
     public void guardarcliente(Integer idClientes, String Nombre, String Apellido, String Cedula, String Direccion, String Telefono1, String Telefono2, String Credito,String Imagen, String Estado, String Audito1,String Audito2,String Fecha1,String Fecha2){
     

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
            JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"El Registro No Se Logro Realizar Error:" +ex);
            }

        
    }
    
    
    
}
