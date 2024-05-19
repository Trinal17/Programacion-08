# Gestión de empleados

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/e26aec01-9fbf-4f84-b4d5-de9372e5a524)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/689abe5d-92c1-4091-a940-fb7846733094)

___
## Informes

Existen diferentes formas de mostrar el informe de los empleados, tanto por el departamento al que pertenecen los empleados como por la ordenación.

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/eda06ade-18f4-48a9-967c-d9d0db1d1525)

Dependiendo de lo seleccionado en la lista, los empleados a mostrar pueden ser de todos los departamentos (todos los empleados) o de un departamento en concreto.

___
### Mostrar todos los empleados

Observa la lista html. Cada departamento tiene asociado su correspondiente código y que en el caso de querer mostrar todos los empleados, el código recibido será 0.

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/24c29951-e859-4514-8bd2-613889ddcbf5)

Por defecto: se mostrarán sin ningún orden y nombre, apellido1, apellido2 van en la misma columna:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/3afd18ab-02a8-4ae0-8c1f-53a2b8bd1a18)

En la tabla debe aparecer el nombre del departamento, no el código. Para obtener el nombre debes hacer a través de una consulta SQL (SELECT nombre from departamento where codigo = ? )

Ten en cuenta que hay empleados que no tienen departamento, es null  (revisa los datos de la primera página del enunciado). En vez de aparecer NULL en el campo departamento de la tabla, debe aparecer “sin_departamento”

___
### Mostrar los empleados de un departamento concreto

Por ejemplo, si se selecciona el departamento desarrollo, los empleados serán:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/4d428402-34e9-4e54-a339-11b9232cbfb2)

Estos empleados filtrados deben obtenerse de la colección de memoria, no haciendo una consulta específica SQL. Hazlo mediante un método estático en la clase Utils.java.

Si el departamento no tiene empleados, la tabla saldrá vacía, por ejemplo el departamento “Proyectos”:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/362e0ef0-9274-4b5b-ad6a-cf1e26f0062d)

___
### Comprobar que el departamento exista

Hay que controlar si el departamento elegido de la lista no existe. Para tus pruebas, el departamento “Creativo” no existe en base de datos. 

Esta comprobación debes hacerla vía java y no sql, por tanto no debes usar una consulta contra la base de datos. Hazlo mediante un método estático en la clase Utils.java. 

Si el departamento no existe, debe devolverse la página resultado_mensaje.jsp con el siguiente mensaje: 

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/61fe2a09-463b-4c5f-b0a2-86e6d5a5c95f)

___
### Ordenaciones

- Si se selecciona el ordenado por NIF, los empleados deben de aparecer acordes a la ordenación natural.
- Si se selecciona el ordenado por nombre, los empleados deben aparecer ordenados solo por “nombre” de forma ascendente

___
## Importación JSON: carga masiva de empleados en BD

- Es necesario leer el archivo JSON llamado empleados.json que se encuentra en el directorio webapp del proyecto. Como puedes observar, el json contiene cuatro empleados.
- Esos cuatro empleados se deben cargar en un array de objetos Empleado. Para ello usa:
```
Empleado[] empleados = gson.fromJson(reader, Empleado[].class); 
// reader es el encargado de leer el archivo Json
```
- Una vez cargado el array, píntalo por consola en el siguiente formato:
  
```
******** EMPLEADOS DEL JSON  **************
NIF: 12345678A
Nombre: Nombre1
Apellido1: Apellido11
Apellido2: Apellido12
Código departamento: 1

NIF: 12345678B
….
```

- Por un fallo informático, el JSON tiene empleados repetidos. 
    - Antes de insertar debes comprobar que no haya empleados repetidos, teniendo en cuenta que un empleado es igual a otro si coinciden su NIF.
    - Muestra por consola los empleados no repetidos:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/02b78229-246f-45a0-ad87-6cb909658cfd)

- Una vez que tengas los empleados a insertar no repetidos, realiza la inserción en BD.
- Como resultado debes devolver la página resultado_mensaje.jsp con el mensaje siguiente:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/54d8c691-4610-4fc0-869c-93ba6cd6ac0f)

- Una vez ejecuta con éxito la inserción, si vuelves a ejecutar la carga masiva, obtendrás una excepción porque el nif tiene una restricción unique: org.sqlite.SQLiteException
- Captura correctamente la excepción y muestra su mensaje (getMessage())  en la página resultado_mensaje.jsp
  
![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/b9c99087-37a6-4407-9f17-8fb09253ea49)


___
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
- Como resultado:

  ![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/508006c7-886c-466e-9b92-b55780184d77)


Si todo ha ido bien, esta sería la estructura de carpetas y el contenido de cada archivo CSV:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/c552d151-47c9-48c5-b933-9911d0ecf948)
