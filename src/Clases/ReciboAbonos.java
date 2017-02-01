/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.Entradas;
import Interfaces.Recibos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Juan
 */
public class ReciboAbonos {
     Object[] filas = new Object[6];
    Object[] filas1 = new Object[9];
      ResultSet rs2, todos;
    PreparedStatement cargar2, cargar3, guardarrecibo, facturas;
    DefaultTableModel tabla; 


public ReciboAbonos(){

}

public void buscarcliente(Integer Codigo){
    try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT idClientes,Cedula, Nombre, Apellido, Direccion FROM clientes where idClientes ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    ;
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){
            Recibos.txtBeneficiario.setText(rs2.getString("Nombre")+ " " + rs2.getString("Apellido"));         
            Recibos.cliente.setText(String.valueOf(rs2.getInt("idClientes")) );
      rs2.close();
    conect.desconectar();
           }else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
           conect.desconectar();
            }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
}

public void cargarfacturas(){
    
    try {
     DefaultTableModel tabla= (DefaultTableModel) Recibos.jTableFacturas.getModel();   
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();

      String codigo = Recibos.cliente.getText();         
      String Est = "POR PAGAR";
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
     consulta="SELECT idFacturas, Fecha, Monto, Saldo, Tipo, Estado FROM facturas  where (CodCliente ='"+ codigo +"') and (Estado = '"+ Est +"') ORDER BY Fecha ASC";
     //pasamos la consulta al preparestatement
     facturas=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     todos=facturas.executeQuery(consulta);
     //recorremos el resulset
    while (todos.next()){
        
                    filas[0]=todos.getInt("idFacturas");
                    filas[1]=todos.getString("Fecha");
                    filas[2]=todos.getDouble("Monto");
                    filas[3]=todos.getDouble("Saldo");
                    filas[4]=todos.getString("Tipo");
                    filas[5]=todos.getString("Estado");                    
       tabla.addRow(filas);
    }
    todos.close();
    facturas.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
    }

public void guardarrecibo(){
    try {
    DefaultTableModel tabla = (DefaultTableModel) Recibos.jTableFacturas.getModel();
    conectar conect = new conectar(); 
    conect.conexion();
    
    //-----obtener la fecha----------------------
      String  dia = Integer.toString(Recibos.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Recibos.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Recibos.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
         
               
    int codigo= Integer.parseInt(Recibos.recibo.getText());
    int codigocliente= Integer.parseInt(Recibos.cliente.getText());
    Double Monto =Double.parseDouble(Recibos.txtCantidad.getText());   
    String Tipo = String.valueOf(Recibos.tipo.getSelectedItem());
    String Concepto = Recibos.detalle.getText();    
    String Banco =String.valueOf(Recibos.banco.getSelectedItem());

  guardarrecibo=conect.con.prepareStatement("INSERT INTO recibos ( Codigo, Monto, CodCliente, Detalle, Fecha, Tipo, Banco) VALUES (?,?,?,?,?,?,?)");
  //este es duplicando el numero consultar a juan el uso del codigo
  guardarrecibo.setInt(1,codigo);
  guardarrecibo.setDouble(2, Monto);
  guardarrecibo.setInt(3, codigocliente);
  guardarrecibo.setString(4, Concepto);
  guardarrecibo.setString(5, fecha);
  guardarrecibo.setString(6, Tipo);
  guardarrecibo.setString(7, Banco);
  guardarrecibo.execute();

  ActualizarSaldo();  
    //-------------------hasta aki guardo en detallesventa-------------//
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
    Recibos.recibo.setText("");
    Recibos.cliente.setText("");
    Recibos.txtCantidad.setText("");
    Recibos.detalle.setText("");
    Recibos.saldo.setText("");
    Recibos.txtBeneficiario.setText("");
    Recibos.Suma.setText("");

     JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
    
    guardarrecibo.close();
    conect.desconectar();
    
        }catch(SQLException ex){
           
        JOptionPane.showMessageDialog(null, "Error" + ex);
        
        }
     }

    public void ActualizarSaldo()
    {
    try {
        String consulta;  
        conectar conect = new conectar(); 
        conect.conexion();  
        String Estado;
        Double Saldo;
        Integer idFactura;
        
        if (Double.parseDouble(Recibos.saldo.getText()) == 0.00)
        {
            Estado = "CANCELADO";
        }else{
            Estado = "POR PAGAR";
        }
    
    Saldo = Double.parseDouble(Recibos.saldo.getText());
    idFactura  = Integer.parseInt(Recibos.Fact.getText());

    consulta="UPDATE facturas SET Saldo =?,Estado=? WHERE idFacturas= ? ";

    cargar3=conect.con.prepareStatement(consulta);
    cargar3.setDouble(1, Saldo);
    cargar3.setString(2, Estado);
    cargar3.setInt(3, idFactura);
    cargar3.executeUpdate();  
    
    conect.desconectar(); 

        }catch(SQLException ex){
            
       JOptionPane.showMessageDialog(null,"Error" +ex);  
        
        }
       
    }
        

}


