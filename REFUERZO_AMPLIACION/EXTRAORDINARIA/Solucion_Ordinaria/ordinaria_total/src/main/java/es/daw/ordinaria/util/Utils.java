package es.daw.ordinaria.util;

import java.util.ArrayList;
import java.util.List;

import es.daw.ordinaria.modelBD.Pedido;

/**
 *
 * @author melola
 */
public class Utils {

    /**
     * 
     * @param cod_departamento
     * @param empleados
     * @return
     */
    public static List<Pedido> obtenerPedidosDelCliente(int id_cliente,List<Pedido> pedidos){
        List<Pedido> pedidosAux = new ArrayList<>();

        for (Pedido p : pedidos) {
            if (p.getIdCliente() == id_cliente)
            pedidosAux.add(p);
        }

        return pedidosAux;
    }

    
}
