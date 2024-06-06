package es.daw.ordinaria.model;

import java.time.LocalDate;

/**
 *
 * @author javaee
 */
public class VehiculoCuatroRuedas extends Tributo {

    private String matricula;
    private double caballosFiscales;
    private final double valor = 4.43;

    //new VehiculoCuatroRuedas("0987YD", 12.3, "31111111Y", UtilFechas.convertirFecha("15/07/2022"))
    public VehiculoCuatroRuedas(String matricula, double caballosFiscales, String NIF) {
        super(NIF);
        this.matricula = matricula;
        this.caballosFiscales = caballosFiscales;
    }

    @Override
    public double calcularImporte() {
        return caballosFiscales * valor;

    }

    

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "VehiculoCuatroRuedas{" + super.toString()+" matricula=" + matricula + ", caballosFiscales=" + caballosFiscales + '}';
    }
    
    
    
}
