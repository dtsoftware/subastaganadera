/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Cheques;
import Interfaces.Clientes;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tserng
 */
public class Cheque {
    PreparedStatement cargar2,guardar,numerocheque;
    ResultSet rs2,rscheque;
    Integer ultimocheque;
    public Cheque(){}
    
    public void buscarcliente(Integer Codigo){
    conectar conect = new conectar(); 
    conect.conexion();
    try {
    String consulta; 
     // creamos la consulta
     consulta="SELECT  Nombre, Apellido FROM clientes where idClientes ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){
            
            Cheques.Beneficiario.setText(rs2.getString("Nombre")+ "  " + rs2.getString("Apellido"));
           
            Cheques.txtmonto.requestFocus();
          
            //imagen pendiente 
       
    rs2.close();
    cargar2.close();
    conect.desconectar();
           }else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
            rs2.close();
            cargar2.close();
           conect.desconectar();
            }
    }catch (SQLException ex){
    conect.desconectar();   
   JOptionPane.showMessageDialog(null,"Error" +ex.getMessage());
   }
    
    }
    
  
    public void imprimircheque(Integer codigo){
       // JOptionPane.showMessageDialog(null,"Se Genero");
    conectar conect = new conectar(); 
    conect.conexion();
       PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
       
       //JOptionPane.showMessageDialog(null,"Se Genero en la " + printService);
        if( printService!= null)//si existen impresoras
        {
                     try {
                    JasperReport jasperReport;
                    JasperPrint jasperPrint;
                    Map<String, Object> params = new HashMap<String, Object>();
                    String  ruta="C:\\SG-SOFT\\subastaganadera\\src\\ReportesSG\\" +  "Chequeimprimir.jrxml";  
                    jasperReport =JasperCompileManager.compileReport(ruta);
                    params.put("codigo", codigo);
                  //se procesa el archivo jasper
                 
                  jasperPrint = JasperFillManager.fillReport(jasperReport, params, conect.con);
                  //JasperViewer.viewReport(jasperPrint, false);
                   //se manda a la impresora
                   JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                   jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint );
                   //jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService );
                   jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
                   jrprintServiceExporter.exportReport();
                  
                //JOptionPane.showMessageDialog(null,"Se Genero en la " + printService);
                 } catch (Exception ex) {
                    System.err.println("Error JRException: " + ex.getMessage());
                 }
                              
            }else {
               JOptionPane.showMessageDialog(null,"no hay impresora");
           }
        }
    
    public Integer buscarultimocheque(){
    
     conectar conect = new conectar(); 
                 conect.conexion();
         try {
     String consulta; 
                      
     // creamos la consulta
     consulta="SELECT MAX(Numero) FROM cheques ";
     //pasamos la consulta al preparestatement
   numerocheque=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    rscheque=numerocheque.executeQuery(consulta);
     //recorremos el resulset
    rscheque.next();
        
               ultimocheque=rscheque.getInt(1)+1;
          //Entradas.jTextFieldTotalMachos.setText(totalmachos.toString());
  
   
           
   }catch (SQLException ex1){
   JOptionPane.showMessageDialog(null,"Error" +ex1.getMessage());
   }finally{
         try {
             numerocheque.close();
             rscheque.close();
             conect.desconectar();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error" +ex.getMessage());
         }
   
     }   
    return ultimocheque;
    }
    
      public void guardarcheque(String numero,String beneficiario, Double monto,String fecha,String montoletras,String observacion, String CuentaB, String Tipo, String a1,String a2,String a3,String a4,String m1,String m2,String d1,String d2) throws SQLException{
                 conectar conect = new conectar(); 
                 conect.conexion();
          try {
          String Estado = "Impreso";     
            guardar=conect.con.prepareStatement("INSERT INTO cheques (Numero,Beneficiario,Monto,Fecha,montoletras,observacion,Cuenta,Estado,Tipo,a1,a2,a3,a4,m1,m2,d1,d2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            guardar.setString(1, numero);
            guardar.setString(2, beneficiario);
            guardar.setDouble(3, monto);
            guardar.setString(4, fecha);
            guardar.setString(5, montoletras);
            guardar.setString(6, observacion);
            guardar.setString(7, CuentaB);
            guardar.setString(8, Estado);
            guardar.setString(9, Tipo);
            guardar.setString(10, a1);
            guardar.setString(11, a2);
            guardar.setString(12, a3);
            guardar.setString(13, a4);
            guardar.setString(14, m1);
            guardar.setString(15, m2);
            guardar.setString(16, d1);
            guardar.setString(17, d2);
            guardar.execute();
            JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente");
            Cheque ch = new Cheque();
            ch.imprimircheque2(numero);
            
          
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"El Registro No Se Logro Realizar Error:" +ex.getMessage());
                
            }finally{
           guardar.close();
           conect.desconectar();
          }
      }
       public void imprimircheque2(String ncheque){
    // JOptionPane.showMessageDialog(null,"Se Genero");
    conectar conect = new conectar(); 
    conect.conexion();
    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Eliga impresora:",
                "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[1]);       
       //JOptionPane.showMessageDialog(null,"Se Genero en la66 " + printService);
       // PrinterJob job = PrinterJob.getPrinterJob();
    if( impresora!= null)//si existen impresoras
        {           
                      try {
                   
                    JasperReport jasperReport;
                    JasperPrint jasperPrint;
                
                     Map<String, Object> params = new HashMap<String, Object>();
                    String  ruta="C:\\SG-SOFT\\subastaganadera\\src\\ReportesSG\\" +  "Chequeimprimir.jrxml";  
                    jasperReport =JasperCompileManager.compileReport(ruta);
                    params.put("ncheque", ncheque);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, params, conect.con);
                  //JasperViewer.viewReport(jasperPrint, false);
                   //se manda a la impresora
                   JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                   jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint );
                   jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
                   //jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                   jrprintServiceExporter.exportReport();
                  
                JOptionPane.showMessageDialog(null,"Se Genero en la " + impresora);
                 } catch (Exception ex) {
                    System.err.println("Error JRException: " + ex.getMessage());
                 }
                              
            }else {
               JOptionPane.showMessageDialog(null,"El Proceso Ha Sido Cancelado O no Hay Impresoras Instaladas");
           }
        }
    }
    
    

