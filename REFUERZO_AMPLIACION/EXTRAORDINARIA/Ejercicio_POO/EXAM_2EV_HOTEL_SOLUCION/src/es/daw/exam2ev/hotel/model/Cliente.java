package es.daw.exam2ev.hotel.model;

import java.util.Objects;

public class Cliente {
    
    private String referenciaCliente;
    private String nombreApellidos;
    private String email; 
    private String movil; 

    public Cliente(String referenciaCliente, String nombreApellidos, String email, String movil) {
        this.referenciaCliente = referenciaCliente;
        this.nombreApellidos = nombreApellidos;
        this.email = email;
        this.movil = movil;
    }

    public String getReferenciaCliente() {
        return referenciaCliente;
    }

    public void setReferenciaCliente(String referenciaCliente) {
        this.referenciaCliente = referenciaCliente;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("referenciaCliente=").append(referenciaCliente);
        sb.append(", nombreApellidos=").append(nombreApellidos);
        sb.append(", email=").append(email);
        sb.append(", movil=").append(movil);
        sb.append('}');
        return sb.toString();
    }

    // PENDIENTE COMPLETAR...
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.referenciaCliente);
        hash = 17 * hash + Objects.hashCode(this.nombreApellidos);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.movil);
        return hash;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.referenciaCliente, other.referenciaCliente)) {
            return false;
        }
        if (!Objects.equals(this.nombreApellidos, other.nombreApellidos)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.movil, other.movil);
    }
    

}
