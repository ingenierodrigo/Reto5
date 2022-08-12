
package co.edu.utp.misiontic2022.c2.reto5.model;

public class LiderVo {
    
    // Variables
    private Integer IdLider = 0;
    private String nombre;
    private String primerApellido; 
    private String segundoApellido; 
    private String ciudadResidencia;
    
    // Métodos Constructores
    public LiderVo() {
    }
    
    public LiderVo(Integer IdLider, String nombre, String primerApellido, String segundoApellido, String ciudadResidencia) {
        this.IdLider = IdLider;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.ciudadResidencia = ciudadResidencia;
    }
    // Métodos Getter
    public Integer getIdLider() {
        return IdLider;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }
}
