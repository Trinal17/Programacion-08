package es.daw.ordinaria.model;

import java.util.Comparator;

public class ComparadorByMetros implements Comparator<BienesInmuebles>{

    @Override
    public int compare(BienesInmuebles arg0, BienesInmuebles arg1) {
        return Double.compare(arg0.getMetros(),arg1.getMetros()); //ascendente
    }
    
}
