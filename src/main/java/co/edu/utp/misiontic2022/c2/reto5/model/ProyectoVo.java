
package co.edu.utp.misiontic2022.c2.reto5.model;

public class ProyectoVo {
     // Variables
    private Integer IdProyecto;
    private String constructora;
    private Integer numeroHabitaciones;
    private String ciudad;
    
    // Métodos Constructor
    public ProyectoVo(Integer IdProyecto, String constructora, Integer numeroHabitaciones, String ciudad) {
        this.IdProyecto = IdProyecto;
        this.constructora = constructora;
        this.numeroHabitaciones = numeroHabitaciones;
        this.ciudad = ciudad;
    }
    // Métodos Getter
    public Integer getIdProyecto() {
        return IdProyecto;
    }

    public String getConstructora() {
        return constructora;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    
}
