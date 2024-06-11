package es.daw.exam2ev.hotel.excepciones;

import es.daw.exam2ev.hotel.util.UtilFechas;
import java.time.LocalDateTime;

public class ReferenciaClienteNoEncontradaException extends Exception {

    private String referencia;
    private LocalDateTime horaBusqueda;
    
    public static final String MESSAGE = "Número de referencia %s no encontrada en la fecha %s";

    public ReferenciaClienteNoEncontradaException(String referencia, LocalDateTime horaBusqueda) {
        super( String.format(MESSAGE,referencia, UtilFechas.convertirFechaHora(horaBusqueda)));
        this.referencia = referencia;
        this.horaBusqueda = horaBusqueda;
    }

}
