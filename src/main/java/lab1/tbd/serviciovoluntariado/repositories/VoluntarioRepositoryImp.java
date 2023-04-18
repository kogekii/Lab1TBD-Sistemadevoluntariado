package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVoluntario() {
        String sql = "SELECT COUNT(*) FROM voluntario";
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
    public List<Voluntario> getAllVoluntario() {
        String sql = "SELECT * FROM voluntario";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeAndFetch(Voluntario.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Voluntario getVoluntarioById(int id) {
        String sql = "SELECT * FROM voluntario WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Voluntario.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Voluntario createVoluntario(Voluntario v) {
        String sql = "INSERT INTO voluntario (id, nombre) " +
                "VALUES (:id, :nombre)";
        Connection conn = sql2o.open();
        try (conn) {
            int id = (int) conn.createQuery(sql,true)
                    .bind(v)
                    .executeUpdate()
                    .getKey();
            v.setId((long) id);
            return v;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public Voluntario updateVoluntario(Voluntario v) {
        String sql = "UPDATE voluntario SET nombre = :nombre WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .bind(v)
                    .executeUpdate();
            return v;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public void deleteVoluntarioById(int id) {
        String sql = "DELETE FROM voluntario WHERE id = :id";
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
