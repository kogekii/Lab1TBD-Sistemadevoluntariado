package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.VolCantidadHabilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

@Repository
public class VolRankingRequerimientosRepositoryImp implements VolRankingRequerimientosRepository {

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<VolCantidadHabilidades> getVoluntariosRequerimiento(Long id) {
        final String sql =
                "select v.id, v.nombre, v.apellido, v.estado_salud, t3.cantidad_habilidades from voluntario v, (select vh.id_voluntario, count(vh.id_habilidad) as cantidad_habilidades from vol_habilidad vh, (select id_habilidad from eme_habilidad eh,(select distinct th.id_eme_habilidad from tarea t, tarea_habilidad th " +
                        " where " +
                        "t.id_emergencia = :emergenciaId and " +
                        "th.id_tarea = t.id) t1 " +
                        "where " +
                        "t1.id_eme_habilidad = eh.id and " +
                        "eh.id_emergencia = :emergenciaId) t2 " +
                        "where " +
                        "t2.id_habilidad = vh.id_habilidad " +
                        "group by vh.id_voluntario order by cantidad_habilidades desc) t3 " +
                        "where " +
                        "t3.id_voluntario = v.id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("emergenciaId",id)
                    .executeAndFetch(VolCantidadHabilidades.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}