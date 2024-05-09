package es.daw.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author melola
 */
public class Utils {

    /**
     * Método que devuelve una cadena de texto con la fecha actual del sistema
     * en formato dd/MM/YYYY HH:mm:ss
     * @return 
     */
    public static String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String formatoFecha = sdf.format(new Date());
        return formatoFecha;
    }   
    
    
}
