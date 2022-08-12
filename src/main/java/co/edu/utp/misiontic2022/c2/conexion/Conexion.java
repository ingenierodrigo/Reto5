
package co.edu.utp.misiontic2022.c2.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Clase Conexion utilizando el patron Singleton
public class Conexion {
    
    // Atributos de clase para gestión de conexión con la base de datos
    private final String UBICACION_BD = "ProyectosConstruccion.db"; 
    private Connection conexion;
    private static Conexion instancia;
    
    // Método constructor privado
    private Conexion(){
        this.conexion=null;
    }
    
    //  Retorna conexión de la base de datos
    public Connection conectar() throws SQLException{
        try {
            String url = "jdbc:sqlite:" + UBICACION_BD;
            this.conexion=DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.conexion;
    }
    
    // Método para cerrar la conexión de la BD
    public void desconectar(){
        try {
            this.conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Rtorna una nueva instancia de la clase Conexion
    public synchronized static Conexion getInstancia(){
        if (instancia==null){
            instancia=new Conexion();
        }
        return instancia;
    }
}
