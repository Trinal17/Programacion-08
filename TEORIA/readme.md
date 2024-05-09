# JDBC

## SQLite

<img src="https://github.com/profeMelola/-Programacion-08-2023-24-/assets/91023374/2dbc38b5-318e-4d50-b407-1b58e4195367" height="100"/>

SQLite es una biblioteca o base de datos ligera e independiente, que ya está integrada en numerosas aplicaciones. Destaca sobre todo por la ausencia de una estructura cliente-servidor.

El código de SQLite es de dominio público y, por lo tanto, es de uso gratuito para cualquier propósito, comercial o privado. SQLite es la base de datos más implementada en el mundo con más aplicaciones de las que podemos contar, incluidos varios proyectos de alto perfil.

SQLite lee y escribe directamente en archivos de disco ordinarios. Una base de datos SQL completa con varias tablas, índices, disparadores y vistas está contenida en un solo archivo de disco. 

https://www.sqlite.org/

### Crear una base de datos vacía 

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/fcd4bb19-ab52-4b06-aa3a-e58be8d354fc)

### Visual Studio Code + SQLite

#### Instalar la extensión:

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/fa7e2196-cf7d-4298-964e-a0956c2a5e97)

___

#### Ejecutar sql

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/b69d3d0b-338c-4150-8030-13349a676799)


![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/9f10f714-c1b8-48b6-943f-88fe40a3e2f6)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/c4e6cd9d-b29e-484d-a897-50e18b7ccdd9)

![image](https://github.com/profeMelola/Programacion-08-2023-24/assets/91023374/7a13e1b6-6048-4a58-8388-efb478795e44)



## Driver JDBC: dependencia

 A añadir en el pom.xml de nuestro proyecto Maven:
```
        <!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.45.2.0</version>
        </dependency>
```
## Objeto request

```
        // Para leer parámetros en formato UTF-8
        request.setCharacterEncoding("UTF-8");

```

```
	// Formas de leer parámetros del formulario en el Servlet
		// -----------------------------------------------------------
		// Para obtener todos los parámetros en un map (nombre,valor)
		Map<String,String[]> propiedades = request.getParameterMap();
		
		// Para obtener valores de un campo multivalor
		String[] provincias = request.getParameterValues("provincia");
		
		// Para obtener el valor de un campo simple
		String nombre = request.getParameter("nombre");
		// -------------------------------------------------------
	
```
## Operaciones que haremos contra la BD

![image](https://user-images.githubusercontent.com/91023374/234879873-bb42e5f6-be4f-4fc2-b4cc-7ea556346903.png)

El CRUD es un acrónimo que significa Create, Read, Update y Delete. 

Estas son las cuatro operaciones básicas que podemos realizar sobre una base de datos (insert, select, update, delete)

## Patrón de diseño: DAO

- El patrón DAO propone separar por completo la lógica de negocio de la lógica para acceder a los datos. 
- El DAO proporcionará los métodos necesarios para insertar, actualizar, borrar y consultar la información... 
- La capa de negocio solo se preocupa por lógica de negocio y utiliza el DAO para interactuar con la fuente de datos.

http://www.cursohibernate.es/doku.php?id=patrones:dao

![image](https://user-images.githubusercontent.com/91023374/234880925-ec9b54eb-d257-4ab0-ba1b-ae28a33086ff.png)

*fuente: https://openwebinars.net/*

## Desfase objeto-relacional

https://datos.codeandcoke.com/apuntes:hibernate#:~:text=El%20desfase%20objeto%2Drelacional%20surge,una%20base%20de%20datos%20relacional.

![image](https://user-images.githubusercontent.com/91023374/235109155-24752bf2-8085-4473-bc11-b4b4f7dbc70e.png)

*fuente: https://cipsa.net/que-es-un-orm-y-cuando-emplearlo/*


### ORM (Object-Relational Mapping)

Herramienta que permite mapear automáticamente los objetos de la aplicación con las tablas de la base de datos y mantenerlos sincronizados. 

Los ORM suelen implementar mecanismos de caché para mejorar el rendimiento y gestionan automáticamente la actualización de los objetos cuando se realizan cambios en la tabla de la base de datos.

https://ed.team/blog/que-es-un-orm

#### Ejemplo con JDBC

```
. . .				
String sentenciaSql = "INSERT INTO personajes (nombre, descripcion, vida, ataque)" +
  ") VALUES (?, ?, ?, ?)";
PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
sentencia.setString(1, personaje.getNombre());
sentencia.setString(2, personaje.getDescripcion());
sentencia.setInt(3, personaje.getVida());
sentencia.setInt(4, personaje.getAtaque());
sentencia.executeUpdate();
 
if (sentencia != null)
  sentencia.close();
. . .
```

#### Ejemplo con Hibernate

```
@Entity
@Table(name="personajes")
public class Personaje {
  @Id // Marca el campo como la clave de la tabla
  @GeneratedValue(strategy = IDENTITY)
  @Column(name="id")
  private int id;
  @Column(name="nombre")
  private String nombre;
  @Column(name="descripcion")
  private String descripcion;
  @Column(name="vida")
  private int vida;
  @Column(name="ataque")
  private int ataque;
 
  public Personaje(. . .) {
    . . .
  }
 
  // getters y setters
}
```

```
. . .
sesion = HibernateUtil.getCurrentSession();
sesion.beginTransaction();
sesion.save(personaje);
sesion.getTransaction().commit();
sesion.close();
. . .
```

### Recursos

https://datos.codeandcoke.com/apuntes:jdbc
