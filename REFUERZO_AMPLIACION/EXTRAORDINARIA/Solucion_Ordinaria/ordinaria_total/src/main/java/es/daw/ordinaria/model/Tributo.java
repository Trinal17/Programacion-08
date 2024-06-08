package es.daw.ordinaria.model;

import java.time.LocalDate;

import es.daw.ordinaria.exception.ErrorPagoException;

/**
 *
 * @author javaee
 */
public abstract class Tributo implements Comparable<Tributo> {

    // Atributo de clase o atributo de instancia
    private static int contador = 3524;
    private int identificador;
    private String NIF;

    private LocalDate fechapagado;

    private LocalDate fechaAlta;
    private LocalDate fechaLimite; //fecha límite de pago que tiene que ser 1 mes después de dar de alta el tributo


    public Tributo(String NIF) {
        this.identificador = contador++;

        this.NIF = NIF;

        fechapagado = null;

        // fecha de alta es la fecha del sistema
        //fechaAlta = LocalDate.now();
        // fecha límite de pago es un mes después de la fecha de alta
        //fechaLimite = fechaAlta.plusMonths(1);

    }

    public int getIdentificador() {
        return identificador;
    }

    // public void setIdentificador(int referencia) {
    //     this.identificador = referencia;
    // }


    // -----------------------------------------------
    public LocalDate getFechapagado() {
        return fechapagado;
    }
    // No tiene setFechapagado porque la fecha cuando se paga se completa con la fecha actual en el momento de hacer el pago

    // -----------------------------------------------

    // Método abstracto. Es protected porque solo los hijos van a tener acceso a él para implementarlo. No es público
    protected abstract double calcularImporte();

    // ------------------------------------------------------------------------
    // MÉTODOS DE COMPORTAMIENTO
    public double pagarTributo() throws ErrorPagoException {
        // si el tributo está pagado no permite volver a pagarlo... lanzará una excepción

        if (fechapagado != null) {
            throw new ErrorPagoException(this);
        }

        fechapagado = LocalDate.now();

        return calcularImporte();

    }

    // --------------------------------------------------------------------------------------

    // ----------------- MÉTODOS QUE SOBREESCRIBEN A LOS MÉTODOS DE OBJECT ------------------
    /*
     MUY IMPORTANTE!!!!
     La invocación a los métodos equals y hashcode forma parte intrínseca del framework de colecciones.
     Por ejemplo si construimos dos objetos de tipo Persona y los añadimos a un HashSet, 
     podemos comprobar que la Persona existe utilizando el método contains dentro del conjunto.
     En java los metodos equals y hashcode van de la mano, no deberias editar uno sin el otro, 
     de lo contrario algunas clases que dependen de su correcta implementacion se comportan de forma erratica (como Set, Map entre otras)
     El contrato general entre equals y hashcode es que si 2 objetos de una misma clase tienen un hashcode distinto 
     entonces equals entre ellos es false.

     Una forma simple de mantener ese contrato es usar siempre los mismos atributos para determinar la igualdad que para generar su hash.    
    
     CURIOSIDAD: dos objetos diferentes pueden tener mismo hashcode. 
     Si implementamos el método para que devuelva el mismo hashCode, pero van a estar en colecciones Hash diferentes
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.identificador;
        return hash;
    }

    @Override
    public String toString() {
        return "Tributo [identificador=" + identificador + ", NIF=" + NIF + ", fechapagado=" + fechapagado + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tributo other = (Tributo) obj;
        return this.identificador == other.identificador;
    }


    // -------------------------------------------------------------------------------
    /*
        int negativo si esto < aquello
        0 si esto == aquello
        int positivo si esto > aquello
     */
    @Override
    public int compareTo(Tributo t) {
        //return Double.compare(precio, t.precio);
        return NIF.compareTo(t.NIF);
    }

}
