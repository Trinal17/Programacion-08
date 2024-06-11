package es.daw.exam2ev.hotel.dao;

import es.daw.exam2ev.hotel.enumerados.TipoHabitacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import es.daw.exam2ev.hotel.model.Habitacion;
import es.daw.exam2ev.hotel.model.Cliente;
import es.daw.exam2ev.hotel.enumerados.TipoSPA;
import es.daw.exam2ev.hotel.model.ServicioSPA;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import java.time.LocalDate;

/**
 * SE PROPORCIONA LA CLASE COMPLETA
 * NO DEBES MODIFICARLA
 */
public class ReservasDAO {

    private static ArrayList<Reservable> reservas;

    public ReservasDAO(){
       
        Cliente[] lista;
        
        if (reservas == null) {
            lista = getClientes();
            reservas = new ArrayList<Reservable>();
            
            //Habitacion(Cliente cliente, int numero,  LocalDate diaReserva, int cantidadNoches, TipoHabitacion tipo)
            reservas.add(new Habitacion(lista[0], 1, LocalDate.of(2023, 03, 1), 7, TipoHabitacion.SUITE));
            reservas.add(new Habitacion(lista[1], 2, LocalDate.of(2023, 03, 3), 1, TipoHabitacion.SINGLE));
            reservas.add(new Habitacion(lista[2], 1, LocalDate.of(2023, 03, 2), 2, TipoHabitacion.SUITE));

            // ServicioSPA(String referenciaCliente, TipoSPA tipo, LocalDateTime diaReservaHoraEntrada)
            reservas.add(new ServicioSPA("NH000002", TipoSPA.ESTANDAR, LocalDateTime.of(2023, 03, 3, 10, 15)));
            reservas.add(new Habitacion(lista[0], 2, LocalDate.of(2023, 04, 3),2, TipoHabitacion.SINGLE));
            reservas.add(new Habitacion(lista[1], 3, LocalDate.of(2023, 04, 1),1,TipoHabitacion.DOUBLE));
            reservas.add(new ServicioSPA("NH000001", TipoSPA.BASICO, LocalDateTime.of(2023, 03, 1, 19, 0)));
            
        }
        
    }
    
    /**
     * Método que devuelte la colección de reservas
     * @return 
     */
    public ArrayList<Reservable> select() {
        return new ArrayList<>(reservas);

    }

    /**
     * Método que carga un array de clientes
     * @return 
     */
    private static Cliente[] getClientes() {
        Cliente[] clientes = new Cliente[3];
        clientes[0] = new Cliente("NH000001", "nombreapellidos1", "email_1@gmail.com", "111111111");
        clientes[1] = new Cliente("NH000002", "nombreapellidos2", "email_2@gmail.com", "222222222");
        clientes[2] = new Cliente("NH000003", "nombreapellidos3", "email_3@gmail.com", "333333333");
        return clientes;
    }

}
