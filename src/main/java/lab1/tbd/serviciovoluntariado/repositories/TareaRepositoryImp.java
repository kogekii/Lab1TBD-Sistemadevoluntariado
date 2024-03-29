
package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Tarea;
import lab1.tbd.serviciovoluntariado.models.VoluntarioCercano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@Component
@Configuration
@Repository
public class TareaRepositoryImp implements TareaRepository
{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea createTarea(Tarea tarea) {
        final String sql =
            "INSERT INTO tarea (id, nombre, descripcion, id_estado_tarea, id_emergencia, coordenadas) " +
            "VALUES (:id ,:nombre, :descripcion, :id_estado_tarea, :id_emergencia, ST_GeomFromText(:coordenadas,4326))";

        try(Connection conn = sql2o.open()){
            Long idNuevo = getIdMayor()+ 1;
            conn.createQuery(sql, true)
                .addParameter("id", idNuevo)
                .addParameter("nombre", tarea.getNombre())
                .addParameter("descripcion", tarea.getDescripcion())
                .addParameter("id_estado_tarea", tarea.getIdEstadoTarea())
                .addParameter("id_emergencia", tarea.getIdEmergencia())
                .addParameter("coordenadas","POINT("+tarea.getCoordenadas()+")")
                .executeUpdate();
            tarea.setId(idNuevo);
            return tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getAllTareas() {
        final String sql =
                "SELECT id,nombre,descripcion,id_estado_tarea,id_emergencia, st_x(st_astext(coordenadas)) AS longitude, st_y(st_astext(coordenadas)) AS latitude FROM tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateTarea(Long id, Tarea tarea) {
        String updateSql = "UPDATE tarea " +
                "SET nombre = :tareaNombre, descripcion = :tareaDescripcion,  " +
                "id_estado_tarea = :tareaid_estado_tarea, id_emergencia = :tareaid_emergencia, coordenadas = ST_GeomFromText(:coordenadas,4326), updated_at = :tareaNuevaFecha " +
                "WHERE id = :tareaID";

        Date fecha = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(fecha.getTime());
        //Se consigue el valor actual de la tarea, que sera actualizado
        try (Connection con = sql2o.open()) {
            Tarea antiguo = con.createQuery("SELECT * FROM tarea where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Tarea.class);
            //Si no encontro tupla
            if(antiguo == null){
                return "No se encontro el id";
            }
            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("tareaID", id);

            if(tarea.getNombre() != null){
                consulta.addParameter("tareaNombre", tarea.getNombre());
            } else {
                consulta.addParameter("tareaNombre", antiguo.getNombre());
            }

            if(tarea.getDescripcion() != null){
                consulta.addParameter("tareaDescripcion", tarea.getDescripcion());
            } else {
                consulta.addParameter("tareaDescripcion", antiguo.getDescripcion());
            }
            if(tarea.getIdEstadoTarea() != null){
                consulta.addParameter("tareaid_estado_tarea", tarea.getIdEstadoTarea());
            } else {
                consulta.addParameter("tareaid_estado_tarea", antiguo.getIdEstadoTarea());
            }
            if(tarea.getIdEmergencia() != null){
                consulta.addParameter("tareaid_emergencia", tarea.getIdEmergencia());
            } else {
                consulta.addParameter("tareaid_emergencia", antiguo.getIdEmergencia());
            }
            if(tarea.getCoordenadas() != null){
                consulta.addParameter("coordenadas","POINT("+tarea.getCoordenadas()+")");
            } else {
                consulta.addParameter("coordenadas","POINT("+antiguo.getCoordenadas()+")");
            }
            consulta.addParameter("tareaNuevaFecha", timestamp);
            consulta.executeUpdate();

            return ("La Tarea de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteTarea(Long id) {
        String deleteSql = "DELETE FROM tarea e WHERE e.id = "+id;
        try(Connection conn = sql2o.open()){
            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado la tarea "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Tarea getTarea(Long id) {
        final String sql =
            "SELECT *, ST_X(ST_FlipCoordinates(coordenadas)) AS longitude, ST_Y(ST_FlipCoordinates(coordenadas)) AS latitude "+
            "FROM tarea t WHERE t.id = :tid";
        try(Connection conn = sql2o.open()){
            Tarea tarea = (Tarea)conn.createQuery(sql).addParameter("tid", id).executeAndFetchFirst(Tarea.class);
            System.out.println("SELECT Tarea("+ tarea.getId() +", \""+ tarea.getNombre() +"\")");
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Long getIdMayor(){
        try(Connection conn = sql2o.open()){
            Long aux = conn.createQuery("SELECT id FROM tarea ORDER BY id DESC")
                    .executeAndFetchFirst(Tarea.class).
                    getId();
            return aux;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0L;
        }
    }

    public List<Tarea> getTareasByRegion(Long gid){
        final String sql =
            "SELECT id,nombre,descripcion,id_estado_tarea,id_emergencia,"+
                "ST_X(ST_Transform(t.coordenadas,4326)) AS longitude,"+
                "ST_Y(ST_Transform(t.coordenadas,4326)) AS latitude "+
            "FROM division_regional dr, tarea t " +
            "WHERE ST_CONTAINS(ST_SetSRID(dr.geom, 4326), ST_FlipCoordinates(t.coordenadas)) and dr.gid = :tid";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                .addParameter("tid",gid)
                .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getTareasByEmergencia(Long eid) {
        String sql = "SELECT * FROM tarea WHERE id_emergencia = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", eid).executeAndFetch(Tarea.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public List<VoluntarioCercano> getClosestVoluntarios(Long tid, Long limit) {
        String sql =
            "SELECT v.id AS id, v.nombre AS nombre, v.apellido AS apellido, v.correo_electronico as correoElectronico, "+
                "ST_X(ST_FlipCoordinates(v.coordenadas)) AS longitude,"+
                "ST_Y(ST_FlipCoordinates(v.coordenadas)) AS latitude "+
            "FROM tarea t, voluntario v "+
            "WHERE t.id = :id "+
            "ORDER BY ST_Distance(ST_Transform(t.coordenadas,4326), ST_Transform(v.coordenadas,4326)) ASC "+
            "LIMIT :limit";
        Connection session = sql2o.open();
        List<VoluntarioCercano> result = session.createQuery(sql)
            .addParameter("id", tid)
            .addParameter("limit", limit)
            .executeAndFetch(VoluntarioCercano.class);
        session.close();
        return result;
    }
}
