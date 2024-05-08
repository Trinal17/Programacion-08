# Oficina JDBC

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/ef0d36b4-888f-42d3-9cd1-19cceb3bce87)


<img src="https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/0f8c714f-0279-4bae-9e1a-642527c9bf26" height="400px"/>


## Especificaciones

### INFORME PERSONALIZADO DE OFICINA

Al hacer click en el botón de **Obtener Informe** se generará una página html con una tabla que contendrá información de la oficina cuyo código se haya seleccionado en la lista html.

La lista de códigos de oficina es monoselección, por tanto el informe resultado estará compuesto por una tabla con solo una fila con tantas columnas como campos checkbox se hayan seleccionado. A tener en cuenta:
- El campo dirección hace referencia a la dirección completa (campos de base de datos linea_direccion1 + linea_direccion2)
- No debes tocar nada de la página index.html.

En el caso de que no se haya seleccionado ningún campo, el **Servlet1** parará de procesar y redirigirá la salida a la página error.html (response.sendRedirect("error.html"))

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/e0f9e403-438c-4465-821c-b927dae83339)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/b4503288-b97e-4e41-ad5f-88ccf990a480)


**A TENER EN CUENTA A LA HORA DE PROGRAMAR:**
- Toda la información del informe se obtiene de las colecciones que has cargado y tienes en memoria. 
- Debes trabajar con las colecciones de los pedidos y los clientes para obtener la información. No debes realizar querys complejas (joins) contra base de datos cruzando las dos tablas.
- Las ordenaciones también se realizan directamente sobre las colecciones Java. No debes hacer order by en la query contra la B.D

### DAR DE ALTA UN EMPLEADO A TRAVÉS DE DATOS EN FORMATO CSV

El **Servlet2** va a recibir una cadena de texto con toda la información necesaria para dar de alta un empleado en la base de datos.

Debes leer esa información y tratarla para poder hacer la inserción. Daremos por hecho que siempre va a llegar una cadena con el formato correcto.

Cuando se haya creado el empleado correctamente el Servlet2 el mensaje:

```
El empleado NOMBRE APELLIDO1 se ha dado de alta correctamente
```

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/82fea845-843f-4e8c-be62-684b70e1d39c)




Antes de dar de alta el empleado, hay que verificar que el código de oficina exista. En caso de que no sea así, el Servlet2 redirigirá la salida a la página error.jsp con el mensaje 
```
ERROR: El código de oficina ALCALA-ES no existe en la base de datos
```

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/337577d2-087f-4003-a631-b763605a4d06)


Observa que en los datos de prueba aparece el código **ALCALA-ES en el textarea (código que no existe)**. Te servirá para tus pruebas. Debes insertar al menos dos empleados bien.

Por otro lado, si se produjera cualquier excepcion (SQLException, IOException ….), el Servlet2 también redirigirá el mensaje de error a error.jsp.


