package es.daw.ordinaria.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 *
 * @author melola
 */
public class Utils {
    
    public static int contarPalabras(String fichero) throws IOException{
        Path p = Paths.get(fichero);
        int contador = 0;
        try(BufferedReader br = Files.newBufferedReader(p)){
            String linea = "";
            String[] palabras;
            
            while( (linea = br.readLine()) != null){
                palabras = linea.split(" ");
                contador += palabras.length;
            }
        }
        
        return contador;
    }
    
    public static int contarLineas(String fichero) throws IOException{
        Path p = Paths.get(fichero);
        
        //BufferedReader br2 = new BufferedReader(new FileReader("path del fichero"));

        /*
        int contador = 0;
        try(BufferedReader br = Files.newBufferedReader(p)){
            String linea = "";
            while( (linea = br.readLine()) != null){
                contador++;
            }
        }
        
        return contador;
        */
        
        List<String> lista = Files.readAllLines(p);
        
        return lista.size();
        
    }
    
    public static int contarCaracteres(String fichero) throws FileNotFoundException, IOException{
        /*int contador = 0;
        
        try(FileReader fr = new FileReader(fichero)){
           while ( fr.read() != -1){
               contador++;
           }
        }
        return contador;*/
        
        
        String contenido = Files.readString(Paths.get(fichero));
        
        return contenido.length();
        
    }
    
    public static void hacerBackup(String rutaOrigen, String rutaBackup) throws IOException{

        System.out.println("* rutaOrigen: "+rutaOrigen);
        System.out.println("* rutaBackup: "+rutaBackup);
        
        Path pBack = Paths.get(rutaBackup);
        Path pOrigen = Paths.get(rutaOrigen);
        
        if (Files.notExists(pBack)){
            // if (Files.notExists(pBack.getParent()))
            //     Files.createDirectory(pBack.getParent());
            Files.createDirectories(pBack);
            
            //Files.createFile(pBack);
        }
        
        // Si existe que lo reemplace
        Files.copy(pOrigen, pBack,StandardCopyOption.REPLACE_EXISTING);
            
    }
}
