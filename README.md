<div align="center">
    <h1> <img src="https://th.bing.com/th/id/R.70c11b59c144e8d8af1a292274043105?rik=qsIhI%2f3hvZdFJQ&pid=ImgRaw&r=0" width="80px"> <br/>Laboratorio 1 y 2 TBD
    </h1>
</div>

## Autores

-   **Esteban Glochon**
-   **Andres Ijura**
-   **Leonardo Muñoz**
-   **Gonzalo Ordenes**

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

### Instrucciones de Instalacion:

- Prerrequisitos:
    Se debe tener las siguientes tecnologias para la ejecucion optima del proyecto.
    a) PgAdmin4
    b) IDE Intellij.
    c) JDK 17.
    d) PostGis.

- Clonar el repositorio, la URL es:
        https://github.com/kogekii/Lab1TBD-Sistemadevoluntariado

- Base de datos:
    Se debe crear una base de datos llamada "voluntariado", la cual sera poblada con el archivo [backup], el cual cuenta con un script de creacion de la base de datos y la pobla con informacion para la utilizacion y pruebas del programa.

- Backend:
    Se debe poner la contraseña de admin en el documento application.properties y eliminar el .example, que se encuentra en la carpeta
    src/main/resources/application.properties.example
    Para ejecutar el codigo se debe abrir la carpeta raiz del proyecto con el IDE Intellij y abrir el archivo llamado ServiciovoluntariadoApplication.java y presionar el boton de play verde en el editor.

- Frontend:
    Para la instalacion de las dependencias de javascript y react se debe dirigir a la carpeta llamada voluntariado-frontend-react, y con la consola posicionada en esta se tiene que ejecutar los siguientes comandos:
    1) npm install react
    2) npm run build
    3) npm run start
    Con todo lo anteriormente realizado se levantara un servidor de frontend con react, donde se encontrara todas las vistas del sistema.