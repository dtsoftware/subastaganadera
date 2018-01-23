/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.Cheques;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sg.soft.Principal;

/**
 *
 * @author Juan
 */
public class Accesos {
    PreparedStatement cargar2,guardar,numerocheque, ActEdetalle, ActEdetalle2;
    ResultSet rs2,rscheque;
    Integer ultimocheque;
    
        public Accesos() { 
}
        
    public void buscaracceso(String id){
    conectar conect = new conectar(); 
    conect.conexion();
    try {
    String consulta; 
     // creamos la consulta
     consulta="SELECT  * From Accesos where Usuario ='"+ id +"'";
     //pasamos la consulta al preparestatement
    
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
     if (rs2.next()){
            
        if (rs2.getInt("MA01")==0){
                    Principal.MA01.setEnabled(false);
                } 
        if (rs2.getInt("MA02")==0){
                    Principal.MA02.setEnabled(false);
                } 
        if (rs2.getInt("MA03")==0){
                    Principal.MA03.setEnabled(false);
                } 
        if (rs2.getInt("MB01")==0){
                    Principal.MB01.setEnabled(false);
                } 
        if (rs2.getInt("MB02")==0){
                    Principal.MB02.setEnabled(false);
                } 
        if (rs2.getInt("MB03")==0){
                    Principal.MB03.setEnabled(false);
                } 
        if (rs2.getInt("MB04")==0){
                    Principal.MB04.setEnabled(false);
                } 
        if (rs2.getInt("MB05")==0){
                    Principal.MB05.setEnabled(false);
                } 
        if (rs2.getInt("MB06")==0){
                    Principal.MB06.setEnabled(false);
                } 
        if (rs2.getInt("MR01")==0){
                    Principal.MR01.setEnabled(false);
                } 
        if (rs2.getInt("MR02")==0){
                    Principal.MR02.setEnabled(false);
                } 
        if (rs2.getInt("MR03")==0){
                    Principal.MR03.setEnabled(false);
                } 
        if (rs2.getInt("MR04")==0){
                    Principal.MR04.setEnabled(false);
                } 
        if (rs2.getInt("MR05")==0){
                    Principal.MR05.setEnabled(false);
                } 
        if (rs2.getInt("MC01")==0){
                    Principal.MC01.setEnabled(false);
                } 
        if (rs2.getInt("BP01")==0){
                    Principal.BP01.setEnabled(false);
                } 
        if (rs2.getInt("BP02")==0){
                    Principal.BP02.setEnabled(false);
                } 
        if (rs2.getInt("BP03")==0){
                    Principal.BP03.setEnabled(false);
                } 
        if (rs2.getInt("BP04")==0){
                    Principal.BP04.setEnabled(false);
                } 
        if (rs2.getInt("BP05")==0){
                    Principal.BP05.setEnabled(false);
                } 
        if (rs2.getInt("BP06")==0){
                    Principal.BP06.setEnabled(false);
                } 
       
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
        
}
