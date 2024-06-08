package es.daw.ordinaria.util;

import java.sql.SQLException;
import java.time.LocalDate;
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

        // -----------------------------
        // NO HAY GETPARAMETER....
        int id_cliente = 2; //probar con 8
        //int id_cliente_fake = 666;
        //int id_cliente = 666;
        // -----------------------------


        //List<Cliente> clientes = null;
        DaoCliente daoC = null;
        DaoPedido daoP = null;
        List<Pedido> pedidos = null;
        //List<Cliente> clientes = null;

        String nombreApellido = "";

        try {
            daoP = new DaoPedido();
            daoC = new DaoCliente();

            // BORRO EL PEDIDO CORRUPTO QUE TIENE ID 17....
            System.out.println("* BORRAR PEDIDO CORRUPTO CON ID 17!!!!!");
            daoP.delete(17);

            //clientes = daoC.selectAll();
            pedidos = daoP.selectAll();


            System.out.println("********** PEDIDOS ******");
            pedidos.forEach(System.out::println);

            // Ordenados por precio descendente!!!
            pedidos.sort((p1,p2) -> Double.valueOf(p2.getPrecio()).compareTo(Double.valueOf(p1.getPrecio())));

            Cliente c = daoC.select(id_cliente);
            System.out.println("Cliente:"+c);

            // // COMPROBAR QUE EL CLIENTE EXISTA....
            if (c == null){
                System.out.println("El cliente con id "+id_cliente+" no existe");
            }else{
                nombreApellido = c.getNombre()+" "+c.getApellido1();
                System.out.println("nombreApellido:"+nombreApellido);
    
                // Listar
                pedidos = Utils.obtenerPedidosDelCliente(id_cliente, pedidos);
                System.out.println("********* PEDIDOS FILTRADOS **********");
                System.out.println("Pedidos del cliente "+nombreApellido);
                pedidos.forEach(System.out::println);

                insertarPedido(daoP);
                System.out.println("Se ha insertado correctamente el nuevo pedido");
                // Quiero pintar de nuevo la lista de pedidos
                pedidos = daoP.selectAll();

                System.out.println("********** PEDIDOS ******");
                pedidos.forEach(System.out::println);
    


            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }



    }

    private static void insertarPedido(DaoPedido daoP) throws SQLException{
        Pedido pedidoNuevo = new Pedido();
        pedidoNuevo.setPrecio(12000);
        pedidoNuevo.setFecha(LocalDate.now());
        pedidoNuevo.setIdCliente(666); // Adela Salas

        // COMPROBAR QUE EL CLIENTE EXISTE, SI NO EXISTE NO INSERTO EL PEDIDO
        // PARA NO CREAR PEDIDOS INCONSISTENTES
        // EN ESE CASO PROPAGAR UNA EXCEPCIÓN PROPIA ClienteNoExisteException
        daoP.insert(pedidoNuevo);



    }

    // PENDIENTE HACER UN UPDATE DE LO QUE SE QUIERA...
    //private static void actualizarXXX();

    // PENDIENTE HACER UN BORRADO DE PEDIDO CUYO TOTAL SE > QUE XXXX
    //DELETE FROM PEDIDO WHERE TOTAL > ?
    // Pedido p = new Pedido();
    // p.setPrecio(5000);
    // ? => pedido.getTotal();

}
