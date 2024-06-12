package es.daw.ordinaria;

import es.daw.ordinaria.util.Utils;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author melola
 */
public class EjercicioQuijote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opt = 5;
        
        do{
            pintaMenu();
            opt = sc.nextInt();
            
            try{
                switch(opt){
                    case 1:
                        System.out.println("Número de líneas:");
                        System.out.println(Utils.contarLineas("quijote.txt"));
                        break;
                    case 2:
                        System.out.println("Número de palabras:");
                        System.out.println(Utils.contarPalabras("quijote.txt"));
                        break;
                    case 3:
                        System.out.println("Número de caracteres:");
                        System.out.println(Utils.contarCaracteres("quijote.txt"));
                        break;
                    case 4:
                        //Utils.hacerBackup("quijote.txt", System.getProperty("user.home")+File.separator+"BACKS"+File.separator+"quijote_backup.txt");
                        
                        Utils.hacerBackup("quijote.txt", System.getProperty("user.home")+File.separator+"BACKS"+File.separator+"EXTRA"+File.separator+"quijote_backup.txt");
                        break;
                    case 5:
                        System.out.println("Vas a salir del programa");
                        break;
                    default:
                        System.out.println("Elige una opción correcta");
                        break;
                }
            }catch(IOException e){
                e.printStackTrace();
                System.err.println("Error de E/S: "+e.getMessage());
            }
            
        }while(opt != 5);
        
    }
    
    public static void pintaMenu(){
        System.out.println("******** ANALIZANDO EL QUIJOTE *********");
        System.out.println("1. Contar número de líneas");
        System.out.println("2. Contar número de palabras");
        System.out.println("3. Contar número de caracteres");
        System.out.println("4. Guardar backup");
        System.out.println("5. Salir");
        System.out.println("-----------------------------------------");
        System.out.println("Elige una opción:");
    }
    
}
