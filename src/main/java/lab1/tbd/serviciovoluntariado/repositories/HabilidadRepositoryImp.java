package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Habilidad;
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
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countHabilidad() {
        String sql = "SELECT COUNT(*) FROM habilidad";
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
    public List<Habilidad> getAllHabilidad() {
        String sql = "SELECT * FROM habilidad";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeAndFetch(Habilidad.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Habilidad getHabilidadById(Long id) {
        String sql = "SELECT * FROM habilidad WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Habilidad.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Habilidad createHabilidad(Habilidad h) {
        String sql = "INSERT INTO habilidad (id, descrip) " +
                "VALUES (:id, :descrip)";
        Connection conn = sql2o.open();
        try (conn) {
            int id = (int) conn.createQuery(sql,true)
                    .bind(h)
                    .executeUpdate()
                    .getKey();
            h.setId((long) id);
            return h;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Habilidad updateHabilidad(Habilidad h) {
        String sql = "UPDATE habilidad SET descrip = :descrip WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .bind(h)
                    .executeUpdate();
            return h;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }

    }

    @Override
    public void deleteHabilidadById(Long id) {
        String sql = "DELETE FROM habilidad WHERE id = :id";
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

    @Override
    public List<Habilidad> getHabilidadByEmergency(Long id) {
        String sql = "SELECT * FROM habilidad WHERE id IN (SELECT id_habilidad FROM eme_habilidad WHERE id_emergencia = :id)";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetch(Habilidad.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }


}
