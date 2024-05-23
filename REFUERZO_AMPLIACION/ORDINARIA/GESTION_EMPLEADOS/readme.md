# Gestión de empleados

El objetivo de este ejercicio es trabajar con:
- Colecciones avanzadas.
- Genéricos de Java.
- Ficheros.
- JDBC

Completa el proyecto en base a las siguientes especificaciones:

## Base de datos

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/44e7eb45-67ef-4d89-9912-4791ffac7dc6)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/43a0fb47-f6d2-45f9-b5c3-08161bcc2644)


## Interfaz gráfica del cliente

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/19f92cc2-18c4-43f9-8504-80df9f053dee)


___

## INFORMES

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/4c8d0e46-741b-40f2-ad36-7c8204a9470c)

### Mostrar todos los empleados

Observa la lista html. Cada departamento tiene asociado su correspondiente código y que en el caso de querer mostrar todos los empleados, el código recibido será 0.

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/b133bb90-5b2f-453d-94e5-02d2596f5f73)

Por defecto: se mostrarán sin ningún orden y nombre, apellido1, apellido2 van en la misma columna:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/01607a8e-48d3-4518-a884-341db5b02b38)

En la tabla debe aparecer el nombre del departamento, no el código. 

Para obtener el nombre debes hacer a través de una consulta SQL (SELECT nombre from departamento where codigo = ? )

Si no sabes obtener el nombre del departamento, que se muestre el código.

Ten en cuenta que hay empleados que no tienen departamento, es null  (revisa los datos de la primera página del enunciado). En vez de aparecer NULL en el campo departamento de la tabla, debe aparecer “sin_departamento”.

### Mostar los empleados de un departamento concreto

Estos empleados filtrados deben obtenerse de la colección de memoria, no haciendo una consulta específica SQL (select con where...). Hazlo mediante un método estático en la clase Utils.java.

Si el departamento no tiene empleados, la tabla saldrá vacía.

### Comprobar que el departamento exista

Hay que controlar si el departamento elegido de la lista no existe. Para tus pruebas, el departamento “Creativo” no existe en base de datos. 

Esta comprobación debes hacerla vía java y no sql, por tanto no debes usar una consulta contra la base de datos. Hazlo mediante un método estático en la clase Utils.java. 

Si el departamento no existe, debe devolverse la página resultado_mensaje.jsp con el siguiente mensaje: 

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/52ec081d-ea4a-4339-b8e3-b291bc94a889)

### Ordenaciones

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/fe45cbb7-e018-4e74-9c79-d42a42a1d34e)


___

## Importación JSON

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/62ea5696-3cd2-45a6-b748-e81f1577769e)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/508bc02e-d755-4792-853a-88157fd46a20)


![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/a0f81796-520b-4223-ae68-aa44f83fb6d9)


## Exportación CSV

Vas a implementar una simulación de exportación a CSV:

- En la carpeta home del usuario se debe crear una carpeta llamada CSV_EXAM donde se va a realizar la exportación.
  - No puedes crear ese directorio a mano. 
  - Ten en cuenta que la exportación se puede ejecutar tantas veces como se quiera. 

- Dentro de esa carpeta CSV se crearán tantas subcarpetas como departamentos haya.
  - Usa la colección que se proporciona en el código. 
  - El nombre de la subcarpeta se corresponderá con el nombre del departamento. 

- En cada una de esas subcarpetas, debe crearse un ARCHIVO CSV llamado: YYYY-MM-DD_nombreDepartamento.csv

- En cada uno de esos archivos CSV habrá información de los empleados de cada departamento. 
  - La primera línea será informativa: #CÓDIGO, NIF, NOMBRE

- Utiliza el método Utils.obtenerEmpleadosServlet3() para obtener una lista de empleados a exportar en formato CSV.
  - Dependiendo del código del departamento de cada empleado, la información de dicho empleado debe escribirse en su correspondiente fichero CSV.
  - Si vuelvo a exportar debe sobreescribirse el contenido de los CSV.
  - Como resultado debes devolver la página resultado_mensaje.jsp con el mensaje siguiente:

    ![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/bb8e55b5-78bf-4263-af58-6f00c35e1780)

  - En caso de excepción (IOException) debe devolverse el mensaje de la excepción.

  - Si todo ha ido bien, esta sería la estructura de carpetas y el contenido de cada archivo CSV:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/590e12d1-d583-4816-a868-1bbf813f6ce1)
