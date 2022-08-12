
package co.edu.utp.misiontic2022.c2.reto5.model;

import co.edu.utp.misiontic2022.c2.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProyectoDao {
    // Declarando Atributos
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    // Método constructor
    public ProyectoDao() {
        this.CON = Conexion.getInstancia();
    }
    // Retorna la lista de los registros que se obtiene 
    //de la consulta tabla proyectos de la BD.
    public List<ProyectoVo> obtenerRegistrosProyectos()throws SQLException{
        List<ProyectoVo> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad\n" 
                    + "FROM Proyecto \n"
                    + "WHERE Clasificacion = 'Casa Campestre'\n"
                    + "and Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')");
            rs=ps.executeQuery();
            while(rs.next()){
                ProyectoVo proyecto = new ProyectoVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                registros.add(proyecto);
            }
            ps.close();
            rs.close();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
}
