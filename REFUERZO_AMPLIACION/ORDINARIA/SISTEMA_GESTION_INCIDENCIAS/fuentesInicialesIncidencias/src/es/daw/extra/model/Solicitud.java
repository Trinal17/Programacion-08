package es.daw.extra.model;

/**
 *
 * @author javaee
 */
public abstract class Solicitud implements Comparable<Solicitud> {

    private int id;
    private String detalle;
    private LocalDate fechaCreacion;
    private TIPO_CLIENTE tipoCliente;

}
