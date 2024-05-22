package utils;

import java.time.LocalDate;

public class Utilidades {


    /**
     * Método que devuelve la fecha (LocalDate) tras añadir los días a la fecha pasada por parámetro 
     * @param fecha
     * @param dias
     * @return 
     */
    public static LocalDate sumaDias(LocalDate fecha, int dias) {
        return fecha.plusDays(dias);
    }

    /**
     * Método que pinta por consola el menú principal
     */
    public static void pintaMenu(){
        System.out.println("\n************* SISTEMA DE GESTIÓN DE INCIDENCIAS Y MEJORAS ***************");
        System.out.println("1. LISTADO DE TODAS LAS SOLICITUDES");
        System.out.println("2. LISTAR LAS SOLICITUDES RESUELTAS ORDENADAS POR FECHA DE RESOLUCIÓN");
        System.out.println("3. CERRAR SOLICITUD");
        System.out.println("4. EXPORTAR TODAS LAS SOLICITUDES A FORMATO CSV");
        System.out.println("5. SALIR");
    }
    
}
