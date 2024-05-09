# Oficina JDBC

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/ef0d36b4-888f-42d3-9cd1-19cceb3bce87)


<img src="https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/0162cce1-74c5-4bd5-9d69-a570bd2846e6" height="600px"/>

## Especificaciones

### 1. Informe personalizado de Oficina

Al hacer click en el botón de **Obtener Informe** se generará una página html con una tabla que contendrá información de la oficina cuyo código se haya seleccionado en la lista html.

La lista de códigos de oficina es monoselección, por tanto el informe resultado estará compuesto por una tabla con solo una fila con tantas columnas como campos checkbox se hayan seleccionado. A tener en cuenta:
- El campo dirección hace referencia a la dirección completa (campos de base de datos linea_direccion1 + linea_direccion2)
- No debes tocar nada de la página index.html.

En el caso de que no se haya seleccionado ningún campo, el **Servlet1** parará de procesar y redirigirá la salida a la página error.html (response.sendRedirect("error.html"))

**Ejemplos de salida:**

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/e0f9e403-438c-4465-821c-b927dae83339)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/b4503288-b97e-4e41-ad5f-88ccf990a480)


**A tener en cuenta a la hora de programar:**

- Toda la información del informe se obtiene de las colecciones que has cargado y tienes en memoria. 
- Debes trabajar con las colecciones de los pedidos y los clientes para obtener la información. No debes realizar querys complejas (joins) contra base de datos cruzando las dos tablas.
- Las ordenaciones también se realizan directamente sobre las colecciones Java. No debes hacer order by en la query contra la B.D

___

### 2. Dar de alta un empleado a través de datos en formato CSV

El **Servlet2** va a recibir una cadena de texto con toda la información necesaria para dar de alta un empleado en la base de datos.

Debes leer esa información y tratarla para poder hacer la inserción. Daremos por hecho que siempre va a llegar una cadena con el formato correcto.

Cuando se haya creado el empleado correctamente el Servlet2 el mensaje:


![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/82fea845-843f-4e8c-be62-684b70e1d39c)



Antes de dar de alta el empleado, hay que verificar que el código de oficina exista. En caso de que no sea así, el Servlet2 redirigirá la salida a la página error.jsp con el mensaje 

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/337577d2-087f-4003-a631-b763605a4d06)


Observa que en los datos de prueba aparece el código **ALCALA-ES en el textarea (código que no existe)**. Te servirá para tus pruebas. Debes insertar al menos dos empleados bien.

Por otro lado, si se produjera cualquier excepcion (SQLException, IOException ….), el Servlet2 también redirigirá el mensaje de error a error.jsp.
___

#### 2.1 Para comprobar que se ha dado de alta el empleado correctamente

El **Servlet3** se ejecutará para mostrar la lista de empleados. El código se proporciona completo. No debes tocar nada!!!

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/3feccffa-b296-43ce-9fe4-f0f832f8925f)

Obtendrás un informe como el siguiente:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/85bb9b13-3c94-427a-a0ba-4504e87f8671)

___

### 3. Fichero de log de usuarios dados de alta

Añade en **Servlet2** el código necesario para que cada vez que se de de alta un usuario esta información se registre en un **fichero de log situado en un directorio llamado LOG del directorio home del usuario.**

- Ese directorio no debes crearlo a mano.
- El fichero de log se llamará **empleados.log.**
- Cada información sobre un nuevo empleado (toString()) se añadirá como una nueva línea empezando con la fecha en formato dd/MM/YYYY HH:mm:ss (revisa la clase Utils.java)
  
![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/dae104a4-35d9-4c2a-aed8-57f80156539a)



