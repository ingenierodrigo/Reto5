
package co.edu.utp.misiontic2022.c2.reto5.model;

import co.edu.utp.misiontic2022.c2.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CompraDao {
    
    // Declarando Atributos
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    
    // Método constructor
    public CompraDao() {
        this.CON = Conexion.getInstancia();
    } 
    // Retorna la lista de los registros que se obtiene 
    //de la consulta tabla compras de la BD.
    public List<CompraVo> obtenerRegistrosCompras()throws SQLException{
        List<CompraVo> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT ID_Compra, Constructora, Banco_Vinculado, Proveedor, Ciudad \n" +
                                                 "FROM Compra c\n" +
                                                 "JOIN Proyecto p\n" +
                                                 "ON c.ID_Proyecto = p.ID_Proyecto\n" +
                                                 "WHERE Proveedor = 'Homecenter'\n" +
                                                 "AND Ciudad = 'Salento'");
            rs=ps.executeQuery();
            while(rs.next()){
                CompraVo compra = new CompraVo(rs.getInt(1), rs.getString(2), rs.getString(3), 
                                                  rs.getString(4), rs.getString(5));
                registros.add(compra);
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
