package es.daw.web.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
    
    /**
     * Método que devuelve un objeto oficina encontrado en una lista de oficinas
     * @param cod_oficina
     * @param oficinas
     * @return
     */
    public static Oficina getOficinaByCod(String cod_oficina,List<Oficina> oficinas){
        for (Oficina o : oficinas) {
            if (o.getCodigo_oficina().equalsIgnoreCase(cod_oficina))
                return o;
        }
        return null;
    }

    /**
     * 
     * @param cod_oficina
     * @param oficinas
     * @return
     */
    public static boolean existeOficina(String cod_oficina, List<Oficina> oficinas){
        for (Oficina oficina : oficinas) {
            if(oficina.getCodigo_oficina().equalsIgnoreCase(cod_oficina))
                return true;
        }

        return false;
    }
    

    /**
     * 
     * @param pathLog
     * @param nombreLog
     * @throws IOException 
     */
    public static void writeLog(String pathLog,String nombreLog, String mensaje) throws IOException{

        Path p = Paths.get(pathLog);

        if (!Files.exists(p)){
            Files.createDirectory(p);
        }

        Path file = Paths.get(pathLog,nombreLog);

        // también podríamos usar resolver para unir dos path

        Files.write(file, (mensaje+"\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        

    }
    
}
