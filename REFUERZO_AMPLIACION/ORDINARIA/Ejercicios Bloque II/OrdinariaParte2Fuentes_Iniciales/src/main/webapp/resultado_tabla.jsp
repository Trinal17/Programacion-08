<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    
    <body>
        <h2>Informe de pedidos del cliente ${cliente}</h2>
        <table border='1'>
            <tr>
                <th>ID PEDIDO</th>
                <th>PRECIO TOTAL</th>
                <th>FECHA</th>
            </tr>
            ${filas}
        </table>
        <a href="index.html">Volver</a>
    </body>
</html>

