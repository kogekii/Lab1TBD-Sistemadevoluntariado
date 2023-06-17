Para Restaurar los archivos hay dos maneras posibles, primero crear una base de datos manualmente desde pgadmin o bien crear  la BD mdiante consola sql


------------Consola SQL Y queryTool--------------

-si se crea mediante consola, es necesario loguarse y luego copiar todo lo del archivo dbCreatee y pergarlo directamente en la consola.


Eso creará una nueva base de datos con las tablas cargadas en la BD directamente;

*Luego es necesario copiar los datos del archivo division_regional y pegarlos haciendo query tool de pgadmin de la base de datos creada por consola.

*Luego es necesario copiar los datos del archivo loadData mediante query tool, para poblar las tablas con datos.



------------queryTool ------------------------------


- si se crea manualmente (es decir mediante pgadmin) es necesario utilizar el comando abriendo la query tool de la BD:

\c "nombreBD";

CREATE EXTENSION postgis;


Esto permitirá hacerla una base georeferencial.

Luego es repetir los mismos pasos que la primera opción.

