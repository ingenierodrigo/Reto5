
package co.edu.utp.misiontic2022.c2.reto5.model;

public class CompraVo {
    
    // Variables
    private Integer IdCompra;
    private String constructora;
    private String bancoVinculado;
    private String proveedor;
    private String ciudad;
    
    // Constructor
    public CompraVo(Integer IdCompra, String constructora, String bancoVinculado, String proveedor, String ciudad) {
        this.IdCompra = IdCompra;
        this.constructora = constructora;
        this.bancoVinculado = bancoVinculado;
        this.proveedor = proveedor;
        this.ciudad = ciudad;
    }
    
    // Métodos Getter
    public Integer getIdCompra() {
        return IdCompra;
    }

    public String getConstructora() {
        return constructora;
    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getCiudad() {
        return ciudad;
    }

}
