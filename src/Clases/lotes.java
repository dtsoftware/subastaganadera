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
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tserng
 */
public class lotes {
    ResultSet rsentradas;
    PreparedStatement numeroentrada;
    Integer ultimaentrada;
    
    public lotes(){}
    
     public Integer buscarultimolote(){
    
     conectar conect = new conectar(); 
                 conect.conexion();
         try {
     String consulta; 
                      
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
   
     
     // creamos la consulta
     consulta="SELECT MAX(nlote) FROM subastas  where Fecha ='"+ fecha +"'";
     //pasamos la consulta al preparestatement
   numeroentrada=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rsentradas=numeroentrada.executeQuery(consulta);
     //recorremos el resulset
    rsentradas.next();
        
               ultimaentrada=rsentradas.getInt(1)+1;
          //Entradas.jTextFieldTotalMachos.setText(totalmachos.toString());
  
   
           
   }catch (SQLException ex1){
   JOptionPane.showMessageDialog(null,"Error" +ex1.getMessage());
   }finally{
         try {
             numeroentrada.close();
             rsentradas.close();
             conect.desconectar();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error" +ex.getMessage());
         }
   
     }   
    return ultimaentrada;
    }
    
}
