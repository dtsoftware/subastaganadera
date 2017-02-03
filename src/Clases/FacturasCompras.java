/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Facturacion;
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
public class FacturasCompras {
    Object[] filas = new Object[6];
    Object[] filas1 = new Object[9];
    ResultSet rs1, rs2, rs3, rs4, rs5,  todos;
    PreparedStatement cargar2, cargar3, cargar4, cargar5, factmax, guardarrecibo, facturas;
    DefaultTableModel tabla;    
    
    
    public FacturasCompras(){
    }
    
    
    public void buscarcliente(Integer Codigo){
    try {
     String consulta, consulta1, consulta2, consulta3;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     //-----obtener la fecha----------------------
      String  dia = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
     
     String Estado="Subastado";
     
     // creamos la consulta
     consulta="SELECT idClientes,Cedula, Nombre, Apellido, Direccion FROM clientes where idClientes ='"+ Codigo +"'";
     consulta1="SELECT COUNT(Sexo) As 'MACHOS' FROM entrada_detalle Where Sexo = '"+"MACHO"+"' And Estado = '"+Estado+"' And idComprador = '"+Codigo+"' And Fecha = '"+fecha+"'";
     consulta2="SELECT COUNT(Sexo) As 'HEMBRAS' FROM entrada_detalle Where Sexo = '"+"HEMBRA"+"' And Estado = '"+Estado+"' And idComprador = '"+Codigo+"' And Fecha = '"+fecha+"'";
     
     //pasamos la consulta al preparestatement
    
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     cargar3=conect.con.prepareStatement(consulta1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     cargar4=conect.con.prepareStatement(consulta2,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs1=cargar2.executeQuery(consulta);
     rs2=cargar3.executeQuery(consulta1);
     rs3=cargar4.executeQuery(consulta2);
           if (rs1.next()){               
                Facturacion.idcomprador.setText(rs1.getString("idClientes"));   
                Facturacion.txtnombre.setText(rs1.getString("Nombre"));         
                Facturacion.txtapellido.setText(rs1.getString("Apellido"));  
                Facturacion.txtcedula.setText(rs1.getString("Cedula"));  
                Facturacion.txtdireccion.setText(rs1.getString("Direccion"));  
                
                
                if (rs2.next()){               
                    Facturacion.txtmachos.setText(rs2.getString("MACHOS"));    
                }else{
                    JOptionPane.showMessageDialog(null,"Error De Conteo de Machos"  ); 
                    conect.desconectar();
                }
    
                if (rs3.next()){               
                    Facturacion.txthembras.setText(rs3.getString("HEMBRAS"));    
                }else{
                    JOptionPane.showMessageDialog(null,"Error De Conteo de Hembras"  ); 
                    conect.desconectar();
                }
               
                    int ID=Integer.parseInt(rs1.getString("idClientes"));
                    consulta3="SELECT Precio, Peso FROM entrada_detalle Where Estado = '"+Estado+"' And idComprador = '"+ID+"' And Fecha ='"+fecha+"'";
                    cargar5=conect.con.prepareStatement(consulta3,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs4=cargar5.executeQuery(consulta3);
                Double MTotal, NuevoValor;
                MTotal = (0.00);
                 redondear redon  = new redondear();
                while (rs4.next()){
                // if (rs4.next()){
                     
                    NuevoValor = redon.redondearDecimales((rs4.getDouble("Precio")*rs4.getDouble("Peso")), 2);
                    
                    MTotal = redon.redondearDecimales(MTotal + NuevoValor, 2);
               // }else{
                  //  JOptionPane.showMessageDialog(null,"No Hay Facturas Por Completar Para Este Cliente"  );
                //    conect.desconectar();
                //}
                }
                    Facturacion.txtmonto.setText(""+MTotal); 

                    int H= Integer.parseInt(rs3.getString("HEMBRAS"));
                    int M= Integer.parseInt(rs2.getString("MACHOS"));
                    int Final= (H+M);
                    Facturacion.txttotal.setText(""+Integer.valueOf(Final));
                    rs1.close();
                    rs2.close();
                    rs3.close();
                    rs4.close(); 
                
                conect.desconectar();
                
           }else{
                JOptionPane.showMessageDialog(null,"Este Numero De Cliente No Existe"  ); 
                conect.desconectar();
           }
    
           
           
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
}

    
public void BuscarUltFact(){
    try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
     
     // creamos la consulta
     consulta="SELECT MAX(idFacturas) AS 'Ultimo' FROM facturas";
   
     //pasamos la consulta al preparestatement
    
     factmax=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    
     rs5=factmax.executeQuery(consulta);

           if (rs5.next()){               
 
                int Ultimo= Integer.parseInt(rs5.getString("Ultimo"));
                int FactProx= (Ultimo + 1);
                Facturacion.NumFactura.setText(""+Integer.valueOf(FactProx));
           }else{
                JOptionPane.showMessageDialog(null,"Error en Numeracion de Facturas"  ); 
                conect.desconectar();
           }

                rs5.close(); 
                factmax.close();
                
                conect.desconectar();
           
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
    
}    
    
public void guardarfactura(){    
      try {
          
    DefaultTableModel tabla = (DefaultTableModel) Facturacion.jTableAnimalesVendidos.getModel();
    conectar conect = new conectar(); 
    conect.conexion();

    //-----obtener la fecha----------------------
      String  dia = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
      String  mes = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.MONTH) + 1);
      String year = Integer.toString(Facturacion.jDateChooserFecha.getCalendar().get(Calendar.YEAR));
      String fecha = (year + "-" + mes+ "-" + dia);         
     //---------fin de obtener la fecha
         
               
    int codigo= Integer.parseInt(Facturacion.NumFactura.getText());
    int codigocliente= Integer.parseInt(Facturacion.idcomprador.getText());
    redondear redon  = new redondear();
    Double Monto = redon.redondearDecimales(Double.parseDouble(Facturacion.txtmonto.getText()), 2);
    String Tipo = String.valueOf(Facturacion.tipo.getSelectedItem());
    String Estado = "POR PAGAR";    

  facturas=conect.con.prepareStatement("INSERT INTO facturas ( idFacturas, Monto, CodCliente, Saldo, Fecha, Tipo, Estado) VALUES (?,?,?,?,?,?,?)");
  //este es duplicando el numero consultar a juan el uso del codigo

  facturas.setInt(1,codigo);
  facturas.setDouble(2, Monto);
  facturas.setInt(3, codigocliente);
  facturas.setDouble(4, Monto);
  facturas.setString(5, fecha);
  facturas.setString(6, Tipo);
  facturas.setString(7, Estado);
  facturas.execute();
  
  
    
    facturas.close();
    conect.desconectar();
    
        }catch(SQLException ex){
           
        JOptionPane.showMessageDialog(null, "Error" + ex);
        
        }
     }

  public void LimpiarCampos()
    {
        Facturacion.txthembras.setText("");
        Facturacion.txtlote.setText("");
        Facturacion.txtmonto.setText("");
        Facturacion.txttotal.setText("");
        Facturacion.txtnombre.setText("");
        Facturacion.txtapellido.setText("");
        Facturacion.txtcedula.setText("");
        Facturacion.txtdireccion.setText("");
        Facturacion.idcomprador.setText("");
        Facturacion.txtmachos.setText("");       
    }
}
