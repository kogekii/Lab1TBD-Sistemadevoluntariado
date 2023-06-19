<div align="center">
    <h1> <img src="https://th.bing.com/th/id/R.70c11b59c144e8d8af1a292274043105?rik=qsIhI%2f3hvZdFJQ&pid=ImgRaw&r=0" width="80px"> <br/>Laboratorio 1 y 2 TBD
    </h1>
</div>

## Autores

-   [**Esteban Glochon**](https://github.com/EstebanGlochonUSACH)
-   [**Andres Ijura**]()
-   [**Leonardo Muñoz**]()
-   [**Gonzalo Ordenes**](https://github.com/Gonzalo-OrdenesQ)

# Descripcion

En nuestro pais, con la ocurrencia de desastres naturales, se da con frecuencia que voluntarios concurren espontaneamente al sitio del suceso. Si bien su presencia es de gran ayuda, puede resultar dificil coordinar sus esfuerzos para la realizacion de tareas.
Para este fin, se propone crear un sistema para la gestion del voluntariado espontaneo.

# Caracteristicas

**Modulo de coordinacion**
Se construyo un modulo consistente en una aplicacion web para la gestion de coordinadores, quienes pueden crear emergencias y tareas, ademas de definir requisitos para cada una de estas.

**Modulo de voluntariado**
Por otro lado, se construyo un modulo web para que voluntarios puedan registrarse, crear y editar perfiles, ver y registrarse en emergencias activas, registrar habilidades que posee y puedan ser utiles en una emergencia, ver y aceptar tareas, ademas de actualizar el estado de las mismas.

# Tecnologias tilizadas:
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![React.js](https://img.shields.io/badge/-ReactJs-61DAFB?logo=react&logoColor=white&style=for-the-badge) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)

## Instrucciones de Instalación y Ejecución

### Prerrequisitos

Se debe tener las siguientes tecnologias para la ejecucion optima del proyecto.

- PgAdmin4
- IDE Intellij.
- JDK 17.
- PostGis.

### Clonar el repositorio

La URL es: [https://github.com/kogekii/Lab1TBD-Sistemadevoluntariado](https://github.com/kogekii/Lab1TBD-Sistemadevoluntariado)

### Base de datos

Se debe crear una base de datos llamada `voluntariadofinal`, la cual sera poblada con el archivo [backup], el cual cuenta con un script de creacion de la base de datos y la pobla con informacion para la utilizacion y pruebas del programa.

### Backend

Se debe crear un archivo `application.properties` en la carpeta `src/main/resources/`. Para ello se diponse de un archivo de ejemplo `application.properties.example` que se puede copiar para.

Se deben reemplazar, de ser necesario, las credenciales de acceso a la base de datos postgres (usuario, contraseña y nombre de la base de datos) en el documento `application.properties`.

Para ejecutar el codigo se debe abrir la carpeta raiz del proyecto con el IDE Intellij y abrir el archivo llamado ServiciovoluntariadoApplication.java y presionar el boton de play verde en el editor.

Alternativamente, en Linux, se puede ejecutar la aplicacion a traves de linea de comandos en la carpeta raiz del proyecto, de la siguiente forma:

```sh
$ ./mvnw spring-boot:run
```

Notar que antes de ejecutar la aplicacion se deben instalar las dependencias. A traves del IDE Intellij, se pueden instalar automaticamente ustilizando el plugin de Maven. En linux se puede tambien utilizar el comando `./mvnw clean install` a través de una terminal en el directorio raiz del proyecto.

### Frontend

El codigo fuente de la parte del frontend del proyecto se encuentra en la carpeta `voluntariado-frontend-react`. Antes de poder ejecutar el frontend, se deben instalar sus dependencias, en una consola utilizando en siguiente comando:

```
npm instal
```

Luego, para poder ejecutar el codigo del frontend se utiliza en siguiente codigo:

```
npm run start
```

Si se ejecuto lo anterios sin problemas, a continuacion se pobra visualizar la interfaz grafica de la aplicacion en el navegador donde se encontraran todas las vistas del sistema.

## Correr una BD con Docker

En el proyecto se podrá encontrar un archivo `docker-compose.yml` para poder crear y ejecutar una base de datos postgres+postgis, junto con una instancia de pgadmin.

Cabe destacar que de ser necesario se deben modificar las credenciales por defecto en ese archivo para que coincidan con las credenciales definidas en el archivo `application.properties`.

Para ejecutar el servidor de base de datos postgres y pgadmin:

```
docker-compose up -d
```

Para detener el servidor

```
docker-compose stop
```

Y para eliminar los contenedores:

```
docker-compose down
```

> `NOTA`: Ejecutar `docker-compose down` no va a borrar los datos de la base de datos mientras no se eliminen los volumenes.

## Poblar la base de datos

> `NOTA`: Los scripts SQL necesario se encuentran en la carpeta `ScriptsBD`.

Existen 2 formas de poblar la base de datos.

La primera es ejecutar los scripts SQL a traves de pgadmin. Se puede directamente copiar el codigo en el "Query Tool" que provee en el siguiente orden:

1. `dbCreate.sql`
2. `division_regional.sql`
3. `loadData.sql`

> `NOTA`: En el script `dbCreate.sql` se hace referencia a la base de datos `voluntariadofinal`, en caso de que se haya cambiado o se quiera usar otro nombre, se puede simplemente reemplazar antes de ejecutar el script.

La segunda forma (disponible en Linux) es utilizando el comando `psql` que se instala junto con postgres, y se puede utilizar de la siguiente forma:

1. Crear las tablas:
    ```sh
    $ cat "/scripts/dbCreate.sql" | psql
    ```
2. Importar los datos para postgis de las regiones de Chile:
    ```sh
    $ cat "/scripts/division_regional.sql" | psql voluntariadofinal
    ```
3. Importar los datos para postgis de las regiones de Chile:
    ```sh
    $ cat "/scripts/loadData.sql" | psql voluntariadofinal
    ```

Notar que la ruta `/scripts/` corresponde a un volúmen montado dentro del contenedor "postgres" a través de docker. Además `voluntariadofinal` corresponde al nombre de la base de datos con la que se esta trabajando. Ambas cosas se deben reemplazar acorde a la situación.