
package co.edu.utp.misiontic2022.c2.reto5.controlador;

import co.edu.utp.misiontic2022.c2.reto5.model.CompraDao;
import co.edu.utp.misiontic2022.c2.reto5.model.CompraVo;
import co.edu.utp.misiontic2022.c2.reto5.model.LiderDao;
import co.edu.utp.misiontic2022.c2.reto5.model.LiderVo;
import co.edu.utp.misiontic2022.c2.reto5.model.ProyectoDao;
import co.edu.utp.misiontic2022.c2.reto5.model.ProyectoVo;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class ModeloControlador {
    // Atributos Daos
    private static LiderDao lDao;
    private static ProyectoDao pDao;
    private static CompraDao cDao;
   
    // Atributo de tipo DefaultTableModel
    private DefaultTableModel modeloTabla;

    public ModeloControlador() {
        lDao = new LiderDao();
        pDao = new ProyectoDao();
        cDao = new CompraDao(); 
    }
    
    // Retorna el modelo de la tabla con los registros respectivos al lider
    public DefaultTableModel modeloTablaLideres() {

        String[] titulos = {"Id", "Nombres", "Primer Apellido", "Segundo Apallido", "Ciudad Residencia"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String[] registro = new String[5];
        try {
            for (LiderVo item : lDao.obtenerRegistrosLideres()) {
                registro[0] = Integer.toString(item.getIdLider());
                registro[1] = item.getNombre();
                registro[2] = item.getPrimerApellido();
                registro[3] = item.getSegundoApellido();
                registro[4] = item.getCiudadResidencia();
                modeloTabla.addRow(registro);
            }
        } catch (SQLException ex) {
        }

        return modeloTabla;
    }
    
    // Retorna el modelo de la tabla con los registros respectivos al proyecto
    public DefaultTableModel modeloTablaProyectos() {
        
        String[] titulos = {"Id", "Constructora", "Numero Habitaciones", "Ciudad"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        String[] registro = new String[4];
        try {
            for (ProyectoVo item : pDao.obtenerRegistrosProyectos()) {
                registro[0] = Integer.toString(item.getIdProyecto());
                registro[1] = item.getConstructora();
                registro[2] = item.getNumeroHabitaciones().toString();
                registro[3] = item.getCiudad();
                this.modeloTabla.addRow(registro);
            }
        } catch (SQLException ex) {
        }

        return this.modeloTabla;
    }
    
    // Retorna el modelo de la tabla con los registros respectivos a la compra
    public DefaultTableModel modeloTablaCompras() {

        String[] titulos = {"Id", "Constructora", "Banco Vinculado", "Proveedor", "Ciudad"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        String[] registro = new String[5];
        try {
            for (CompraVo item : cDao.obtenerRegistrosCompras()) {
                registro[0] = Integer.toString(item.getIdCompra());
                registro[1] = item.getConstructora();
                registro[2] = item.getBancoVinculado();
                registro[3] = item.getProveedor();
                registro[4] = item.getCiudad();
                this.modeloTabla.addRow(registro);
            }
        } catch (SQLException ex) {
        }
        return this.modeloTabla;
    }
    
    // Retorna el objeto de la clase DefaultTableModel
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
