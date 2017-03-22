/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.ReciboCaja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Juan
 */
public class Caja {
    PreparedStatement guardarbanco, UltimoRg, cargar;
    String idbanco,nombre,cuenta,detalle,estado;
    Double montoi, montoa;
    ResultSet aux, rs, aux1, rsdeposito; 
    int ultimo;
    public Caja() { 
}
    
    public void guardarrecibo(){
    
        try {
            
        String  dia = Integer.toString(ReciboCaja.fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        String  mes = Integer.toString(ReciboCaja.fecha.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(ReciboCaja.fecha.getCalendar().get(Calendar.YEAR));
        String fecha = (year + "-" + mes+ "-" + dia); 
        String Estado = "Registrado";
        int idcaja=Integer.parseInt(ReciboCaja.ID.getText());
        detalle= ReciboCaja.detalle.getText();
        Double monto = Double.parseDouble(ReciboCaja.monto.getText());
        conectar conexcio = new conectar(); 
        conexcio.conexion();

        guardarbanco=conexcio.con.prepareStatement("INSERT INTO caja (idCaja, Fecha, Monto, Detalle, Estado) VALUES (?,?,?,?,?)");
        guardarbanco.setInt(1, idcaja);
        guardarbanco.setString(2, fecha);
        guardarbanco.setDouble(3, monto);
        guardarbanco.setString(4, detalle);
        guardarbanco.setString(5, Estado);
        guardarbanco.execute();
        JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El Registro No Se Logro Realizar Error:" +ex);
        }
        
    
    }
   
    public Integer buscarultimo(){
    
     conectar conect = new conectar(); 
                 conect.conexion();
         try {
     String consulta; 
                      
     // creamos la consulta
     consulta="SELECT MAX(idCaja) FROM caja ";
     //pasamos la consulta al preparestatement
   UltimoRg=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rsdeposito=UltimoRg.executeQuery(consulta);
     //recorremos el resulset
    rsdeposito.next();
        
               ultimo=rsdeposito.getInt(1)+1;
          //Entradas.jTextFieldTotalMachos.setText(totalmachos.toString());
  
   
           
   }catch (SQLException ex1){
   JOptionPane.showMessageDialog(null,"Error" +ex1.getMessage());
   }finally{
         try {
             UltimoRg.close();
             rsdeposito.close();
             conect.desconectar();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error" +ex.getMessage());
         }
   
     }   
    return ultimo;
    }

}
