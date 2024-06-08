package es.daw.ordinaria.exception;

import es.daw.ordinaria.model.Tributo;

public class ErrorPagoException  extends Exception{
    
    public ErrorPagoException(Tributo tributo){
        super("EL TRIBUTO CON IDENTIFICADOR "+tributo.getIdentificador()+" ESTÁ PAGADO CON FECHA " + tributo.getFechapagado().toString());
    }
    
    /*
    // ---------------------------------
    // FORMA 2
    private Tributo tributo;
    public ErrorPagoException(Tributo tributo) {
        this.tributo = tributo;
    }

    @Override
    public String getMessage() {
        return "EL IMPUESTO CON REFERENCIA "+tributo.getReferencia()+" ESTÁ PAGADO CON FECHA " + tributo.getFechapagado().toString();
    }    
    // ---------------------------------
    */
}
