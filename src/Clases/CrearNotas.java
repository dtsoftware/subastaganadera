/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.NotasDC;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class CrearNotas {
    
     PreparedStatement guardarbanco, UltimoRg, cargar;
    String idbanco,nombre,cuenta,detalle,estado, tipo;
    Double montoi, montoa;
    ResultSet aux, rs;
 
    
   public CrearNotas() {
    
} 
 public void guardarnotas(){
    
        try {
            
        Calendar c1 = Calendar.getInstance();
        String  dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
        String  mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String year = Integer.toString(c1.get(Calendar.YEAR));
        String fecha = (year + "-" + mes+ "-" + dia); 
        
        int idbanco=Integer.parseInt(NotasDC.ID.getText());
        cuenta=String.valueOf(NotasDC.cuenta.getSelectedItem());
        tipo= String.valueOf(NotasDC.tipo.getSelectedItem());
        detalle= NotasDC.detalle.getText();
        Double monto = Double.parseDouble(NotasDC.monto.getText());
        conectar conexcio = new conectar(); 
        conexcio.conexion();

        guardarbanco=conexcio.con.prepareStatement("INSERT INTO notas (idNotas, Cuenta, Fecha, Detalle, Monto, Tipo) VALUES (?,?,?,?,?,?)");
        guardarbanco.setInt(1, idbanco);
        guardarbanco.setString(2, cuenta);
        guardarbanco.setString(3, fecha);
        guardarbanco.setString(4, detalle);
        guardarbanco.setDouble(5, monto);
        guardarbanco.setString(6, detalle);
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
   
}
