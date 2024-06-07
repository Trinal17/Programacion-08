package es.daw.ordinaria.util;

import java.sql.SQLException;
import java.util.List;


import es.daw.ordinaria.bd.DaoCliente;
import es.daw.ordinaria.bd.DaoPedido;
import es.daw.ordinaria.modelBD.Cliente;
import es.daw.ordinaria.modelBD.Pedido;

public class Ejercicio5 {
    public static void ejecuta(){

        // <select name="id_cliente" id="id_cliente">
        //     <option value="1">Aarón Rivero</option>
        //     <option value="2">Adela Salas</option>
        //     <option value="3">Adolfo Rubio</option>
        //     <option value="4">Adrián Suárez</option>
        //     <option value="5">Marcos Loyola</option>
        //     <option value="6">María Santana</option>
        //     <option value="7">Pilar Ruiz</option>
        //     <option value="8">Pepe Ruiz</option>
        //     <option value="9">Guillermo López</option>
        //     <option value="10">Daniel Santana</option>
        //     <option value="666">Cliente FAKE</option>
        // </select>

        int id_cliente = 2;

        //List<Cliente> clientes = null;
        DaoCliente daoC = null;
        DaoPedido daoP = null;
        List<Pedido> pedidos = null;
        //List<Cliente> clientes = null;

        StringBuilder sb = new StringBuilder();

        String nombreApellido = "";

        try {
            daoP = new DaoPedido();
            daoC = new DaoCliente();
            //clientes = daoC.selectAll();
            pedidos = daoP.selectAll();

            System.out.println("********** PEDIDOS ******");
            pedidos.forEach(System.out::println);

            // Ordenados por precio ascendente!!! 0,5 PUNTOS!!!!
            pedidos.sort((p1,p2) -> Double.valueOf(p2.getPrecio()).compareTo(Double.valueOf(p1.getPrecio())));

            Cliente c = daoC.select(id_cliente);
            System.out.println("Cliente:"+c);

            // COMPROBAR QUE EL CLIENTE EXISTA.... 1,25 PUNTOS!!!!
            if (c == null){
                System.out.println("El cliente con id "+id_cliente+" no existe");
            }

            nombreApellido = c.getNombre()+" "+c.getApellido1();
            System.out.println("nombreApellido:"+nombreApellido);

            // Listar
            pedidos = Utils.obtenerPedidosDelCliente(id_cliente, pedidos);
            System.out.println("********* PEDIDOS FILTRADOS **********");
            pedidos.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }



    }
}
