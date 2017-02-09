/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Proveedor;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class CrearProvedor {
   PreparedStatement guardarbanco, UltimoRg, cargar;
    String idproveedor,nombre,Dv,Direccion,Ruc, Telefono01, Telefono02, Email, estado;
    Double montoi, montoa;
    ResultSet aux, rs;

    public CrearProvedor() {
    
}
  
    
    public void guardarproveedor(){
    
        try {
            
        Calendar c1 = Calendar.getInstance();
        String  dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
        String  mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String year = Integer.toString(c1.get(Calendar.YEAR));
        String fecha = (year + "-" + mes+ "-" + dia); 
        
        idproveedor=Proveedor.codigo.getText();
        nombre=Proveedor.nombre.getText();
        Dv=Proveedor.dv.getText();
        Direccion= Proveedor.direccion.getText();
        estado=Proveedor.estado.getSelectedItem().toString();
        Email=Proveedor.email.getText();
        Ruc=Proveedor.ruc.getText();
        Telefono01=Proveedor.tel01.getText();
        Telefono02=Proveedor.tel02.getText();
       
        conectar conexcio = new conectar(); 
        conexcio.conexion();

        guardarbanco=conexcio.con.prepareStatement("INSERT INTO proveedor (idProveedor, Fecha, Nombre, Ruc, Dv, Telefono1, Telefono2, Direccion, Email, Estado) VALUES (?,?,?,?,?,?,?,?,?,?)");
        guardarbanco.setString(1, idproveedor);
        guardarbanco.setString(2, fecha);
        guardarbanco.setString(3, nombre);
        guardarbanco.setString(4, Ruc);
        guardarbanco.setString(5, Dv);
        guardarbanco.setString(6, Telefono01);
        guardarbanco.setString(7, Telefono02);
        guardarbanco.setString(8, Direccion);
        guardarbanco.setString(9, Email);
        guardarbanco.setString(10, estado);
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
     consulta="SELECT MAX(idProveedor) AS 'Ultimo' FROM proveedor";
   
     //pasamos la consulta al preparestatement
    
     UltimoRg=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    
     aux=UltimoRg.executeQuery(consulta);

           if (aux.next()){               
 
                int Ultimo= Integer.parseInt(aux.getString("Ultimo"));
                int URG= (Ultimo + 1);
                Proveedor.codigo.setText(""+URG);
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
    
public void eliminarproveedor(Integer Codigo){
  try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    // creamos la consulta
     consulta="DELETE FROM proveedor where idProveedor = ?";
     //pasamos la consulta al preparestatement
     cargar=conect.con.prepareStatement(consulta);
     //pasamos al resulset la consulta preparada y ejecutamos
     cargar.setInt(1, Codigo);  
     cargar.execute();
    conect.desconectar();          
    JOptionPane.showMessageDialog(null,"Registro Eliminado Satisfactoriamente");
    Proveedor.editar.setEnabled(false);
    Proveedor.eliminar.setEnabled(false);
    Date date = new Date();
            Proveedor.fecha.setDate(date);
            Proveedor.direccion.setText("");
            Proveedor.nombre.setText("");
            Proveedor.ruc.setText("");
            Proveedor.dv.setText("");
            Proveedor.tel01.setText("");
            Proveedor.tel02.setText("");
            Proveedor.email.setText("");
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
  
  
  }    
}
