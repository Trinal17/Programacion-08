package es.daw.ordinaria.model;

import java.time.LocalDate;

/**
 *
 * @author javaee
 */
public class VehiculoDosRuedas extends Tributo{
    private String matricula;
    private double cmcubicos;
    private final double  valor = 0.08;

    public VehiculoDosRuedas(String matricula, double cmcubicos, String NIF) {
        super(NIF);
        this.matricula = matricula;
        this.cmcubicos = cmcubicos;
    }

    

    public String getMatricula() {
        return matricula;
    }



    @Override
    public double calcularImporte() {
        return cmcubicos * valor;
    }

    @Override
    public String toString() {
        return "VehiculoDosRuedas{" + super.toString()+ " matricula=" + matricula + ", cmcubicos=" + cmcubicos + '}';
    }
            
    
}
