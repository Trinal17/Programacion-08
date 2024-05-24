package es.daw.web.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.model.Departamento;
import es.daw.web.model.Empleado;

/**
 *
 * @author melola
 */
public class Utils {

    /**
     * IMPORTANTE USAR EN EL SERVLET 3!!!!!
     * NO TOCAR!!!!
     * @return
     */
    public static List<Empleado> obtenerEmpleadosServlet3(){
        List<Empleado> empleados = new ArrayList<>();

         Empleado e;

         e = new Empleado();
         e.setCodigo(1);
         e.setNIF("11111111A");
         e.setNombre("Empleado_1");
         e.setCodigo_departamento(1);
         empleados.add(e);

         e = new Empleado();
         e.setCodigo(2);
         e.setNIF("11111111B");
         e.setNombre("Empleado_2");
         e.setCodigo_departamento(2);
         empleados.add(e);

         e = new Empleado();
         e.setCodigo(3);
         e.setNIF("11111111C");
         e.setNombre("Empleado_3");
         e.setCodigo_departamento(3);
         empleados.add(e);

         e = new Empleado();
         e.setCodigo(4);
         e.setNIF("22222222A");
         e.setNombre("Empleado_4");
         e.setCodigo_departamento(2);
         empleados.add(e);

         e = new Empleado();
         e.setCodigo(5);
         e.setNIF("22222222B");
         e.setNombre("Empleado_5");
         e.setCodigo_departamento(1);
         empleados.add(e);
        
        return empleados;
    }

    /**
     * 
     * @param departamentos
     * @param cod_departamento
     * @return
     */
    public static boolean existeDepartamento(List<Departamento> departamentos,String cod_departamento){

        for (Departamento d : departamentos) {
            if (d.getCodigo() == Integer.parseInt(cod_departamento)){
                return true;
            }
        }
        return false;

    }

    /**
     * 
     * @param empleados
     * @param cod_departamento
     * @return
     */
    public static List<Empleado> obtenerEmpleadoByDepartamento(List<Empleado> empleados, String cod_departamento){
        List<Empleado> empleadosFiltrados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            if (empleado.getCodigo_departamento() == Integer.parseInt(cod_departamento))
                empleadosFiltrados.add(empleado);
        }

        return empleadosFiltrados;

    }

    /**
     * crearCSV
     * @param home
     * @param departamento
     * @throws IOException
     */
    public static void crearCSV(Path home, String departamento) throws IOException{

        Path subCarpeta = Paths.get(departamento);
        Path pathTotalSubCarpeta = home.resolve(subCarpeta);

        String cabecera = "#CÓDIGO,NIF,NOMBRE";

        // Creamos la subcarpeta (y ruta completa) del departamento
        if(!Files.exists(pathTotalSubCarpeta))
            Files.createDirectories(pathTotalSubCarpeta);


        // Creamos el fichero CSV dentro de dicha subcarpeta
        Path fichero = Paths.get(LocalDate.now()+"_"+departamento+".csv"); //nombre
        Path path_fichero = pathTotalSubCarpeta.resolve(fichero); //ruta completa y el nombre

        Files.write(path_fichero,cabecera.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);


    }

    /**
     * escribirEnCSV
     * @param empleado
     * @param home
     * @param departamento
     * @throws IOException
     */
    public static void escribirEnCSV(Empleado empleado, Path home, String departamento) throws IOException{
        Path subCarpeta = Paths.get(departamento); // un path al nombre del departamento
        Path pathTotalSubcarpeta = home.resolve(subCarpeta);
        Path fichero = Paths.get(LocalDate.now()+"_"+departamento+".csv"); //nombre
        Path path_fichero = pathTotalSubcarpeta.resolve(fichero); //ruta completa y el nombre

        //String cabecera = "#CÓDIGO,NIF,NOMBRE";
        String linea = "\n"+empleado.getCodigo()+","+empleado.getNIF()+","+empleado.getNombre();

        Files.write(path_fichero,linea.getBytes(), StandardOpenOption.APPEND);


    }

}
