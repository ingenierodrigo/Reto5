
package co.edu.utp.misiontic2022.c2.reto5.model;

import co.edu.utp.misiontic2022.c2.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */


public class LiderDao {
    
    // Declarando Atributos
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    // Método constructor
    public LiderDao() {
        this.CON = Conexion.getInstancia();
    }
    // Retorna la lista de los registros que se obtiene 
    //de la consulta tabla lider de la BD.
    public List<LiderVo> obtenerRegistrosLideres()throws SQLException{
        List<LiderVo> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT ID_Lider, Nombre, Primer_Apellido, Segundo_Apellido, Ciudad_Residencia \n" +
            "FROM Lider ORDER BY Ciudad_Residencia ASC");
            rs=ps.executeQuery();
            while(rs.next()){
                LiderVo lider = new LiderVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                registros.add(lider);
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
