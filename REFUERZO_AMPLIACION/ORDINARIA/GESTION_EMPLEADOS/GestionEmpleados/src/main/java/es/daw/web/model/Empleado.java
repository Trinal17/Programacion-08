package es.daw.web.model;

public class Empleado implements Comparable<Empleado>{
    private int codigo;
    private String NIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int codigo_departamento;

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", NIF=" + NIF + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", codigo_departamento=" + codigo_departamento + '}';
    }

    @Override
    public int compareTo(Empleado o) {
        return NIF.compareTo(o.NIF);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((NIF == null) ? 0 : NIF.hashCode());
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
        Empleado other = (Empleado) obj;
        if (NIF == null) {
            if (other.NIF != null)
                return false;
        } else if (!NIF.equals(other.NIF))
            return false;
        return true;
    }
    
    
}
