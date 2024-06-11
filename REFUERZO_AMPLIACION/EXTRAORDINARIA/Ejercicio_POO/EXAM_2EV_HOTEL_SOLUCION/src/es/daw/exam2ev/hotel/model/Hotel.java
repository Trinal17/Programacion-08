package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.dao.ReservasDAO;
import es.daw.exam2ev.hotel.excepciones.ReferenciaClienteNoEncontradaException;
import es.daw.exam2ev.hotel.model.interfaces.Gestionable;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hotel implements Gestionable {

    // ---------------------------------------------
    private final ArrayList<Reservable> reservas;

    private ArrayList<Habitacion> habitaciones;
    private ArrayList<ServicioSPA> spas;
    
    public Hotel(ArrayList<Reservable> reservas) {
        this.reservas = reservas;
    }
    
    // public Hotel(){
    //     this.reservas = new ReservasDAO().select();
    // }
    // ---------------------------------------------

    @Override
    public ArrayList<Habitacion> obtenerReservasHabitacionOrdenadasDeFormaNatural() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        
        for(Reservable r: reservas){
            if (r instanceof Habitacion)
                habitaciones.add((Habitacion)r);
        }
        
        
        //habitaciones.sort(Comparator.naturalOrder());
        Collections.sort(habitaciones);
        
        return habitaciones;
    }

    @Override
    public ArrayList<ServicioSPA> obtenerReservasServicioSPAOrdenadosPorReferenciaCliente() {
        ArrayList<ServicioSPA> spas = new ArrayList<>();
        for(Reservable r: reservas){
            if (r instanceof ServicioSPA)
                spas.add((ServicioSPA)r);
       
        }
        spas.sort((s1,s2) -> s1.getReferenciaCliente().compareTo(s2.getReferenciaCliente()));

        // ordenar por precio del tipo de servicioSPA ascendente
        //spas.sort( (s1,s2) -> Integer.compare(s1.getTipo().getPrecio(), s2.getTipo().getPrecio()));
        // ordenar por precio del tipo de servicioSPA descendente
        //spas.sort( (s1,s2) -> Integer.compare(s2.getTipo().getPrecio(), s1.getTipo().getPrecio()));
        //Collections.reverse(spas);
        
        return spas;
        
    }
    
    @Override
    public ArrayList<Reservable> obtenerReservasPorReferenciaCliente(String referenciaCliente) throws ReferenciaClienteNoEncontradaException{
        ArrayList<Reservable> reservasCliente = new ArrayList<>();
        for(Reservable r: reservas){
            if ( r instanceof ServicioSPA){
                if (referenciaCliente.equalsIgnoreCase(((ServicioSPA) r).getReferenciaCliente()))
                    reservasCliente.add(r);
            }
            else if ( r instanceof Habitacion){
                if (((Habitacion) r).getCliente().getReferenciaCliente().equalsIgnoreCase(referenciaCliente))
                    reservasCliente.add(r);
            }
        }
        
        if (reservasCliente.isEmpty())
            throw new ReferenciaClienteNoEncontradaException(referenciaCliente,LocalDateTime.now());
                    
        return reservasCliente;
        
    }
    
    @Override
    public ArrayList<Habitacion> obtenerReservasHabitacionPorCliente(Cliente cliente) {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        for(Reservable r: reservas){
            if (r instanceof Habitacion){
                if (((Habitacion) r).getCliente().equals(cliente))
                    habitaciones.add((Habitacion) r);
            }
                
        } 
        return habitaciones;
    }
    
    @Override
    public String obtenerFacturaReservaPorPosicion(int posicion){
        return reservas.get(posicion).obtenerFacturaReserva();
    }








}
