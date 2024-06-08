package es.daw.ordinaria.util;

import java.util.ArrayList;
import java.util.List;

import es.daw.ordinaria.modelEJ2.Matricula;

public class Ejercicio2 {

    static List<Matricula> lista_matriculas = new ArrayList<>();

    static final int PRECIO_MATRICULA_GM = 50;
    static final int PRECIO_MATRICULA_GS = 70;


    public static void ejecuta(){

        // CASO 1: ARCHIVO CSV
        // #NOMBRE,DNI,EDAD,NUM_MODS,CICLO
        // Ana,11111111A,18,6,GM
        // Juan,11111111B,25,3,GS

        // CASO 2: MATRIZ
        // String[][] matriz = {
        //     {"Ana","11111111A","18","6","GM"},
        //     {"Juan","11111111B","25","3","GS"}
        // };

        // String[][] matriz2 = new String[7][5];
        // matriz2[0][0] = "Ana";
        // matriz2[0][1] = "11111111A";
        // matriz2[0][2] = "18";
        // matriz2[0][3] = "6";
        // matriz2[0][4] = "GM";
        // matriz2[1][0] = "Juan";

        // CASO 3: array unidimensional de cadenas
        String[] matriculas = {
            "Ana,11111111A,18,6,GM",
            "Juan,11111111B,25,3,GS",
            "Sonia,22222222A,42,6,GS",
            "Pepe,22222222B,21,2,GM",
            "Lucas,11111111B,32,2,GS",
            "Lola,33333333A,32,4,GS",
            "Lucas,33333333B,32,2,GS"};


        for (String matricula : matriculas) {
            String[] datos = matricula.split(",");
            //Matricula m = new Matricula(datos[0],datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),datos[4]);
            lista_matriculas.add(new Matricula(datos[0],datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),datos[4]));
        }

        System.out.println("************ LISTADO MATRICULAS ********+");
        lista_matriculas.forEach(System.out::println);

        Matricula matriculaRepetida = new Matricula("11111111B");
        String mensaje = (esRepetida(matriculaRepetida))? "está repetida":"no está repetida";
        System.out.println("1. La matricula del DNI 11111111B "+mensaje);
    }


    private static boolean esRepetida(Matricula matricula){

        // // FORMA 1
        // for (Matricula m : lista_matriculas) {
        //     if (m.getDNI().equalsIgnoreCase(matricula.getDNI()))
        //         return true;
            
        // }
        // return false;

        // FORMA 2
        return lista_matriculas.contains(matricula);
    }

    private static String obtenerNombreAlumnoMayorImporte() {

        int importeMayor = 0;
        String nombre = "";

        for (Matricula estudiante : lista_matriculas) {

            int importe = 0;

            int numModulos = estudiante.getNumModulos();
            
            if (estudiante.getCiclo().equalsIgnoreCase("GM")) {
                importe = numModulos * PRECIO_MATRICULA_GM;
            } else {
                importe = numModulos * PRECIO_MATRICULA_GS;
            }
    
            if (importeMayor < importe) {
                importeMayor = importe; // machaco el importe con el nuevo importe mayor
                nombre = estudiante.getNombre();
            }
    
        }

        return nombre;
    }


}
