# JDBC

## SQLite


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
