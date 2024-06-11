package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.enumerados.TipoSPA;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import es.daw.exam2ev.hotel.util.UtilFechas;
import java.time.LocalDateTime;

public class ServicioSPA implements Reservable{
    private String referenciaCliente;
    private TipoSPA tipo;
    private LocalDateTime diaHoraCita;
    

    public ServicioSPA(String referenciaCliente, TipoSPA tipo, LocalDateTime diaHoraCita) {
        this.referenciaCliente = referenciaCliente;
        this.tipo = tipo;
        this.diaHoraCita = diaHoraCita;
        
    }

    public String getReferenciaCliente() {
        return referenciaCliente;
    }

    public TipoSPA getTipo() {
        return tipo;
    }

    public LocalDateTime getDiaReservaHoraEntrada() {
        return diaHoraCita;
    }

    
    @Override
    public String obtenerFacturaReserva() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia del cliente: ");
        sb.append(referenciaCliente);
        sb.append("\nTipo de servicio SPA: ");
        sb.append(tipo);
        sb.append("\nDia y hora de la cita: ");
        sb.append(UtilFechas.convertirFechaHora(diaHoraCita));
        sb.append("\nPrecio de la reserva: ");
        sb.append(calcularPrecioReserva());

        return sb.toString();
    }

    @Override
    public int calcularPrecioReserva() {
        return tipo.getPrecio();
    }

    @Override
    public String toString() {
        return "ServicioSPA{" + "referenciaCliente=" + referenciaCliente + ", tipo=" + tipo + ", diaHoraCita=" + UtilFechas.convertirFechaHora(diaHoraCita) + '}';
    }


}
