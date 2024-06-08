/**
 * SE PROPORCIONA COMPLETA
 * NO DEBES MODIFICARLA
 */

package es.daw.exam2ev.hotel.model.interfaces;

public interface Reservable {
    
    /**
     * Método que devolverá como cadena de texto la factura de la reserva
     * @return 
     */
    public String obtenerFacturaReserva();

    /**
     * Método que devolverá el precio final de la reserva
     * @return 
     */
    public int calcularPrecioReserva();
    
}
