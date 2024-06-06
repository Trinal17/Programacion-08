
package es.daw.ordinaria.model;

import java.time.LocalDate;

/**
 *
 * @author javaee
 */
public class BienesInmuebles extends Tributo {
    private double metros;
    private String referenciaCatastral;
    private final double VALOR = 10;

    public BienesInmuebles(double metros, String referenciaCatastral, String NIF) {
        super(NIF);
        this.metros = metros;
        this.referenciaCatastral = referenciaCatastral;
    }

    
    public String getReferenciaCatastral() {
        return referenciaCatastral;
    }


    public double getMetros() {
        return metros;
    }


    // Sobreescrito el método estático
    @Override
    public double calcularImporte() {
        return (metros * VALOR);
    }

    @Override
    public String toString() {
        return "BienesInmuebles{" +  super.toString() + " metros=" + metros + ", referenciaCatastral=" + referenciaCatastral + '}';
    }
    
    
}
