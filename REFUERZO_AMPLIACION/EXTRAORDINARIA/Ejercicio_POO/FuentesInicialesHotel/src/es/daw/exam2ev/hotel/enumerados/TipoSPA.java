/**
 * SE PROPORCIONA LA CLASE COMPLETA
 * NO DEBES MODIFICARLA
 */

package es.daw.exam2ev.hotel.enumerados;

public enum TipoSPA {
    BASICO(50),
    ESTANDAR(75),
    PREMIUN_BRONCE(100),
    PREMIUM_PLATA(125),
    PREMIUM_ORO(150);
    
    private int precio;
    
    private TipoSPA(int precio){
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
    
    
}
