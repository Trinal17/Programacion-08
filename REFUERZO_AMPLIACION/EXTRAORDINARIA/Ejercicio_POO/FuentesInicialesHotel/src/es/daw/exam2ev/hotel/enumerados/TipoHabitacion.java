/**
 * SE PROPORCIONA LA CLASE COMPLETA
 * NO DEBES MODIFICARLA
 */

package es.daw.exam2ev.hotel.enumerados;

public enum TipoHabitacion {
    SINGLE(25),
    DOUBLE(50),
    SUITE(100);
    
    private int extra;
    
    private TipoHabitacion(int extra){
        this.extra = extra;
    }

    public int getExtra() {
        return extra;
    }
    
    
}
