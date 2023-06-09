package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.VolParticipacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository

public class VolParticipacionRepositoryImp implements VolParticipacionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<VolParticipacion> getVoluntariesPerParticipation(Long id) {

        String sql = "select v.id, v.nombre, v.apellido, count (v.id) as cantidad_tareas" +
                " from voluntario v, voluntario_tarea vt, " +
                " (select e.id as id_emergencia, t.id as id_tarea" +
                " from emergencia e, tarea t, estado_tarea et" +
                " where e.id = :eid and t.id_emergencia = e.id and et.estado = 'Terminada') as te" +
                " where te.id_tarea = vt.id_tarea and v.id = vt.id_voluntario" +
                " group by v.id, v.nombre, v.apellido" +
                " order by cantidad_tareas desc";


        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetch(VolParticipacion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
