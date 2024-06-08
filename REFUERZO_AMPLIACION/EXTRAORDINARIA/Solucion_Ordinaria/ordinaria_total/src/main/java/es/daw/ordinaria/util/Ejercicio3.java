package es.daw.ordinaria.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.daw.ordinaria.dao.TributoDAO;
import es.daw.ordinaria.exception.ErrorPagoException;
import es.daw.ordinaria.model.BienesInmuebles;
import es.daw.ordinaria.model.ComparadorByMetros;
import es.daw.ordinaria.model.Tributo;
import es.daw.ordinaria.model.VehiculoCuatroRuedas;
import es.daw.ordinaria.model.VehiculoDosRuedas;

public class Ejercicio3 {
    
    static ArrayList<Tributo> tributos;

    public static void ejecuta(){
        TributoDAO tDAO = new TributoDAO();
        tributos = tDAO.selectAll();   
        
        // ---------------------------------------------------------
        System.out.println("* LISTAR TODOS LOS TRIBUTOS: ");
        tributos.forEach(System.out::println);



        // ---------------------------------------------------------
        System.out.println("\n* LISTAR LOS TRIBUTOS DE BIENES INMUEBLES ORDENADOS DE FORMA NATURAL: ");
        List<BienesInmuebles> inmuebles = new ArrayList<>();
        for (Tributo tributo : tributos) {
            if (tributo instanceof BienesInmuebles)
                inmuebles.add((BienesInmuebles)tributo);
        }
        Collections.sort(inmuebles);
        inmuebles.forEach(System.out::println);
        // ----------------------------------------------------------
        System.out.println("* LISTAR BIENESINMUEBLES POR PRECIO DESC: ");
        // inmuebles.sort( (i1,i2) -> Double.compare(i1.getMetros(),i2.getMetros()) ); //ascendente
        // //inmuebles.sort(Comparator.reverseOrder());
        // Collections.reverse(inmuebles);

        // inmuebles.sort( (i1,i2) -> Double.compare(i2.getMetros(),i1.getMetros()) ); //descendente

        inmuebles.sort(new ComparadorByMetros().reversed());

        inmuebles.forEach(System.out::println);

        // ---------------------------------------------------------
        System.out.println("\n* LISTAR LOS TRIBUTOS DE VEHÍCULOS CUYA MATRÍCULA CONTIENE 7Y: ");
        for (Tributo t : tributos) {

            if(t instanceof VehiculoCuatroRuedas){
                VehiculoCuatroRuedas coche = (VehiculoCuatroRuedas)t;
                if (coche.getMatricula().contains("7Y"))
                    System.out.println(coche);
            }
            else if(t instanceof VehiculoDosRuedas){
                VehiculoDosRuedas moto = (VehiculoDosRuedas)t;
                if (moto.getMatricula().contains("7Y"))
                    System.out.println(moto);
            }            
            else{}
        }

        // PAGAR ...........
        try {

            System.out.println("\n* PAGAR BIENESINMUEBLES CON REFERENCIA CATASTRAL 1BV66666666");
            pagarInmueble(inmuebles,"1BV66666666");

            System.out.println("\n* PAGAR BIENESINMUEBLES CON REFERENCIA CATASTRAL 1BV30988765");
            pagarInmueble(inmuebles,"1BV30988765");

            System.out.println("\n* VOLVER A INTENTAR PAGAR BIENESINMUEBLES CON REFERENCIA CATASTRAL 1BV30988765");
            pagarInmueble(inmuebles,"1BV30988765");

        } catch (ErrorPagoException e) {
            System.out.println("************ EXCEPCIÓN PROPIA *****************");
            System.out.println(e.getMessage());
            System.out.println("************************************************");
        }
        
    }

    /**
     * 
     * @param inmuebles
     * @param referenciaCatastral
     * @throws ErrorPagoException
     */
    public static void pagarInmueble(List<BienesInmuebles> inmuebles, String referenciaCatastral) throws ErrorPagoException{
        BienesInmuebles tributo = buscarTributo(inmuebles,referenciaCatastral);

        

        if (tributo != null){
            System.out.println("tributo!!!"+tributo.toString());
            double precio = tributo.pagarTributo();
            System.out.println("Pagado el tributo con referencia catastral "+referenciaCatastral);
            //System.out.println("El importe del mismo:"+tributo.calcularImporte());
            System.out.println("El importe del mismo:"+precio);
        }else{
            System.out.println("No existe la referencia "+referenciaCatastral);
        }

    }

    /**
     * 
     * @param identificador
     * @return
     */
    public static BienesInmuebles buscarTributo(List<BienesInmuebles> inmuebles, String referenciaCatastral){
        for (BienesInmuebles bienesInmuebles : inmuebles) {
            if (bienesInmuebles.getReferenciaCatastral().equals(referenciaCatastral))
                return bienesInmuebles;
        }
        return null;

    }

}
