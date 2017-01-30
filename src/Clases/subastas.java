/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Entradas;
import Interfaces.Subastas;
import Interfaces.Nosubastados;
import static Interfaces.Subastas.jTextAreaDetalle;
import static Interfaces.Subastas.jTextFieldCeduladelcomprador;
import static Interfaces.Subastas.jTextFieldCodigoComprador;
import static Interfaces.Subastas.jTextFieldColor;
import static Interfaces.Subastas.jTextFieldFerrete;
import static Interfaces.Subastas.jTextFieldMontoTotal;
import static Interfaces.Subastas.jTextFieldNanimal;
import static Interfaces.Subastas.jTextFieldNombredelcomprador;
import static Interfaces.Subastas.jTextFieldPeso;
import static Interfaces.Subastas.jTextFieldPesoNeto;
import static Interfaces.Subastas.jTextFieldPrecioPactado;
import static Interfaces.Subastas.jTextFieldSexo;
import static Interfaces.Subastas.jTextFieldTipo;
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
    ResultSet rs2,animal,rsmachos,rssubastados,rshembras,todos,ntodos;
    PreparedStatement cargar2,cargaranimal,guardarsubastas,machos,subastados,hembra,estado,animales,nanimales;
    DefaultTableModel tabla;
    Integer totalmachos,totalhembra,totalporsubastar;
    Object[] filas = new Object[7];
    Object[] filas1 = new Object[7];
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
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and sexo='MACHO'";
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
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and sexo='HEMBRA'";
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
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and Estado='Por Subastar'";
     //pasamos la consulta al preparestatement
    subastados=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rssubastados=subastados.executeQuery(consulta);
     //recorremos el resulset
    rssubastados.next();
    totalporsubastar= rssubastados.getInt(1);
   Subastas.jTextFieldPorsubastar.setText(totalporsubastar.toString());
    
   subastados.close();
   rssubastados.close();
   conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
       // return totalmachos;
   
    }
     
       public void tablenosubastado(){
     try{
     DefaultTableModel tabla= (DefaultTableModel) Nosubastados.jTableNoSubastados.getModel();
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
      //-----obtener la fecha----------------------
      String  dia = Integer.toString(Nosubastados.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Nosubastados.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Nosubastados.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
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
     consulta="SELECT idAnimal,Observacion,Sexo,Color,Precio,Peso,CodVendedor FROM entrada_detalle  where Fecha ='"+ fecha +"' and Estado='Por Subastar'";
     //pasamos la consulta al preparestatement
     nanimales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     ntodos=nanimales.executeQuery(consulta);
     //recorremos el resulset
    while (ntodos.next()){
        
                    filas1[0]=ntodos.getInt("idAnimal");
                    filas1[1]=ntodos.getString("Observacion");
                    filas1[2]=ntodos.getString("Sexo");
                    filas1[3]=ntodos.getString("Color");
                    filas1[4]=ntodos.getDouble("Precio");
                    filas1[5]=ntodos.getDouble("Peso");
                    filas1[6]=ntodos.getInt("CodVendedor");
                                      
       tabla.addRow(filas1);
    }
      nanimales.close();
      ntodos.close();
      conect.desconectar();
     }catch(Exception ex){
     JOptionPane.showMessageDialog(null,"Error" +ex);
     }
     
     } 
      
      
      
      
     public void tablesubastado(){
     try{
     DefaultTableModel tabla= (DefaultTableModel) Subastas.jTableSubastados.getModel();
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 
      //-----obtener la fecha----------------------
      String  dia = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
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
     consulta="SELECT idAnimal,Observacion,Sexo,Color,Precio,Peso,idComprador FROM entrada_detalle  where Fecha ='"+ fecha +"' and Estado='Subastado'";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas[0]=todos.getInt("idAnimal");
                    filas[1]=todos.getString("Observacion");
                    filas[2]=todos.getString("Sexo");
                    filas[3]=todos.getString("Color");
                    filas[4]=todos.getDouble("Precio");
                    filas[5]=todos.getDouble("Peso");
                    filas[6]=todos.getInt("idComprador");
                                      
       tabla.addRow(filas);
    }
      animales.close();
      todos.close();
      conect.desconectar();
     }catch(Exception ex){
     JOptionPane.showMessageDialog(null,"Error" +ex);
     }
     
     } 
      
     public void guardarsubasta(){
    try {
    String consulta,tipo,detalle;
    Double peso,precio,valortotal;
    Integer numeroa,codcomprador;
  
    conectar conect = new conectar(); 
    conect.conexion();
    
    codcomprador= Integer.parseInt(Subastas.jTextFieldCodigoComprador.getText());
    tipo= Subastas.jTextFieldTipo.getText();
    numeroa= Integer.parseInt(Subastas.jTextFieldNanimal.getText());
    peso= Double.parseDouble(Subastas.jTextFieldPesoNeto.getText());
    precio=Double.parseDouble(Subastas.jTextFieldPrecioPactado.getText());
    detalle=Subastas.jTextAreaDetalle.getText();
    valortotal=Double.parseDouble(Subastas.jTextFieldMontoTotal.getText());
    
    //-----obtener la fecha----------------------
      String  dia = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Subastas.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
          
      String estados="Subastado";
     //String condicion="Contado";
   
      //codigo para guardar en tabla subastas.
  guardarsubastas=conect.con.prepareStatement("INSERT INTO subastas ( Fecha, Tipo, NumeroA,CodComprador,Peso,Precio,Detalle,ValorTotal) VALUES (?,?,?,?,?,?,?,?)");
  //este es duplicando el numero consultar a juan el uso del codigo
  guardarsubastas.setString(1, fecha);
  guardarsubastas.setString(2, tipo);
  guardarsubastas.setInt(3, numeroa);
  guardarsubastas.setInt(4, codcomprador);
  guardarsubastas.setDouble(5, peso);
  guardarsubastas.setDouble(6, precio);
  guardarsubastas.setString(7, detalle);
  guardarsubastas.setDouble(8, valortotal);
  guardarsubastas.execute();
 //hasta aki
    
 //codigo para actualizar el estado en entrada detalle a subastado   
 consulta="UPDATE entrada_detalle SET Estado =?, idComprador=?,TotalBruto=?  WHERE idAnimal= ? and Fecha=?";
    //pasamos la consulta al preparestatement
    estado =conect.con.prepareStatement(consulta);
    estado.setString(1, estados);
    estado.setInt(2, codcomprador);
    estado.setDouble(3, valortotal);
    estado.setInt(4, numeroa);
    estado.setString(5, fecha);
    estado.executeUpdate(); 
 //hasta aki     
        jTextAreaDetalle.setText("");
        jTextFieldNanimal.setText("0");
        jTextFieldCodigoComprador.setText("0");
        jTextFieldTipo.setText("");
        jTextFieldColor.setText("");
        jTextFieldSexo.setText("");
        jTextFieldFerrete.setText("");
        jTextFieldNombredelcomprador.setText("");
        jTextFieldCeduladelcomprador.setText("");
        jTextFieldPesoNeto.setText("");
        jTextFieldPrecioPactado.setText("");
        jTextFieldMontoTotal.setText("");
        Subastas.jTextFieldPrecio.setText("");
        jTextFieldPeso.setText("");
        Subastas.jTextFieldNanimal.requestFocus();
    
    JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
    
    
    guardarsubastas.close();
    estado.close();
    conect.desconectar();
    
        }catch(SQLException ex){
           
        JOptionPane.showMessageDialog(null, "Error" + ex);
        
        }
        
     
    
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
