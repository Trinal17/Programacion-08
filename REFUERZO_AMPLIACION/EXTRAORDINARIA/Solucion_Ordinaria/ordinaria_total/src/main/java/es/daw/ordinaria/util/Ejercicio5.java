package es.daw.ordinaria.util;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
                pintaPedidos(pedidos, daoP);

                System.out.println("********* ACTUALIZAR PRECIO PEDIDO ID 17 A 1 EURO");
                actualizarPedido(daoP);
                pintaPedidos(pedidos, daoP);


                System.out.println("**** BORRAR PEDIDOS CUYO PRECIO SUPERA UN VALOR");
                borrarPedido(daoP);
                pintaPedidos(pedidos, daoP);

                mostrarInformeCompletoOrdenado(daoC, daoP);
    
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }



    }

    /**
     * insertarPedido
     * @param daoP
     * @throws SQLException
     */
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

    /**
     * actualizarPedido
     * @param daoP
     * @throws SQLException
     */
    private static void actualizarPedido(DaoPedido daoP) throws SQLException{
        // Enunciado: actualiza el pedido con id 
        Pedido pedidoAct = new Pedido();
        pedidoAct.setPrecio(1);
        pedidoAct.setId(17);

        daoP.update(pedidoAct);

    }


    /**
     * Método que borrar los pedidos cuyo precio sea superior a un valor dado
     * @param daoP
     * @throws SQLException
     */
    private static void borrarPedido(DaoPedido daoP) throws SQLException{
        Pedido p = new Pedido();
        p.setPrecio(2000);

        daoP.delete(p);
    }

    private static void pintaPedidos(List<Pedido> pedidos, DaoPedido daoP) throws SQLException{
        System.out.println("********** PEDIDOS ACTUALIZADOS ******");
        pedidos = daoP.selectAll();
        pedidos.forEach(System.out::println);


    }

    // MÉTODO PARA LISTAR LOS PEDIDOS DE TODOS LOS CLIENTES PERO QUE NO APAREZCA
    // EL CÓDIGO DEL CLIENTE SINO SU NOMBRE COMPLETO, ORDENADO POR NOMBRE COMPLETO DESC
    private static void mostrarInformeCompletoOrdenado(DaoCliente daoC, DaoPedido daoP) throws SQLException{
        List<Cliente> clientes = daoC.selectAll();
        List<Pedido> pedidos = daoP.selectAll();

        StringBuilder sb = new StringBuilder();
        String nombreCompletoCliente = "";
        Cliente cliente;

        String todosNombres = "";

        Map<String,Pedido> mapa = new TreeMap<>(Comparator.reverseOrder());

        for (Pedido pedido : pedidos) {
            sb.append(pedido.getId()).append(", ").
            append(pedido.getPrecio()).append(", ").
            append(pedido.getFecha()).append(", ");

            // obtener el nombre
            int idCliente = pedido.getIdCliente();

            // 2 opciones: 
            // - 2.1: Recorro la lista de cliente y busco el cliente cuyo código == idCliente
            // - 2.2: Uso el método JDBC select(idCliente)

            //cliente = daoC.select(idCliente);
            //nombreCompletoCliente = cliente.getNombre()+" "+cliente.getApellido1()+" "+cliente.getApellido2();

            for (Cliente c : clientes) {
                if (c.getId() == idCliente){
                    nombreCompletoCliente = c.getNombre()+" "+c.getApellido1()+" "+c.getApellido2();
                }
            }
            

            // Añado finalmente el nombre completo
            sb.append(nombreCompletoCliente+"\n");

            todosNombres += nombreCompletoCliente+"-";

            // Insertar datos el Map
            mapa.put(nombreCompletoCliente, pedido);

            
        }

        System.out.println("* TODOS LOS NOMBRES A CHOLÓN: "+todosNombres);
        System.out.println("********* INFORME COMPLETO (SIN ORDENAR) ******* ");
        System.out.println(sb.toString());

        System.out.println("********* INFORME COMPLETO (MAP ORDENADO) ******* ");
        for (Map.Entry<String,Pedido> fila : mapa.entrySet()) {
            System.out.println(fila.getKey()+"-"+fila.getValue());
        }

    }

}
