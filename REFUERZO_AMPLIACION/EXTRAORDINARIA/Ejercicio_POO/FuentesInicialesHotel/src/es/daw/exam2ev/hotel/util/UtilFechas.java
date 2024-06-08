/**
 * SE PROPORCIONA LA CLASE COMPLETA
 * NO DEBES MODIFICARLA
 */
package es.daw.exam2ev.hotel.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilFechas {

    /**
     * Método que devuelve un LocalDateTime a una cadena de texto con el formato 
     * "dd/MM/yyyy HH:mm:ss"
     * @param dateTime
     * @return 
     */
    public static String convertirFechaHora(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }
    
    /**
     * Método que obtiene un nuevo LocalDate después de sumar un número de días a 
     * una fecha inicial
     * @param date
     * @param numDias
     * @return 
     */
    public static LocalDate obtenerFechaPasadoDias(LocalDate date, int numDias){
        return date.plusDays(numDias);
        
    }

}
