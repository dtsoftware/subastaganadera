/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.Entradas;
import Interfaces.Recibos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Juan
 */
public class ReciboAbonos {
      ResultSet rs2;
    PreparedStatement cargar2,guardarentradas;
    DefaultTableModel tabla; 


public ReciboAbonos(){

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
            Recibos.txtBeneficiario.setText(rs2.getString("Nombre")+ " " + rs2.getString("Apellido"));         
            Recibos.cliente.setText(String.valueOf(rs2.getInt("idClientes")) );
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
}

