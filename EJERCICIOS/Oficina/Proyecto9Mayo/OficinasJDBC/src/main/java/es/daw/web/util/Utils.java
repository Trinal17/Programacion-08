package es.daw.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.daw.web.model.Oficina;


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
    
    public static Oficina getOficinaByCod(String cod_oficina,List<Oficina> oficinas){
        for (Oficina o : oficinas) {
            if (o.getCodigo_oficina().equalsIgnoreCase(cod_oficina))
                return o;
        }
        return null;
    }
    
    
}
