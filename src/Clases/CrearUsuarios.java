/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.Usuarios;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Juan
 */
public class CrearUsuarios {
    Connection conectar;
    PreparedStatement guardarusuario;
    String idusuario,nombre,apellido,clave,tipodeusuario,estado,telefono,celular,correo,direccion, ruta;
    
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
  
}
