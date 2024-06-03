package es.daw.ordinaria.modelEJ2;

public class Matricula {

    private String nombre;
    private String DNI;
    private int edad;
    private int numModulos;
    private String ciclo;

    public Matricula(String nombre, String DNI, int edad,int numModulos, String ciclo) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.numModulos = numModulos;
        this.ciclo = ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public int getNumModulos() {
        return numModulos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Matricula [nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad + ", numModulos=" + numModulos
                + ", ciclo=" + ciclo + "]";
    }

    
}
