/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Entradas;
import Interfaces.Subastas;
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
public class subastas {
    ResultSet rs2,animal,rsmachos,rssubastados,rshembras;
    PreparedStatement cargar2,cargaranimal,guardarsubastas,machos,subastados,hembra;
    DefaultTableModel tabla;
    Integer totalmachos,totalhembra,totalporsubastar;
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
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar: El Cliente No Esta Registrado"  ); 
           conect.desconectar();
            }
    
    
   }catch (SQLException ex){
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
      String  dia = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
   
     
     // creamos la consulta
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and sexo='MACHO' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
    machos=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rsmachos=machos.executeQuery(consulta);
     //recorremos el resulset
    rsmachos.next();
        
               totalmachos=rsmachos.getInt(1);
          Subastas.jTextFieldMachos.setText(totalmachos.toString());
  
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
      String  dia = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
   
     
     // creamos la consulta
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and sexo='HEMBRA' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
    hembra=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rshembras=hembra.executeQuery(consulta);
     //recorremos el resulset
    rshembras.next();
        
               totalhembra=rshembras.getInt(1);
          Subastas.jTextFieldHembras.setText(totalhembra.toString());
  
   hembra.close();
   rshembras.close();
   conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
       // return totalmachos;
   
    }   
    
      public void totalmachoshembras(){
     
    try{
    Integer m,h,t;
    h= Integer.parseInt(Subastas.jTextFieldHembras.getText());
    
    m= Integer.parseInt(Subastas.jTextFieldMachos.getText());
    t=h+m;
    
    Subastas.jTextFieldTotaldeanimales.setText(t.toString());
    }catch(Exception ex){
     JOptionPane.showMessageDialog(null,"Error" + ex);
    }      
   
    }
         
      public void buscarporsubastar(){
    try {
     String consulta; 
     
     conectar conect = new conectar(); 
                 conect.conexion();
                 
//Calendar c = Calendar.getInstance();
    
//-----obtener la fecha----------------------
      String  dia = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
   
     
     // creamos la consulta
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and Estado='Por Subastar' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
    subastados=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rssubastados=subastados.executeQuery(consulta);
     //recorremos el resulset
    if (rssubastados.next()){
    totalporsubastar= rssubastados.getInt(1);
          Subastas.jTextFieldPorsubastar.setText(totalporsubastar.toString());
    }else{
    
    }
   subastados.close();
   rssubastados.close();
   conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
       // return totalmachos;
   
    }
         
         
         
     public void buscaranimal(Integer Codigo, String fecha){
     try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idAnimal,Tipo, Color, Sexo,Ferrete,Peso FROM entrada_detalle where idAnimal ='"+ Codigo +"' and Fecha ='"+ fecha +"' and Estado='Por Subastar'  ";
     //pasamos la consulta al preparestatement
    
     cargaranimal=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     animal=cargaranimal.executeQuery(consulta);
           if (animal.next()==true){
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
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar: El Animal Ha Sido Subastado O no se a Realizado Su Registro De Entada"  ); 
           conect.desconectar();
            }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
     }
}
