package es.daw.ordinaria.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio4 {
    
    public static void ejecuta(){

        Path path_csv = Paths.get("empleados.csv");

        try {
            List<String> empleados = Files.readAllLines(path_csv);
            System.out.println("*********** EMPLEADOS DEL CSV ************");
            empleados.forEach(System.out::println);

            int numEmpleados = empleados.size()-1;
            System.out.println("* El número de empleados es: "+numEmpleados);

            float sueldoTotal = 0.0f;
            float sueldoMedio = 0.0f;

            Map<String,String> empleadosMap = new TreeMap<>();

            // Calcular el sueldo medio
            //for (String empleado : empleados) {
            for (int i = 1; i < empleados.size(); i++) {
                String[] datos = empleados.get(i).split(",");
                sueldoTotal += Float.parseFloat(datos[2]);

                // cargar en el Map
                empleadosMap.put(datos[0],datos[datos.length - 1]);
            }
            sueldoMedio = sueldoTotal / numEmpleados;
            System.out.println("* El sueldo medio es: "+sueldoMedio);


            // -------------------
            System.out.println("************ COLECCIÓN MAP DE NIF Y TELÉFONOS ************");
            for (Map.Entry<String,String> fila : empleadosMap.entrySet()) {
                System.out.println("NIF: "+fila.getKey());
                System.out.println("TELÉFONO: "+fila.getValue());
                System.out.println();
            }

            // BACKUP ............

            Path ruta = Paths.get(System.getProperty("user.home"),"BACKUP_ORDINARIA",LocalDate.now().toString());

            if (Files.notExists(ruta))
                Files.createDirectories(ruta);
            
            Path fichero_back = Paths.get("empleados.back");
            Path ruta_fichero_back = ruta.resolve(fichero_back);

            if(Files.exists(ruta_fichero_back)){
                System.out.println("[ERROR] Ya existe el archivo "+ruta_fichero_back.toString());
            }
            else{ // Si no exite
                // Creo el backup
                //Files.write(ruta_fichero_back,empleados,StandardOpenOption.CREATE);
                Files.copy(path_csv, ruta_fichero_back, StandardCopyOption.REPLACE_EXISTING);

                // Añadir la última línea
                String ultima_linea = "El sueldo medio de los "+numEmpleados+" empleados es "+sueldoMedio;
                Files.write(ruta_fichero_back, ultima_linea.getBytes(), StandardOpenOption.APPEND);

                System.out.println("Realizado el backup correctamente!!!!!!!!!!");

            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

    }
}
