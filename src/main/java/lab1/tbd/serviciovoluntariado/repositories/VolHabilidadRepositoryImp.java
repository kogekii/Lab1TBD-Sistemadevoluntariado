package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.VolHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Component
@Configuration
@Repository
public class VolHabilidadRepositoryImp implements VolHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVolHabilidad() {
        String sql = "SELECT COUNT(*) FROM vol_habilidad";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeScalar(Integer.class);
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }finally{
            conn.close();
        }
    }

    @Override
    public List<VolHabilidad> getAllVolHabilidad() {
        String sql = "SELECT * FROM vol_habilidad";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeAndFetch(VolHabilidad.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public VolHabilidad getVolHabilidadById(Long id) {
        String sql = "SELECT * FROM vol_habilidad WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(VolHabilidad.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public VolHabilidad createVolHabilidad(VolHabilidad t) {
        String sql = "INSERT INTO vol_habilidad (id, id_voluntario, id_habilidad) " +
                "VALUES (:id, :id_voluntario, :id_habilidad)";
        Connection conn = sql2o.open();
        try (conn) {
            int id = (int) conn.createQuery(sql,true)
                    .bind(t)
                    .executeUpdate()
                    .getKey();
            t.setId((long) id);
            return t;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public VolHabilidad updateVolHabilidad(VolHabilidad t) {
        String sql = "UPDATE vol_habilidad SET id_voluntario = :id_voluntario, id_habilidad = :id_habilidad " +
                "WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .bind(t)
                    .executeUpdate();
            return t;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public void deleteVolHabilidadById(Long id) {
        String sql = "DELETE FROM vol_habilidad WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            conn.close();
        }
    }
}
