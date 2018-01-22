/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Cheques;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sg.soft.Principal;

/**
 *
 * @author Juan
 */
public class Accesos {
    PreparedStatement cargar2,guardar,numerocheque, ActEdetalle, ActEdetalle2;
    ResultSet rs2,rscheque;
    Integer ultimocheque;
    
        public Accesos() { 
}
        
    public void buscaracceso(String id){
    conectar conect = new conectar(); 
    conect.conexion();
    try {
    String consulta; 
     // creamos la consulta
     consulta="SELECT  * From Accesos where Usuarios ='"+ id +"'";
     //pasamos la consulta al preparestatement
    
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){
            
Principal.MA01.setEnabled(true);
            Cheques.Beneficiario.setText(rs2.getString("Nombre")+ "  " + rs2.getString("Apellido"));
           
            Cheques.txtmonto.requestFocus();
          
            //imagen pendiente 
       
    rs2.close();
    cargar2.close();
    conect.desconectar();
           }else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
            rs2.close();
            cargar2.close();
           conect.desconectar();
            }
    }catch (SQLException ex){
    conect.desconectar();   
   JOptionPane.showMessageDialog(null,"Error" +ex.getMessage());
   }
    
    }
        
}
