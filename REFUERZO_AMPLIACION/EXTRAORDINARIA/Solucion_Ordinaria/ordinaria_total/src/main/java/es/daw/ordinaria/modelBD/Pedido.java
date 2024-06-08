package es.daw.ordinaria.modelBD;

import java.time.LocalDate;

public class Pedido {
    private int id;
    private double precio;
    private LocalDate fecha;
    private int idCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", precio=" + precio + ", fecha=" + fecha + ", idCliente=" + idCliente + '}';
    }

}

