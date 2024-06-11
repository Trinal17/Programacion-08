package es.daw.exam2ev.hotel.model.interfaces;

import es.daw.exam2ev.hotel.model.Habitacion;
import es.daw.exam2ev.hotel.excepciones.ReferenciaClienteNoEncontradaException;
import es.daw.exam2ev.hotel.model.Cliente;
import es.daw.exam2ev.hotel.model.ServicioSPA;
import java.util.ArrayList;

public interface Gestionable {

    //public ArrayList<Reservable> obtenerTodasLasReservas();

    public ArrayList<Habitacion> obtenerReservasHabitacionOrdenadasDeFormaNatural();
    
    public ArrayList<ServicioSPA> obtenerReservasServicioSPAOrdenadosPorReferenciaCliente();

    public ArrayList<Reservable> obtenerReservasPorReferenciaCliente(String referenciaCliente) throws ReferenciaClienteNoEncontradaException;
    
    public ArrayList<Habitacion> obtenerReservasHabitacionPorCliente(Cliente cliente);
    
    public String obtenerFacturaReservaPorPosicion(int posicion);

    
}
