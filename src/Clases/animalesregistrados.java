/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.Entradas;
import Interfaces.Facturacion;
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
    ResultSet rsmachos,rshembras,todos,rsentradas, buy, cargall, ActualizarE;
    PreparedStatement machos,hembras,animales,editar,numeroentrada, comprados, InsertFact, ActEdetalle, Completados, ActEntrada;
    Integer totalmachos,totalhembras, ultimaentrada;;
    
    //DefaultTableModel tabla;
    Object[] filas = new Object[6];
    Object[] filas1 = new Object[9];
    Object[] filas2 = new Object[9];
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
     consulta="SELECT idAnimal,Tipo,Sexo,Color,Peso,Ferrete,CodVendedor,Observacion,idedetalle FROM entrada_detalle  where Fecha ='"+ fecha +"' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas1[0]=todos.getInt("idAnimal");
                    filas1[1]=todos.getString("Tipo");
                    filas1[2]=todos.getString("Sexo");
                    filas1[3]=todos.getString("Color");
                    filas1[4]=todos.getDouble("Peso");
                    filas1[5]=todos.getString("Ferrete");
                    filas1[6]=todos.getInt("CodVendedor");
                    filas1[7]=todos.getString("Observacion");   
                    filas1[8]=todos.getInt("idedetalle");
       tabla.addRow(filas1);
    }
    todos.close();
    animales.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    }
    
    public void cargaranimalesporcodigo(String codigo ){
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
     consulta="SELECT idAnimal,Tipo,Sexo,Color,Peso,Ferrete,CodVendedor,Observacion,idedetalle FROM entrada_detalle  where CodVendedor LIKE '"+ codigo +"%' and  Fecha ='"+ fecha +"' ORDER BY idedetalle";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas1[0]=todos.getInt("idAnimal");
                    filas1[1]=todos.getString("Tipo");
                    filas1[2]=todos.getString("Sexo");
                    filas1[3]=todos.getString("Color");
                    filas1[4]=todos.getDouble("Peso");
                    filas1[5]=todos.getString("Ferrete");
                    filas1[6]=todos.getInt("CodVendedor");
                    filas1[7]=todos.getString("Observacion");   
                    filas1[8]=todos.getInt("idedetalle");
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
     consulta="SELECT idAnimal,Sexo,Color,CodVendedor,Peso,Observacion FROM entrada_detalle  where Fecha ='"+ fecha +"' ORDER BY idAnimal";
     //pasamos la consulta al preparestatement
     animales=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=animales.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas[0]=todos.getInt("idAnimal");
                    filas[1]=todos.getString("Sexo");
                    filas[2]=todos.getString("Color");
                    filas[3]=todos.getInt("CodVendedor");
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
    
    public Integer buscarultimaentrada(){
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
     consulta="SELECT MAX(idEntradas) FROM entradas  where Fecha ='"+ fecha +"'";
     //pasamos la consulta al preparestatement
   numeroentrada=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rsentradas=numeroentrada.executeQuery(consulta);
     //recorremos el resulset
    rsentradas.next();
        
               ultimaentrada=rsentradas.getInt(1);
          //Entradas.jTextFieldTotalMachos.setText(totalmachos.toString());
  
   numeroentrada.close();
   rsentradas.close();
   conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }   
    return ultimaentrada;
    }
    
    
    public void cargaracomprados(){
    
    try {
            DefaultTableModel tabla= (DefaultTableModel) Facturacion.jTableAnimalesVendidos.getModel();   
            String consulta;    
            conectar conect = new conectar(); 
            conect.conexion();

            String  dia = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String  mes = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
            String fecha = (year + "-" + mes+ "-" + dia);
            String Estado = "Subastado";

            try {
                if (tabla != null) {
                    while (tabla.getRowCount() > 0) {
                        tabla.removeRow(0);
                    }
                }
           
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error" +ex);
                }
//
            consulta="SELECT idAnimal,Observacion,Sexo,Color,idComprador,Precio,Peso,CodVendedor FROM entrada_detalle Where Fecha = '"+fecha+"' And Estado = '"+Estado+"' ";

            comprados=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            buy=comprados.executeQuery(consulta);
   
            while (buy.next()){
                    filas2[1]=buy.getString("idAnimal");
                    filas2[2]=buy.getString("Observacion");
                    filas2[3]=buy.getString("Sexo");
                    filas2[4]=buy.getString("Color");
                    filas2[5]=buy.getString("idComprador");
                    filas2[6]=buy.getDouble("Precio");
                    filas2[7]=buy.getDouble("Peso");
                    filas2[8]=buy.getString("CodVendedor"); 
                    tabla.addRow(filas2);
            }
            buy.close();
            comprados.close();
            conect.desconectar();
           
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"No Hay Animales Comprados o Subastados el dia de hoy");
        }
     
    }
   
    
    public void cargartodasfacturas(){
    
    try {
            DefaultTableModel tabla= (DefaultTableModel) Facturacion.jTableAnimalesVendidos.getModel();   
            String consulta, CActualizar, Consulta2, EActualizar;    
            conectar conect = new conectar(); 
            conect.conexion();

            String  dia = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String  mes = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
            String fecha = (year + "-" + mes+ "-" + dia);

            String Estado = "Subastado";
            Integer Codigo= Integer.parseInt(Facturacion.idcomprador.getText());
            Integer CODFact= Integer.parseInt(Facturacion.NumFactura.getText());
            
            
            for (int i = 0; i < Facturacion.jTableAnimalesVendidos.getRowCount(); i++) {
            Integer Animal =Integer.parseInt(String.valueOf(Facturacion.jTableAnimalesVendidos.getValueAt(i, 1)));
            Integer Comprador =Integer.parseInt(String.valueOf(Facturacion.jTableAnimalesVendidos.getValueAt(i, 5)));            
            
            if (Facturacion.seleccion.isSelected()== true){ 
                  if (Comprador == Codigo)
                  {     
                      JOptionPane.showMessageDialog(null,"Codigo Igual");
                   // boolean a = boolean.valueOf(Facturacion.jTableAnimalesVendidos.getValueAt(i, 0));
                        if( Facturacion.jTableAnimalesVendidos.getValueAt(i, 0)!=null){                       
                        }else{
                            continue;
                        }
                  } else{
                         continue; 
                          }
                }
            
                consulta="SELECT idAnimal,Precio, Peso FROM entrada_detalle Where Fecha = '"+fecha+"' And Estado = '"+Estado+"' And idComprador = '"+Codigo+"' And idAnimal = '"+Animal+"' ";
           
                comprados=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                cargall=comprados.executeQuery(consulta);

                Double comision, TotalReal, TotalBruto;

                while (cargall.next()){
                    
                    InsertFact=conect.con.prepareStatement("INSERT INTO facturas_detalle ( idFactura, idAnimal) VALUES (?,?)");
                    InsertFact.setInt(1,CODFact);
                    InsertFact.setInt(2,cargall.getInt("idAnimal")); 
                    InsertFact.execute();       
                    TotalBruto = (cargall.getDouble("Precio")*cargall.getDouble("Peso"));
                    comision = (TotalBruto* 0.03);
                    TotalReal = (TotalBruto - comision);
                    
                    CActualizar="UPDATE entrada_detalle SET Estado =?,TotalBruto=?,Comision=?,TotalReal=? WHERE idComprador= '"+Codigo+"' And Fecha = '"+fecha+"' And Estado = '"+Estado+"' And idAnimal = ?";
                    //pasamos la consulta al preparestatement
                    ActEdetalle=conect.con.prepareStatement(CActualizar);
                    ActEdetalle.setString(1, "Completado");
                    ActEdetalle.setDouble(2, TotalBruto);
                    ActEdetalle.setDouble(3, comision);
                    ActEdetalle.setDouble(4, TotalReal);
                    ActEdetalle.setInt(5, cargall.getInt("idAnimal"));
                    ActEdetalle.executeUpdate();  

                }
            }
            
            Consulta2="SELECT SUM(TotalReal) AS Total FROM entrada_detalle Where Fecha = '"+fecha+"' And Estado = '"+"Completado"+"' And idComprador = '"+Codigo+"'";
           
                Completados=conect.con.prepareStatement(Consulta2,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ActualizarE=Completados.executeQuery(Consulta2);


                while (ActualizarE.next()){
                    
                    
                    EActualizar="UPDATE entradas SET Estado =?,Total=? WHERE CodCliente= '"+Codigo+"' And Fecha = '"+fecha+"'";
                    //pasamos la consulta al preparestatement
                    ActEntrada=conect.con.prepareStatement(EActualizar);
                    ActEntrada.setString(1, "Completado");
                    ActEntrada.setDouble(2, ActualizarE.getDouble("Total"));
                    ActEntrada.executeUpdate();  

                }
            
            
            
            
            cargall.close();
            comprados.close();
            conect.desconectar();
            InsertFact.close();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Error Al Registrar Detalle de Factura");
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
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and sexo='MACHO' ORDER BY idAnimal";
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
     consulta="SELECT count(*) FROM entrada_detalle  where Fecha ='"+ fecha +"' and sexo='HEMBRA' ORDER BY idAnimal";
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
   try{
   Integer m,h,t;
    h= Integer.parseInt(Entradas.jTextFieldTotalHembras.getText());
    
    m= Integer.parseInt(Entradas.jTextFieldTotalMachos.getText());
    t=h+m;
    
    Entradas.jTextFieldTotalAnimales.setText(t.toString());
   }catch(Exception ex){
     JOptionPane.showMessageDialog(null,"Error" +ex);
   }    
    }
       
public void guardareditados( Integer numero,Integer idedetalle, String tipo,String sexo,String color,String ferrete,String observacion , double peso ){
try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();  
    
     // creamos la consulta
     consulta="UPDATE entrada_detalle SET idAnimal =?,Tipo=?,Sexo=?,Color=?,Ferrete=?,Observacion=? ,Peso=? WHERE idedetalle= ? ";
    //pasamos la consulta al preparestatement
    editar=conect.con.prepareStatement(consulta);
    editar.setInt(1, numero);
   // editar.setInt(2, cod_cliente);
    editar.setString(2, tipo);
    editar.setString(3, sexo);
    editar.setString(4, color);
    editar.setString(5, ferrete);
    editar.setString(6, observacion);
    editar.setDouble(7, peso);
    editar.setInt(8, idedetalle);
    
    editar.executeUpdate(); 
    conect.desconectar(); 
    editar.close();
    JOptionPane.showMessageDialog(null, "Registro Editado Satisfactoriamente");
        }catch(SQLException ex){
            
       JOptionPane.showMessageDialog(null,"Error" +ex);  
        
        }

}


}
