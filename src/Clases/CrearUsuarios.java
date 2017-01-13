/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.BuscarU;
import Interfaces.Usuarios;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Juan
 */


public class CrearUsuarios {

    
    Connection conectar;
    PreparedStatement guardarusuario;
    String idusuario,nombre,apellido,clave,tipodeusuario,estado,telefono,celular,correo,direccion, ruta;
 PreparedStatement cargar,cargar2,cargar3,cargar4;
 ResultSet rs,rs2,rs4;
 DefaultTableModel tabla = new DefaultTableModel(); 
 Object[] filas = new Object[5]; 
    
    public CrearUsuarios(){
  
    }
    
    public void guardarusuario(){
    
        try {
                   
        idusuario=Usuarios.txtusuario.getText();
        nombre=Usuarios.txtnombre.getText();
        apellido=Usuarios.txtapellido.getText();
        clave=Usuarios.txtcontraseña.getText();
        tipodeusuario= Usuarios.cmb_tipousuario.getSelectedItem().toString();
        estado=Usuarios.cmb_estado.getSelectedItem().toString();
        telefono=Usuarios.txttelefono.getText();
        celular=Usuarios.txtcelular.getText();
        correo=Usuarios.txtcorreo.getText();
        direccion=Usuarios.txtdireccion.getText();
        if (!"".equals(Usuarios.txtrutaimagen.getText())){
        ruta=Usuarios.txtrutaimagen.getText();}
        if ("".equals(Usuarios.txtrutaimagen.getText()));{
        ruta = "C:\\Users\\Juan\\Documents\\NetBeansProjects\\SG-SOFT\\src\\Graficos\\Login.png";
        }
        
        conectar conexcio = new conectar(); 
        conexcio.conexion();
        FileInputStream archivofoto;
        guardarusuario=conexcio.con.prepareStatement("INSERT INTO usuarios (Usuario, Contraseña, Nombre, Apellido, Direccion, Correo, TipoUsuario, Telefono1, Telefono2, Estado, Foto, RutaImagen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        guardarusuario.setString(1, idusuario);
        guardarusuario.setString(2, clave);
        guardarusuario.setString(3, nombre);
        guardarusuario.setString(4, apellido);
        guardarusuario.setString(5, direccion);
        guardarusuario.setString(6, correo);
        guardarusuario.setString(7, tipodeusuario);
        guardarusuario.setString(8, telefono);
        guardarusuario.setString(9, celular);
        guardarusuario.setString(10, estado);
        archivofoto = new FileInputStream(ruta);
        guardarusuario.setBinaryStream(11, archivofoto);
        guardarusuario.setString(12, ruta);
        guardarusuario.execute();
        JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | FileNotFoundException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null,"El Registro No Se Logro Realizar Error:" +ex);
        }
        
    
    }
    public void buscarpornombre(String nombre){
     try {
         tabla = (DefaultTableModel) BuscarU.Tbl_usuarios.getModel();
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
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
     consulta="SELECT idUsuarios,Usuario, Nombre, Apellido, Direccion FROM Usuarios where Nombre LIKE'"+ nombre +"%' ORDER BY Nombre";
     //pasamos la consulta al preparestatement
     cargar=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     rs=cargar.executeQuery(consulta);
     //recorremos el resulset
    while (rs.next()){
        
                    filas[0]=rs.getInt("idUsuarios");
                    filas[1]=rs.getString("Usuario");
                    filas[2]=rs.getString("Nombre");
                    filas[3]=rs.getString("Apellido");
                    filas[4]=rs.getString("Direccion");
                                        
       tabla.addRow(filas);
    }
    rs.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
     }
    
     public void buscartodos(){
     try {
         tabla = (DefaultTableModel) BuscarU.Tbl_usuarios.getModel();
     String consulta;    
     conectar conect = new conectar(); 
                 conect.conexion();
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
     consulta="SELECT idUsuarios,Usuario, Nombre, Apellido, Direccion FROM Usuarios ORDER BY Nombre";
     //pasamos la consulta al preparestatement
     cargar=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
     rs=cargar.executeQuery(consulta);
     //recorremos el resulset
    while (rs.next()){
        
                    filas[0]=rs.getInt("idUsuarios");
                    filas[1]=rs.getString("Usuario");
                    filas[2]=rs.getString("Nombre");
                    filas[3]=rs.getString("Apellido");
                    filas[4]=rs.getString("Direccion");
                                        
       tabla.addRow(filas);
    }
    rs.close();
    conect.desconectar();
           
   }catch (Exception ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
     
     } 
    
      public void buscarparaeditar(Integer Codigo){
  try {
     String consulta;  
     conectar conect = new conectar(); 
     conect.conexion();
    
     
     // creamos la consulta
     consulta="SELECT * FROM Usuarios where idUsuarios ='"+ Codigo +"'";
     //pasamos la consulta al preparestatement
    
     cargar2=conect.con.prepareStatement(consulta,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     //pasamos al resulset la consulta preparada y ejecutamos
    
     rs2=cargar2.executeQuery(consulta);
           if (rs2.next()){

                            Usuarios.txtcodigo.setText(String.valueOf(rs2.getInt("idUsuarios")) );                
                            Usuarios.txtusuario.setText(rs2.getString("Usuario"));
                            Usuarios.txtcontraseña.setText(rs2.getString("Contraseña"));
                            Usuarios.txtnombre.setText(rs2.getString("Nombre"));
                            Usuarios.txtapellido.setText(rs2.getString("Apellido"));
                            Usuarios.txtdireccion.setText(rs2.getString("Direccion"));
                            Usuarios.txtcorreo.setText(rs2.getString("Correo"));
                            Usuarios.txttelefono.setText(rs2.getString("Telefono1"));
                            Usuarios.txtcelular.setText(rs2.getString("Telefono2"));
                            Usuarios.cmb_tipousuario.setSelectedItem(rs2.getString("TipoUsuario"));
                            Usuarios.cmb_estado.setSelectedItem(rs2.getString("Estado"));
                            //imagen pendiente 
                            Usuarios.jButton2.setEnabled(true);
                            Usuarios.btn_eliminar.setEnabled(true);
                            rs2.close();
                            conect.desconectar();
                          }
           else{
           JOptionPane.showMessageDialog(null,"No Hay Registros Para Mostrar"  ); 
           conect.desconectar();
               }
    
    
   }catch (SQLException ex){
   JOptionPane.showMessageDialog(null,"Error" +ex);
   }
  
  }
  
    }
