
-- eme-habilidad
CREATE OR REPLACE FUNCTION eme_habilidades_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_eme_habilidades values 
  (old.id, old.id_emergencia, old.id_habilidad, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION eme_habilidades_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_eme_habilidades values 
  (NEW.id, NEW.id_emergencia, NEW.id_habilidad, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION eme_habilidades_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_eme_habilidades values 
  (old.id, old.id_emergencia, old.id_habilidad, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_eme_habilidad
BEFORE UPDATE ON eme_habilidad
FOR EACH ROW
EXECUTE FUNCTION eme_habilidades_function_update();

CREATE TRIGGER insert_eme_habilidad
BEFORE INSERT ON eme_habilidad
FOR EACH ROW
EXECUTE FUNCTION eme_habilidades_function_insert();

CREATE TRIGGER delete_eme_habilidad
BEFORE DELETE ON eme_habilidad
FOR EACH ROW
EXECUTE FUNCTION eme_habilidades_function_delete();

-- emergencia
CREATE OR REPLACE FUNCTION emergencia_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_emergencia values 
  (old.id, old.nombre, old.descripcion, old.fecha, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION emergencia_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_emergencia values 
  (NEW.id, NEW.nombre, NEW.descripcion, NEW.fecha, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION emergencia_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_emergencia values 
  (old.id, old.nombre, old.descripcion, old.fecha, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_emergencia
BEFORE UPDATE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_function_update();

CREATE TRIGGER insert_emergencia
BEFORE INSERT ON emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_function_insert();

CREATE TRIGGER delete_emergencia
BEFORE DELETE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_function_delete();

-- estado-tarea
CREATE OR REPLACE FUNCTION estado_tarea_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_estado_tarea values 
  (old.id, old.estado, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION estado_tarea_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_estado_tarea values 
  (NEW.id, NEW.estado, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION estado_tarea_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_estado_tarea values 
  (old.id, old.estado, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_estado_tarea
BEFORE UPDATE ON estado_tarea
FOR EACH ROW
EXECUTE FUNCTION estado_tarea_function_update();

CREATE TRIGGER insert_estado_tarea
BEFORE INSERT ON estado_tarea
FOR EACH ROW
EXECUTE FUNCTION estado_tarea_function_insert();

CREATE TRIGGER delete_estado_tarea
BEFORE DELETE ON estado_tarea
FOR EACH ROW
EXECUTE FUNCTION estado_tarea_function_delete();

-- habilidad
CREATE OR REPLACE FUNCTION habilidad_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_habilidad values 
  (old.id, old.descripcion, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION habilidad_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_habilidad values 
  (NEW.id, NEW.descripcion, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION habilidad_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_habilidad values 
  (old.id, old.descripcion, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_habilidad
BEFORE UPDATE ON habilidad
FOR EACH ROW
EXECUTE FUNCTION habilidad_function_update();

CREATE TRIGGER insert_habilidad
BEFORE INSERT ON habilidad
FOR EACH ROW
EXECUTE FUNCTION habilidad_function_insert();

CREATE TRIGGER delete_habilidad
BEFORE DELETE ON habilidad
FOR EACH ROW
EXECUTE FUNCTION habilidad_function_delete();

-- institucion

CREATE OR REPLACE FUNCTION institucion_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_institucion values 
  (old.id, old.razon_social, NULL, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION institucion_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_institucion values 
  (NEW.id, NEW.razon_social, NULL, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION institucion_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_institucion values 
  (old.id, old.razon_social, NULL, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_institucion
BEFORE UPDATE ON institucion
FOR EACH ROW
EXECUTE FUNCTION institucion_function_update();

CREATE TRIGGER insert_institucion
BEFORE INSERT ON institucion
FOR EACH ROW
EXECUTE FUNCTION institucion_function_insert();

CREATE TRIGGER delete_institucion
BEFORE DELETE ON institucion
FOR EACH ROW
EXECUTE FUNCTION institucion_function_delete();

-- ranking 

CREATE OR REPLACE FUNCTION ranking_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_ranking values 
  (old.id, old.id_voluntario, old.id_tarea, old.puntos, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION ranking_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_ranking values 
  (NEW.id, NEW.id_voluntario, NEW.id_tarea, NEW.puntos, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION ranking_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_ranking values 
  (old.id, old.id_voluntario, old.id_tarea, old.puntos, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_ranking
BEFORE UPDATE ON ranking
FOR EACH ROW
EXECUTE FUNCTION ranking_function_update();

CREATE TRIGGER insert_ranking
BEFORE INSERT ON ranking
FOR EACH ROW
EXECUTE FUNCTION ranking_function_insert();

CREATE TRIGGER delete_ranking
BEFORE DELETE ON ranking
FOR EACH ROW
EXECUTE FUNCTION ranking_function_delete();

-- tarea
CREATE OR REPLACE FUNCTION tarea_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_tarea values 
  (old.id, old.nombre, old.descripcion, old.id_estado_tarea, old.id_emergencia, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION tarea_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_tarea values 
  (NEW.id, NEW.nombre, NEW.descripcion, NEW.id_estado_tarea, NEW.id_emergencia, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION tarea_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_tarea values 
  (old.id, old.nombre, old.descripcion, old.id_estado_tarea, old.id_emergencia, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER update_tarea
BEFORE UPDATE ON tarea
FOR EACH ROW
EXECUTE FUNCTION tarea_function_update();

CREATE TRIGGER insert_tarea
BEFORE INSERT ON tarea
FOR EACH ROW
EXECUTE FUNCTION tarea_function_insert();

CREATE TRIGGER delete_tarea
BEFORE DELETE ON tarea
FOR EACH ROW
EXECUTE FUNCTION tarea_function_delete();

-- vol-habilidad
CREATE OR REPLACE FUNCTION vol_habilidad_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_vol_habilidad
  values
  (NEW.id, NEW.id_voluntario, NEW.id_habilidad, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION vol_habilidad_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_vol_habilidad 
  values
  (old.id, old.id_voluntario, old.id_habilidad, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION vol_habilidad_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_vol_habilidad
  values
  (old.id, old.id_voluntario, old.id_habilidad, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;


CREATE TRIGGER update_vol_habilidad
BEFORE UPDATE ON vol_habilidad
FOR EACH ROW
EXECUTE FUNCTION vol_habilidad_function_update();

CREATE TRIGGER insert_vol_habilidad
BEFORE INSERT ON vol_habilidad
FOR EACH ROW
EXECUTE FUNCTION vol_habilidad_function_insert();

CREATE TRIGGER delete_vol_habilidad
BEFORE DELETE ON vol_habilidad
FOR EACH ROW
EXECUTE FUNCTION vol_habilidad_function_delete();

-- vol-habilidad

CREATE OR REPLACE FUNCTION voluntario_function_insert()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_voluntario
  values
  (NEW.id, NEW.correo_electronico, NEW.nombre, NEW.password, current_user, current_timestamp, 'insert');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION voluntario_function_update()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_voluntario 
  values
  (old.id, old.correo_electronico, old.nombre, old.password, current_user, current_timestamp, 'update');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION voluntario_function_delete()
  RETURNS TRIGGER AS
$BODY$
BEGIN
  insert into log_voluntario 
  values
  (old.id, old.correo_electronico, old.nombre, old.password, current_user, current_timestamp, 'delete');
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;


CREATE TRIGGER  update_voluntario
BEFORE UPDATE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_function_update();

CREATE TRIGGER insert_voluntario
BEFORE INSERT ON voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_function_insert();

CREATE TRIGGER delete_voluntario
BEFORE DELETE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_function_delete();

-- Cargado de datos a la base de datos

-- Cargar datos de estado_tarea
INSERT into estado_tarea(id, estado) VALUES
(1, 'Terminada'),
(2, 'En proceso'),
(3, 'Pendiente'),
(4, 'Incumplida');

SELECT setval('estado_tarea_id_seq', 4, true);

-- Carga Datos para tabla habilidad
INSERT INTO habilidad(id,nombre,descripcion) VALUES
(1,'Limpieza de escombros','Recoger escombros, tierra, etc.'),
(2,'Cargar cosas','Cargar materiales de construcción u otras cosas'),
(3,'Apaga incendios','Capacidad para apagar incendios eficientmente'),
(4,'Afinidad con los animales','Capacidad de poder llevarse bien con mascotas u animales'),
(5,'Cazador de ogros','Puede enfrentarse a ogros como si de un insecto se tratase'),
(6,'Curar heridas','Posee conocimiento de enfermería que permite tratar heridas'),
(7,'Chofer','Es capaz de conducir vehiculos y transportar personas'),
(8,'Cocinero','Capacidad de cocinar distintas comidas con lo disponible'),
(9,'Constructor','Conocimiento de construcción de casas o mediasaguas'),
(10,'Buscador','Puede encontrar personas u animales perdidos'),
(11,'Organizador','Capacidad de organizar grupos de personas'),
(12,'Mensajero','Capacidad de poder trasladar comida y medicamentos'),
(13,'Telecomunicador','Puede establecer comunicaciones a distancia, manteniendo a todos comunicados');

SELECT setval('habilidad_id_seq', 13, true);


-- Carga Datos para tabla emergencia
INSERT INTO emergencia(id,nombre,ubicacion,fecha,descripcion, coordenadas) VALUES
(1,'Terremoto 8.8 Richter','Chile', '2010-02-27', 'Terremoto de alta intensidad registrado en Chile', ST_GeomFromText('POINT(-33.45694 -70.64827)', 4326)),
(2,'Ogro destroza pantano cerca de ciudad','Santiago', '2021-12-27', 'Ogro enloquece y destroza pantano en las cercanías de Santiago, se solicitan refuerzos', ST_GeomFromText('POINT(-33.45694 -70.64827)', 4326)),
(3,'Terremoto 7.8 Richter','Arica', '2005-06-13','sismo de magnitud 7,8 que se percibe entre las regiones de Arica-Parinacota y Atacama', ST_GeomFromText('POINT(-18.4746 -70.29792)', 4326)),
(4, 'Anegamiento de carretera','Putre', '2016-02-23', 'Anegamiento en diversos puntos de la carretera 11 a causa de precipitaciones', ST_GeomFromText('POINT(-18.4746 -70.29792)', 4326)),
(5, 'Aluvion en caleta', 'Iquique', '2015-08-09', 'Aluvion en el sector de la caleta San Marcos', ST_GeomFromText('POINT(-18.4746 -70.29792)', 4326)),
(6, 'Caida de rocas en carretera', 'Antofagasta', '2017-01-22', 'Lluvias generan caida de rocas en la ruta 1', ST_GeomFromText('POINT(-23.65236 -70.3954)', 4326)),
(7, 'Desborde de rio', 'Alto del Carmen', '2017-01-22', 'Desborde del rio Chollay en Alto del Carmen afecta viviendas y caminos', ST_GeomFromText('POINT(-22.45667 -68.92371)', 4326)),
(8, 'Alud', 'Cabeza del Indio', '1984-07-03', 'Alud afecta al sector de Cabeza del Indio en el paso fronterizo Los Libertadores', ST_GeomFromText('POINT(-41.4693 -72.94237)', 4326)),
(9, 'Inundaciones por marejadas', 'Valparaiso', '2015-07-28', 'Marejadas causan inundacion de estacionamientos en Valparaiso, a la altura del Puente Quinta del estero Marga Marga', ST_GeomFromText('POINT(-33.036 -71.62963)', 4326)),
(10, 'Desborde de canal', 'Maipu', '2016-03-17', 'Desborde del canal Santa Marta provoca anegamiento de las viviendas cercanas', ST_GeomFromText('POINT(-33.61169 -70.57577)', 4326));

SELECT setval('emergencia_id_seq', 10, true);


-- Carga datos para tabla eme_habilidad
INSERT INTO eme_habilidad(id,id_emergencia,id_habilidad) VALUES
(1,1,1),
(2,1,2),
(3,1,8),
(4,1,9),
(5,1,10),
(6,1,6),
(7,1,4),
(8,1,11),
(9,2,5),
(10,2,3),
(11,2,11),
(12,2,13);
SELECT setval('eme_habilidad_id_seq', 12, true);


-- Cargar datos de tarea
INSERT into tarea(id, nombre, descripcion, id_estado_tarea, id_emergencia, coordenadas) VALUES
(1, 'Quitar escombros', 'Sacar los escombros de las casas', 1, 1, ST_GeomFromText('POINT(-33.45694 -70.64827)', 4326)),
(2, 'Transportar ancianos', 'Ubicar a los ancianos en un lugar seguro', 2, 1, ST_GeomFromText('POINT(-33.61169 -70.57577)', 4326)),
(3, 'Encontrar animales', 'Ubicar a las mascotas de los residentes', 3, 1, ST_GeomFromText('POINT(-23.65236 -70.3954)', 4326)),
(4, 'Rastrear personas', 'Ubicar a las personas desaparecidas', 4, 1, ST_GeomFromText('POINT(-33.02457 -71.55183)', 4326)),
(5, 'Contar heridos', 'Contabilizar a las personas heridas', 1, 1, ST_GeomFromText('POINT(-33.036 -71.62963)', 4326)),
(6, 'Trasladar heridos', 'Trasladar a las personas heridas para recibir atencion medica', 2, 1, ST_GeomFromText('POINT(-36.72494 -73.11684)',4326)),
(7, 'Identificar fallecidos', 'Identificar el nombre de los cuerpos fallecidos', 3, 1, ST_GeomFromText('POINT(-33.59217 -70.6996)',4326)),
(8, 'Evacuar adultos mayores', 'Reubicar adultos mayores de zonas de peligro', 4, 1, ST_GeomFromText('POINT(-38.73965 -72.59842)', 4326)),
(9, 'Evacuar personas', 'Reubicar a la poblacion en zonas de peligro', 2, 1, ST_GeomFromText('POINT(-20.21326 -70.15027)', 4326)),
(10, 'Vendar heridos', 'Atender lesiones menores de personas', 2, 1, ST_GeomFromText('POINT(-36.82699 -73.04977)', 4326)),
(11, 'Tratar heridas graves', 'Atender a las personas con heridas que involucren un peligro de muerte', 1, 2, ST_GeomFromText('POINT(-34.17083 -70.74444)', 4326)),
(12, 'Limpiar', 'Eliminar desechos de la zona', 2, 2, ST_GeomFromText('POINT(-33.58331 -70.63419)', 4326)),
(13, 'Encontrar heridos', 'Ubicar a personas inconscientes', 3, 2, ST_GeomFromText('POINT(-35.4264 -71.65542)', 4326)),
(14, 'Vendar animales', 'Atender heridas leves en animales', 3, 2, ST_GeomFromText('POINT(-18.4746 -70.29792)', 4326)),
(15, 'Medicar personas', 'Recetar farmacos a personas', 1, 2, ST_GeomFromText('POINT(-29.95332 -71.33947)', 4326)),
(16, 'Medicar animales', 'Recetar farmacos para animales', 3, 2, ST_GeomFromText('POINT(-41.4693 -72.94237)', 4326)),
(17, 'Apagar incendio', 'Extingir llamas de un recinto', 4, 2, ST_GeomFromText('POINT(-29.90453 -71.24894)', 4326)),
(18, 'Repartir comida', 'Distribuir comida entre los afectados', 1, 2, ST_GeomFromText('POINT(-29.90453 -71.24894)', 4326)),
(19, 'Repartir agua', 'Distribuir agua entre los afectados', 3, 2, ST_GeomFromText('POINT(-36.60664 -72.10344)', 4326)),
(20, 'Repartir medicamentos', 'Distribuir medicamentos entre los afectados', 3, 2, ST_GeomFromText('POINT(-33.04222 -71.37333)', 4326));
SELECT setval('tarea_id_seq', 20, true);


-- Cargar datos para tabla de voluntarios
INSERT INTO voluntario(id,estado_salud,nombre,apellido,correo_electronico,password, coordenadas) VALUES
(1,'Estresado','Leonardo','Munoz','leonardo.munoz.f@usach.cl','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A3B191C258340C0E8BCC62E51E351C0'),
(2,'Bueno','Leo','Messi','leomessi@usach.cl','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000027A5A0DB4BCE40C026016A6AD9A451C0'),
(3,'Saludable','Elvis','Cocho','elvis.cocho@usach.cl','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F437A11001A737C0A835CD3B4E9951C0'),
(4,'Saludable','Israel','Arias','israel.arias@usach.cl','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A3B191C258340C0E8BCC62E51E351C0'),
(5,'Saludable','Jose','Tronco','jose.tronco@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F853E3A59B8440C027A5A0DB4BE851C0'),
(6,'Saludable','Armando','Paredes','armando.paredes@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F7C77BD5CA5C42C056B77A4E7A4752C0'),
(7,'Poderoso','Ricardo','Milos','ricardo.milos@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000000FD6FF39CCCB40C00612143FC6AC51C0'),
(8,'Disponible','Juan','Perez','juan.perez@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000423EE8D9AC5E43C06E5166834C2652C0'),
(9,'Bueno','Gabriel','Boric','gabriel.boric@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000828B1535983634C07AE40F069E8951C0'),
(10,'Bueno','Arnol','chopsuei','arnol051@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003D0FEECEDA6942C09A94826E2F4352C0'),
(11,'Saludable','Rebecca','Robinson','kmorton@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000007D96E7C1DD1541C06475ABE7A4AF51C0'),
(12,'Saludable','James','Nicholson','stephensdanielle@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000002B7EEE6A9CA40C0D15CA79196A851C0'),
(13,'Saludable','Joseph','Beck','estewart@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000D881734694B641C03D49BA66F2E951C0'),
(14,'Saludable','Jenna','Hoffman','jason27@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000007DAEB6627F7932C0C2340C1F119351C0'),
(15,'Saludable','Christopher','Jensen','ruthwilliams@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000006B9F8EC70CF43DC048FE60E0B9D551C0'),
(16,'Saludable','Cindy','Collins','millercarly@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000A301BC0512BC44C0D1AE42CA4F3C52C0'),
(17,'Saludable','Christine','Wagner','shawn77@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A4030478FE73DC0A4AA09A2EECF51C0'),
(18,'Saludable','David','Bailey','rrodriguez@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A4030478FE73DC0A4AA09A2EECF51C0'),
(19,'Saludable','Heather','Perez','josephlewis@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000004392861A64D42C04A46CEC29E0652C0'),
(20,'Saludable','Tina','Nichols','robertsariel@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000005A9E0777678540C0672783A3E4D751C0'),
(21,'Saludable','Charlene','Spencer','gonzalezeric@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A3B191C258340C0E8BCC62E51E351C0'),
(22,'Saludable','Melissa','Mason','thomas82@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000027A5A0DB4BCE40C026016A6AD9A451C0'),
(23,'Saludable','Steven','Adams','deborah76@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F437A11001A737C0A835CD3B4E9951C0'),
(24,'Saludable','Samantha','Chandler','darrellweaver@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A3B191C258340C0E8BCC62E51E351C0'),
(25,'Saludable','Alyssa','Walker','ustanley@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F853E3A59B8440C027A5A0DB4BE851C0'),
(26,'Saludable','Samantha','Henderson','faithmcmillan@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F7C77BD5CA5C42C056B77A4E7A4752C0'),
(27,'Saludable','Tyler','Blair','joneskaren@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000000FD6FF39CCCB40C00612143FC6AC51C0'),
(28,'Saludable','Lori','Daniel','vle@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000423EE8D9AC5E43C06E5166834C2652C0'),
(29,'Saludable','Christopher','Smith','brenda55@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000828B1535983634C07AE40F069E8951C0'),
(30,'Saludable','Leslie','Walker','morganpatricia@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003D0FEECEDA6942C09A94826E2F4352C0'),
(31,'Saludable','Dana','Nolan','millermichael@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000007D96E7C1DD1541C06475ABE7A4AF51C0'),
(32,'Saludable','Ashley','Harris','brittanywilliams@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000002B7EEE6A9CA40C0D15CA79196A851C0'),
(33,'Saludable','Monica','Smith','wcervantes@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000D881734694B641C03D49BA66F2E951C0'),
(34,'Saludable','Matthew','Fisher','julie79@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000007DAEB6627F7932C0C2340C1F119351C0'),
(35,'Saludable','Patricia','Ross','houstoncheryl@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000006B9F8EC70CF43DC048FE60E0B9D551C0'),
(36,'Saludable','Catherine','Martin','brandon28@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000A301BC0512BC44C0D1AE42CA4F3C52C0'),
(37,'Saludable','Joshua','Morgan','ortegajillian@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A4030478FE73DC0A4AA09A2EECF51C0'),
(38,'Saludable','Tracey','Smith','nharris@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A4030478FE73DC0A4AA09A2EECF51C0'),
(39,'Saludable','Daniel','Nicholson','patricia64@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000004392861A64D42C04A46CEC29E0652C0'),
(40,'Saludable','Jill','Brown','qsanders@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000005A9E0777678540C0672783A3E4D751C0'),
(41,'Saludable','Danny','Price','ronnieriley@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A3B191C258340C0E8BCC62E51E351C0'),
(42,'Saludable','Leslie','King','davisdavid@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E610000027A5A0DB4BCE40C026016A6AD9A451C0'),
(43,'Saludable','Jessica','Harris','jonathanosborne@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F437A11001A737C0A835CD3B4E9951C0'),
(44,'Saludable','Amanda','Johnson','alexis76@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003A3B191C258340C0E8BCC62E51E351C0'),
(45,'Saludable','Shane','Wood','powellhailey@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F853E3A59B8440C027A5A0DB4BE851C0'),
(46,'Saludable','Carrie','Shaw','michaelshaw@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000F7C77BD5CA5C42C056B77A4E7A4752C0'),
(47,'Saludable','Mark','Miller','nicoleclark@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000000FD6FF39CCCB40C00612143FC6AC51C0'),
(48,'Saludable','Joshua','Williams','benjamindana@yahoo.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000423EE8D9AC5E43C06E5166834C2652C0'),
(49,'Saludable','Kevin','Avery','jacquelinemorgan@hotmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E6100000828B1535983634C07AE40F069E8951C0'),
(50,'Saludable','Cameron','Warner','ortizjames@gmail.com','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','0101000020E61000003D0FEECEDA6942C09A94826E2F4352C0');
SELECT setval('voluntario_id_seq', 50, true);


-- Carga datos para tabla ranking
INSERT INTO ranking(id, puntos, id_tarea, id_voluntario) VALUES
(1, 100, 3, 2),
(2, 400, 17, 1),
(3, 1000, 1, 7),
(4, 200, 1, 4),
(5, 600, 1, 8),
(6, 300, 1, 9),
(7, 450, 1, 5),
(8, 200, 1, 10),
(9, 150, 2, 1),
(10, 200, 2, 2),
(11, 300, 2, 5),
(12, 500, 3, 7),
(13, 700, 3, 3),
(14, 750, 3, 10),
(15, 150, 3, 6),
(16, 350, 11, 3),
(17, 650, 11, 8),
(18, 950, 11, 7),
(19, 1000, 19, 9),
(20, 850, 19, 2),
(21, 550, 19, 4),
(22, 350, 19, 7),
(23, 150, 19, 3),
(24, 400, 17, 1);
SELECT setval('ranking_id_seq', 24, true);


-- Carga datos para tabla institucion
INSERT INTO institucion(id,razon_social) VALUES
(1,'Un_techo_para_chile'),
(2,'Coaniqem'),
(3,'Ayuda_chile'),
(4,'Cruz_roja'),
(5,'Salud_rural'),
(6,'Bomberos'),
(7,'Cruz_roja'),
(8,'Salud_rural'),
(9,'Hogar_de_cristo'),
(10,'Constitucion_2021'),
(11,'Chile_conectado'),
(12,'Ayuda_incendios');

SELECT setval('institucion_id_seq', 12, true);



-- Carga datos para tabla coordinador
INSERT INTO coordinador(id,nombre,apellido,estado_salud,password,correo_electronico,id_institucion) VALUES
(1,'Manuel','Mano','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','manuel@gmail.com',2),
(2,'jhon','lopez','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','jhon@gmail.com',1),
(3,'cristiano','ronaldo','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','ronaldo@gmail.com',3),
(4,'chris','ronaldo','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','ronaldo@gmail.com',4),
(5,'peter','parker','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','peter@gmail.com',5),
(6,'brock','perez','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','perez@gmail.com',6),
(7,'edge','rojas','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','rojas@gmail.com',7),
(8,'tony','caluga','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','caluga@gmail.com',8),
(9,'tony','stark','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','stark@gmail.com',9),
(10,'bruce','wayne','Saludable','$2a$10$qpkjcJ4AXy6uf16wudVS7OWq.pXgb.TRi7wVUDws3M9w4LqauyOZe','wayne@gmail.com',10);

SELECT setval('coordinador_id_seq', 10, true);


-- Cargar datos para tabla equipamiento
INSERT INTO equipamiento(id, nombre, descripcion, id_voluntario) VALUES
(1,'Silla de Ruedas','descripción del equipo',35),
(2,'Camilla','descripción del equipo',23),
(3,'Casco','descripción del equipo',3),
(4,'Equipo de primeros auxilios','descripción del equipo',12),
(5,'Taladro','descripción del equipo',33),
(6,'Taladro','descripción del equipo',42),
(7,'Taladro','descripción del equipo',4),
(8,'Furgoneta','descripción del equipo',36),
(9,'Camilla','descripción del equipo',45),
(10,'Casco','descripción del equipo',39),
(11,'Silla de Ruedas','descripción del equipo',50),
(12,'Equipo de montaña','descripción del equipo',26),
(13,'Equipo de montaña','descripción del equipo',8),
(14,'Silla de Ruedas','descripción del equipo',19),
(15,'Equipo de primeros auxilios','descripción del equipo',6),
(16,'Silla de Ruedas','descripción del equipo',36),
(17,'Desfibrilador','descripción del equipo',47),
(18,'Furgoneta','descripción del equipo',49),
(19,'Casco','descripción del equipo',10),
(20,'Furgoneta','descripción del equipo',28),
(21,'Camilla','descripción del equipo',49),
(22,'Equipo de montaña','descripción del equipo',14),
(23,'Equipo de primeros auxilios','descripción del equipo',18),
(24,'Automovil','descripción del equipo',13),
(25,'Silla de Ruedas','descripción del equipo',31),
(26,'Silla de Ruedas','descripción del equipo',2),
(27,'Taladro','descripción del equipo',12),
(28,'Casco','descripción del equipo',27),
(29,'Furgoneta','descripción del equipo',23),
(30,'Furgoneta','descripción del equipo',25),
(31,'Camilla','descripción del equipo',1),
(32,'Casco','descripción del equipo',9),
(33,'Taladro','descripción del equipo',2),
(34,'Taladro','descripción del equipo',26),
(35,'Camilla','descripción del equipo',36),
(36,'Automovil','descripción del equipo',43),
(37,'Desfibrilador','descripción del equipo',4),
(38,'Equipo de primeros auxilios','descripción del equipo',45),
(39,'Equipo de primeros auxilios','descripción del equipo',10),
(40,'Equipo de montaña','descripción del equipo',32),
(41,'Equipo de montaña','descripción del equipo',46),
(42,'Equipo de primeros auxilios','descripción del equipo',13),
(43,'Casco','descripción del equipo',48),
(44,'Equipo de montaña','descripción del equipo',2),
(45,'Equipo de primeros auxilios','descripción del equipo',36),
(46,'Silla de Ruedas','descripción del equipo',4),
(47,'Automovil','descripción del equipo',33),
(48,'Taladro','descripción del equipo',20),
(49,'Desfibrilador','descripción del equipo',8),
(50,'Equipo de primeros auxilios','descripción del equipo',2);


SELECT setval('equipamiento_id_seq', 50, true);


-- Carga datos para tabla tarea_habilidad
INSERT INTO tarea_habilidad(id, id_tarea, id_eme_habilidad) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 1),
(14, 14, 2),
(15, 15, 3),
(16, 16, 4),
(17, 17, 8),
(18, 18, 8),
(19, 19, 9),
(20, 20, 2),
(21, 1, 1),
(22, 2, 2),
(23, 3, 3),
(24, 4, 4),
(25, 5, 5),
(26, 6, 6),
(27, 7, 7),
(28, 8, 8),
(29, 9, 9),
(30, 1, 10),
(31, 2, 11),
(32, 10, 12),
(33, 3, 3),
(34, 4, 4),
(35, 5, 5),
(36, 6, 6),
(37, 7, 7),
(38, 8, 8),
(39, 9, 9),
(40, 2, 12);

SELECT setval('tarea_habilidad_id_seq', 40, true);


INSERT INTO vol_habilidad(id,id_voluntario,id_habilidad) VALUES
(1,1,3),
(2,1,7),
(3,1,11),
(4,1,4),
(5,2,13),
(6,2,5),
(7,2,2),
(8,2,7),
(9,3,9),
(10,3,4),
(11,3,6),
(12,3,10),
(13,4,7),
(14,4,4),
(15,4,13),
(16,4,2),
(17,5,3),
(18,5,13),
(19,5,4),
(20,5,12),
(21,6,1),
(22,6,10),
(23,6,5),
(24,6,9),
(25,7,3),
(26,7,9),
(27,7,2),
(28,7,10),
(29,8,3),
(30,8,9),
(31,8,11),
(32,8,7),
(33,9,1),
(34,9,6),
(35,9,5),
(36,9,3),
(37,10,7),
(38,10,2),
(39,10,4),
(40,10,5),
(41,11,10),
(42,11,12),
(43,11,8),
(44,11,2),
(45,12,10),
(46,12,12),
(47,12,11),
(48,12,9),
(49,13,10),
(50,13,5),
(51,13,1),
(52,13,4),
(53,14,5),
(54,14,6),
(55,14,13),
(56,14,9),
(57,15,8),
(58,15,13),
(59,15,10),
(60,15,12),
(61,16,9),
(62,16,13),
(63,16,11),
(64,16,12),
(65,17,13),
(66,17,7),
(67,17,3),
(68,17,9),
(69,18,1),
(70,18,4),
(71,18,9),
(72,18,11),
(73,19,13),
(74,19,11),
(75,19,1),
(76,19,8),
(77,20,3),
(78,20,2),
(79,20,12),
(80,20,11),
(81,21,12),
(82,21,1),
(83,21,7),
(84,21,3),
(85,22,5),
(86,22,6),
(87,22,13),
(88,22,8),
(89,23,6),
(90,23,9),
(91,23,7),
(92,23,5),
(93,24,6),
(94,24,7),
(95,24,11),
(96,24,1),
(97,25,5),
(98,25,2),
(99,25,12),
(100,25,10),
(101,26,11),
(102,26,1),
(103,26,10),
(104,26,4),
(105,27,12),
(106,27,6),
(107,27,10),
(108,27,1),
(109,28,2),
(110,28,9),
(111,28,13),
(112,28,3),
(113,29,8),
(114,29,3),
(115,29,9),
(116,29,11),
(117,30,13),
(118,30,5),
(119,30,1),
(120,30,6),
(121,31,2),
(122,31,8),
(123,31,11),
(124,31,10),
(125,32,2),
(126,32,3),
(127,32,7),
(128,32,13),
(129,33,7),
(130,33,6),
(131,33,8),
(132,33,4),
(133,34,6),
(134,34,10),
(135,34,1),
(136,34,12),
(137,35,10),
(138,35,5),
(139,35,2),
(140,35,13),
(141,36,13),
(142,36,2),
(143,36,3),
(144,36,11),
(145,37,1),
(146,37,8),
(147,37,2),
(148,37,12),
(149,38,3),
(150,38,13),
(151,38,8),
(152,38,2),
(153,39,9),
(154,39,13),
(155,39,8),
(156,39,2),
(157,40,11),
(158,40,4),
(159,40,9),
(160,40,8),
(161,41,6),
(162,41,7),
(163,41,5),
(164,41,2),
(165,42,8),
(166,42,10),
(167,42,5),
(168,42,2),
(169,43,9),
(170,43,3),
(171,43,8),
(172,43,4),
(173,44,10),
(174,44,2),
(175,44,3),
(176,44,5),
(177,45,10),
(178,45,1),
(179,45,12),
(180,45,9),
(181,46,6),
(182,46,1),
(183,46,3),
(184,46,10),
(185,47,10),
(186,47,13),
(187,47,3),
(188,47,4),
(189,48,13),
(190,48,3),
(191,48,5),
(192,48,9),
(193,49,13),
(194,49,12),
(195,49,3),
(196,49,4),
(197,50,13),
(198,50,7),
(199,50,6),
(200,50,8);

SELECT setval('vol_habilidad_id_seq', 200, true);

-- Carga datos para tabla voluntario_tarea
INSERT INTO voluntario_tarea(id, id_tarea, id_voluntario) VALUES
(1, 1, 6),
(2, 2, 5),
(3, 3, 4),
(4, 4, 29),
(5, 5, 44),
(6, 6, 46),
(7, 7, 24),
(8, 8, 33),
(9, 9, 43),
(10, 10, 47),
(11, 11, 40),
(12, 12, 23),
(13, 13, 15),
(14, 14, 16),
(15, 15, 30),
(16, 16, 33),
(17, 17, 41),
(18, 18, 1),
(19, 19, 8),
(20, 20, 23),
(21, 1, 19),
(22, 2, 23),
(23, 3, 11),
(24, 4, 4),
(25, 5, 8),
(26, 6, 12),
(27, 7, 38),
(28, 8, 29),
(29, 9, 13),
(30, 10, 31);

SELECT setval('voluntario_tarea_id_seq', 30, true);
