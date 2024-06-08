/**
 * SE PROPORCIONA COMPLETA
 * NO DEBES MODIFICARLA
 */

package es.daw.exam2ev.hotel.model.interfaces;

import es.daw.exam2ev.hotel.model.Habitacion;
import es.daw.exam2ev.hotel.excepciones.ReferenciaClienteNoEncontradaException;
import es.daw.exam2ev.hotel.model.Cliente;
import es.daw.exam2ev.hotel.model.ServicioSPA;
import java.util.ArrayList;

/**
 * SE PROPORCIONA LA CLASE COMPLETA
 * NO DEBES MODIFICARLA
 */

public interface Gestionable {
    
    /**
     * Método que devuelve una colección ArrayList solo de objetos Habitacion 
     * ordenados de forma natural
     * 
     * @return Colección de objetos Habitacion ordenados
     */
    public ArrayList<Habitacion> obtenerReservasHabitacionOrdenadasDeFormaNatural();
    
    /**
     * Método que devuelve una coleccion ArrayList solo de objetos ServicioSPA 
     * ordenador por referencia del cliente
     * 
     * @return colección de objetos ServicioSPA ordenados
     */
    public ArrayList<ServicioSPA> obtenerReservasServicioSPAOrdenadosPorReferenciaCliente();

    /**
     * Método que devuelve una colección ArrayList de todas las reservas (habitación y servicio de spa)
     * que tiene un cliente concreto buscando por referencia del cliente
     * En el caso de no encontrar al cliente por la referencia se lanzará una excepcion
     * 
     * @param referenciaCliente Cadena de texto con la referencia del cliente por la que buscar
     * @return Colección de reservas del cliente
     * @throws ReferenciaClienteNoEncontradaException En el caso de no encontrar el cliente
     */
    public ArrayList<Reservable> obtenerReservasPorReferenciaCliente(String referenciaCliente) throws ReferenciaClienteNoEncontradaException;
    
    /**
     * Método que devuelve una colección de ArrayList solo de objetos Habitacion
     * de un objeto cliente concreto
     * @param cliente Objeto cliente por el que buscar
     * @return Colección de objetos Habitacion del cliente
     */
    public ArrayList<Habitacion> obtenerReservasHabitacionPorCliente(Cliente cliente);
    
    /**
     * Método que devuelve la información de la factura
     * 
     * @param posicion Posicion de la reserva dentro de la colección de reservas
     * @return Cadena de texto con la información de la factura
     */
    public String obtenerFacturaReservaPorPosicion(int posicion);

    
}
