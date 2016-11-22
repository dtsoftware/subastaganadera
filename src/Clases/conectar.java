/*
 * Con esta clase nos conectamos a la base de datos
 */
package Clases;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Juan
 */
public class conectar {
    
private static String username="root";
private static String password="denver";
private static String database="sg-soft";
private static String url="jdbc:mysql://localhost/"+database;
public Connection con = null;
    
    //constructor de la clase
    public conectar(){
               
        }
    
    public Connection conexion(){
         try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(url,username,password);        
           JOptionPane.showMessageDialog(null,"conectado" ); 
        } catch (SQLException ex){
        JOptionPane.showMessageDialog(null,"Error de Conexcion" +ex);
        
        }catch (ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,"Error de Conexcion" +e);
        }
    return con;
    }
    
    public ResultSet SeleccionarUsuarios(){
       Connection cn = conexion();
       Statement st;
       ResultSet rs = null;
        try{
            st = cn.createStatement();
            rs = st.executeQuery("Select Usuario, Contraseña, Nombre, Apellido From usuarios");
        } catch (SQLException ex){
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return rs;
    }
    
    
    
    public void desconectar(){
    con=null;
    //JOptionPane.showMessageDialog(null,"desconectada"  );
    } 
}
