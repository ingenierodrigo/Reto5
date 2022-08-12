
package co.edu.utp.misiontic2022.c2.reto5.controlador;

import co.edu.utp.misiontic2022.c2.reto5.vista.FrmPrincipal;

// Clase controladora para iniciar FrmPrinicpal 
public class FrmControlador {
    
    // método estático que crea un nuevo objeto de FrmPrinipal
    // y permite visualizar la ventana
    public static void iniciarFrmPrincipal(){
        new FrmPrincipal().setVisible(true);
    } 
}
