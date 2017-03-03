/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.MantNotas;
import Interfaces.NotasDC;
import java.awt.HeadlessException;
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
public class CrearNotas {
    
     PreparedStatement guardarbanco, UltimoRg, cargar;
    String idbanco,nombre,cuenta,detalle,estado, tipo;
    Double montoi, montoa;
    ResultSet aux, rs, aux1;
    Object[] filas1 = new Object[6];  
    
   public CrearNotas() {
    
} 
 public void guardarnotas(){
    
        try {
            
        String  dia = Integer.toString(NotasDC.fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        String  mes = Integer.toString(NotasDC.fecha.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(NotasDC.fecha.getCalendar().get(Calendar.YEAR));

        String fecha = (year + "-" + mes+ "-" + dia); 
        String Estado = "Registrada";
        int idbanco=Integer.parseInt(NotasDC.ID.getText());
        cuenta=String.valueOf(NotasDC.cuenta.getSelectedItem());
        tipo= String.valueOf(NotasDC.tipo.getSelectedItem());
        detalle= NotasDC.detalle.getText();
        Double monto = Double.parseDouble(NotasDC.monto.getText());
        conectar conexcio = new conectar(); 
        conexcio.conexion();

        guardarbanco=conexcio.con.prepareStatement("INSERT INTO notas (idNotas, Cuenta, Fecha, Detalle, Monto, Tipo, Estado) VALUES (?,?,?,?,?,?,?)");
        guardarbanco.setInt(1, idbanco);
        guardarbanco.setString(2, cuenta);
        guardarbanco.setString(3, fecha);
        guardarbanco.setString(4, detalle);
        guardarbanco.setDouble(5, monto);
        guardarbanco.setString(6, tipo);
        guardarbanco.setString(7, Estado);
        guardarbanco.execute();
        JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null,"El Registro No Se Logro Realizar Error:" +ex);
        }
        
    
    }



public void UltimoRg(){
    try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
     
     // creamos la consulta
     consulta="SELECT MAX(idNotas) AS 'Ultimo' FROM notas";
   
     //pasamos la consulta al preparestatement
    
     UltimoRg=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    
     aux=UltimoRg.executeQuery(consulta);

           if (aux.next()){               
 
                int Ultimo= Integer.parseInt(aux.getString("Ultimo"));
                int URG= (Ultimo + 1);
                NotasDC.ID.setText(""+URG);
           }else{
                JOptionPane.showMessageDialog(null,"Error en Numeracion de Facturas"  ); 
                conect.desconectar();
           }

                aux.close(); 
                UltimoRg.close();
                
                conect.desconectar();
           
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
}      
 
public void llenarcombo(){
        try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
     
     // creamos la consulta
     consulta="SELECT Nombre FROM cuentas Where idCuentas !='"+'0'+"'";
   
     //pasamos la consulta al preparestatement
    
     UltimoRg=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    
     aux=UltimoRg.executeQuery(consulta);

          while(aux.next()){               
                if (MantNotas.Orden == "1"){
                
                MantNotas.cuenta.addItem(aux.getString("Nombre"));
                }else{
                    NotasDC.cuenta.addItem(aux.getString("Nombre"));
                }
               
           }
           
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
 
 public void cargarnotas(){
       try {
     DefaultTableModel tabla= (DefaultTableModel) MantNotas.jTablenotas.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
                 

      String  dia1 = Integer.toString(MantNotas.jDateChooserFecha1.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes1 = Integer.toString(MantNotas.jDateChooserFecha1.getCalendar().get(Calendar.MONTH) + 1);
      String year1 = Integer.toString(MantNotas.jDateChooserFecha1.getCalendar().get(Calendar.YEAR));
      String fecha1 = (year1 + "-" + mes1+ "-" + dia1);   

      String  dia2 = Integer.toString(MantNotas.jDateChooserFecha2.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes2 = Integer.toString(MantNotas.jDateChooserFecha2.getCalendar().get(Calendar.MONTH) + 1);
      String year2 = Integer.toString(MantNotas.jDateChooserFecha2.getCalendar().get(Calendar.YEAR));
      String fecha2 = (year2 + "-" + mes2+ "-" + dia2);      
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
     
    consulta = ""; 

    String Cuenta = MantNotas.cuenta.getSelectedItem().toString();
    if (MantNotas.todas.isSelected()) 
    {   
        consulta="SELECT Fecha, Cuenta, Detalle, Monto, Tipo, Estado FROM notas where Fecha BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"' AND Cuenta = '"+ Cuenta +"' ORDER BY Fecha";
    }else if (MantNotas.credito.isSelected()) {
        consulta="SELECT Fecha, Cuenta, Detalle, Monto, Tipo, Estado FROM notas where Fecha BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"' AND Cuenta = '"+ Cuenta +"' AND Tipo = '"+ "Credito" +"' ORDER BY Fecha";
    }else if (MantNotas.debito.isSelected()){
        consulta="SELECT Fecha, Cuenta, Detalle, Monto, Tipo, Estado FROM notas where Fecha BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"' AND Cuenta = '"+ Cuenta +"' AND Tipo = '"+ "Debito" +"' ORDER BY Fecha";    
    }
        

     // creamos la consulta
     
     //pasamos la consulta al preparestatement
     cargar=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     aux1=cargar.executeQuery(consulta);
     //recorremos el resulset
    while (aux1.next()){
        
                    filas1[0]=aux1.getString("Fecha");
                    filas1[1]=aux1.getString("Cuenta");
                    filas1[2]=aux1.getString("Detalle");
                    filas1[3]=aux1.getDouble("Monto");
                    filas1[4]=aux1.getString("Tipo");
                    filas1[5]=aux1.getString("Estado");                    
       tabla.addRow(filas1);
    }
    cargar.close();
    aux1.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
 }
}
