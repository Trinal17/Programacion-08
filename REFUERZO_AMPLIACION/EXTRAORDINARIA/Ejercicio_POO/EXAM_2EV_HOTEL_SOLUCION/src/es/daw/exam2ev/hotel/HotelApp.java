package es.daw.exam2ev.hotel;

import es.daw.exam2ev.hotel.dao.ReservasDAO;
import es.daw.exam2ev.hotel.excepciones.ReferenciaClienteNoEncontradaException;
import es.daw.exam2ev.hotel.model.Cliente;
import java.util.ArrayList;
import es.daw.exam2ev.hotel.model.Hotel;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;

public class HotelApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ------------------------------------------
        //CARGAR RESERVAS DEL DAO y CREACIÓN DEL HOTEL
        ReservasDAO dao = new ReservasDAO();
        
        ArrayList<Reservable> reservas = dao.select();
        
        Hotel hotel = new Hotel(dao.select());
        // ------------------------------------------
        
        // 
        System.out.println("\n* 1. LISTADO DE LAS RESERVAS DE HABITACIÓN ORDENADAS DE FORMA NATURAL:\n");
        hotel.obtenerReservasHabitacionOrdenadasDeFormaNatural().forEach(System.out::println);

        System.out.println("\n* 2. LISTADO DE LAS RESERVAS DE SPA ORDENADAS POR REFERENCIA DEL CLIENTE:\n");
        hotel.obtenerReservasServicioSPAOrdenadosPorReferenciaCliente().forEach(System.out::println);

        System.out.println("\n* 3.1 LISTADO DE RESERVAS POR REFERENCIA DEL CLIENTE (probando con NH000001):\n");
        try {
            hotel.obtenerReservasPorReferenciaCliente("NH000001").forEach(System.out::println);
        } catch (ReferenciaClienteNoEncontradaException ex) {
            ex.getMessage();
        }

        System.out.println("\n* 3.2 LISTADO DE RESERVAS POR REFERENCIA DEL CLIENTE (probando con KK000001):\n");
        try {
            hotel.obtenerReservasPorReferenciaCliente("KK000001").forEach(System.out::println);
        } catch (ReferenciaClienteNoEncontradaException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println("\n* 4. LISTADO DE RESERVAS DE HABITACIÓN POR CLIENTE:\n");
        Cliente c = new Cliente("NH000001", "nombreapellidos1", "email_1@gmail.com", "111111111");
        hotel.obtenerReservasHabitacionPorCliente(c).forEach(System.out::println);
        
        System.out.println("\n* 5. OBTENER FACTURA DE LA RESERVA POR POSICIÓN:\n");
        // primera
        System.out.println(" 5.1. FACTURA DE LA PRIMERA RESERVA:\n");
        System.out.println(hotel.obtenerFacturaReservaPorPosicion(0));
        // última
        System.out.println("\n5.2. FACTURA DE LA ÚLTIMA RESERVA:\n");
        System.out.println(hotel.obtenerFacturaReservaPorPosicion(reservas.size() - 1));
        

    }

}
