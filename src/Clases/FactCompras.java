/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.FacturarC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class FactCompras {
    
 ResultSet ventas;
   PreparedStatement buscarv;   
   Object[] filas = new Object[6];
    

    
public FactCompras(){
}
 

public void buscarfcompras(){
    
       try {
     DefaultTableModel tabla= (DefaultTableModel) FacturarC.Tcompras.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
     conect.conexion();
       
     Calendar c1 = Calendar.getInstance();
      String  dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
      String year = Integer.toString(c1.get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         

      try {
            if (tabla != null) {
                while (tabla.getRowCount() > 0) {
                    tabla.removeRow(0);
                }
            }
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error" +ex);
        }

     consulta="SELECT idFacturas, Fecha, CodCliente, Tipo, Monto, Estado FROM facturas  where Fecha ='"+ fecha +"' ORDER BY idFacturas";
     //pasamos la consulta al preparestatement
     buscarv=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     ventas=buscarv.executeQuery(consulta);
     //recorremos el resulset
    while (ventas.next()){
        
                    filas[0]=ventas.getInt("idFacturas");
                    filas[1]=ventas.getString("Fecha");
                    filas[2]=ventas.getString("CodCliente");
                    filas[3]=ventas.getString("Tipo");
                    filas[4]=ventas.getDouble("Monto");
                    filas[5]=ventas.getString("Estado");
                    
       tabla.addRow(filas);
    }
    ventas.close();
    buscarv.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    
}



}
