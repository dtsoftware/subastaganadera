/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.EstadisticaGeneral;
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
public class Estadistica {
    PreparedStatement guardarbanco, UltimoRg, cargar;
    ResultSet aux, rs, aux1, rsdeposito; 
    
     public Estadistica() { 
}
     
     public void extraerregistros(){
         try {
            String consulta1, consulta2, consulta3, consulta4, consulta5, consulta6 = null;  
            conectar conect = new conectar(); 
            conect.conexion();
            
            
            String  dia = Integer.toString(EstadisticaGeneral.jDateChooserFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH));
            String  mes = Integer.toString(EstadisticaGeneral.jDateChooserFechaInicio.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(EstadisticaGeneral.jDateChooserFechaInicio.getCalendar().get(Calendar.YEAR));
            String  fechainicio = (year + "-" + mes+ "-" + dia);
            //---------fin de obtener la fecha
            //-----obtener la fecha----------------------
            String  diaf = Integer.toString(EstadisticaGeneral.jDateChooserFechaFin.getCalendar().get(Calendar.DAY_OF_MONTH));
            String  mesf = Integer.toString(EstadisticaGeneral.jDateChooserFechaFin.getCalendar().get(Calendar.MONTH) + 1);
            String yearf = Integer.toString(EstadisticaGeneral.jDateChooserFechaFin.getCalendar().get(Calendar.YEAR));
            String  fechafin = (yearf + "-" + mesf+ "-" + diaf);
            
            // creamos la consulta
            
            // MONTO Y CANTIDAD DE CHEQUES IMPRESOS
            consulta1="SELECT COUNT(Numero) AS 'Cantidad', SUM(Monto) AS 'Monto' FROM cheques where Fecha = '"+fechainicio+"'";
            
            Double MontoCH=0.00;
            Integer CantidadCH;
            
                        UltimoRg=conect.con.prepareStatement(consulta1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
                        aux=UltimoRg.executeQuery(consulta1);

                        while(aux.next()){                  
                                MontoCH = (aux.getDouble("Monto")); 
                                CantidadCH = (aux.getInt("Cantidad")); 
                        }
            
            // MONTO DE OTROS INGRESOS DE CAJA
            consulta2="SELECT SUM(Monto) AS 'Monto' FROM registroscaja Where Fecha = '"+fechainicio+"' AND Tipo = 'INGRESO';";
            
            Double MontoING=0.00;
            
                        UltimoRg=conect.con.prepareStatement(consulta2,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
                        aux=UltimoRg.executeQuery(consulta2);

                        while(aux.next()){                  
                                MontoING = (aux.getDouble("Monto"));   
                        }
            
            // MONTO DE GASTOS DE CAJA
            consulta3="SELECT SUM(Monto) AS 'Monto' FROM registroscaja Where Fecha = '"+fechainicio+"' AND Tipo = 'GASTO';";
            
            Double MontoGAS=0.00;
            
                        UltimoRg=conect.con.prepareStatement(consulta3,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
                        aux=UltimoRg.executeQuery(consulta3);

                        while(aux.next()){                  
                                MontoGAS = (aux.getDouble("Monto"));   
                        }
            
            // TODOS LAS FACTURAS DEL DIA DE AQUI SACAMOS (TOTAL  DE TRANSACCIONES, CONTADOS Y CREDITOS, HEMBRAS, MACHOS, TERNEROS
            consulta4="SELECT * FROM facturas Where Fecha = '"+fechainicio+"'";
            
            Integer CantTA=0, CantAM=0, CantAH=0, CantAT=0;
            Double  PromM=0.00, PromH=0.00, MontoFacts=0.00, MontoCONT=0.00, MontoCRED=0.00, Diferencia=0.00, PromMF=0.00, PromHF=0.00;
            
                        UltimoRg=conect.con.prepareStatement(consulta4,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
                        aux=UltimoRg.executeQuery(consulta4);

                        while(aux.next()){                  
                              
                            CantTA = CantTA + 1;
                            CantAM = CantAM + (aux.getInt("TotalMachos"));
                            CantAH = CantAH + (aux.getInt("TotalHembras"));
                            CantAT = CantAT + (aux.getInt("TotalTerneros"))+(aux.getInt("TotalTerneras"));   
                            
                            PromM = PromM + (aux.getDouble("PPromMachos"));
                            PromH = PromH + (aux.getDouble("PPromHembrass"));
                            MontoFacts = MontoFacts + (aux.getDouble("Monto")); 
                            
                            if ("CONTADO".equals(aux.getString("Tipo"))){
                                MontoCONT = MontoCONT + (aux.getDouble("Monto"));
                            }else{
                                MontoCRED = MontoCRED + (aux.getDouble("Monto"));
                            }
                            
                            
                        }
                        
                        Diferencia = MontoFacts - MontoCH;
            
            // COMPLEMENTAR DATOS
            consulta5="SELECT * FROM entrada_detalle WHERE Fecha = '"+fechainicio+"' AND Estado = '"+"Completado"+"'";

                        UltimoRg=conect.con.prepareStatement(consulta5,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
                        aux=UltimoRg.executeQuery(consulta5);

                        while(aux.next()){                  
                               
                        }
           
            // COMPLEMENTAR DATOS
            consulta5="SELECT SUM(MontoTotal) AS 'Total', SUM(MontoEfectivo) AS 'Efectivo', SUM(MontoCheque) AS 'Cheque) FROM recibos WHERE Fecha = '"+fechainicio+"'";
            
            Double ReciboTotal, ReciboEfectivo, ReciboCheque;
            
                        UltimoRg=conect.con.prepareStatement(consulta6,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);     
                        aux=UltimoRg.executeQuery(consulta6);

                        while(aux.next()){                  
                                ReciboTotal = (aux.getDouble("Total"));  
                                ReciboEfectivo = (aux.getDouble("Efectivo"));  
                                ReciboCheque = (aux.getDouble("Cheque"));  
                        }
            
            
        guardarbanco=conect.con.prepareStatement("INSERT INTO caja (idCaja, Fecha, MontoActual, MontoInicial, Detalle, Nombre, Estado) VALUES (?,?,?,?,?,?,?)");
      //  guardarbanco.setInt(1, idcaja);
     //   guardarbanco.setString(2, fecha);
      //  guardarbanco.setDouble(3, montoa);
     //   guardarbanco.setDouble(4, montoi);
     //   guardarbanco.setString(5, detalle);
      //  guardarbanco.setString(6, Nombre);
      //  guardarbanco.setString(7, Estado);
        guardarbanco.execute();
        JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
    
            
            
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error" +ex);
        }
    
     }
}
