package es.daw.ordinaria.modelEJ2;

public class Matricula {

    private String nombre;
    private String DNI;
    private int edad;
    private int numModulos;
    private String ciclo;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matricula other = (Matricula) obj;
        if (DNI == null) {
            if (other.DNI != null)
                return false;
        } else if (!DNI.equals(other.DNI))
            return false;
        return true;
    }

    public Matricula(String nombre, String DNI, int edad,int numModulos, String ciclo) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.numModulos = numModulos;
        this.ciclo = ciclo;
    }

    public Matricula(String DNI){
        this.DNI = DNI;
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
