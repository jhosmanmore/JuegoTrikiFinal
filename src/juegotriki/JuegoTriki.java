
package juegotriki;

/**
 *
 * @author JhosmanM
 */
public class JuegoTriki {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Ventana vista = new Ventana();
        Modelo model = new Modelo();
        
        Acciones acciones = new Acciones(vista, model);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
}
