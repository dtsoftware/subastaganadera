/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.Entradas;
import Interfaces.ModificarEntradas;
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
    PreparedStatement machos,hembras,animales,editar;
    Integer totalmachos,totalhembras;
    //DefaultTableModel tabla;
    Object[] filas = new Object[6];
    Object[] filas1 = new Object[9];
    public  animalesregistrados(){
    
    }
    
    public void entradasparamodificar (){
    
     try {
     DefaultTableModel tabla= (DefaultTableModel) ModificarEntradas.jTableModificarEntradas.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(ModificarEntradas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(ModificarEntradas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(ModificarEntradas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
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
     consulta="SELECT Numero,Tipo,Sexo,Color,Peso,Ferrete,CodCliente,Observacion,idEntradas FROM entradas  where Fecha ='"+ fecha +"' ORDER BY Numero";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas1[0]=todos.getInt("Numero");
                    filas1[1]=todos.getString("Tipo");
                    filas1[2]=todos.getString("Sexo");
                    filas1[3]=todos.getString("Color");
                    filas1[4]=todos.getDouble("Peso");
                    filas1[5]=todos.getString("Ferrete");
                    filas1[6]=todos.getInt("CodCliente");
                    filas1[7]=todos.getString("Observacion");   
                    filas1[8]=todos.getInt("idEntradas");
       tabla.addRow(filas1);
    }
    todos.close();
    animales.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    }
    
    
    public void cargaranimales(){
    
    try {
     DefaultTableModel tabla= (DefaultTableModel) Entradas.jTableAnimalesRegistrados.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
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
    animales.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
    }
    
    public void machos(){
    try {
     String consulta; 
     
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
   
     
     // creamos la consulta
     consulta="SELECT count(*) FROM entradas  where Fecha ='"+ fecha +"' and sexo='MACHO' ORDER BY Numero";
     //pasamos la consulta al preparestatement
    machos=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rsmachos=machos.executeQuery(consulta);
     //recorremos el resulset
    rsmachos.next();
        
               totalmachos=rsmachos.getInt(1);
          Entradas.jTextFieldTotalMachos.setText(totalmachos.toString());
  
   machos.close();
   rsmachos.close();
   conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
       // return totalmachos;
   
    }
    
    
    public void hembras(){
    try {
     String consulta; 
     
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Entradas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
   
     
     // creamos la consulta
     consulta="SELECT count(*) FROM entradas  where Fecha ='"+ fecha +"' and sexo='HEMBRA' ORDER BY Numero";
     //pasamos la consulta al preparestatement
    hembras=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rshembras=hembras.executeQuery(consulta);
     //recorremos el resulset
    rshembras.next();
        
          totalhembras=rshembras.getInt(1);
          Entradas.jTextFieldTotalHembras.setText(totalhembras.toString());
  
   hembras.close();
   rshembras.close();
   conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    
    }
public void totalmachoshembras(){
    Integer m,h,t;
    h= Integer.parseInt(Entradas.jTextFieldTotalHembras.getText());
    
    m= Integer.parseInt(Entradas.jTextFieldTotalMachos.getText());
    t=h+m;
    
    Entradas.jTextFieldTotalAnimales.setText(t.toString());
    }
       
public void guardareditados( Integer numero,Integer codigo,Integer cod_cliente,Integer idEntradas, String tipo,String sexo,String color,String ferrete,String observacion , double peso ){
try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();  
    
     // creamos la consulta
     consulta="UPDATE entradas SET Numero =?,Codigo=?,CodCliente=?,Tipo=?,Sexo=?,Color=?,Ferrete=?,Observacion=? ,Peso=? WHERE idEntradas= ? ";
    //pasamos la consulta al preparestatement
    editar=conect.con.prepareStatement(consulta);
    editar.setInt(1, numero);
    editar.setInt(2, codigo);
    editar.setInt(3, cod_cliente);
    editar.setString(4, tipo);
    editar.setString(5, sexo);
    editar.setString(6, color);
    editar.setString(7, ferrete);
    editar.setString(8, observacion);
    editar.setDouble(9, peso);
    editar.setInt(10, idEntradas);
    editar.executeUpdate(); 
    conect.desconectar(); 
    editar.close();
    JOptionPane.showMessageDialog(null, "Registro Editado Satisfactoriamente");
        }catch(SQLException ex){
            
       JOptionPane.showMessageDialog(null,"Error" +ex);  
        
        }

}


}
