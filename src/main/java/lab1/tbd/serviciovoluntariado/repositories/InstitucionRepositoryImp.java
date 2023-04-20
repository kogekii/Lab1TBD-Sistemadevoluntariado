package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class InstitucionRepositoryImp implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countInstitucion() {
        String sql = "SELECT COUNT(*) FROM institucion";
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
    public List<Institucion> getAllInstitucion() {
        String sql = "SELECT * FROM institucion";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeAndFetch(Institucion.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Institucion getInstitucionById(int id) {
        String sql = "SELECT * FROM institucion WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Institucion.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Institucion createInstitucion(Institucion i) {
        String sql = "INSERT INTO institucion (id, nombre, descrip) " +
                "VALUES (:id, :nombre, :descrip)";
        Connection conn = sql2o.open();
        try (conn) {
            int id = (int) conn.createQuery(sql,true)
                    .bind(i)
                    .executeUpdate()
                    .getKey();
            i.setId((long) id);
            return i;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Institucion updateInstitucion(Institucion i) {
        String sql = "UPDATE institucion SET nombre = :nombre, descrip = :descrip WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .bind(i)
                    .executeUpdate();
            return i;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public void deleteInstitucionById(int id) {
        String sql = "DELETE FROM institucion WHERE id = :id";
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
