package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.enumerados.TipoHabitacion;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import es.daw.exam2ev.hotel.util.UtilFechas;
import java.time.LocalDate;

public class Habitacion implements Reservable, Comparable<Habitacion>{
    
    private Cliente cliente;
    private int numero;
    private LocalDate diaReserva;
    private int cantidadNoches;
    private TipoHabitacion tipo;
    
    private static final int PRECIO_BASE = 50;
   
    public Habitacion(Cliente cliente, int numero,  LocalDate diaReserva, int cantidadNoches, TipoHabitacion tipo) {
        this.cliente = cliente;
        this.numero = numero;
        this.diaReserva = diaReserva;
        this.cantidadNoches = cantidadNoches;
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDiaReserva() {
        return diaReserva;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public static int getPRECIO_BASE() {
        return PRECIO_BASE;
    }

    @Override
    public String obtenerFacturaReserva() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia del cliente: ");
        sb.append(cliente.getReferenciaCliente());
        sb.append("\nNúmero de la habitación: ");
        sb.append(numero);
        sb.append("\nTipo de habitación:");
        sb.append(tipo);
        sb.append("\nDia entrada al hotel: ");
        sb.append(diaReserva);
        sb.append("\nDia salida del hotel: ");
        sb.append(UtilFechas.obtenerFechaPasadoDias(diaReserva, cantidadNoches));
        sb.append("\nPrecio de la reserva: ");
        sb.append(calcularPrecioReserva());
        
        return sb.toString();
    }

    @Override
    public int calcularPrecioReserva() {
        return PRECIO_BASE + tipo.getExtra();
    }

    @Override
    public int compareTo(Habitacion o) {
        return diaReserva.compareTo(o.diaReserva);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("cliente=").append(cliente);
        sb.append("\nnumero=").append(numero);
        sb.append(" ,diaReserva=").append(diaReserva);
        sb.append(" ,cantidadNoches=").append(cantidadNoches);
        sb.append(" ,tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    
}
