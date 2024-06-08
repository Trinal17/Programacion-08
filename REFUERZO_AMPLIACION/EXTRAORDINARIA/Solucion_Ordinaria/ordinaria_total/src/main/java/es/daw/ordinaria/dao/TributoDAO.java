package es.daw.ordinaria.dao;

import java.util.ArrayList;

import es.daw.ordinaria.model.BienesInmuebles;
import es.daw.ordinaria.model.Tributo;
import es.daw.ordinaria.model.VehiculoCuatroRuedas;
import es.daw.ordinaria.model.VehiculoDosRuedas;

public class TributoDAO {

    private ArrayList<Tributo> tributos = new ArrayList();

    public TributoDAO(){
        tributos.add(new BienesInmuebles(75, "1BV30988764", "11111111Y"));
        tributos.add(new BienesInmuebles(85, "1BV30988765", "21111111Y"));
        tributos.add(new BienesInmuebles(95, "1BV30988766", "71111111Y"));
        tributos.add(new BienesInmuebles(100, "1BV30988767", "81111111Y"));
        tributos.add(new VehiculoCuatroRuedas("0988YD", 12.3, "31111111Y"));
        tributos.add(new VehiculoCuatroRuedas("0987YZ", 12.3, "41111111Y"));
        tributos.add(new VehiculoDosRuedas("0987YE", 1340, "51111111Y"));
        tributos.add(new VehiculoDosRuedas("0988YF", 1340, "61111111Y"));
    }
    
    public ArrayList<Tributo> selectAll() {
        return new ArrayList<Tributo>(tributos);
    }
    
}
