CREATE OR REPLACE FUNCTION public.obtener_estadisticas_log_query_tabla(
	querytype text,
	tabla text)
    RETURNS TABLE(updated_by character varying, count bigint, llamada character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY EXECUTE '
    SELECT updated_by, count(*), llamada
    FROM ' || quote_ident(tabla) || '
	WHERE llamada = ' || quote_literal(querytype) || '
    GROUP BY updated_by, llamada';
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.obtener_estadisticas_log_tabla(
	tabla text)
    RETURNS TABLE(updated_by character varying, count bigint, llamada character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY EXECUTE '
    SELECT updated_by, count(*), llamada
    FROM ' || quote_ident(tabla) || '
    GROUP BY updated_by, llamada';
END;
$BODY$;

CREATE OR REPLACE FUNCTION public.obtener_estadisticas_log_total(
	querytype text)
    RETURNS TABLE(updated_by character varying, llamada character varying, count bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
  RETURN QUERY
  SELECT foo.updated_by, foo.llamada, COUNT(*)
  FROM (
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_emergencia')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_estado_tarea')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_habilidad')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_institucion')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_ranking')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_tarea')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_tarea_habilidad')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_vol_habilidad')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_voluntario')
    UNION ALL
    SELECT * FROM obtener_estadisticas_log_query_tabla(querytype, 'log_eme_habilidades')
  ) AS foo
  GROUP BY foo.updated_by, foo.llamada;

END;
$BODY$;