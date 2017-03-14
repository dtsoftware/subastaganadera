/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Cheques;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    PreparedStatement cargar2;
    ResultSet rs2;
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
            
            Cheques.jLabelCliente.setText(rs2.getString("Nombre")+ "  " + rs2.getString("Apellido"));
           
             Cheques.jLabelCliente.requestFocus();
          
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
      public void imprimircheque2(Integer codigo){
       // JOptionPane.showMessageDialog(null,"Se Genero");
    conectar conect = new conectar(); 
    conect.conexion();
    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Eliga impresora:",
                "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[5]);       
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
                    params.put("codigo", codigo);
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
    
    

