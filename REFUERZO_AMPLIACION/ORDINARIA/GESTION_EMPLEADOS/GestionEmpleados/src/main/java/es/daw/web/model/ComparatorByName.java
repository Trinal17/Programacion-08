package es.daw.web.model;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Empleado>{

    @Override
    public int compare(Empleado e1, Empleado e2) {
        return e1.getNombre().compareTo(e2.getNombre());
    }
    
}
