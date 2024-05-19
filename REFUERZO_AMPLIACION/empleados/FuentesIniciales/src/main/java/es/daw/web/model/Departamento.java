package es.daw.web.model;

public class Departamento {
    private int codigo;
    private String nombre;
    private double presupesto;
    private double gastos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupesto() {
        return presupesto;
    }

    public void setPresupesto(double presupesto) {
        this.presupesto = presupesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    @Override
    public String toString() {
        return "Departamento{" + "codigo=" + codigo + ", nombre=" + nombre + ", presupesto=" + presupesto + ", gastos=" + gastos + '}';
    }

}

