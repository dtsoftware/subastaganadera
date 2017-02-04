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
      ResultSet rs2, todos, todos2;
    PreparedStatement cargar2, cargar3, guardarrecibo, facturas, facturas2;
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
            String consulta1, consulta2;
                    Double STotal, GValor, SaldoI;
    
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
            if (Recibos.AFactura.isSelected()){
                
            
                if(!"0.0".equals(Recibos.saldo.getText()) && "CONTADO".equals(Recibos.Fact2.getText())){
                    JOptionPane.showMessageDialog(null, "LA FACTURA ES AL CONTADO, DEBE CANCELAR SU TOTALIDAD");
                     int filaseleccionada;
                    Recibos.txtCantidad.setText("");
                    filaseleccionada= Recibos.jTableFacturas.getSelectedRow();
                    if (filaseleccionada==-1){
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun registro");
                    }else{
                        DefaultTableModel modelotabla=(DefaultTableModel) Recibos.jTableFacturas.getModel();
                        String RIS =String.valueOf(modelotabla.getValueAt(filaseleccionada, 3));
                        Recibos.saldo.setText(RIS);
                    }
                    
                    
                    
                }else
                {
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

                    try {
                            if (tabla != null) {
                                while (tabla.getRowCount() > 0) {
                                    tabla.removeRow(0);
                                }
                            }
           
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,"Error" +ex);
                        }
                    
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
                    
                }
            }else{
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
                 
                    String Est1 = "POR PAGAR";
                    
                    SaldoI = Double.parseDouble(Recibos.txtCantidad.getText());
                    STotal = 0.00;
                    
                    consulta1="SELECT idFacturas, Fecha, Monto, Saldo, Tipo, Estado FROM facturas  where (CodCliente ='"+ codigocliente +"') and (Estado = '"+ Est1 +"') ORDER BY Fecha ASC";

                    facturas2=conect.con.prepareStatement(consulta1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    todos2=facturas2.executeQuery(consulta1);
      
                            while (todos2.next()){   
   
                                    redondear redon  = new redondear();
                                    GValor = redon.redondearDecimales(todos2.getDouble("Saldo")- SaldoI, 2);
                                    if(GValor<0){
                                        Est1 = "CANCELADO";
                                        SaldoI = GValor*(-1);
                                        STotal = 0.00;
                                    }else if(GValor==0){
                                        Est1 = "CANCELADO";
                                        STotal = 0.00;
                                        SaldoI = 0.00;                       
                                    }else{
                                        Est1 = "POR PAGAR";
                                        STotal = GValor;
                                        SaldoI = 0.00;
                                    }
                                    
                                    consulta2="UPDATE facturas SET Saldo =?,Estado=? WHERE idFacturas= ? ";

                                        cargar3=conect.con.prepareStatement(consulta2);
                                        cargar3.setDouble(1, STotal);
                                        cargar3.setString(2, Est1);
                                        cargar3.setInt(3, todos2.getInt("idFacturas"));
                                        cargar3.executeUpdate();                                       
                            }
            
                    todos2.close();
                    facturas2.close();
                    conect.desconectar();
            

                    try {
                            if (tabla != null) {
                                while (tabla.getRowCount() > 0) {
                                    tabla.removeRow(0);
                                }
                            }
           
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,"Error" +ex);
                        }
                    
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
            
            
            
            }
    
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
    redondear redon  = new redondear();
    Saldo = redon.redondearDecimales(Double.parseDouble(Recibos.saldo.getText()), 2);
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


