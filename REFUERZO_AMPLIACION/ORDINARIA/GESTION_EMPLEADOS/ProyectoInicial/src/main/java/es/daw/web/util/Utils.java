package es.daw.web.util;

import java.util.ArrayList;
import java.util.List;

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

}
