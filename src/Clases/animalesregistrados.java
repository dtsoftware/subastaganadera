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
public class animalesregistrados {
    ResultSet rsmachos,rshembras,todos;
    PreparedStatement machos,hembras,animales;
    //DefaultTableModel tabla;
    Object[] filas = new Object[6];
    public  animalesregistrados(){
    
    }
    
    public void cargaranimales(){
    
    try {
     DefaultTableModel tabla= (DefaultTableModel) Entradas.jTableAnimalesRegistrados.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
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
     consulta="SELECT Numero,Sexo,Color,CodCliente,Peso,Observacion FROM entradas  where Fecha ='"+ fecha +"' ORDER BY Numero";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas[0]=todos.getInt("Numero");
                    filas[1]=todos.getString("Sexo");
                    filas[2]=todos.getString("Color");
                    filas[3]=todos.getInt("CodCliente");
                    filas[4]=todos.getDouble("Peso");
                    filas[5]=todos.getString("Observacion");                    
       tabla.addRow(filas);
    }
    todos.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
    }
    
    public Integer machos(){
    
        return 0;
    }
    
    
    public Integer hembras(){
    
        return 0;
    }
}
