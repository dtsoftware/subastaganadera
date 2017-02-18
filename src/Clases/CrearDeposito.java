/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Depositos;
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
public class CrearDeposito {
    
   PreparedStatement guardarbanco, UltimoRg, cargar;
    String idbanco,nombre,cuenta,detalle,estado;
    Double montoi, montoa;
    ResultSet aux, rs;
    DefaultTableModel tabla = new DefaultTableModel(); 
    Object[] filas = new Object[8];  
    
    
    
    public CrearDeposito() {
    
}
    public void guardardeposito(){
    
        try {
            
        Calendar c1 = Calendar.getInstance();
        String  dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
        String  mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String year = Integer.toString(c1.get(Calendar.YEAR));
        String fecha = (year + "-" + mes+ "-" + dia); 
        
        int idbanco=Integer.parseInt(Depositos.ID.getText());
        cuenta=String.valueOf(Depositos.cuenta.getSelectedItem());
        detalle= Depositos.detalle.getText();
        Double monto = Double.parseDouble(Depositos.monto.getText());
        conectar conexcio = new conectar(); 
        conexcio.conexion();

        guardarbanco=conexcio.con.prepareStatement("INSERT INTO depositos (idDepositos, Cuenta, Fecha, Detalle, Monto) VALUES (?,?,?,?,?)");
        guardarbanco.setInt(1, idbanco);
        guardarbanco.setString(2, cuenta);
        guardarbanco.setString(3, fecha);
        guardarbanco.setString(4, detalle);
        guardarbanco.setDouble(5, monto);
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
     consulta="SELECT MAX(idDepositos) AS 'Ultimo' FROM depositos";
   
     //pasamos la consulta al preparestatement
    
     UltimoRg=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    
     aux=UltimoRg.executeQuery(consulta);

           if (aux.next()){               
 
                int Ultimo= Integer.parseInt(aux.getString("Ultimo"));
                int URG= (Ultimo + 1);
                Depositos.ID.setText(""+URG);
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
 
                Depositos.cuenta.addItem(aux.getString("Nombre"));
                     
               
           }
           
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
    }
}


