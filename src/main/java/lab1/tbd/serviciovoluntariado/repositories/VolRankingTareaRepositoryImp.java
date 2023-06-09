package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.VolRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolRankingTareaRepositoryImp implements VolRankingTareaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<VolRanking> getVoluntariesRankedPerTask(Long id) {
        String sql = "SELECT voluntario.id, voluntario.nombre, voluntario.apellido, voluntario.estado_salud, voluntario.correo_electronico, ranking.puntos FROM voluntario, tarea, ranking " +
                "WHERE voluntario.id = ranking.id_voluntario AND tarea.id = ranking.id_tarea AND tarea.id = :tid " +
                "ORDER BY ranking.puntos desc";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("tid", id)
                    .executeAndFetch(VolRanking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}